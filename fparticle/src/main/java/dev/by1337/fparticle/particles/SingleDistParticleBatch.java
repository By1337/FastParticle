package dev.by1337.fparticle.particles;

import dev.by1337.fparticle.*;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.particle.ParticleIterator;
import dev.by1337.fparticle.util.DistMutator;
import dev.by1337.fparticle.util.PosMutator;
import dev.by1337.fparticle.util.Vec3f;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class SingleDistParticleBatch implements ParticleIterable {
    private static final NMSUtil NMS_UTIL = FParticle.NMS_UTIL;
    private final double[] pos;
    private final float[] dist;
    private final byte[] particle;
    private final int size;
    private final int bytesSize;
    private @Nullable PosMutator posMutator;
    private @Nullable DistMutator distMutator;

    private SingleDistParticleBatch(double[] pos, float[] dist, byte[] particle) {
        if (pos.length == 0) throw new IllegalArgumentException();
        this.dist = dist;
        this.pos = pos;
        this.particle = particle;
        size = pos.length / 3;
        bytesSize = particle.length + pos.length * Double.BYTES;
    }

    public static SingleDistParticleBatch create(MutableParticleData particle, Consumer<Spawner> consumer) {
        ByteBuf particle1 = Unpooled.buffer();
        particle.write(particle1);
        byte[] particleBytes = new byte[particle1.readableBytes()];
        particle1.readBytes(particleBytes);
        particle1.release();
        DoubleArrayList positions = new DoubleArrayList();
        FloatArrayList dist = new FloatArrayList();
        consumer.accept((x, y, z, xDist,  yDist, zDist) -> {
            positions.add(x);
            positions.add(y);
            positions.add(z);
            dist.add(xDist);
            dist.add(yDist);
            dist.add(zDist);
        });
        return new SingleDistParticleBatch(positions.toDoubleArray(), dist.toFloatArray(), particleBytes);
    }


    public @Nullable PosMutator posMutator() {
        return posMutator;
    }

    public SingleDistParticleBatch posMutator(@Nullable PosMutator posMutator) {
        this.posMutator = posMutator;
        return this;
    }

    public @Nullable DistMutator distMutator() {
        return distMutator;
    }

    public SingleDistParticleBatch distMutator(@Nullable DistMutator distMutator) {
        this.distMutator = distMutator;
        return this;
    }

    public SingleDistParticleBatch witchPosMutator(PosMutator posMutator) {
        var mutator = this.posMutator == null ? posMutator : this.posMutator.and(posMutator);
        return new SingleDistParticleBatch(pos, dist, particle).posMutator(mutator);
    }

    public SingleDistParticleBatch witchDistMutator(DistMutator distMutator) {
        DistMutator mutator = this.distMutator == null ? distMutator : this.distMutator.and(distMutator);
        return new SingleDistParticleBatch(pos, dist, particle).distMutator(mutator).posMutator(posMutator);
    }

    public SingleDistParticleBatch copy() {
        return new SingleDistParticleBatch(pos, dist, particle).posMutator(posMutator).distMutator(distMutator);
    }

    @Override
    public ParticleIterator iterator() {
        return new ParticleIterator() {
            int ptr;
            final Vector vector = new Vector();
            final Vec3f vec = new Vec3f();
            @Override
            public boolean writeNext(ByteBuf buf) {
                if (ptr >= pos.length) return false;
                int startPtr = buf.writerIndex();
                buf.writeBytes(particle);

                NMS_UTIL.mutatePos(startPtr, buf, v -> {
                    v.setX(pos[ptr])
                            .setY(pos[ptr + 1])
                            .setZ(pos[ptr + 2]);
                    if (posMutator != null) posMutator.mutate(v);
                }, vector);
                NMS_UTIL.mutateDist(startPtr, buf, v -> {
                    v.set(dist[ptr], dist[ptr +1],  dist[ptr + 2]);
                    if (distMutator != null) distMutator.mutate(v);
                }, vec);
                ptr += 3;
                return true;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    public int sizeBytes() {
        return bytesSize;
    }

    public interface Spawner {
        void at(double x, double y, double z, float xDist, float yDist, float zDist);
    }
}
