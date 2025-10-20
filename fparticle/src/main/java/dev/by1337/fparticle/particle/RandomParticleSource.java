package dev.by1337.fparticle.particle;

import java.util.concurrent.ThreadLocalRandom;

public class RandomParticleSource extends ParticleSource {
    private final ParticleSource[] values;
    private final int size;

    public RandomParticleSource(ParticleSource... values) {
        this.values = values;
        size = values.length;
    }

    @Override
    public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
        values[ThreadLocalRandom.current().nextInt(size)].doWrite(writer, baseX, baseY, baseZ);
    }
}
