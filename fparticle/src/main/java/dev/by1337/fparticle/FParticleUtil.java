package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.MutableParticleData;
import io.netty.channel.Channel;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public final class FParticleUtil {
    static NmsAccessor instance;

    public static boolean canReceiveParticles(Player player) {
        return instance.canReciveParticles(player);
    }

    public static Channel getChannel(Player player) {
        return instance.getChannel(player);
    }

    public static int getLevelParticlesPacketId() {
        return instance.getLevelParticlesPacketId();
    }

    public static int getCompressionThreshold() {
        return instance.getCompressionThreshold();
    }

    public static MutableParticleData newParticle() {
        return instance.newParticle();
    }


    protected static abstract class NmsAccessor {
        public abstract boolean canReciveParticles(Player player);

        public abstract Channel getChannel(Player player);

        public abstract int getLevelParticlesPacketId();

        public abstract int getCompressionThreshold();

        public abstract MutableParticleData newParticle();

        public abstract int getParticleId(Particle particle, @Nullable Object data);
    }
}
