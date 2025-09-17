package dev.by1337.fparticle.netty.buffer;

import com.viaversion.viaversion.exception.InformativeException;
import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteBufUtil {
    public static final int PACKET_ID = FParticleUtil.getLevelParticlesPacketId();
    public static final int COMPRESSION_THRESHOLD = FParticleUtil.getCompressionThreshold();
    private static final Logger log = LoggerFactory.getLogger("FParticle");


    public static ByteBuf writeAndGetSlice(ByteBuf out, ParticleSource particles, ViaHook.ViaMutator via) {
        int start = out.writerIndex();
        writeParticle(out, particles, via);
        int end = out.writerIndex();
        return start == end ? null : out.retainedSlice(start, end - start);
    }

    // prepender size varInt3
    // compress size varInt
    // packet id varInt
    // packet payload
    public static void writeParticle(ByteBuf out, ParticleSource particles, ViaHook.ViaMutator via) {
        var iterator = particles.writer();

        while (iterator.hasNext()) {
            int startBlockPtr = out.writerIndex();
            // пишем prepender size в два байта, максимум 2^14,
            // этого достаточно так как если размер будет больше чем COMPRESSION_THRESHOLD это значение перезапишется после сжатия
            writeVarInt2(out, 0);

            int idx = out.writerIndex();
            // compress size всегда 0 если размер меньше COMPRESSION_THRESHOLD, если больше то при сжатии это значение перезапишется
            writeVarInt1(out, 0);

            int packetStart = out.writerIndex();

            writeVarInt(out, PACKET_ID);
            iterator.write(out);
            if (via.shouldTransformPacket()) {
                try {
                    // без slice via не умеет
                    var slice = out.slice(packetStart, out.writerIndex() - packetStart);
                    via.mutator().accept(slice);
                    out.writerIndex(packetStart + slice.writerIndex());
                } catch (InformativeException ignored) {
                    log.error("Failed to adapt package via ViaVersion!");
                    out.writerIndex(startBlockPtr);
                    return;
                }
            }

            int size = out.writerIndex() - idx;
            if (size < COMPRESSION_THRESHOLD) {
                setVarInt2(out, startBlockPtr, size);
            } else {
                //todo compress
            }
        }


    }

    public static void writeVarInt1(ByteBuf buf, int value) {
        buf.writeByte(value);
    }

    public static void writeVarInt2(ByteBuf buf, int value) {
        buf.writeShort((value & 0x7F | 0x80) << 8 | (value >>> 7));
    }

    public static void setVarInt2(ByteBuf buf, int index, int value) {
        buf.setShort(index, (value & 0x7F | 0x80) << 8 | (value >>> 7));
    }

    public static void writeVarInt(ByteBuf buf, int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            buf.writeByte(value);
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            int w = (value & 0x7F | 0x80) << 8 | (value >>> 7);
            buf.writeShort(w);
        } else if ((value & (0xFFFFFFFF << 21)) == 0) {
            int w = (value & 0x7F | 0x80) << 16 | ((value >>> 7) & 0x7F | 0x80) << 8 | (value >>> 14);
            buf.writeMedium(w);
        } else if ((value & (0xFFFFFFFF << 28)) == 0) {
            int w = (value & 0x7F | 0x80) << 24 | (((value >>> 7) & 0x7F | 0x80) << 16)
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | (value >>> 21);
            buf.writeInt(w);
        } else {
            int w = (value & 0x7F | 0x80) << 24 | ((value >>> 7) & 0x7F | 0x80) << 16
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | ((value >>> 21) & 0x7F | 0x80);
            buf.writeInt(w);
            buf.writeByte(value >>> 28);
        }
    }

    public static int warIntSize(int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            return 1;
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int readVarInt(ByteBuf buf) {
        int readable = buf.readableBytes();
        if (readable == 0) {
            throw new IllegalArgumentException();
        }

        int k = buf.readByte();
        if ((k & 0x80) != 128) {
            return k;
        }
        int maxRead = Math.min(5, readable);
        int i = k & 0x7F;
        for (int j = 1; j < maxRead; j++) {
            k = buf.readByte();
            i |= (k & 0x7F) << j * 7;
            if ((k & 0x80) != 128) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    static {
        // Без сжатия в prepender size пишем только два байта, и в два байта помещается только 2^14
        if (COMPRESSION_THRESHOLD > 16384) {
            throw new IllegalStateException("Bad compression threshold. Should be < 16384.");
        }
    }
}
