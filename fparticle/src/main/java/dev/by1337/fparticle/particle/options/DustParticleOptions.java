package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class DustParticleOptions implements ParticleOption {
    private final int rgb;
    private final float size;

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
}
