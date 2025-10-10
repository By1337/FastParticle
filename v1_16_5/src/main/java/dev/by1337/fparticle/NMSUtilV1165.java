package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.MutableParticleData;
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

class NMSUtilV1165 extends FParticleUtil.NmsAccessor {
    private static final int[] PARTICLE_TO_ID;
    private final int id = ConnectionProtocol.PLAY.getPacketId(PacketFlow.CLIENTBOUND, new ClientboundLevelParticlesPacket());

    @Override
    public boolean canReciveParticles(Player player) {
        return ((CraftPlayer) player).getHandle().networkManager.protocol == ConnectionProtocol.PLAY;
    }

    @Override
    public Channel getChannel(Player player) {
        return ((CraftPlayer) player).getHandle().networkManager.channel;
    }

    @Override
    public int getLevelParticlesPacketId() {
        return id;
    }

    public int getCompressionThreshold() {
        return MinecraftServer.getServer().getCompressionThreshold();
    }

    @Override
    public MutableParticleData newParticle() {
        return new MutableParticleData() {
            private @Nullable ParticleOptions options;
            private int particleID = -1;

            @Override
            public int particleId() {
                if (particleID == -1){
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

            @Override
            public MutableParticleData data(@Nullable Object data) {
                options = null;
                return super.data(data);
            }

            @Override
            public MutableParticleData particle(Particle particle) {
                options = null;
                return super.particle(particle);
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
