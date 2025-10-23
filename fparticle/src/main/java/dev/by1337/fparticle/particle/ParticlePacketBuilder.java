package dev.by1337.fparticle.particle;

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
 * Users typically interact with this class through the {@link #append(ParticleData, double, double, double)}
 * and {@link #append(ParticleSource, double, double, double)} methods when implementing custom
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
public abstract class ParticlePacketBuilder implements PacketBuilder {
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



}