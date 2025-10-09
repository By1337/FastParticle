package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;

public abstract class ParticleSpawner implements ParticleSource {

    protected abstract void onWrite(ParticleWriter writer);

    @Override
    public void write(double x, double y, double z, ByteBuf out, ViaHook.ViaMutator via) {
        ParticleWriter writer = new ParticleWriter(x, y, z, out, via);
        onWrite(writer);
    }
}
