package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.server.MinecraftServer;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.CraftParticle;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

class NMSUtilV1165 implements FParticleUtil.NmsAccessor {
    private static final int[] PARTICLE_TO_ID;
    private final int id = ConnectionProtocol.PLAY.getPacketId(PacketFlow.CLIENTBOUND, new ClientboundLevelParticlesPacket());

    @Override
    public boolean isPlayState(Player player) {
        if (player == null) return false;
        var v = ((CraftPlayer) player).getHandle();
        if (v == null) return false;
        return v.networkManager != null && v.networkManager.protocol == ConnectionProtocol.PLAY;
    }

    @Override
    public Channel getChannel(Player player) {
        if (player == null) return null;
        var v = ((CraftPlayer) player).getHandle();
        if (v == null) return null;
        return v.networkManager == null ? null : v.networkManager.channel;
    }

    @Override
    public int getLevelParticlesPacketId() {
        return id;
    }

    public int getCompressionThreshold() {
        return MinecraftServer.getServer().getCompressionThreshold();
    }

    @Override
    public ParticleData newParticle(ParticleData.Builder builder) {
        return new ParticleData(builder) {
            private @Nullable ParticleOptions options;
            private int particleID = -1;

            @Override
            public int particleId() {
                if (particleID == -1) {
                    particleID = getParticleId(particle, data);
                }
                return particleID;
            }

            @Override
            public void write(ByteBuf buf, double x, double y, double z, float xDist, float yDist, float zDist) {
                if (options == null) {
                    options = CraftParticle.toNMS(particle, data);
                    particleID = getParticleId(particle, data);
                }
                buf.writeInt(particleID);
                buf.writeBoolean(this.overrideLimiter);
                buf.writeDouble(x);
                buf.writeDouble(y);
                buf.writeDouble(z);
                buf.writeFloat(xDist);
                buf.writeFloat(yDist);
                buf.writeFloat(zDist);
                buf.writeFloat(this.maxSpeed);
                buf.writeInt(this.count);
                options.writeToNetwork(new FriendlyByteBuf(buf));
            }
        };
    }

    public int getParticleId(Particle particle, @Nullable Object data) {
        int val = PARTICLE_TO_ID[particle.ordinal()];
        if (val != -1) return val;
        var nms = CraftParticle.toNMS(particle, data);
        return PARTICLE_TO_ID[particle.ordinal()] = Registry.PARTICLE_TYPE.getId(nms.getParticle());
    }

    static {
        Particle[] arr = Particle.values();
        PARTICLE_TO_ID = new int[arr.length];
        Arrays.fill(PARTICLE_TO_ID, -1);
        for (ParticleType<?> particleType : Registry.PARTICLE_TYPE) {
            Particle particle = CraftParticle.toBukkit(particleType);
            PARTICLE_TO_ID[particle.ordinal()] = Registry.PARTICLE_TYPE.getId(particleType);
        }
    }
}
