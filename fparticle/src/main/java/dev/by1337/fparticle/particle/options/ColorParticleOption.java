package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

import java.util.Objects;

public final class ColorParticleOption implements ParticleOption {

    private final int argb;

    public ColorParticleOption(int argb) {
        this.argb = argb;
    }

    public ColorParticleOption(int alpha, int red, int green, int blue) {
        argb = (alpha & 0xFF) << 24 | (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
    }

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 766) throw new UnsupportedOperationException(version + " is not supported 766+");
        out.writeInt(argb);
    }

    @Override
    public boolean writable(int version) {
        return version >= 766;
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
    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.COLOR_PARTICLE_OPTION;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ColorParticleOption that = (ColorParticleOption) o;
        return argb == that.argb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(argb);
    }
}
