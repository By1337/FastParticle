package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class ShriekParticleOption implements ParticleOption {
    private final int delay;

    public ShriekParticleOption(int delay) {
        this.delay = delay;
    }

    @Override
    public void write(ByteBuf out, int version) {
        if (version < 759) throw new UnsupportedOperationException(version + " is not supported 759+");
        ByteBufUtil.writeVarInt(out, delay);
    }
    @Override
    public boolean writable(int version) {
        return version >= 759;
    }

    public int delay() {
        return delay;
    }
    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.SHRIEK_PARTICLE_OPTION;
    }
}
