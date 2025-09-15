package dev.by1337.fparticle.particle;

import io.netty.buffer.ByteBuf;

public interface ParticleIterator {
    void write(ByteBuf buf);
    boolean hasNext();
}