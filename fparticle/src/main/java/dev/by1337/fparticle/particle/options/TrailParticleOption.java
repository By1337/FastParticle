package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

/**
 * @param duration since 769(1.21.4)
 */
public record TrailParticleOption(double x, double y, double z, int color, int duration) implements ParticleOption {

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 768) throw new UnsupportedOperationException(version + " is not supported 768+");
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeInt(color);
        if (version >= 769) {
            ByteBufUtil.writeVarInt(out, duration);
        }
    }

    @Override
    public boolean writable(int version) {
        return version >= 768;
    }

    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.TRAIL_PARTICLE_OPTION;
    }
}
