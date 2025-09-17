package dev.by1337.fparticle.particle;

public interface ParticleSource {
    ParticleWriter writer();
    int size();
}
