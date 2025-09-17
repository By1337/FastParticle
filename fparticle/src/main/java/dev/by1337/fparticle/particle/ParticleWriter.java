package dev.by1337.fparticle.particle;

import io.netty.buffer.ByteBuf;

public interface ParticleWriter {
    void write(ByteBuf buf);
    boolean hasNext();
}