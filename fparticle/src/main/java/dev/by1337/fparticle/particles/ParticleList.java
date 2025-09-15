package dev.by1337.fparticle.particles;

import dev.by1337.fparticle.*;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.particle.ParticleIterator;
import dev.by1337.fparticle.util.ByteBufUtil;
import dev.by1337.fparticle.util.DistMutator;
import dev.by1337.fparticle.util.PosMutator;
import dev.by1337.fparticle.util.Vec3f;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ParticleList implements ParticleIterable {
    private static final NMSUtil NMS_UTIL = FParticle.NMS_UTIL;
    private final ByteBuf buf;
    private final ByteBuf offsets;
    private final @Nullable PosMutator posMutator;
    private final @Nullable DistMutator distMutator;
    private final int size;

    private ParticleList(ByteBuf buf, ByteBuf offsets, @Nullable PosMutator posMutator, @Nullable DistMutator distMutator, int size) {
        this.buf = buf;
        this.offsets = offsets;
        this.posMutator = posMutator;
        this.distMutator = distMutator;
        this.size = size;

    }

    public static ParticleList.Builder builder() {
        return new Builder();
    }

    public @Nullable PosMutator posMutator() {
        return posMutator;
    }

    public int size() {
        return size;
    }

    public int sizeBytes() {
        return buf.readableBytes();
    }

    public ParticleIterator iterator() {
        return new ParticleIterator() {
            final ByteBuf buf = ParticleList.this.buf.duplicate();
            final ByteBuf offsets = ParticleList.this.offsets.duplicate();
            final Vector vector = posMutator == null ? null : new Vector();
            final Vec3f vec = distMutator == null ? null : new Vec3f();

            @Override
            public boolean writeNext(ByteBuf out) {
                if (offsets.readableBytes() == 0) return false;
                int startOffset = ByteBufUtil.readVarInt(offsets);
                offsets.markReaderIndex();
                int endOffset = offsets.readableBytes() > 0 ? ByteBufUtil.readVarInt(offsets) : buf.readableBytes();
                offsets.resetReaderIndex();
                int offset = out.writerIndex();
                out.writeBytes(buf, startOffset, endOffset - startOffset);
                if (posMutator != null) {
                    NMS_UTIL.mutatePos(offset, out, posMutator, vector);
                }
                if (distMutator != null){
                    NMS_UTIL.mutateDist(offset, out, distMutator, vec);
                }
                return true;
            }
        };
    }



    public static class Builder {
        private final ByteBuf buf = Unpooled.buffer();
        private final ByteBuf offsets = Unpooled.buffer();
        private final MutableParticleData particle = FParticle.NMS_UTIL.newParticle();
        private @Nullable PosMutator posMutator;
        private @Nullable DistMutator distMutator;
        private int size;

        public @Nullable PosMutator posMutator() {
            return posMutator;
        }

        public Builder posMutator(@Nullable PosMutator posMutator) {
            this.posMutator = posMutator;
            return this;
        }

        public Builder distMutator(@Nullable DistMutator distMutator) {
            this.distMutator = distMutator;
            return this;
        }

        public Builder write(BiConsumer<MutableParticleData, Consumer<MutableParticleData>> c) {
            c.accept(particle, this::write);
            return this;
        }

        public Builder write(MutableParticleData particle) {
            ByteBufUtil.writeVarInt(offsets, buf.writerIndex());
            particle.write(buf);
            size++;
            return this;
        }

        public Builder write(Consumer<MutableParticleData> consumer) {
            consumer.accept(particle);
            ByteBufUtil.writeVarInt(offsets, buf.writerIndex());
            particle.write(buf);
            size++;
            return this;
        }

        public ParticleList build() {
            byte[] bufBytes = new byte[buf.readableBytes()];
            buf.readBytes(bufBytes);
            byte[] offsetsBytes = new byte[offsets.readableBytes()];
            offsets.readBytes(offsetsBytes);
            buf.release();
            offsets.release();
            return new ParticleList(
                    Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(bufBytes)),
                    Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(offsetsBytes)),
                    posMutator,
                    distMutator,
                    size
            );
        }
    }

}
