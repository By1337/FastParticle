package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class PowerParticleOption implements ParticleOption {
    private final float power;

    public PowerParticleOption(float power) {
        this.power = power;
    }

    @Override
    public void write(ByteBuf out, int version) {
        out.writeFloat(this.power);
    }

    @Override
    public boolean writable(int version) {
        return version >= 773;
    }
    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.POWER_PARTICLE_OPTION;
    }
}
