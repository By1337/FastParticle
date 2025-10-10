package dev.by1337.fparticle.particle;

public interface ParticleSource {
    ParticleWriter newWriter(double x, double y, double z);
}
