package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleSource;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;

public class ParticleSender {
    private final int[] protocols = new int[32];
    private int freeBuffIdx = 0;
    private final ByteBuf[] bufs = new ByteBuf[32];
    private ParticleSource particleSource;

    public ParticleSender(ParticleSource particleSource) {
        this.particleSource = particleSource;
    }

    public void send(ParticleReceiver receiver) {
        freeBuffIdx = send(receiver, particleSource, protocols, freeBuffIdx, bufs);
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

    static int send(ParticleReceiver receiver, ParticleSource particles, int[] protocols, int freeBuffIdx, ByteBuf[] bufs) {
        int protocol = receiver.protocolVersion();
        int idx = protocol % 32;
        int packed = protocols[idx];
        int storedProtocol = packed & 0xFFFFFF;
        if (packed == 0) {
            ByteBuf buf = receiver.writeAndGetSlice(particles); //todo без slice
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
            receiver.write(particles);
        }
        return freeBuffIdx;
    }
}
