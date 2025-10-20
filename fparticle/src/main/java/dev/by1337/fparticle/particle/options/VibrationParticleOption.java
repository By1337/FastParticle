package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class VibrationParticleOption implements ParticleOption {

    @Override
    public void write(ByteBuf out, int version) {

    }
    @Override
    public boolean writable(int version) {
        return false;
    }
    @Override
    public ParticleOptionType getType() {
        return null;
       // return ParticleOptionType.VIBRATION_PARTICLE_OPTION;
    }
}
