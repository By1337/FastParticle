package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticlePacketBuilder;
import dev.by1337.fparticle.util.NMSLoader;
import io.netty.channel.Channel;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Utility class for handling particle-related operations in conjunction with NMS (Net Minecraft Server) functionalities.
 * This class provides methods for creating, manipulating, and sending particle packets to players,
 * while abstracting away the NMS implementation details.
 *
 * <p>All methods in this class delegate the underlying functionality to the internally managed {@link NmsAccessor} instance,
 * which adapts to the specific NMS version in use.</p>
 *
 * This class is not designed to be instantiated and serves solely static purposes.
 */
@Deprecated // todo no nms
public final class FParticleUtil {
    static final NmsAccessor instance;

    public static Channel getChannel(Player player) {
        return instance.getChannel(player);
    }

    public static void send(Player player, ParticlePacketBuilder writer) {
        var v = getChannel(player);
        if (v != null) v.write(writer);
    }

    static {
        instance = NMSLoader.load();
    }

    public interface NmsAccessor {

        @Contract("null -> false")
        boolean isPlayState(@Nullable Player player);

        @Contract("null -> null")
        @Nullable Channel getChannel(@Nullable Player player);

        default int getLevelParticlesPacketId() {
            return -1;
        }

        int getCompressionThreshold();

        ParticleData newParticle(ParticleData.Builder builder);

        int getParticleId(Particle particle, @Nullable Object data);
    }
}
