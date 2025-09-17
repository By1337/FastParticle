package dev.by1337.fparticle.particle.impl;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.particle.ParticleWriter;
import dev.by1337.fparticle.util.DistMutator;
import dev.by1337.fparticle.util.PosMutator;
import dev.by1337.fparticle.util.Vec3f;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ParticleList implements ParticleSource {
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

    public ParticleWriter writer() {
        return new ParticleWriter() {
            final ByteBuf buf = ParticleList.this.buf.duplicate();
            final ByteBuf offsets = ParticleList.this.offsets.duplicate();
            final Vector vector = posMutator == null ? null : new Vector();
            final Vec3f vec = distMutator == null ? null : new Vec3f();

            @Override
            public void write(ByteBuf out) {
                if (offsets.readableBytes() == 0) throw new NoSuchElementException();
                int startOffset = ByteBufUtil.readVarInt(offsets);
                offsets.markReaderIndex();
                int endOffset = offsets.readableBytes() > 0 ? ByteBufUtil.readVarInt(offsets) : buf.readableBytes();
                offsets.resetReaderIndex();
                int offset = out.writerIndex();
                out.writeBytes(buf, startOffset, endOffset - startOffset);
                if (posMutator != null) {
                    FParticleUtil.mutatePos(offset, out, posMutator, vector);
                }
                if (distMutator != null) {
                    FParticleUtil.mutateDist(offset, out, distMutator, vec);
                }
            }

            @Override
            public boolean hasNext() {
                return offsets.readableBytes() > 0;
            }
        };
    }


    public static class Builder {
        private final ByteBuf buf = Unpooled.buffer();
        private final ByteBuf offsets = Unpooled.buffer();
        private final MutableParticleData particle = FParticleUtil.newParticle();
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
