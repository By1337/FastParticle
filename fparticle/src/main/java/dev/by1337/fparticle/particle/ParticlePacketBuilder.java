package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.via.ParticleWriter;
import dev.by1337.fparticle.via.Mappings;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Builder for constructing particle network packets.
 * <p>
 * This class handles the low-level encoding of particle data into Minecraft protocol packets.
 * It manages protocol version adaptation, VarInt encoding, and ByteBuf writing operations.
 * <p>
 * Users typically interact with this class through the {@link #write(ParticleData, double, double, double)}
 * and {@link #write(ParticleSource, double, double, double)} methods when implementing custom
 * {@link ParticleSource} patterns.
 * <p>
 * The builder uses a callback pattern where {@link #onWrite()} is invoked during packet encoding
 * to populate the packet with particle data. This allows for lazy evaluation and efficient batching.
 * <p>
 * <b>Internal API:</b> The {@link #accept(ViaHook.ViaMutator, ByteBuf)} method and internal fields
 * are part of the packet encoding pipeline and should not be called directly by users.
 *
 * @see ParticleSource
 * @see ParticleData
 * @see dev.by1337.fparticle.netty.handler.ParticleEncoder
 */
public abstract class ParticlePacketBuilder {
    private static final Logger log = LoggerFactory.getLogger("FParticle");

    private ByteBuf out;
    private ViaHook.ViaMutator via;

    /**
     * Accepts the protocol mutator and output buffer to begin packet encoding.
     * <p>
     * This method is called internally by {@link dev.by1337.fparticle.netty.handler.ParticleEncoder}
     * during the Netty encoding pipeline. It sets up the encoding context and invokes {@link #onWrite()}
     * to populate the packet.
     * <p>
     * <b>Internal API:</b> This method should not be called directly by users.
     *
     * @param via the protocol version mutator for client adaptation
     * @param out the ByteBuf to write packet data to
     */
    public final void accept(ViaHook.ViaMutator via, ByteBuf out) {
        this.via = via;
        this.out = out;
        onWrite();
    }


    protected abstract void onWrite();

    /**
     * Writes a particle source pattern to the packet.
     * <p>
     * This method delegates to the source's {@link ParticleSource#doWrite(ParticlePacketBuilder, double, double, double)}
     * method, allowing composition of particle patterns. All particles written by the source will be
     * batched into the same network packet.
     * <p>
     * Example:
     * <pre>{@code
     * @Override
     * public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
     *     // Write another particle source at an offset
     *     writer.write(otherSource, baseX + 5, baseY, baseZ);
     * }
     * }</pre>
     *
     * @param particle the particle source pattern to write
     * @param x        the X coordinate for the pattern
     * @param y        the Y coordinate for the pattern
     * @param z        the Z coordinate for the pattern
     */
    public final void write(ParticleSource particle, double x, double y, double z) {
        particle.doWrite(this, x, y, z);
    }

    /**
     * Writes a single particle to the packet at the specified coordinates.
     * <p>
     * This is the primary method for spawning particles within a {@link ParticleSource} implementation.
     * The particle will be encoded with its configured offsets ({@link ParticleData#xDist},
     * {@link ParticleData#yDist}, {@link ParticleData#zDist}).
     * <p>
     * Example:
     * <pre>{@code
     * ParticleData flame = ParticleData.builder()
     *     .particle(Particle.FLAME)
     *     .count(1)
     *     .build();
     *
     * @Override
     * public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
     *     writer.write(flame, baseX, baseY, baseZ);
     * }
     * }</pre>
     *
     * @param particle the particle data to write
     * @param x        the X world coordinate
     * @param y        the Y world coordinate
     * @param z        the Z world coordinate
     */
    public final void write(ParticleData particle, double x, double y, double z) {
        write(particle, x, y, z, particle.xDist, particle.yDist, particle.zDist);
    }

    // prepender size varInt(1-3)
    // compress size varInt
    // packet id varInt
    // packet payload
    public final void write(ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        final int prependerStartIdx = out.writerIndex();
        // пишем prepender size в два байта, максимум 2^14,
        // этого достаточно так как если размер будет больше чем COMPRESSION_THRESHOLD это значение перезапишется после сжатия
        ByteBufUtil.writeVarInt2(out, 0);

        final int compressStartIdx = prependerStartIdx + 2;
        // compress size всегда 0 если размер меньше COMPRESSION_THRESHOLD, если больше то при сжатии это значение перезапишется
        ByteBufUtil.writeVarInt1(out, 0);

        final int payloadStart = compressStartIdx + 1;

        final int version = via.protocol();
        int writeLike = ParticleWriter.write(version, out, particle, x, y, z, xDist, yDist, zDist);
        if (writeLike == -1) {
            out.writerIndex(prependerStartIdx);
            return;
        }
        if (writeLike != version) {
            if (writeLike == Mappings.NATIVE_PROTOCOL) {
                try {
                    // без slice via не умеет
                    out.ensureWritable(256);
                    int widx = out.writerIndex() - payloadStart;
                    var slice = out.slice(payloadStart, widx + 256);
                    slice.writerIndex(widx);
                    via.mutator().accept(slice);
                    out.writerIndex(payloadStart + slice.writerIndex());
                } catch (Exception e) {
                    log.error("Failed to adapt packet via ViaVersion!", e);
                    out.writerIndex(prependerStartIdx);
                    return;
                }
            } else {
                log.error("Записал как {} хотя ожидалось {} или {}", writeLike, version, Mappings.NATIVE_PROTOCOL);
                out.writerIndex(prependerStartIdx);
                return;
            }
        }
        // Вообще надо бы сжать пакет, но пакет вряд ли будет размером больше чем 256 байт
        // Только партикл с ItemStack может превысить, но клиент всё равно примет пакет даже если он не был сжат.
        // Если решится на сжатие, то сюда надо прокинуть Deflater, который можно создать в ParticleEncoder.
        int prependerSize = out.writerIndex() - compressStartIdx;

        //Под prepender size выделили только 2 байта...
        //Если 1 пакет с партиклом занимает больше 16384 байт, то это не норма
        if (prependerSize > 16384) {
            // Здесь можно весь буфер с prependerStartIdx+2 сдвинуть на 1 байт и всё же записать prepender size,
            // но смысл поддерживать плохие решения когда в пакет попадает ItemStack с градиентами и вообще со всем...
            log.error("Packet size exceeds 16384!");
            out.writerIndex(prependerStartIdx);
            return;
        }
        ByteBufUtil.setVarInt2(out, prependerStartIdx, prependerSize);
    }
}