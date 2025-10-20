package dev.by1337.fparticle.particle;

public interface PacketBuilder {

    default void append(ParticleSource particle, double x, double y, double z) {
        particle.doWrite(this, x, y, z);
    }

    default void append(ParticleData particle, double x, double y, double z) {
        append(particle, x, y, z, particle.xDist, particle.yDist, particle.zDist);
    }

    void append(ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist);
}
