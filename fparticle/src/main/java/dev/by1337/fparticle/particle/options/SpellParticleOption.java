package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class SpellParticleOption implements ParticleOption {
    private final int argb;
    private final float power;

    public SpellParticleOption(int argb, float power) {
        this.argb = argb;
        this.power = power;
    }

    public SpellParticleOption(int alpha, int red, int green, int blue, float power) {
        argb = (alpha & 0xFF) << 24 | (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
        this.power = power;
    }

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 773) throw new UnsupportedOperationException(version + " is not supported 773+");
        out.writeInt(argb);
        out.writeFloat(power);

    }
    @Override
    public boolean writable(int version) {
        return version >= 773;
    }


    public int alpha() {
        return argb >>> 24;
    }

    public int red() {
        return argb >> 16 & 0xFF;
    }

    public int green() {
        return argb >> 8 & 0xFF;
    }

    public int blue() {
        return argb & 0xFF;
    }

    public int argb() {
        return argb;
    }

    public float power() {
        return power;
    }
    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.SPELL_PARTICLE_OPTION;
    }
}
