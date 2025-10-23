package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public record DustColorTransitionOptions(int rgbFrom, int rgbTo, float size) implements ParticleOption {

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 755) throw new UnsupportedOperationException(version + " is not supported 755+");
        boolean intColors = version >= 768;
        boolean sizeAfter = version >= 766;

        writeColor(out, rgbFrom, intColors);

        if (!sizeAfter) {
            out.writeFloat(size);
        }

        writeColor(out, rgbTo, intColors);

        if (sizeAfter) {
            out.writeFloat(size);
        }
    }

    private static void writeColor(ByteBuf out, int color, boolean intColors) {
        if (intColors) {
            out.writeInt(color);
        } else {
            out.writeFloat(((color >> 16) & 0xFF) / 255f);
            out.writeFloat(((color >> 8) & 0xFF) / 255f);
            out.writeFloat((color & 0xFF) / 255f);
        }
    }

    @Override
    public boolean writable(int version) {
        return version >= 755;
    }

    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.DUST_COLOR_TRANSITION_OPTIONS;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DustColorTransitionOptions that = (DustColorTransitionOptions) o;
        return rgbFrom == that.rgbFrom && rgbTo == that.rgbTo && Float.compare(size, that.size) == 0;
    }

}

