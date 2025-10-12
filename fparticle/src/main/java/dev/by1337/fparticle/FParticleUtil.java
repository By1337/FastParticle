package dev.by1337.fparticle;

import dev.by1337.fparticle.netty.NMSLoader;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticlePacketBuilder;
import io.netty.channel.Channel;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.net.URLClassLoader;

public final class FParticleUtil {
    static NmsAccessor instance;

    @ApiStatus.Internal
    public static void setInstance(NmsAccessor instance) {
        FParticleUtil.instance = instance;
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

    public static ParticleData newParticle(ParticleData.Builder builder) {
        return instance.newParticle(builder);
    }

    public static void send(Player player, ParticlePacketBuilder writer) {
        var v = getChannel(player);
        if (v != null) v.write(writer);
    }

    public static boolean isPlayState(Player player) {
        return instance.isPlayState(player);
    }

    public static int getParticleId(Particle particle, @Nullable Object data) {
        return instance.getParticleId(particle, data);
    }

    static {
        if (FParticleUtil.class.getClassLoader() instanceof URLClassLoader urlClassLoader) {
            NMSLoader.load(urlClassLoader);
        } else {
            throw new IllegalStateException("nms is not loaded");
        }
    }

    public interface NmsAccessor {

        @Contract("null -> false")
        boolean isPlayState(@Nullable Player player);

        @Contract("null -> null")
        @Nullable Channel getChannel(@Nullable Player player);

        int getLevelParticlesPacketId();

        int getCompressionThreshold();

        ParticleData newParticle(ParticleData.Builder builder);

        int getParticleId(Particle particle, @Nullable Object data);
    }
}
