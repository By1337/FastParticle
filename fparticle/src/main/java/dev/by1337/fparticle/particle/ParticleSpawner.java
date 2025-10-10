package dev.by1337.fparticle.particle;

public abstract class ParticleSpawner implements ParticleSource {

    protected abstract void onWrite(ParticleWriter writer);

    @Override
    public ParticleWriter newWriter(double x, double y, double z) {
        return new ParticleWriter(x, y, z, this::onWrite);
    }
}
