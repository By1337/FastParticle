package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.options.BlockParticleOption;
import dev.by1337.fparticle.particle.options.DustParticleOptions;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ParticleType implements Keyed {
    // 754(1.16.5)+: ~
    DRIPPING_HONEY("minecraft:dripping_honey"),
    // 754(1.16.5)+: ~
    SMOKE("minecraft:smoke"),
    // 754(1.16.5)+: BlockParticleOption
    FALLING_DUST("minecraft:falling_dust"),
    // 754(1.16.5)+: ~
    LANDING_LAVA("minecraft:landing_lava"),
    // 754(1.16.5)+: ~
    CAMPFIRE_COSY_SMOKE("minecraft:campfire_cosy_smoke"),
    // 754(1.16.5)+: ~
    REVERSE_PORTAL("minecraft:reverse_portal"),
    // 754(1.16.5)+: ~
    SOUL_FIRE_FLAME("minecraft:soul_fire_flame"),
    // 754(1.16.5)+: ~
    UNDERWATER("minecraft:underwater"),
    // 766(1.20.5)+: ~
    GUST_EMITTER_LARGE("minecraft:gust_emitter_large"),
    // 754(1.16.5)+: ~
    WITCH("minecraft:witch"),
    // 755(1.17)+: ~
    WAX_OFF("minecraft:wax_off"),
    // 754(1.16.5)+: ~
    SWEEP_ATTACK("minecraft:sweep_attack"),
    // 754(1.16.5)+: ~
    DRIPPING_WATER("minecraft:dripping_water"),
    // 773(1.21.9)+: ~
    COPPER_FIRE_FLAME("minecraft:copper_fire_flame"),
    // 754(1.16.5)+: ~
    DOLPHIN("minecraft:dolphin"),
    // 754(1.16.5) - 765(1.20.4): ~
    // 766(1.20.5)+: ColorParticleOption
    ENTITY_EFFECT("minecraft:entity_effect"),
    // 755(1.17)+: ~
    DRIPPING_DRIPSTONE_LAVA("minecraft:dripping_dripstone_lava"),
    // 754(1.16.5)+: ~
    LANDING_OBSIDIAN_TEAR("minecraft:landing_obsidian_tear"),
    // 754(1.16.5)+: ItemParticleOption
    ITEM("minecraft:item"),
    // 754(1.16.5)+: ~
    BUBBLE("minecraft:bubble"),
    // 754(1.16.5)+: ~
    TOTEM_OF_UNDYING("minecraft:totem_of_undying"),
    // 766(1.20.5)+: ~
    TRIAL_OMEN("minecraft:trial_omen"),
    // 754(1.16.5)+: ~
    ASH("minecraft:ash"),
    // 754(1.16.5)+: ~
    RAIN("minecraft:rain"),
    // 754(1.16.5)+: ~
    ITEM_SLIME("minecraft:item_slime"),
    // 754(1.16.5)+: ~
    ITEM_SNOWBALL("minecraft:item_snowball"),
    // 755(1.17)+: ~
    FALLING_DRIPSTONE_WATER("minecraft:falling_dripstone_water"),
    // 759(1.19)+: ShriekParticleOption
    SHRIEK("minecraft:shriek"),
    // 763(1.20)+: ~
    CHERRY_LEAVES("minecraft:cherry_leaves"),
    // 763(1.20)+: ~
    EGG_CRACK("minecraft:egg_crack"),
    // 755(1.17)+: ~
    DRIPPING_DRIPSTONE_WATER("minecraft:dripping_dripstone_water"),
    // 766(1.20.5)+: BlockParticleOption
    DUST_PILLAR("minecraft:dust_pillar"),
    // 754(1.16.5) - 772(1.21.8): ~
    // 773(1.21.9)+: ColorParticleOption
    FLASH("minecraft:flash"),
    // 754(1.16.5)+: ~
    COMPOSTER("minecraft:composter"),
    // 765(1.20.3)+: ~
    WHITE_SMOKE("minecraft:white_smoke"),
    // 759(1.19)+: ~
    SONIC_BOOM("minecraft:sonic_boom"),
    // 754(1.16.5)+: ~
    WARPED_SPORE("minecraft:warped_spore"),
    // 754(1.16.5)+: ~
    SPLASH("minecraft:splash"),
    // 754(1.16.5)+: ~
    FALLING_OBSIDIAN_TEAR("minecraft:falling_obsidian_tear"),
    // 755(1.17)+: ~
    FALLING_DRIPSTONE_LAVA("minecraft:falling_dripstone_lava"),
    // 766(1.20.5)+: ~
    OMINOUS_SPAWNING("minecraft:ominous_spawning"),
    // 754(1.16.5)+: ~
    NAUTILUS("minecraft:nautilus"),
    // 770(1.21.5)+: ColorParticleOption
    TINTED_LEAVES("minecraft:tinted_leaves"),
    // 754(1.16.5)+: ~
    ENCHANT("minecraft:enchant"),
    // 755(1.17)+: VibrationParticleOption
    //   VIBRATION("minecraft:vibration"), //todo
    // 766(1.20.5)+: ~
    VAULT_CONNECTION("minecraft:vault_connection"),

    // 768(1.21.2)+: BlockParticleOption
    BLOCK_CRUMBLE("minecraft:block_crumble"),
    // 765(1.20.3)+: ~
    DUST_PLUME("minecraft:dust_plume"),
    // 754(1.16.5) - 772(1.21.8): ~
    // 773(1.21.9)+: PowerParticleOption
    DRAGON_BREATH("minecraft:dragon_breath"),
    // 754(1.16.5)+: ~
    FALLING_LAVA("minecraft:falling_lava"),
    // 759(1.19)+: ~
    SCULK_SOUL("minecraft:sculk_soul"),
    // 755(1.17)+: ~
    FALLING_SPORE_BLOSSOM("minecraft:falling_spore_blossom"),
    // 754(1.16.5)+: ~
    FALLING_HONEY("minecraft:falling_honey"),
    // 754(1.16.5)+: ~
    CAMPFIRE_SIGNAL_SMOKE("minecraft:campfire_signal_smoke"),
    // 754(1.16.5)+: ~
    WHITE_ASH("minecraft:white_ash"),
    // 754(1.16.5)+: ~
    LAVA("minecraft:lava"),
    // 754(1.16.5)+: ~
    SNEEZE("minecraft:sneeze"),
    // 754(1.16.5)+: ~
    END_ROD("minecraft:end_rod"),
    // 754(1.16.5)+: ~
    DRIPPING_OBSIDIAN_TEAR("minecraft:dripping_obsidian_tear"),
    // 754(1.16.5)+: ~
    CRIT("minecraft:crit"),
    // 754(1.16.5)+: ~
    HAPPY_VILLAGER("minecraft:happy_villager"),
    // 766(1.20.5)+: ~
    SMALL_GUST("minecraft:small_gust"),
    // 754(1.16.5)+: ~
    DAMAGE_INDICATOR("minecraft:damage_indicator"),
    // 765(1.20.3)+: ~
    GUST("minecraft:gust"),
    // 754(1.16.5)+: ~
    FALLING_WATER("minecraft:falling_water"),
    // 754(1.16.5)+: ~
    PORTAL("minecraft:portal"),
    // 755(1.17)+: DustColorTransitionOptions
    DUST_COLOR_TRANSITION("minecraft:dust_color_transition"),
    // 766(1.20.5)+: ~
    RAID_OMEN("minecraft:raid_omen"),
    // 754(1.16.5)+: ~
    FLAME("minecraft:flame"),
    // 755(1.17)+: ~
    ELECTRIC_SPARK("minecraft:electric_spark"),
    // 754(1.16.5) - 772(1.21.8): ~
    // 773(1.21.9)+: SpellParticleOption
    INSTANT_EFFECT("minecraft:instant_effect"),
    // 768(1.21.2)+: TrailParticleOption
    TRAIL("minecraft:trail"),
    // 754(1.16.5)+: ~
    LANDING_HONEY("minecraft:landing_honey"),
    // 765(1.20.3)+: ~
    TRIAL_SPAWNER_DETECTION("minecraft:trial_spawner_detection"),
    // 754(1.16.5)+: ~
    EXPLOSION("minecraft:explosion"),
    // 754(1.16.5)+: ~
    ENCHANTED_HIT("minecraft:enchanted_hit"),
    // 766(1.20.5)+: ~
    GUST_EMITTER_SMALL("minecraft:gust_emitter_small"),
    // 757(1.18)+: BlockParticleOption
    BLOCK_MARKER("minecraft:block_marker"),
    // 754(1.16.5)+: ~
    NOTE("minecraft:note"),
    // 754(1.16.5)+: ~
    CRIMSON_SPORE("minecraft:crimson_spore"),
    // 754(1.16.5)+: ~
    SOUL("minecraft:soul"),
    // 754(1.16.5)+: DustParticleOptions
    DUST("minecraft:dust"),
    // 754(1.16.5)+: ~
    FIREWORK("minecraft:firework"),
    // 755(1.17)+: ~
    SMALL_FLAME("minecraft:small_flame"),
    // 755(1.17)+: ~
    SNOWFLAKE("minecraft:snowflake"),
    // 754(1.16.5)+: ~
    FISHING("minecraft:fishing"),
    // 754(1.16.5)+: ~
    CLOUD("minecraft:cloud"),
    // 755(1.17)+: ~
    WAX_ON("minecraft:wax_on"),
    // 755(1.17)+: ~
    SPORE_BLOSSOM_AIR("minecraft:spore_blossom_air"),
    // 754(1.16.5)+: ~
    CURRENT_DOWN("minecraft:current_down"),
    // 770(1.21.5)+: ~
    FIREFLY("minecraft:firefly"),
    // 754(1.16.5)+: ~
    BUBBLE_COLUMN_UP("minecraft:bubble_column_up"),
    // 754(1.16.5)+: ~
    SQUID_INK("minecraft:squid_ink"),
    // 754(1.16.5)+: ~
    FALLING_NECTAR("minecraft:falling_nectar"),
    // 754(1.16.5)+: ~
    POOF("minecraft:poof"),
    // 754(1.16.5)+: ~
    EXPLOSION_EMITTER("minecraft:explosion_emitter"),
    // 754(1.16.5)+: ~
    ELDER_GUARDIAN("minecraft:elder_guardian"),
    // 754(1.16.5)+: ~
    DRIPPING_LAVA("minecraft:dripping_lava"),
    // 755(1.17)+: ~
    GLOW("minecraft:glow"),
    // 759(1.19)+: ~
    SCULK_CHARGE_POP("minecraft:sculk_charge_pop"),
    // 755(1.17)+: ~
    GLOW_SQUID_INK("minecraft:glow_squid_ink"),
    // 754(1.16.5)+: ~
    MYCELIUM("minecraft:mycelium"),
    // 766(1.20.5)+: ~
    ITEM_COBWEB("minecraft:item_cobweb"),
    // 754(1.16.5)+: ~
    BUBBLE_POP("minecraft:bubble_pop"),
    // 754(1.16.5)+: ~
    ANGRY_VILLAGER("minecraft:angry_villager"),
    // 766(1.20.5)+: ~
    INFESTED("minecraft:infested"),
    // 766(1.20.5)+: ~
    TRIAL_SPAWNER_DETECTION_OMINOUS("minecraft:trial_spawner_detection_ominous"),
    // 754(1.16.5) - 772(1.21.8): ~
    // 773(1.21.9)+: SpellParticleOption
    EFFECT("minecraft:effect"),
    // 759(1.19)+: SculkChargeParticleOptions
    SCULK_CHARGE("minecraft:sculk_charge"),
    // 755(1.17)+: ~
    SCRAPE("minecraft:scrape"),
    // 754(1.16.5)+: ~
    SPIT("minecraft:spit"),
    // 754(1.16.5)+: BlockParticleOption
    BLOCK("minecraft:block"),
    // 769(1.21.4)+: ~
    PALE_OAK_LEAVES("minecraft:pale_oak_leaves"),
    // 754(1.16.5)+: ~
    LARGE_SMOKE("minecraft:large_smoke"),
    // 754(1.16.5)+: ~
    HEART("minecraft:heart"),

    // <-- Deprecated -->
    // 765(1.20.3) - 765(1.20.4): ~
    @Deprecated
    GUST_DUST("minecraft:gust_dust", ParticleType.DUST, new DustParticleOptions(0xFFFFFF, 1.0F)),
    // 762(1.19.4) - 762(1.19.4): ~  
    @Deprecated
    FALLING_CHERRY_LEAVES("minecraft:falling_cherry_leaves", ParticleType.CHERRY_LEAVES),
    // 765(1.20.3) - 765(1.20.4): ~
    @Deprecated
    GUST_EMITTER("minecraft:gust_emitter", ParticleType.CLOUD),
    // 762(1.19.4) - 762(1.19.4): ~
    @Deprecated
    LANDING_CHERRY_LEAVES("minecraft:landing_cherry_leaves", ParticleType.CHERRY_LEAVES),
    // 754(1.16.5) - 765(1.20.4): ~
    @Deprecated
    AMBIENT_ENTITY_EFFECT("minecraft:ambient_entity_effect", ParticleType.EFFECT),
    // 762(1.19.4) - 762(1.19.4): ~
    @Deprecated
    DRIPPING_CHERRY_LEAVES("minecraft:dripping_cherry_leaves", ParticleType.CHERRY_LEAVES),
    // 754(1.16.5) - 756(1.17.1): ~
    @Deprecated
    BARRIER("minecraft:barrier", ParticleType.BLOCK_MARKER, new BlockParticleOption(BlockType.BARRIER)),
    // 755(1.17) - 756(1.17.1): ~
    @Deprecated
    LIGHT("minecraft:light", ParticleType.BLOCK_MARKER, new BlockParticleOption(BlockType.LIGHT)),
    ;

    public static final int SIZE = values().length;
    private static final Map<String, ParticleType> BY_ID;
    private static final Map<NamespacedKey, ParticleType> BY_NAMESPACED_KEY;
    public static final Registry<ParticleType> REGISTRY = new Registry<>() {
        @Override
        public @NotNull Iterator<ParticleType> iterator() {
            return BY_ID.values().iterator();
        }

        @Override
        public @Nullable ParticleType get(@NotNull NamespacedKey namespacedKey) {
            return BY_NAMESPACED_KEY.get(namespacedKey);
        }
    };
    private final String id;
    private final @Nullable Fallback fallback;
    private final NamespacedKey key;

    ParticleType(String id, @Nullable Fallback fallback) {
        this.id = id;
        this.fallback = fallback;
        key = NamespacedKey.fromString(id);
    }

    ParticleType(String id) {
        this.id = id;
        fallback = null;
        key = NamespacedKey.fromString(id);
    }

    ParticleType(String id, ParticleOption def) {
        this.id = id;
        fallback = new Fallback(this, def);
        key = NamespacedKey.fromString(id);
    }

    ParticleType(String id, ParticleType def) {
        this.id = id;
        fallback = new Fallback(def, null);
        key = NamespacedKey.fromString(id);
    }

    ParticleType(String id, ParticleType def, ParticleOption o) {
        this.id = id;
        fallback = new Fallback(def, o);
        key = NamespacedKey.fromString(id);
    }

    public @Nullable Fallback fallback() {
        return fallback;
    }

    public static ParticleType byId(String id) {
        return BY_ID.get(id);
    }

    public String id() {
        return id;
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }

    public record Fallback(ParticleType particle, ParticleOption option) {

    }

    static {
        Map<String, ParticleType> by_id = new HashMap<>();
        BY_NAMESPACED_KEY = new HashMap<>();
        for (ParticleType value : values()) {
            by_id.put(value.id, value);
            BY_NAMESPACED_KEY.put(value.key, value);
        }
        BY_ID = Collections.unmodifiableMap(by_id);
    }
}
