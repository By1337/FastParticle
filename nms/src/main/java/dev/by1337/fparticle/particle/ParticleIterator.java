package dev.by1337.fparticle.particle;

import io.netty.buffer.ByteBuf;

@FunctionalInterface
public interface ParticleIterator {
    boolean writeNext(ByteBuf buf);
}