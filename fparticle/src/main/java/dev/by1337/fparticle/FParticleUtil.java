package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticleOutputStream;
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

    public static ParticleData newParticle(ParticleData.Builder builder) {
        return instance.newParticle(builder);
    }
    public static void send(Player player, ParticleOutputStream writer){
        var v = getChannel(player);
        if (v != null) v.write(writer);
    }


    public interface NmsAccessor {

        Channel getChannel(Player player);

        int getLevelParticlesPacketId();

        int getCompressionThreshold();

        ParticleData newParticle(ParticleData.Builder builder);

        int getParticleId(Particle particle, @Nullable Object data);
    }
}
