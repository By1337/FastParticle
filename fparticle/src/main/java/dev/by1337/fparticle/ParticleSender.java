/*
package dev.by1337.fparticle;

import dev.by1337.fparticle.netty.handler.ParticleEncoder;
import dev.by1337.fparticle.particle.ParticleSource;
import io.netty.buffer.ByteBuf;

import java.io.Closeable;
import java.util.Arrays;

public class ParticleSender implements Closeable {
    private final int[] protocols = new int[32];
    private int freeBuffIdx = 0;
    private final ByteBuf[] bufs = new ByteBuf[32];
    private ParticleSource particleSource;

    public ParticleSender(ParticleSource particleSource) {
        this.particleSource = particleSource;
    }

    public void send(ParticleEncoder receiver, double x, double y, double z) {
        freeBuffIdx = send(receiver, particleSource, protocols, freeBuffIdx, bufs, x, y, z);
    }

    public ParticleSource particleSource() {
        return particleSource;
    }

    public void particleSource(ParticleSource particleSource) {
        this.particleSource = particleSource;
    }

    public void reset() {
        for (int i = 0; i < freeBuffIdx; i++) {
            bufs[i].release();
        }
        Arrays.fill(protocols, 0);
        Arrays.fill(bufs, null);
        freeBuffIdx = 0;
    }

    @Override
    public void close() {
        reset();
    }

    static int send(ParticleEncoder receiver, ParticleSource particles, int[] protocols, int freeBuffIdx, ByteBuf[] bufs, double x, double y, double z) {
        if (receiver == null) return freeBuffIdx;
        int protocol = receiver.protocolVersion();
        int idx = protocol % 32;
        int packed = protocols[idx];
        int storedProtocol = packed & 0xFFFFFF;
        if (packed == 0) {
            ByteBuf buf = receiver.writeAndGetRetainedSlice(particles, x, y, z);
            if (buf != null) {
                bufs[freeBuffIdx] = buf;
                protocols[idx] = ((freeBuffIdx & 0xFF) << 24) | (protocol & 0xFFFFFF);
                freeBuffIdx++;
            }
        } else if (storedProtocol == protocol) {
            int bufIdx = (packed >>> 24) & 0xFF;
            ByteBuf buf = bufs[bufIdx];
            receiver.write(buf.retainedDuplicate());
        } else {
            receiver.write(particles, x, y, z);
        }
        return freeBuffIdx;
    }
}
*/
