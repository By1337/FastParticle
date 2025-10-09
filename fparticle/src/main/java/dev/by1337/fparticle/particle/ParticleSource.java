package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;

public interface ParticleSource {
    void write(double x, double y, double z, ByteBuf out, ViaHook.ViaMutator via);
}
