package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.BlockType;
import dev.by1337.fparticle.particle.options.*;

import java.util.HashMap;
import java.util.Map;

public enum ParticleOptionType {
    BLOCK_PARTICLE_OPTION(new BlockParticleOption(BlockType.BARRIER), "BlockParticleOption"),
    POWER_PARTICLE_OPTION(new PowerParticleOption(1.f), "PowerParticleOption"),
  //  VIBRATION_PARTICLE_OPTION(null, "VibrationParticleOption"),
    DUST_COLOR_TRANSITION_OPTIONS(new DustColorTransitionOptions(3790560, 0xFF0000, 1.0f), "DustColorTransitionOptions"),
    TRAIL_PARTICLE_OPTION(new TrailParticleOption(0, 0, 0, 0xFFFFFF, 50), "TrailParticleOption", "TargetColorParticleOption"),
    SHRIEK_PARTICLE_OPTION(new ShriekParticleOption(50), "ShriekParticleOption"),
    DUST_PARTICLE_OPTIONS(new DustParticleOptions(0xFFFFFF, 1.f), "DustParticleOptions"),
   // ITEM_PARTICLE_OPTION(null, "ItemParticleOption"),
    SCULK_CHARGE_PARTICLE_OPTIONS(new SculkChargeParticleOptions(10), "SculkChargeParticleOptions"),
    SPELL_PARTICLE_OPTION(new SpellParticleOption(0xAAFFFFFF, 2.f), "SpellParticleOption"),
    COLOR_PARTICLE_OPTION(new ColorParticleOption(0xAAFFFFFF), "ColorParticleOption"),
    ;
    private final ParticleOption def;
    private final String[] names;
    private static final Map<String, ParticleOptionType> BY_NAME = new HashMap<>();
    private static final ParticleOptionType[] VALUES = values();

    ParticleOptionType(ParticleOption def, String... names) {
        this.def = def;
        this.names = names;
    }

    public ParticleOption def() {
        return def;
    }

    public static ParticleOptionType byName(String name) {
        return BY_NAME.get(name);
    }

    public static ParticleOptionType byId(int id) {
        return VALUES[id];
    }

    static {
        for (ParticleOptionType type : values()) {
            for (String name : type.names) {
                BY_NAME.put(name, type);
            }
            if (type != type.def().getType()){
                throw new IllegalStateException("ParticleOptionType " + type.name() + " has an invalid default option type");
            }
        }
    }
}