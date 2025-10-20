package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public final class ItemParticleOption implements ParticleOption {
    @Override
    public void write(ByteBuf out, int version) {

    }
    //754 friendlyByteBuf.writeItem(this.itemStack);
    @Override
    public boolean writable(int version) {
        return false;
    }
    @Override
    public ParticleOptionType getType() {
        return null;
        //return ParticleOptionType.ITEM_PARTICLE_OPTION;
    }
}
