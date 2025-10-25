package dev.by1337.fparticle.particle.options;

import dev.by1337.fparticle.ItemType;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;

public record ItemParticleOption(ItemType item) implements ParticleOption {

    @Override
    public void write(ByteBuf out, int version) {
        if (version <= 765) {
            if (item.isAir()) {
                out.writeBoolean(false);
            } else {
                out.writeBoolean(true);
                ByteBufUtil.writeVarInt(out, item.getProtocolId(version));
                out.writeByte(1); //count
                out.writeByte(0); //has no nbt
            }
        } else {
            out.writeByte(1); //count
            ByteBufUtil.writeVarInt(out, item.getProtocolId(version));
            // empty DataComponentPatch
            out.writeByte(0);
            out.writeByte(0);
        }
    }

    @Override
    public boolean writable(int version) {
        return true;
    }

    @Override
    public ParticleOptionType getType() {
        return ParticleOptionType.ITEM_PARTICLE_OPTION;
    }
}
