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
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class SingleParticleBatch implements ParticleIterable {
    private static final NMSUtil NMS_UTIL = FParticle.NMS_UTIL;
    private final double[] pos;
    private final byte[] particle;
    private final int size;
    private final int bytesSize;
    private @Nullable PosMutator posMutator;
    private @Nullable DistMutator distMutator;

    private SingleParticleBatch(double[] pos, byte[] particle) {
        if (pos.length == 0) throw new IllegalArgumentException();
        this.pos = pos;
        this.particle = particle;
        size = pos.length / 3;
        bytesSize = particle.length + pos.length * Double.BYTES;
    }

    public static SingleParticleBatch create(MutableParticleData particle, Consumer<Spawner> consumer) {
        ByteBuf particle1 = Unpooled.buffer();
        particle.write(particle1);
        byte[] particleBytes = new byte[particle1.readableBytes()];
        particle1.readBytes(particleBytes);
        particle1.release();
        DoubleArrayList list = new DoubleArrayList();
        consumer.accept((x, y, z) -> {
            list.add(x);
            list.add(y);
            list.add(z);
        });
        return new SingleParticleBatch(list.toDoubleArray(), particleBytes);
    }


    public @Nullable PosMutator posMutator() {
        return posMutator;
    }

    public SingleParticleBatch posMutator(@Nullable PosMutator posMutator) {
        this.posMutator = posMutator;
        return this;
    }

    public @Nullable DistMutator distMutator() {
        return distMutator;
    }

    public SingleParticleBatch distMutator(@Nullable DistMutator distMutator) {
        this.distMutator = distMutator;
        return this;
    }

    public SingleParticleBatch witchPosMutator(PosMutator posMutator) {
        var mutator = this.posMutator == null ? posMutator : this.posMutator.and(posMutator);
        return new SingleParticleBatch(pos, particle).posMutator(mutator);
    }

    public SingleParticleBatch witchDistMutator(DistMutator distMutator) {
        DistMutator mutator = this.distMutator == null ? distMutator : this.distMutator.and(distMutator);
        return new SingleParticleBatch(pos, particle).distMutator(mutator).posMutator(posMutator);
    }

    public SingleParticleBatch copy() {
        return new SingleParticleBatch(pos, particle).posMutator(posMutator).distMutator(distMutator);
    }

    @Override
    public ParticleIterator iterator() {
        return new ParticleIterator() {
            int ptr;
            final Vector vector = new Vector();
            final Vec3f vec = distMutator == null ? null : new Vec3f();
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
                if (distMutator != null){
                    NMS_UTIL.mutateDist(startPtr, buf, distMutator, vec);
                }
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
        void at(double x, double y, double z);
    }
}
