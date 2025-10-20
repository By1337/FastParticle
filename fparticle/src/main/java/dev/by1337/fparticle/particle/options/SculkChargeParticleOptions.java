package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class SculkChargeParticleOptions implements ParticleOption {
    private final float roll;

    public SculkChargeParticleOptions(float roll) {
        this.roll = roll;
    }

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 759) throw new UnsupportedOperationException(version + " is not supported 759+");
        out.writeFloat(roll);
    }
    @Override
    public boolean writable(int version) {
        return version >= 759;
    }
    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.SCULK_CHARGE_PARTICLE_OPTIONS;
    }
}
