package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.BlockType;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public record BlockParticleOption(BlockType block) implements ParticleOption {

    @Override
    public void write(ByteBuf out, int version) {
        ByteBufUtil.writeVarInt(out, block.getProtocolId(version));
    }

    @Override
    public boolean writable(int version) {
        return version >= 754;
    }

    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.BLOCK_PARTICLE_OPTION;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlockParticleOption that = (BlockParticleOption) o;
        return block == that.block;
    }

}
