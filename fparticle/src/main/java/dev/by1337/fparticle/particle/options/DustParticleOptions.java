package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

import java.util.Objects;

public final class DustParticleOptions implements ParticleOption {
    private final int rgb;
    private final float size;

    public DustParticleOptions(float r, float g, float b, float size) {
        int ri = (int) (r * 255) & 0xFF;
        int gi = (int) (g * 255) & 0xFF;
        int bi = (int) (b * 255) & 0xFF;
        rgb = (ri << 16) | (gi << 8) | bi;
        this.size = size;
    }

    public DustParticleOptions(int rgb, float size) {
        this.rgb = rgb;
        this.size = size;
    }

    @Override
    public void write(ByteBuf out, int version) {
        if (version >= 768) {
            out.writeInt(rgb);
            out.writeFloat(size);
        } else {
            out.writeFloat(((rgb >> 16) & 0xFF) / 255f);
            out.writeFloat(((rgb >> 8) & 0xFF) / 255f);
            out.writeFloat((rgb & 0xFF) / 255f);
            out.writeFloat(size);
        }
    }

    @Override
    public boolean writable(int version) {
        return true;
    }

    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.DUST_PARTICLE_OPTIONS;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DustParticleOptions that = (DustParticleOptions) o;
        return rgb == that.rgb && Float.compare(size, that.size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgb, size);
    }
}
