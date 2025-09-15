package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.util.DistMutator;
import dev.by1337.fparticle.util.PosMutator;
import dev.by1337.fparticle.util.Vec3f;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public interface NMSUtil {
    Channel getChannel(Player player);

    int getLevelParticlesPacketId();
    int getCompressionThreshold();

    MutableParticleData newParticle();

    void mutatePos(int startIndex, ByteBuf buf, PosMutator mutator, Vector vector);

    default void mutatePos(int startIndex, ByteBuf buf, PosMutator mutator) {
        mutatePos(startIndex, buf, mutator, new Vector());
    }

    void mutateDist(int startIndex, ByteBuf buf, DistMutator mutator, Vec3f vector);

    default void mutateDist(int startIndex, ByteBuf buf, DistMutator mutator) {
        mutateDist(startIndex, buf, mutator, new Vec3f());
    }
}
