package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.util.DistMutator;
import dev.by1337.fparticle.util.PosMutator;
import dev.by1337.fparticle.util.Vec3f;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

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

    public static void mutatePos(int startIndex, ByteBuf buf, PosMutator mutator, Vector vector) {
        instance.mutatePos(startIndex, buf, mutator, vector);
    }

    public static void mutatePos(int startIndex, ByteBuf buf, PosMutator mutator) {
        instance.mutatePos(startIndex, buf, mutator, new Vector());
    }

    public static void mutateDist(int startIndex, ByteBuf buf, DistMutator mutator, Vec3f vector) {
        instance.mutateDist(startIndex, buf, mutator, vector);
    }

    public static void mutateDist(int startIndex, ByteBuf buf, DistMutator mutator) {
        instance.mutateDist(startIndex, buf, mutator, new Vec3f());
    }

    protected static abstract class NmsAccessor {
        public abstract Channel getChannel(Player player);

        public abstract int getLevelParticlesPacketId();

        public abstract int getCompressionThreshold();

        public abstract MutableParticleData newParticle();

        public abstract void mutatePos(int startIndex, ByteBuf buf, PosMutator mutator, Vector vector);

        public abstract void mutateDist(int startIndex, ByteBuf buf, DistMutator mutator, Vec3f vector);
    }
}
