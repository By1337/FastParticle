package dev.by1337.fparticle.particle;

import com.viaversion.viaversion.exception.InformativeException;
import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.via.FastVia;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class ParticleWriter {
    public static final int PACKET_ID = FParticleUtil.getLevelParticlesPacketId();
    //  public static final int COMPRESSION_THRESHOLD = FParticleUtil.getCompressionThreshold();
    private static final Logger log = LoggerFactory.getLogger("FParticle");

    private final double x, y, z;
    private final Consumer<ParticleWriter> onWrite;
    private ByteBuf out;
    private ViaHook.ViaMutator via;


    public ParticleWriter(double x, double y, double z, Consumer<ParticleWriter> onWrite) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.onWrite = onWrite;
    }
    public void accept(ViaHook.ViaMutator via, ByteBuf out) {
        this.via = via;
        this.out = out;
        onWrite.accept(this);
    }

    public final void write(MutableParticleData particle, double x, double y, double z) {
        write(particle, x, y, z, particle.xDist, particle.yDist, particle.zDist);
    }

    // prepender size varInt(1-3)
    // compress size varInt
    // packet id varInt
    // packet payload
    public final void write(MutableParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        int startBlockPtr = out.writerIndex();
        // пишем prepender size в два байта, максимум 2^14,
        // этого достаточно так как если размер будет больше чем COMPRESSION_THRESHOLD это значение перезапишется после сжатия
        ByteBufUtil.writeVarInt2(out, 0);

        int idx = out.writerIndex();
        // compress size всегда 0 если размер меньше COMPRESSION_THRESHOLD, если больше то при сжатии это значение перезапишется
        ByteBufUtil.writeVarInt1(out, 0);

        int packetStart = out.writerIndex();

        if (!via.shouldTransformPacket()) {
            writeParticleId();
            particle.write(out, this.x + x, this.y + y, this.z + z, xDist, yDist, zDist);
        } else if (particle.data() != null || !FastVia.write(via.protocol(), out, particle, this.x + x, this.y + y, this.z + z, xDist, yDist, zDist)) {
            writeParticleId();
            particle.write(out, this.x + x, this.y + y, this.z + z, xDist, yDist, zDist);
            try {
                // без slice via не умеет
                var slice = out.slice(packetStart, out.writerIndex() - packetStart);
                via.mutator().accept(slice);
                out.writerIndex(packetStart + slice.writerIndex());
            } catch (InformativeException e) {
                log.error("Failed to adapt packet via ViaVersion!", e);
                out.writerIndex(startBlockPtr);
                return;
            }
        }

        // Вообще надо бы сжать пакет, но пакет вряд ли будет размером больше чем 256 байт
        // Только партикл с ItemStack может превысить, но клиент всё равно примет пакет даже если он не был сжат.
        // Если решится на сжатие, то сюда надо прокинуть Deflater (он не потоко безопасный) + прокинуть native реализацию zlib которая скорее всего тоже не потоко безопасная.
        // Можно не парится и большие пакеты отправлять сразу Channel и там их успешно сожмут, но этот метод требует записи в out иначе ломается api.
        int size = out.writerIndex() - idx;
        // if (size < COMPRESSION_THRESHOLD) {
        ByteBufUtil.setVarInt2(out, startBlockPtr, size);
        // }
    }
    private void writeParticleId(){
        if ((PACKET_ID & (0xFFFFFFFF << 7)) == 0) {
            ByteBufUtil.writeVarInt1(out, PACKET_ID);
        } else if ((PACKET_ID & (0xFFFFFFFF << 14)) == 0) {
            ByteBufUtil.writeVarInt2(out, PACKET_ID);
        }
    }

}