package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ARGB;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.CraftParticle;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

class NMSUtilV1_21_10 implements FParticleUtil.NmsAccessor {
    private static final int[] PARTICLE_TO_ID;
    private static final Class<?> cl = ClientboundLevelParticlesPacket.class;

    @Override
    public boolean isPlayState(Player player) {
        if (player == null) return false;
        var v = ((CraftPlayer) player).getHandle();
        if (v == null) return false;
        var c = v.connection.connection.getPacketListener();
        return c != null && c.protocol() == ConnectionProtocol.PLAY;
    }

    @Override
    public Channel getChannel(Player player) {
        if (player == null) return null;
        var v = ((CraftPlayer) player).getHandle();
        if (v == null) return null;
        return v.connection.connection.channel;
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
                    options = CraftParticle.createParticleParam(particle, data);
                    particleID = getParticleId(particle, data);
                }
                buf.writeBoolean(this.overrideLimiter);
                buf.writeBoolean(this.alwaysShow);
                buf.writeDouble(x);
                buf.writeDouble(y);
                buf.writeDouble(z);
                buf.writeFloat(xDist);
                buf.writeFloat(yDist);
                buf.writeFloat(zDist);
                buf.writeFloat(this.maxSpeed);
                buf.writeInt(this.count);
                ParticleTypes.STREAM_CODEC.encode(
                        new RegistryFriendlyByteBuf(buf, MinecraftServer.getServer().registryAccess()),
                        options
                );
            }
        };
    }

    public int getParticleId(Particle particle, @Nullable Object data) {
        int val = PARTICLE_TO_ID[particle.ordinal()];
        if (val != -1) return val;
        var nms = CraftParticle.createParticleParam(particle, data);

        return PARTICLE_TO_ID[particle.ordinal()] = BuiltInRegistries.PARTICLE_TYPE.getId(nms.getType());
    }

    static {
        Particle[] arr = Particle.values();
        PARTICLE_TO_ID = new int[arr.length];
        Arrays.fill(PARTICLE_TO_ID, -1);
        for (ParticleType<?> particleType : BuiltInRegistries.PARTICLE_TYPE) {
            Particle particle = CraftParticle.minecraftToBukkit(particleType);
            PARTICLE_TO_ID[particle.ordinal()] = BuiltInRegistries.PARTICLE_TYPE.getId(particleType);
        }
    }
}
