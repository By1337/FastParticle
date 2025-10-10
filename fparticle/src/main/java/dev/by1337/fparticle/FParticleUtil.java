package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.particle.ParticleWriter;
import io.netty.channel.Channel;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public final class FParticleUtil {
    static NmsAccessor instance;


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
    public static void send(Player player, ParticleWriter writer){
        var v = getChannel(player);
        if (v != null) v.write(writer);
    }


    protected static abstract class NmsAccessor {

        public abstract Channel getChannel(Player player);

        public abstract int getLevelParticlesPacketId();

        public abstract int getCompressionThreshold();

        public abstract MutableParticleData newParticle();

        public abstract int getParticleId(Particle particle, @Nullable Object data);
    }
}
