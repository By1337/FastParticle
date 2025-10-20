package dev.by1337.fparticle;

import dev.by1337.fparticle.via.Mappings;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum BlockType implements Keyed {
    //since 754(1.16.5)
    ACACIA_BUTTON("minecraft:acacia_button"),
    //since 754(1.16.5)
    ACACIA_DOOR("minecraft:acacia_door"),
    //since 754(1.16.5)
    ACACIA_FENCE("minecraft:acacia_fence"),
    //since 754(1.16.5)
    ACACIA_FENCE_GATE("minecraft:acacia_fence_gate"),
    //since 761(1.19.3)
    ACACIA_HANGING_SIGN("minecraft:acacia_hanging_sign"),
    //since 754(1.16.5)
    ACACIA_LEAVES("minecraft:acacia_leaves"),
    //since 754(1.16.5)
    ACACIA_LOG("minecraft:acacia_log"),
    //since 754(1.16.5)
    ACACIA_PLANKS("minecraft:acacia_planks"),
    //since 754(1.16.5)
    ACACIA_PRESSURE_PLATE("minecraft:acacia_pressure_plate"),
    //since 754(1.16.5)
    ACACIA_SAPLING("minecraft:acacia_sapling"),
    //since 773(1.21.9)
    ACACIA_SHELF("minecraft:acacia_shelf"),
    //since 754(1.16.5)
    ACACIA_SIGN("minecraft:acacia_sign"),
    //since 754(1.16.5)
    ACACIA_SLAB("minecraft:acacia_slab"),
    //since 754(1.16.5)
    ACACIA_STAIRS("minecraft:acacia_stairs"),
    //since 754(1.16.5)
    ACACIA_TRAPDOOR("minecraft:acacia_trapdoor"),
    //since 761(1.19.3)
    ACACIA_WALL_HANGING_SIGN("minecraft:acacia_wall_hanging_sign"),
    //since 754(1.16.5)
    ACACIA_WALL_SIGN("minecraft:acacia_wall_sign"),
    //since 754(1.16.5)
    ACACIA_WOOD("minecraft:acacia_wood"),
    //since 754(1.16.5)
    ACTIVATOR_RAIL("minecraft:activator_rail"),
    //since 754(1.16.5)
    AIR("minecraft:air"),
    //since 754(1.16.5)
    ALLIUM("minecraft:allium"),
    //since 755(1.17)
    AMETHYST_BLOCK("minecraft:amethyst_block"),
    //since 755(1.17)
    AMETHYST_CLUSTER("minecraft:amethyst_cluster"),
    //since 754(1.16.5)
    ANCIENT_DEBRIS("minecraft:ancient_debris"),
    //since 754(1.16.5)
    ANDESITE("minecraft:andesite"),
    //since 754(1.16.5)
    ANDESITE_SLAB("minecraft:andesite_slab"),
    //since 754(1.16.5)
    ANDESITE_STAIRS("minecraft:andesite_stairs"),
    //since 754(1.16.5)
    ANDESITE_WALL("minecraft:andesite_wall"),
    //since 754(1.16.5)
    ANVIL("minecraft:anvil"),
    //since 754(1.16.5)
    ATTACHED_MELON_STEM("minecraft:attached_melon_stem"),
    //since 754(1.16.5)
    ATTACHED_PUMPKIN_STEM("minecraft:attached_pumpkin_stem"),
    //since 755(1.17)
    AZALEA("minecraft:azalea"),
    //since 755(1.17)
    AZALEA_LEAVES("minecraft:azalea_leaves"),
    //since 754(1.16.5)
    AZURE_BLUET("minecraft:azure_bluet"),
    //since 754(1.16.5)
    BAMBOO("minecraft:bamboo"),
    //since 761(1.19.3)
    BAMBOO_BLOCK("minecraft:bamboo_block"),
    //since 761(1.19.3)
    BAMBOO_BUTTON("minecraft:bamboo_button"),
    //since 761(1.19.3)
    BAMBOO_DOOR("minecraft:bamboo_door"),
    //since 761(1.19.3)
    BAMBOO_FENCE("minecraft:bamboo_fence"),
    //since 761(1.19.3)
    BAMBOO_FENCE_GATE("minecraft:bamboo_fence_gate"),
    //since 761(1.19.3)
    BAMBOO_HANGING_SIGN("minecraft:bamboo_hanging_sign"),
    //since 761(1.19.3)
    BAMBOO_MOSAIC("minecraft:bamboo_mosaic"),
    //since 761(1.19.3)
    BAMBOO_MOSAIC_SLAB("minecraft:bamboo_mosaic_slab"),
    //since 761(1.19.3)
    BAMBOO_MOSAIC_STAIRS("minecraft:bamboo_mosaic_stairs"),
    //since 761(1.19.3)
    BAMBOO_PLANKS("minecraft:bamboo_planks"),
    //since 761(1.19.3)
    BAMBOO_PRESSURE_PLATE("minecraft:bamboo_pressure_plate"),
    //since 754(1.16.5)
    BAMBOO_SAPLING("minecraft:bamboo_sapling"),
    //since 773(1.21.9)
    BAMBOO_SHELF("minecraft:bamboo_shelf"),
    //since 761(1.19.3)
    BAMBOO_SIGN("minecraft:bamboo_sign"),
    //since 761(1.19.3)
    BAMBOO_SLAB("minecraft:bamboo_slab"),
    //since 761(1.19.3)
    BAMBOO_STAIRS("minecraft:bamboo_stairs"),
    //since 761(1.19.3)
    BAMBOO_TRAPDOOR("minecraft:bamboo_trapdoor"),
    //since 761(1.19.3)
    BAMBOO_WALL_HANGING_SIGN("minecraft:bamboo_wall_hanging_sign"),
    //since 761(1.19.3)
    BAMBOO_WALL_SIGN("minecraft:bamboo_wall_sign"),
    //since 754(1.16.5)
    BARREL("minecraft:barrel"),
    //since 754(1.16.5)
    BARRIER("minecraft:barrier"),
    //since 754(1.16.5)
    BASALT("minecraft:basalt"),
    //since 754(1.16.5)
    BEACON("minecraft:beacon"),
    //since 754(1.16.5)
    BEDROCK("minecraft:bedrock"),
    //since 754(1.16.5)
    BEE_NEST("minecraft:bee_nest"),
    //since 754(1.16.5)
    BEEHIVE("minecraft:beehive"),
    //since 754(1.16.5)
    BEETROOTS("minecraft:beetroots"),
    //since 754(1.16.5)
    BELL("minecraft:bell"),
    //since 755(1.17)
    BIG_DRIPLEAF("minecraft:big_dripleaf"),
    //since 755(1.17)
    BIG_DRIPLEAF_STEM("minecraft:big_dripleaf_stem"),
    //since 754(1.16.5)
    BIRCH_BUTTON("minecraft:birch_button"),
    //since 754(1.16.5)
    BIRCH_DOOR("minecraft:birch_door"),
    //since 754(1.16.5)
    BIRCH_FENCE("minecraft:birch_fence"),
    //since 754(1.16.5)
    BIRCH_FENCE_GATE("minecraft:birch_fence_gate"),
    //since 761(1.19.3)
    BIRCH_HANGING_SIGN("minecraft:birch_hanging_sign"),
    //since 754(1.16.5)
    BIRCH_LEAVES("minecraft:birch_leaves"),
    //since 754(1.16.5)
    BIRCH_LOG("minecraft:birch_log"),
    //since 754(1.16.5)
    BIRCH_PLANKS("minecraft:birch_planks"),
    //since 754(1.16.5)
    BIRCH_PRESSURE_PLATE("minecraft:birch_pressure_plate"),
    //since 754(1.16.5)
    BIRCH_SAPLING("minecraft:birch_sapling"),
    //since 773(1.21.9)
    BIRCH_SHELF("minecraft:birch_shelf"),
    //since 754(1.16.5)
    BIRCH_SIGN("minecraft:birch_sign"),
    //since 754(1.16.5)
    BIRCH_SLAB("minecraft:birch_slab"),
    //since 754(1.16.5)
    BIRCH_STAIRS("minecraft:birch_stairs"),
    //since 754(1.16.5)
    BIRCH_TRAPDOOR("minecraft:birch_trapdoor"),
    //since 761(1.19.3)
    BIRCH_WALL_HANGING_SIGN("minecraft:birch_wall_hanging_sign"),
    //since 754(1.16.5)
    BIRCH_WALL_SIGN("minecraft:birch_wall_sign"),
    //since 754(1.16.5)
    BIRCH_WOOD("minecraft:birch_wood"),
    //since 754(1.16.5)
    BLACK_BANNER("minecraft:black_banner"),
    //since 754(1.16.5)
    BLACK_BED("minecraft:black_bed"),
    //since 755(1.17)
    BLACK_CANDLE("minecraft:black_candle"),
    //since 755(1.17)
    BLACK_CANDLE_CAKE("minecraft:black_candle_cake"),
    //since 754(1.16.5)
    BLACK_CARPET("minecraft:black_carpet"),
    //since 754(1.16.5)
    BLACK_CONCRETE("minecraft:black_concrete"),
    //since 754(1.16.5)
    BLACK_CONCRETE_POWDER("minecraft:black_concrete_powder"),
    //since 754(1.16.5)
    BLACK_GLAZED_TERRACOTTA("minecraft:black_glazed_terracotta"),
    //since 754(1.16.5)
    BLACK_SHULKER_BOX("minecraft:black_shulker_box"),
    //since 754(1.16.5)
    BLACK_STAINED_GLASS("minecraft:black_stained_glass"),
    //since 754(1.16.5)
    BLACK_STAINED_GLASS_PANE("minecraft:black_stained_glass_pane"),
    //since 754(1.16.5)
    BLACK_TERRACOTTA("minecraft:black_terracotta"),
    //since 754(1.16.5)
    BLACK_WALL_BANNER("minecraft:black_wall_banner"),
    //since 754(1.16.5)
    BLACK_WOOL("minecraft:black_wool"),
    //since 754(1.16.5)
    BLACKSTONE("minecraft:blackstone"),
    //since 754(1.16.5)
    BLACKSTONE_SLAB("minecraft:blackstone_slab"),
    //since 754(1.16.5)
    BLACKSTONE_STAIRS("minecraft:blackstone_stairs"),
    //since 754(1.16.5)
    BLACKSTONE_WALL("minecraft:blackstone_wall"),
    //since 754(1.16.5)
    BLAST_FURNACE("minecraft:blast_furnace"),
    //since 754(1.16.5)
    BLUE_BANNER("minecraft:blue_banner"),
    //since 754(1.16.5)
    BLUE_BED("minecraft:blue_bed"),
    //since 755(1.17)
    BLUE_CANDLE("minecraft:blue_candle"),
    //since 755(1.17)
    BLUE_CANDLE_CAKE("minecraft:blue_candle_cake"),
    //since 754(1.16.5)
    BLUE_CARPET("minecraft:blue_carpet"),
    //since 754(1.16.5)
    BLUE_CONCRETE("minecraft:blue_concrete"),
    //since 754(1.16.5)
    BLUE_CONCRETE_POWDER("minecraft:blue_concrete_powder"),
    //since 754(1.16.5)
    BLUE_GLAZED_TERRACOTTA("minecraft:blue_glazed_terracotta"),
    //since 754(1.16.5)
    BLUE_ICE("minecraft:blue_ice"),
    //since 754(1.16.5)
    BLUE_ORCHID("minecraft:blue_orchid"),
    //since 754(1.16.5)
    BLUE_SHULKER_BOX("minecraft:blue_shulker_box"),
    //since 754(1.16.5)
    BLUE_STAINED_GLASS("minecraft:blue_stained_glass"),
    //since 754(1.16.5)
    BLUE_STAINED_GLASS_PANE("minecraft:blue_stained_glass_pane"),
    //since 754(1.16.5)
    BLUE_TERRACOTTA("minecraft:blue_terracotta"),
    //since 754(1.16.5)
    BLUE_WALL_BANNER("minecraft:blue_wall_banner"),
    //since 754(1.16.5)
    BLUE_WOOL("minecraft:blue_wool"),
    //since 754(1.16.5)
    BONE_BLOCK("minecraft:bone_block"),
    //since 754(1.16.5)
    BOOKSHELF("minecraft:bookshelf"),
    //since 754(1.16.5)
    BRAIN_CORAL("minecraft:brain_coral"),
    //since 754(1.16.5)
    BRAIN_CORAL_BLOCK("minecraft:brain_coral_block"),
    //since 754(1.16.5)
    BRAIN_CORAL_FAN("minecraft:brain_coral_fan"),
    //since 754(1.16.5)
    BRAIN_CORAL_WALL_FAN("minecraft:brain_coral_wall_fan"),
    //since 754(1.16.5)
    BREWING_STAND("minecraft:brewing_stand"),
    //since 754(1.16.5)
    BRICK_SLAB("minecraft:brick_slab"),
    //since 754(1.16.5)
    BRICK_STAIRS("minecraft:brick_stairs"),
    //since 754(1.16.5)
    BRICK_WALL("minecraft:brick_wall"),
    //since 754(1.16.5)
    BRICKS("minecraft:bricks"),
    //since 754(1.16.5)
    BROWN_BANNER("minecraft:brown_banner"),
    //since 754(1.16.5)
    BROWN_BED("minecraft:brown_bed"),
    //since 755(1.17)
    BROWN_CANDLE("minecraft:brown_candle"),
    //since 755(1.17)
    BROWN_CANDLE_CAKE("minecraft:brown_candle_cake"),
    //since 754(1.16.5)
    BROWN_CARPET("minecraft:brown_carpet"),
    //since 754(1.16.5)
    BROWN_CONCRETE("minecraft:brown_concrete"),
    //since 754(1.16.5)
    BROWN_CONCRETE_POWDER("minecraft:brown_concrete_powder"),
    //since 754(1.16.5)
    BROWN_GLAZED_TERRACOTTA("minecraft:brown_glazed_terracotta"),
    //since 754(1.16.5)
    BROWN_MUSHROOM("minecraft:brown_mushroom"),
    //since 754(1.16.5)
    BROWN_MUSHROOM_BLOCK("minecraft:brown_mushroom_block"),
    //since 754(1.16.5)
    BROWN_SHULKER_BOX("minecraft:brown_shulker_box"),
    //since 754(1.16.5)
    BROWN_STAINED_GLASS("minecraft:brown_stained_glass"),
    //since 754(1.16.5)
    BROWN_STAINED_GLASS_PANE("minecraft:brown_stained_glass_pane"),
    //since 754(1.16.5)
    BROWN_TERRACOTTA("minecraft:brown_terracotta"),
    //since 754(1.16.5)
    BROWN_WALL_BANNER("minecraft:brown_wall_banner"),
    //since 754(1.16.5)
    BROWN_WOOL("minecraft:brown_wool"),
    //since 754(1.16.5)
    BUBBLE_COLUMN("minecraft:bubble_column"),
    //since 754(1.16.5)
    BUBBLE_CORAL("minecraft:bubble_coral"),
    //since 754(1.16.5)
    BUBBLE_CORAL_BLOCK("minecraft:bubble_coral_block"),
    //since 754(1.16.5)
    BUBBLE_CORAL_FAN("minecraft:bubble_coral_fan"),
    //since 754(1.16.5)
    BUBBLE_CORAL_WALL_FAN("minecraft:bubble_coral_wall_fan"),
    //since 755(1.17)
    BUDDING_AMETHYST("minecraft:budding_amethyst"),
    //since 770(1.21.5)
    BUSH("minecraft:bush"),
    //since 754(1.16.5)
    CACTUS("minecraft:cactus"),
    //since 770(1.21.5)
    CACTUS_FLOWER("minecraft:cactus_flower"),
    //since 754(1.16.5)
    CAKE("minecraft:cake"),
    //since 755(1.17)
    CALCITE("minecraft:calcite"),
    //since 763(1.20)
    CALIBRATED_SCULK_SENSOR("minecraft:calibrated_sculk_sensor"),
    //since 754(1.16.5)
    CAMPFIRE("minecraft:campfire"),
    //since 755(1.17)
    CANDLE("minecraft:candle"),
    //since 755(1.17)
    CANDLE_CAKE("minecraft:candle_cake"),
    //since 754(1.16.5)
    CARROTS("minecraft:carrots"),
    //since 754(1.16.5)
    CARTOGRAPHY_TABLE("minecraft:cartography_table"),
    //since 754(1.16.5)
    CARVED_PUMPKIN("minecraft:carved_pumpkin"),
    //since 754(1.16.5)
    CAULDRON("minecraft:cauldron"),
    //since 754(1.16.5)
    CAVE_AIR("minecraft:cave_air"),
    //since 755(1.17)
    CAVE_VINES("minecraft:cave_vines"),
    //since 755(1.17)
    CAVE_VINES_PLANT("minecraft:cave_vines_plant"),
    //since 754(1.16.5)
    @Deprecated(since = "1.21.10")
    CHAIN("minecraft:chain"),
    //since 754(1.16.5)
    CHAIN_COMMAND_BLOCK("minecraft:chain_command_block"),
    //since 762(1.19.4)
    CHERRY_BUTTON("minecraft:cherry_button"),
    //since 762(1.19.4)
    CHERRY_DOOR("minecraft:cherry_door"),
    //since 762(1.19.4)
    CHERRY_FENCE("minecraft:cherry_fence"),
    //since 762(1.19.4)
    CHERRY_FENCE_GATE("minecraft:cherry_fence_gate"),
    //since 762(1.19.4)
    CHERRY_HANGING_SIGN("minecraft:cherry_hanging_sign"),
    //since 762(1.19.4)
    CHERRY_LEAVES("minecraft:cherry_leaves"),
    //since 762(1.19.4)
    CHERRY_LOG("minecraft:cherry_log"),
    //since 762(1.19.4)
    CHERRY_PLANKS("minecraft:cherry_planks"),
    //since 762(1.19.4)
    CHERRY_PRESSURE_PLATE("minecraft:cherry_pressure_plate"),
    //since 762(1.19.4)
    CHERRY_SAPLING("minecraft:cherry_sapling"),
    //since 773(1.21.9)
    CHERRY_SHELF("minecraft:cherry_shelf"),
    //since 762(1.19.4)
    CHERRY_SIGN("minecraft:cherry_sign"),
    //since 762(1.19.4)
    CHERRY_SLAB("minecraft:cherry_slab"),
    //since 762(1.19.4)
    CHERRY_STAIRS("minecraft:cherry_stairs"),
    //since 762(1.19.4)
    CHERRY_TRAPDOOR("minecraft:cherry_trapdoor"),
    //since 762(1.19.4)
    CHERRY_WALL_HANGING_SIGN("minecraft:cherry_wall_hanging_sign"),
    //since 762(1.19.4)
    CHERRY_WALL_SIGN("minecraft:cherry_wall_sign"),
    //since 762(1.19.4)
    CHERRY_WOOD("minecraft:cherry_wood"),
    //since 754(1.16.5)
    CHEST("minecraft:chest"),
    //since 754(1.16.5)
    CHIPPED_ANVIL("minecraft:chipped_anvil"),
    //since 761(1.19.3)
    CHISELED_BOOKSHELF("minecraft:chiseled_bookshelf"),
    //since 765(1.20.3)
    CHISELED_COPPER("minecraft:chiseled_copper"),
    //since 755(1.17)
    CHISELED_DEEPSLATE("minecraft:chiseled_deepslate"),
    //since 754(1.16.5)
    CHISELED_NETHER_BRICKS("minecraft:chiseled_nether_bricks"),
    //since 754(1.16.5)
    CHISELED_POLISHED_BLACKSTONE("minecraft:chiseled_polished_blackstone"),
    //since 754(1.16.5)
    CHISELED_QUARTZ_BLOCK("minecraft:chiseled_quartz_block"),
    //since 754(1.16.5)
    CHISELED_RED_SANDSTONE("minecraft:chiseled_red_sandstone"),
    //since 769(1.21.4)
    CHISELED_RESIN_BRICKS("minecraft:chiseled_resin_bricks"),
    //since 754(1.16.5)
    CHISELED_SANDSTONE("minecraft:chiseled_sandstone"),
    //since 754(1.16.5)
    CHISELED_STONE_BRICKS("minecraft:chiseled_stone_bricks"),
    //since 765(1.20.3)
    CHISELED_TUFF("minecraft:chiseled_tuff"),
    //since 765(1.20.3)
    CHISELED_TUFF_BRICKS("minecraft:chiseled_tuff_bricks"),
    //since 754(1.16.5)
    CHORUS_FLOWER("minecraft:chorus_flower"),
    //since 754(1.16.5)
    CHORUS_PLANT("minecraft:chorus_plant"),
    //since 754(1.16.5)
    CLAY("minecraft:clay"),
    //since 769(1.21.4)
    CLOSED_EYEBLOSSOM("minecraft:closed_eyeblossom"),
    //since 754(1.16.5)
    COAL_BLOCK("minecraft:coal_block"),
    //since 754(1.16.5)
    COAL_ORE("minecraft:coal_ore"),
    //since 754(1.16.5)
    COARSE_DIRT("minecraft:coarse_dirt"),
    //since 755(1.17)
    COBBLED_DEEPSLATE("minecraft:cobbled_deepslate"),
    //since 755(1.17)
    COBBLED_DEEPSLATE_SLAB("minecraft:cobbled_deepslate_slab"),
    //since 755(1.17)
    COBBLED_DEEPSLATE_STAIRS("minecraft:cobbled_deepslate_stairs"),
    //since 755(1.17)
    COBBLED_DEEPSLATE_WALL("minecraft:cobbled_deepslate_wall"),
    //since 754(1.16.5)
    COBBLESTONE("minecraft:cobblestone"),
    //since 754(1.16.5)
    COBBLESTONE_SLAB("minecraft:cobblestone_slab"),
    //since 754(1.16.5)
    COBBLESTONE_STAIRS("minecraft:cobblestone_stairs"),
    //since 754(1.16.5)
    COBBLESTONE_WALL("minecraft:cobblestone_wall"),
    //since 754(1.16.5)
    COBWEB("minecraft:cobweb"),
    //since 754(1.16.5)
    COCOA("minecraft:cocoa"),
    //since 754(1.16.5)
    COMMAND_BLOCK("minecraft:command_block"),
    //since 754(1.16.5)
    COMPARATOR("minecraft:comparator"),
    //since 754(1.16.5)
    COMPOSTER("minecraft:composter"),
    //since 754(1.16.5)
    CONDUIT("minecraft:conduit"),
    //since 773(1.21.9)
    COPPER_BARS("minecraft:copper_bars"),
    //since 755(1.17)
    COPPER_BLOCK("minecraft:copper_block"),
    //since 765(1.20.3)
    COPPER_BULB("minecraft:copper_bulb"),
    //since 773(1.21.9)
    COPPER_CHAIN("minecraft:copper_chain"),
    //since 773(1.21.9)
    COPPER_CHEST("minecraft:copper_chest"),
    //since 765(1.20.3)
    COPPER_DOOR("minecraft:copper_door"),
    //since 773(1.21.9)
    COPPER_GOLEM_STATUE("minecraft:copper_golem_statue"),
    //since 765(1.20.3)
    COPPER_GRATE("minecraft:copper_grate"),
    //since 773(1.21.9)
    COPPER_LANTERN("minecraft:copper_lantern"),
    //since 755(1.17)
    COPPER_ORE("minecraft:copper_ore"),
    //since 773(1.21.9)
    COPPER_TORCH("minecraft:copper_torch"),
    //since 765(1.20.3)
    COPPER_TRAPDOOR("minecraft:copper_trapdoor"),
    //since 773(1.21.9)
    COPPER_WALL_TORCH("minecraft:copper_wall_torch"),
    //since 754(1.16.5)
    CORNFLOWER("minecraft:cornflower"),
    //since 755(1.17)
    CRACKED_DEEPSLATE_BRICKS("minecraft:cracked_deepslate_bricks"),
    //since 755(1.17)
    CRACKED_DEEPSLATE_TILES("minecraft:cracked_deepslate_tiles"),
    //since 754(1.16.5)
    CRACKED_NETHER_BRICKS("minecraft:cracked_nether_bricks"),
    //since 754(1.16.5)
    CRACKED_POLISHED_BLACKSTONE_BRICKS("minecraft:cracked_polished_blackstone_bricks"),
    //since 754(1.16.5)
    CRACKED_STONE_BRICKS("minecraft:cracked_stone_bricks"),
    //since 765(1.20.3)
    CRAFTER("minecraft:crafter"),
    //since 754(1.16.5)
    CRAFTING_TABLE("minecraft:crafting_table"),
    //since 768(1.21.2)
    CREAKING_HEART("minecraft:creaking_heart"),
    //since 754(1.16.5)
    CREEPER_HEAD("minecraft:creeper_head"),
    //since 754(1.16.5)
    CREEPER_WALL_HEAD("minecraft:creeper_wall_head"),
    //since 754(1.16.5)
    CRIMSON_BUTTON("minecraft:crimson_button"),
    //since 754(1.16.5)
    CRIMSON_DOOR("minecraft:crimson_door"),
    //since 754(1.16.5)
    CRIMSON_FENCE("minecraft:crimson_fence"),
    //since 754(1.16.5)
    CRIMSON_FENCE_GATE("minecraft:crimson_fence_gate"),
    //since 754(1.16.5)
    CRIMSON_FUNGUS("minecraft:crimson_fungus"),
    //since 761(1.19.3)
    CRIMSON_HANGING_SIGN("minecraft:crimson_hanging_sign"),
    //since 754(1.16.5)
    CRIMSON_HYPHAE("minecraft:crimson_hyphae"),
    //since 754(1.16.5)
    CRIMSON_NYLIUM("minecraft:crimson_nylium"),
    //since 754(1.16.5)
    CRIMSON_PLANKS("minecraft:crimson_planks"),
    //since 754(1.16.5)
    CRIMSON_PRESSURE_PLATE("minecraft:crimson_pressure_plate"),
    //since 754(1.16.5)
    CRIMSON_ROOTS("minecraft:crimson_roots"),
    //since 773(1.21.9)
    CRIMSON_SHELF("minecraft:crimson_shelf"),
    //since 754(1.16.5)
    CRIMSON_SIGN("minecraft:crimson_sign"),
    //since 754(1.16.5)
    CRIMSON_SLAB("minecraft:crimson_slab"),
    //since 754(1.16.5)
    CRIMSON_STAIRS("minecraft:crimson_stairs"),
    //since 754(1.16.5)
    CRIMSON_STEM("minecraft:crimson_stem"),
    //since 754(1.16.5)
    CRIMSON_TRAPDOOR("minecraft:crimson_trapdoor"),
    //since 761(1.19.3)
    CRIMSON_WALL_HANGING_SIGN("minecraft:crimson_wall_hanging_sign"),
    //since 754(1.16.5)
    CRIMSON_WALL_SIGN("minecraft:crimson_wall_sign"),
    //since 754(1.16.5)
    CRYING_OBSIDIAN("minecraft:crying_obsidian"),
    //since 755(1.17)
    CUT_COPPER("minecraft:cut_copper"),
    //since 755(1.17)
    CUT_COPPER_SLAB("minecraft:cut_copper_slab"),
    //since 755(1.17)
    CUT_COPPER_STAIRS("minecraft:cut_copper_stairs"),
    //since 754(1.16.5)
    CUT_RED_SANDSTONE("minecraft:cut_red_sandstone"),
    //since 754(1.16.5)
    CUT_RED_SANDSTONE_SLAB("minecraft:cut_red_sandstone_slab"),
    //since 754(1.16.5)
    CUT_SANDSTONE("minecraft:cut_sandstone"),
    //since 754(1.16.5)
    CUT_SANDSTONE_SLAB("minecraft:cut_sandstone_slab"),
    //since 754(1.16.5)
    CYAN_BANNER("minecraft:cyan_banner"),
    //since 754(1.16.5)
    CYAN_BED("minecraft:cyan_bed"),
    //since 755(1.17)
    CYAN_CANDLE("minecraft:cyan_candle"),
    //since 755(1.17)
    CYAN_CANDLE_CAKE("minecraft:cyan_candle_cake"),
    //since 754(1.16.5)
    CYAN_CARPET("minecraft:cyan_carpet"),
    //since 754(1.16.5)
    CYAN_CONCRETE("minecraft:cyan_concrete"),
    //since 754(1.16.5)
    CYAN_CONCRETE_POWDER("minecraft:cyan_concrete_powder"),
    //since 754(1.16.5)
    CYAN_GLAZED_TERRACOTTA("minecraft:cyan_glazed_terracotta"),
    //since 754(1.16.5)
    CYAN_SHULKER_BOX("minecraft:cyan_shulker_box"),
    //since 754(1.16.5)
    CYAN_STAINED_GLASS("minecraft:cyan_stained_glass"),
    //since 754(1.16.5)
    CYAN_STAINED_GLASS_PANE("minecraft:cyan_stained_glass_pane"),
    //since 754(1.16.5)
    CYAN_TERRACOTTA("minecraft:cyan_terracotta"),
    //since 754(1.16.5)
    CYAN_WALL_BANNER("minecraft:cyan_wall_banner"),
    //since 754(1.16.5)
    CYAN_WOOL("minecraft:cyan_wool"),
    //since 754(1.16.5)
    DAMAGED_ANVIL("minecraft:damaged_anvil"),
    //since 754(1.16.5)
    DANDELION("minecraft:dandelion"),
    //since 754(1.16.5)
    DARK_OAK_BUTTON("minecraft:dark_oak_button"),
    //since 754(1.16.5)
    DARK_OAK_DOOR("minecraft:dark_oak_door"),
    //since 754(1.16.5)
    DARK_OAK_FENCE("minecraft:dark_oak_fence"),
    //since 754(1.16.5)
    DARK_OAK_FENCE_GATE("minecraft:dark_oak_fence_gate"),
    //since 761(1.19.3)
    DARK_OAK_HANGING_SIGN("minecraft:dark_oak_hanging_sign"),
    //since 754(1.16.5)
    DARK_OAK_LEAVES("minecraft:dark_oak_leaves"),
    //since 754(1.16.5)
    DARK_OAK_LOG("minecraft:dark_oak_log"),
    //since 754(1.16.5)
    DARK_OAK_PLANKS("minecraft:dark_oak_planks"),
    //since 754(1.16.5)
    DARK_OAK_PRESSURE_PLATE("minecraft:dark_oak_pressure_plate"),
    //since 754(1.16.5)
    DARK_OAK_SAPLING("minecraft:dark_oak_sapling"),
    //since 773(1.21.9)
    DARK_OAK_SHELF("minecraft:dark_oak_shelf"),
    //since 754(1.16.5)
    DARK_OAK_SIGN("minecraft:dark_oak_sign"),
    //since 754(1.16.5)
    DARK_OAK_SLAB("minecraft:dark_oak_slab"),
    //since 754(1.16.5)
    DARK_OAK_STAIRS("minecraft:dark_oak_stairs"),
    //since 754(1.16.5)
    DARK_OAK_TRAPDOOR("minecraft:dark_oak_trapdoor"),
    //since 761(1.19.3)
    DARK_OAK_WALL_HANGING_SIGN("minecraft:dark_oak_wall_hanging_sign"),
    //since 754(1.16.5)
    DARK_OAK_WALL_SIGN("minecraft:dark_oak_wall_sign"),
    //since 754(1.16.5)
    DARK_OAK_WOOD("minecraft:dark_oak_wood"),
    //since 754(1.16.5)
    DARK_PRISMARINE("minecraft:dark_prismarine"),
    //since 754(1.16.5)
    DARK_PRISMARINE_SLAB("minecraft:dark_prismarine_slab"),
    //since 754(1.16.5)
    DARK_PRISMARINE_STAIRS("minecraft:dark_prismarine_stairs"),
    //since 754(1.16.5)
    DAYLIGHT_DETECTOR("minecraft:daylight_detector"),
    //since 754(1.16.5)
    DEAD_BRAIN_CORAL("minecraft:dead_brain_coral"),
    //since 754(1.16.5)
    DEAD_BRAIN_CORAL_BLOCK("minecraft:dead_brain_coral_block"),
    //since 754(1.16.5)
    DEAD_BRAIN_CORAL_FAN("minecraft:dead_brain_coral_fan"),
    //since 754(1.16.5)
    DEAD_BRAIN_CORAL_WALL_FAN("minecraft:dead_brain_coral_wall_fan"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL("minecraft:dead_bubble_coral"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL_BLOCK("minecraft:dead_bubble_coral_block"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL_FAN("minecraft:dead_bubble_coral_fan"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL_WALL_FAN("minecraft:dead_bubble_coral_wall_fan"),
    //since 754(1.16.5)
    DEAD_BUSH("minecraft:dead_bush"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL("minecraft:dead_fire_coral"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL_BLOCK("minecraft:dead_fire_coral_block"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL_FAN("minecraft:dead_fire_coral_fan"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL_WALL_FAN("minecraft:dead_fire_coral_wall_fan"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL("minecraft:dead_horn_coral"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL_BLOCK("minecraft:dead_horn_coral_block"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL_FAN("minecraft:dead_horn_coral_fan"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL_WALL_FAN("minecraft:dead_horn_coral_wall_fan"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL("minecraft:dead_tube_coral"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL_BLOCK("minecraft:dead_tube_coral_block"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL_FAN("minecraft:dead_tube_coral_fan"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL_WALL_FAN("minecraft:dead_tube_coral_wall_fan"),
    //since 762(1.19.4)
    DECORATED_POT("minecraft:decorated_pot"),
    //since 755(1.17)
    DEEPSLATE("minecraft:deepslate"),
    //since 755(1.17)
    DEEPSLATE_BRICK_SLAB("minecraft:deepslate_brick_slab"),
    //since 755(1.17)
    DEEPSLATE_BRICK_STAIRS("minecraft:deepslate_brick_stairs"),
    //since 755(1.17)
    DEEPSLATE_BRICK_WALL("minecraft:deepslate_brick_wall"),
    //since 755(1.17)
    DEEPSLATE_BRICKS("minecraft:deepslate_bricks"),
    //since 755(1.17)
    DEEPSLATE_COAL_ORE("minecraft:deepslate_coal_ore"),
    //since 755(1.17)
    DEEPSLATE_COPPER_ORE("minecraft:deepslate_copper_ore"),
    //since 755(1.17)
    DEEPSLATE_DIAMOND_ORE("minecraft:deepslate_diamond_ore"),
    //since 755(1.17)
    DEEPSLATE_EMERALD_ORE("minecraft:deepslate_emerald_ore"),
    //since 755(1.17)
    DEEPSLATE_GOLD_ORE("minecraft:deepslate_gold_ore"),
    //since 755(1.17)
    DEEPSLATE_IRON_ORE("minecraft:deepslate_iron_ore"),
    //since 755(1.17)
    DEEPSLATE_LAPIS_ORE("minecraft:deepslate_lapis_ore"),
    //since 755(1.17)
    DEEPSLATE_REDSTONE_ORE("minecraft:deepslate_redstone_ore"),
    //since 755(1.17)
    DEEPSLATE_TILE_SLAB("minecraft:deepslate_tile_slab"),
    //since 755(1.17)
    DEEPSLATE_TILE_STAIRS("minecraft:deepslate_tile_stairs"),
    //since 755(1.17)
    DEEPSLATE_TILE_WALL("minecraft:deepslate_tile_wall"),
    //since 755(1.17)
    DEEPSLATE_TILES("minecraft:deepslate_tiles"),
    //since 754(1.16.5)
    DETECTOR_RAIL("minecraft:detector_rail"),
    //since 754(1.16.5)
    DIAMOND_BLOCK("minecraft:diamond_block"),
    //since 754(1.16.5)
    DIAMOND_ORE("minecraft:diamond_ore"),
    //since 754(1.16.5)
    DIORITE("minecraft:diorite"),
    //since 754(1.16.5)
    DIORITE_SLAB("minecraft:diorite_slab"),
    //since 754(1.16.5)
    DIORITE_STAIRS("minecraft:diorite_stairs"),
    //since 754(1.16.5)
    DIORITE_WALL("minecraft:diorite_wall"),
    //since 754(1.16.5)
    DIRT("minecraft:dirt"),
    //since 755(1.17)
    DIRT_PATH("minecraft:dirt_path"),
    //since 754(1.16.5)
    DISPENSER("minecraft:dispenser"),
    //since 754(1.16.5)
    DRAGON_EGG("minecraft:dragon_egg"),
    //since 754(1.16.5)
    DRAGON_HEAD("minecraft:dragon_head"),
    //since 754(1.16.5)
    DRAGON_WALL_HEAD("minecraft:dragon_wall_head"),
    //since 771(1.21.6)
    DRIED_GHAST("minecraft:dried_ghast"),
    //since 754(1.16.5)
    DRIED_KELP_BLOCK("minecraft:dried_kelp_block"),
    //since 755(1.17)
    DRIPSTONE_BLOCK("minecraft:dripstone_block"),
    //since 754(1.16.5)
    DROPPER("minecraft:dropper"),
    //since 754(1.16.5)
    EMERALD_BLOCK("minecraft:emerald_block"),
    //since 754(1.16.5)
    EMERALD_ORE("minecraft:emerald_ore"),
    //since 754(1.16.5)
    ENCHANTING_TABLE("minecraft:enchanting_table"),
    //since 754(1.16.5)
    END_GATEWAY("minecraft:end_gateway"),
    //since 754(1.16.5)
    END_PORTAL("minecraft:end_portal"),
    //since 754(1.16.5)
    END_PORTAL_FRAME("minecraft:end_portal_frame"),
    //since 754(1.16.5)
    END_ROD("minecraft:end_rod"),
    //since 754(1.16.5)
    END_STONE("minecraft:end_stone"),
    //since 754(1.16.5)
    END_STONE_BRICK_SLAB("minecraft:end_stone_brick_slab"),
    //since 754(1.16.5)
    END_STONE_BRICK_STAIRS("minecraft:end_stone_brick_stairs"),
    //since 754(1.16.5)
    END_STONE_BRICK_WALL("minecraft:end_stone_brick_wall"),
    //since 754(1.16.5)
    END_STONE_BRICKS("minecraft:end_stone_bricks"),
    //since 754(1.16.5)
    ENDER_CHEST("minecraft:ender_chest"),
    //since 765(1.20.3)
    EXPOSED_CHISELED_COPPER("minecraft:exposed_chiseled_copper"),
    //since 755(1.17)
    EXPOSED_COPPER("minecraft:exposed_copper"),
    //since 773(1.21.9)
    EXPOSED_COPPER_BARS("minecraft:exposed_copper_bars"),
    //since 765(1.20.3)
    EXPOSED_COPPER_BULB("minecraft:exposed_copper_bulb"),
    //since 773(1.21.9)
    EXPOSED_COPPER_CHAIN("minecraft:exposed_copper_chain"),
    //since 773(1.21.9)
    EXPOSED_COPPER_CHEST("minecraft:exposed_copper_chest"),
    //since 765(1.20.3)
    EXPOSED_COPPER_DOOR("minecraft:exposed_copper_door"),
    //since 773(1.21.9)
    EXPOSED_COPPER_GOLEM_STATUE("minecraft:exposed_copper_golem_statue"),
    //since 765(1.20.3)
    EXPOSED_COPPER_GRATE("minecraft:exposed_copper_grate"),
    //since 773(1.21.9)
    EXPOSED_COPPER_LANTERN("minecraft:exposed_copper_lantern"),
    //since 765(1.20.3)
    EXPOSED_COPPER_TRAPDOOR("minecraft:exposed_copper_trapdoor"),
    //since 755(1.17)
    EXPOSED_CUT_COPPER("minecraft:exposed_cut_copper"),
    //since 755(1.17)
    EXPOSED_CUT_COPPER_SLAB("minecraft:exposed_cut_copper_slab"),
    //since 755(1.17)
    EXPOSED_CUT_COPPER_STAIRS("minecraft:exposed_cut_copper_stairs"),
    //since 773(1.21.9)
    EXPOSED_LIGHTNING_ROD("minecraft:exposed_lightning_rod"),
    //since 754(1.16.5)
    FARMLAND("minecraft:farmland"),
    //since 754(1.16.5)
    FERN("minecraft:fern"),
    //since 754(1.16.5)
    FIRE("minecraft:fire"),
    //since 754(1.16.5)
    FIRE_CORAL("minecraft:fire_coral"),
    //since 754(1.16.5)
    FIRE_CORAL_BLOCK("minecraft:fire_coral_block"),
    //since 754(1.16.5)
    FIRE_CORAL_FAN("minecraft:fire_coral_fan"),
    //since 754(1.16.5)
    FIRE_CORAL_WALL_FAN("minecraft:fire_coral_wall_fan"),
    //since 770(1.21.5)
    FIREFLY_BUSH("minecraft:firefly_bush"),
    //since 754(1.16.5)
    FLETCHING_TABLE("minecraft:fletching_table"),
    //since 754(1.16.5)
    FLOWER_POT("minecraft:flower_pot"),
    //since 755(1.17)
    FLOWERING_AZALEA("minecraft:flowering_azalea"),
    //since 755(1.17)
    FLOWERING_AZALEA_LEAVES("minecraft:flowering_azalea_leaves"),
    //since 759(1.19)
    FROGSPAWN("minecraft:frogspawn"),
    //since 754(1.16.5)
    FROSTED_ICE("minecraft:frosted_ice"),
    //since 754(1.16.5)
    FURNACE("minecraft:furnace"),
    //since 754(1.16.5)
    GILDED_BLACKSTONE("minecraft:gilded_blackstone"),
    //since 754(1.16.5)
    GLASS("minecraft:glass"),
    //since 754(1.16.5)
    GLASS_PANE("minecraft:glass_pane"),
    //since 755(1.17)
    GLOW_LICHEN("minecraft:glow_lichen"),
    //since 754(1.16.5)
    GLOWSTONE("minecraft:glowstone"),
    //since 754(1.16.5)
    GOLD_BLOCK("minecraft:gold_block"),
    //since 754(1.16.5)
    GOLD_ORE("minecraft:gold_ore"),
    //since 754(1.16.5)
    GRANITE("minecraft:granite"),
    //since 754(1.16.5)
    GRANITE_SLAB("minecraft:granite_slab"),
    //since 754(1.16.5)
    GRANITE_STAIRS("minecraft:granite_stairs"),
    //since 754(1.16.5)
    GRANITE_WALL("minecraft:granite_wall"),
    //since 754(1.16.5)
    @Deprecated(since = "1.20.4")
    GRASS("minecraft:grass"),
    //since 754(1.16.5)
    GRASS_BLOCK("minecraft:grass_block"),
    //since 754(1.16.5)
    @Deprecated(since = "1.17")
    GRASS_PATH("minecraft:grass_path"),
    //since 754(1.16.5)
    GRAVEL("minecraft:gravel"),
    //since 754(1.16.5)
    GRAY_BANNER("minecraft:gray_banner"),
    //since 754(1.16.5)
    GRAY_BED("minecraft:gray_bed"),
    //since 755(1.17)
    GRAY_CANDLE("minecraft:gray_candle"),
    //since 755(1.17)
    GRAY_CANDLE_CAKE("minecraft:gray_candle_cake"),
    //since 754(1.16.5)
    GRAY_CARPET("minecraft:gray_carpet"),
    //since 754(1.16.5)
    GRAY_CONCRETE("minecraft:gray_concrete"),
    //since 754(1.16.5)
    GRAY_CONCRETE_POWDER("minecraft:gray_concrete_powder"),
    //since 754(1.16.5)
    GRAY_GLAZED_TERRACOTTA("minecraft:gray_glazed_terracotta"),
    //since 754(1.16.5)
    GRAY_SHULKER_BOX("minecraft:gray_shulker_box"),
    //since 754(1.16.5)
    GRAY_STAINED_GLASS("minecraft:gray_stained_glass"),
    //since 754(1.16.5)
    GRAY_STAINED_GLASS_PANE("minecraft:gray_stained_glass_pane"),
    //since 754(1.16.5)
    GRAY_TERRACOTTA("minecraft:gray_terracotta"),
    //since 754(1.16.5)
    GRAY_WALL_BANNER("minecraft:gray_wall_banner"),
    //since 754(1.16.5)
    GRAY_WOOL("minecraft:gray_wool"),
    //since 754(1.16.5)
    GREEN_BANNER("minecraft:green_banner"),
    //since 754(1.16.5)
    GREEN_BED("minecraft:green_bed"),
    //since 755(1.17)
    GREEN_CANDLE("minecraft:green_candle"),
    //since 755(1.17)
    GREEN_CANDLE_CAKE("minecraft:green_candle_cake"),
    //since 754(1.16.5)
    GREEN_CARPET("minecraft:green_carpet"),
    //since 754(1.16.5)
    GREEN_CONCRETE("minecraft:green_concrete"),
    //since 754(1.16.5)
    GREEN_CONCRETE_POWDER("minecraft:green_concrete_powder"),
    //since 754(1.16.5)
    GREEN_GLAZED_TERRACOTTA("minecraft:green_glazed_terracotta"),
    //since 754(1.16.5)
    GREEN_SHULKER_BOX("minecraft:green_shulker_box"),
    //since 754(1.16.5)
    GREEN_STAINED_GLASS("minecraft:green_stained_glass"),
    //since 754(1.16.5)
    GREEN_STAINED_GLASS_PANE("minecraft:green_stained_glass_pane"),
    //since 754(1.16.5)
    GREEN_TERRACOTTA("minecraft:green_terracotta"),
    //since 754(1.16.5)
    GREEN_WALL_BANNER("minecraft:green_wall_banner"),
    //since 754(1.16.5)
    GREEN_WOOL("minecraft:green_wool"),
    //since 754(1.16.5)
    GRINDSTONE("minecraft:grindstone"),
    //since 755(1.17)
    HANGING_ROOTS("minecraft:hanging_roots"),
    //since 754(1.16.5)
    HAY_BLOCK("minecraft:hay_block"),
    //since 766(1.20.5)
    HEAVY_CORE("minecraft:heavy_core"),
    //since 754(1.16.5)
    HEAVY_WEIGHTED_PRESSURE_PLATE("minecraft:heavy_weighted_pressure_plate"),
    //since 754(1.16.5)
    HONEY_BLOCK("minecraft:honey_block"),
    //since 754(1.16.5)
    HONEYCOMB_BLOCK("minecraft:honeycomb_block"),
    //since 754(1.16.5)
    HOPPER("minecraft:hopper"),
    //since 754(1.16.5)
    HORN_CORAL("minecraft:horn_coral"),
    //since 754(1.16.5)
    HORN_CORAL_BLOCK("minecraft:horn_coral_block"),
    //since 754(1.16.5)
    HORN_CORAL_FAN("minecraft:horn_coral_fan"),
    //since 754(1.16.5)
    HORN_CORAL_WALL_FAN("minecraft:horn_coral_wall_fan"),
    //since 754(1.16.5)
    ICE("minecraft:ice"),
    //since 754(1.16.5)
    INFESTED_CHISELED_STONE_BRICKS("minecraft:infested_chiseled_stone_bricks"),
    //since 754(1.16.5)
    INFESTED_COBBLESTONE("minecraft:infested_cobblestone"),
    //since 754(1.16.5)
    INFESTED_CRACKED_STONE_BRICKS("minecraft:infested_cracked_stone_bricks"),
    //since 755(1.17)
    INFESTED_DEEPSLATE("minecraft:infested_deepslate"),
    //since 754(1.16.5)
    INFESTED_MOSSY_STONE_BRICKS("minecraft:infested_mossy_stone_bricks"),
    //since 754(1.16.5)
    INFESTED_STONE("minecraft:infested_stone"),
    //since 754(1.16.5)
    INFESTED_STONE_BRICKS("minecraft:infested_stone_bricks"),
    //since 754(1.16.5)
    IRON_BARS("minecraft:iron_bars"),
    //since 754(1.16.5)
    IRON_BLOCK("minecraft:iron_block"),
    //since 773(1.21.9)
    IRON_CHAIN("minecraft:iron_chain"),
    //since 754(1.16.5)
    IRON_DOOR("minecraft:iron_door"),
    //since 754(1.16.5)
    IRON_ORE("minecraft:iron_ore"),
    //since 754(1.16.5)
    IRON_TRAPDOOR("minecraft:iron_trapdoor"),
    //since 754(1.16.5)
    JACK_O_LANTERN("minecraft:jack_o_lantern"),
    //since 754(1.16.5)
    JIGSAW("minecraft:jigsaw"),
    //since 754(1.16.5)
    JUKEBOX("minecraft:jukebox"),
    //since 754(1.16.5)
    JUNGLE_BUTTON("minecraft:jungle_button"),
    //since 754(1.16.5)
    JUNGLE_DOOR("minecraft:jungle_door"),
    //since 754(1.16.5)
    JUNGLE_FENCE("minecraft:jungle_fence"),
    //since 754(1.16.5)
    JUNGLE_FENCE_GATE("minecraft:jungle_fence_gate"),
    //since 761(1.19.3)
    JUNGLE_HANGING_SIGN("minecraft:jungle_hanging_sign"),
    //since 754(1.16.5)
    JUNGLE_LEAVES("minecraft:jungle_leaves"),
    //since 754(1.16.5)
    JUNGLE_LOG("minecraft:jungle_log"),
    //since 754(1.16.5)
    JUNGLE_PLANKS("minecraft:jungle_planks"),
    //since 754(1.16.5)
    JUNGLE_PRESSURE_PLATE("minecraft:jungle_pressure_plate"),
    //since 754(1.16.5)
    JUNGLE_SAPLING("minecraft:jungle_sapling"),
    //since 773(1.21.9)
    JUNGLE_SHELF("minecraft:jungle_shelf"),
    //since 754(1.16.5)
    JUNGLE_SIGN("minecraft:jungle_sign"),
    //since 754(1.16.5)
    JUNGLE_SLAB("minecraft:jungle_slab"),
    //since 754(1.16.5)
    JUNGLE_STAIRS("minecraft:jungle_stairs"),
    //since 754(1.16.5)
    JUNGLE_TRAPDOOR("minecraft:jungle_trapdoor"),
    //since 761(1.19.3)
    JUNGLE_WALL_HANGING_SIGN("minecraft:jungle_wall_hanging_sign"),
    //since 754(1.16.5)
    JUNGLE_WALL_SIGN("minecraft:jungle_wall_sign"),
    //since 754(1.16.5)
    JUNGLE_WOOD("minecraft:jungle_wood"),
    //since 754(1.16.5)
    KELP("minecraft:kelp"),
    //since 754(1.16.5)
    KELP_PLANT("minecraft:kelp_plant"),
    //since 754(1.16.5)
    LADDER("minecraft:ladder"),
    //since 754(1.16.5)
    LANTERN("minecraft:lantern"),
    //since 754(1.16.5)
    LAPIS_BLOCK("minecraft:lapis_block"),
    //since 754(1.16.5)
    LAPIS_ORE("minecraft:lapis_ore"),
    //since 755(1.17)
    LARGE_AMETHYST_BUD("minecraft:large_amethyst_bud"),
    //since 754(1.16.5)
    LARGE_FERN("minecraft:large_fern"),
    //since 754(1.16.5)
    LAVA("minecraft:lava"),
    //since 755(1.17)
    LAVA_CAULDRON("minecraft:lava_cauldron"),
    //since 770(1.21.5)
    LEAF_LITTER("minecraft:leaf_litter"),
    //since 754(1.16.5)
    LECTERN("minecraft:lectern"),
    //since 754(1.16.5)
    LEVER("minecraft:lever"),
    //since 755(1.17)
    LIGHT("minecraft:light"),
    //since 754(1.16.5)
    LIGHT_BLUE_BANNER("minecraft:light_blue_banner"),
    //since 754(1.16.5)
    LIGHT_BLUE_BED("minecraft:light_blue_bed"),
    //since 755(1.17)
    LIGHT_BLUE_CANDLE("minecraft:light_blue_candle"),
    //since 755(1.17)
    LIGHT_BLUE_CANDLE_CAKE("minecraft:light_blue_candle_cake"),
    //since 754(1.16.5)
    LIGHT_BLUE_CARPET("minecraft:light_blue_carpet"),
    //since 754(1.16.5)
    LIGHT_BLUE_CONCRETE("minecraft:light_blue_concrete"),
    //since 754(1.16.5)
    LIGHT_BLUE_CONCRETE_POWDER("minecraft:light_blue_concrete_powder"),
    //since 754(1.16.5)
    LIGHT_BLUE_GLAZED_TERRACOTTA("minecraft:light_blue_glazed_terracotta"),
    //since 754(1.16.5)
    LIGHT_BLUE_SHULKER_BOX("minecraft:light_blue_shulker_box"),
    //since 754(1.16.5)
    LIGHT_BLUE_STAINED_GLASS("minecraft:light_blue_stained_glass"),
    //since 754(1.16.5)
    LIGHT_BLUE_STAINED_GLASS_PANE("minecraft:light_blue_stained_glass_pane"),
    //since 754(1.16.5)
    LIGHT_BLUE_TERRACOTTA("minecraft:light_blue_terracotta"),
    //since 754(1.16.5)
    LIGHT_BLUE_WALL_BANNER("minecraft:light_blue_wall_banner"),
    //since 754(1.16.5)
    LIGHT_BLUE_WOOL("minecraft:light_blue_wool"),
    //since 754(1.16.5)
    LIGHT_GRAY_BANNER("minecraft:light_gray_banner"),
    //since 754(1.16.5)
    LIGHT_GRAY_BED("minecraft:light_gray_bed"),
    //since 755(1.17)
    LIGHT_GRAY_CANDLE("minecraft:light_gray_candle"),
    //since 755(1.17)
    LIGHT_GRAY_CANDLE_CAKE("minecraft:light_gray_candle_cake"),
    //since 754(1.16.5)
    LIGHT_GRAY_CARPET("minecraft:light_gray_carpet"),
    //since 754(1.16.5)
    LIGHT_GRAY_CONCRETE("minecraft:light_gray_concrete"),
    //since 754(1.16.5)
    LIGHT_GRAY_CONCRETE_POWDER("minecraft:light_gray_concrete_powder"),
    //since 754(1.16.5)
    LIGHT_GRAY_GLAZED_TERRACOTTA("minecraft:light_gray_glazed_terracotta"),
    //since 754(1.16.5)
    LIGHT_GRAY_SHULKER_BOX("minecraft:light_gray_shulker_box"),
    //since 754(1.16.5)
    LIGHT_GRAY_STAINED_GLASS("minecraft:light_gray_stained_glass"),
    //since 754(1.16.5)
    LIGHT_GRAY_STAINED_GLASS_PANE("minecraft:light_gray_stained_glass_pane"),
    //since 754(1.16.5)
    LIGHT_GRAY_TERRACOTTA("minecraft:light_gray_terracotta"),
    //since 754(1.16.5)
    LIGHT_GRAY_WALL_BANNER("minecraft:light_gray_wall_banner"),
    //since 754(1.16.5)
    LIGHT_GRAY_WOOL("minecraft:light_gray_wool"),
    //since 754(1.16.5)
    LIGHT_WEIGHTED_PRESSURE_PLATE("minecraft:light_weighted_pressure_plate"),
    //since 755(1.17)
    LIGHTNING_ROD("minecraft:lightning_rod"),
    //since 754(1.16.5)
    LILAC("minecraft:lilac"),
    //since 754(1.16.5)
    LILY_OF_THE_VALLEY("minecraft:lily_of_the_valley"),
    //since 754(1.16.5)
    LILY_PAD("minecraft:lily_pad"),
    //since 754(1.16.5)
    LIME_BANNER("minecraft:lime_banner"),
    //since 754(1.16.5)
    LIME_BED("minecraft:lime_bed"),
    //since 755(1.17)
    LIME_CANDLE("minecraft:lime_candle"),
    //since 755(1.17)
    LIME_CANDLE_CAKE("minecraft:lime_candle_cake"),
    //since 754(1.16.5)
    LIME_CARPET("minecraft:lime_carpet"),
    //since 754(1.16.5)
    LIME_CONCRETE("minecraft:lime_concrete"),
    //since 754(1.16.5)
    LIME_CONCRETE_POWDER("minecraft:lime_concrete_powder"),
    //since 754(1.16.5)
    LIME_GLAZED_TERRACOTTA("minecraft:lime_glazed_terracotta"),
    //since 754(1.16.5)
    LIME_SHULKER_BOX("minecraft:lime_shulker_box"),
    //since 754(1.16.5)
    LIME_STAINED_GLASS("minecraft:lime_stained_glass"),
    //since 754(1.16.5)
    LIME_STAINED_GLASS_PANE("minecraft:lime_stained_glass_pane"),
    //since 754(1.16.5)
    LIME_TERRACOTTA("minecraft:lime_terracotta"),
    //since 754(1.16.5)
    LIME_WALL_BANNER("minecraft:lime_wall_banner"),
    //since 754(1.16.5)
    LIME_WOOL("minecraft:lime_wool"),
    //since 754(1.16.5)
    LODESTONE("minecraft:lodestone"),
    //since 754(1.16.5)
    LOOM("minecraft:loom"),
    //since 754(1.16.5)
    MAGENTA_BANNER("minecraft:magenta_banner"),
    //since 754(1.16.5)
    MAGENTA_BED("minecraft:magenta_bed"),
    //since 755(1.17)
    MAGENTA_CANDLE("minecraft:magenta_candle"),
    //since 755(1.17)
    MAGENTA_CANDLE_CAKE("minecraft:magenta_candle_cake"),
    //since 754(1.16.5)
    MAGENTA_CARPET("minecraft:magenta_carpet"),
    //since 754(1.16.5)
    MAGENTA_CONCRETE("minecraft:magenta_concrete"),
    //since 754(1.16.5)
    MAGENTA_CONCRETE_POWDER("minecraft:magenta_concrete_powder"),
    //since 754(1.16.5)
    MAGENTA_GLAZED_TERRACOTTA("minecraft:magenta_glazed_terracotta"),
    //since 754(1.16.5)
    MAGENTA_SHULKER_BOX("minecraft:magenta_shulker_box"),
    //since 754(1.16.5)
    MAGENTA_STAINED_GLASS("minecraft:magenta_stained_glass"),
    //since 754(1.16.5)
    MAGENTA_STAINED_GLASS_PANE("minecraft:magenta_stained_glass_pane"),
    //since 754(1.16.5)
    MAGENTA_TERRACOTTA("minecraft:magenta_terracotta"),
    //since 754(1.16.5)
    MAGENTA_WALL_BANNER("minecraft:magenta_wall_banner"),
    //since 754(1.16.5)
    MAGENTA_WOOL("minecraft:magenta_wool"),
    //since 754(1.16.5)
    MAGMA_BLOCK("minecraft:magma_block"),
    //since 759(1.19)
    MANGROVE_BUTTON("minecraft:mangrove_button"),
    //since 759(1.19)
    MANGROVE_DOOR("minecraft:mangrove_door"),
    //since 759(1.19)
    MANGROVE_FENCE("minecraft:mangrove_fence"),
    //since 759(1.19)
    MANGROVE_FENCE_GATE("minecraft:mangrove_fence_gate"),
    //since 761(1.19.3)
    MANGROVE_HANGING_SIGN("minecraft:mangrove_hanging_sign"),
    //since 759(1.19)
    MANGROVE_LEAVES("minecraft:mangrove_leaves"),
    //since 759(1.19)
    MANGROVE_LOG("minecraft:mangrove_log"),
    //since 759(1.19)
    MANGROVE_PLANKS("minecraft:mangrove_planks"),
    //since 759(1.19)
    MANGROVE_PRESSURE_PLATE("minecraft:mangrove_pressure_plate"),
    //since 759(1.19)
    MANGROVE_PROPAGULE("minecraft:mangrove_propagule"),
    //since 759(1.19)
    MANGROVE_ROOTS("minecraft:mangrove_roots"),
    //since 773(1.21.9)
    MANGROVE_SHELF("minecraft:mangrove_shelf"),
    //since 759(1.19)
    MANGROVE_SIGN("minecraft:mangrove_sign"),
    //since 759(1.19)
    MANGROVE_SLAB("minecraft:mangrove_slab"),
    //since 759(1.19)
    MANGROVE_STAIRS("minecraft:mangrove_stairs"),
    //since 759(1.19)
    MANGROVE_TRAPDOOR("minecraft:mangrove_trapdoor"),
    //since 761(1.19.3)
    MANGROVE_WALL_HANGING_SIGN("minecraft:mangrove_wall_hanging_sign"),
    //since 759(1.19)
    MANGROVE_WALL_SIGN("minecraft:mangrove_wall_sign"),
    //since 759(1.19)
    MANGROVE_WOOD("minecraft:mangrove_wood"),
    //since 755(1.17)
    MEDIUM_AMETHYST_BUD("minecraft:medium_amethyst_bud"),
    //since 754(1.16.5)
    MELON("minecraft:melon"),
    //since 754(1.16.5)
    MELON_STEM("minecraft:melon_stem"),
    //since 755(1.17)
    MOSS_BLOCK("minecraft:moss_block"),
    //since 755(1.17)
    MOSS_CARPET("minecraft:moss_carpet"),
    //since 754(1.16.5)
    MOSSY_COBBLESTONE("minecraft:mossy_cobblestone"),
    //since 754(1.16.5)
    MOSSY_COBBLESTONE_SLAB("minecraft:mossy_cobblestone_slab"),
    //since 754(1.16.5)
    MOSSY_COBBLESTONE_STAIRS("minecraft:mossy_cobblestone_stairs"),
    //since 754(1.16.5)
    MOSSY_COBBLESTONE_WALL("minecraft:mossy_cobblestone_wall"),
    //since 754(1.16.5)
    MOSSY_STONE_BRICK_SLAB("minecraft:mossy_stone_brick_slab"),
    //since 754(1.16.5)
    MOSSY_STONE_BRICK_STAIRS("minecraft:mossy_stone_brick_stairs"),
    //since 754(1.16.5)
    MOSSY_STONE_BRICK_WALL("minecraft:mossy_stone_brick_wall"),
    //since 754(1.16.5)
    MOSSY_STONE_BRICKS("minecraft:mossy_stone_bricks"),
    //since 754(1.16.5)
    MOVING_PISTON("minecraft:moving_piston"),
    //since 759(1.19)
    MUD("minecraft:mud"),
    //since 759(1.19)
    MUD_BRICK_SLAB("minecraft:mud_brick_slab"),
    //since 759(1.19)
    MUD_BRICK_STAIRS("minecraft:mud_brick_stairs"),
    //since 759(1.19)
    MUD_BRICK_WALL("minecraft:mud_brick_wall"),
    //since 759(1.19)
    MUD_BRICKS("minecraft:mud_bricks"),
    //since 759(1.19)
    MUDDY_MANGROVE_ROOTS("minecraft:muddy_mangrove_roots"),
    //since 754(1.16.5)
    MUSHROOM_STEM("minecraft:mushroom_stem"),
    //since 754(1.16.5)
    MYCELIUM("minecraft:mycelium"),
    //since 754(1.16.5)
    NETHER_BRICK_FENCE("minecraft:nether_brick_fence"),
    //since 754(1.16.5)
    NETHER_BRICK_SLAB("minecraft:nether_brick_slab"),
    //since 754(1.16.5)
    NETHER_BRICK_STAIRS("minecraft:nether_brick_stairs"),
    //since 754(1.16.5)
    NETHER_BRICK_WALL("minecraft:nether_brick_wall"),
    //since 754(1.16.5)
    NETHER_BRICKS("minecraft:nether_bricks"),
    //since 754(1.16.5)
    NETHER_GOLD_ORE("minecraft:nether_gold_ore"),
    //since 754(1.16.5)
    NETHER_PORTAL("minecraft:nether_portal"),
    //since 754(1.16.5)
    NETHER_QUARTZ_ORE("minecraft:nether_quartz_ore"),
    //since 754(1.16.5)
    NETHER_SPROUTS("minecraft:nether_sprouts"),
    //since 754(1.16.5)
    NETHER_WART("minecraft:nether_wart"),
    //since 754(1.16.5)
    NETHER_WART_BLOCK("minecraft:nether_wart_block"),
    //since 754(1.16.5)
    NETHERITE_BLOCK("minecraft:netherite_block"),
    //since 754(1.16.5)
    NETHERRACK("minecraft:netherrack"),
    //since 754(1.16.5)
    NOTE_BLOCK("minecraft:note_block"),
    //since 754(1.16.5)
    OAK_BUTTON("minecraft:oak_button"),
    //since 754(1.16.5)
    OAK_DOOR("minecraft:oak_door"),
    //since 754(1.16.5)
    OAK_FENCE("minecraft:oak_fence"),
    //since 754(1.16.5)
    OAK_FENCE_GATE("minecraft:oak_fence_gate"),
    //since 761(1.19.3)
    OAK_HANGING_SIGN("minecraft:oak_hanging_sign"),
    //since 754(1.16.5)
    OAK_LEAVES("minecraft:oak_leaves"),
    //since 754(1.16.5)
    OAK_LOG("minecraft:oak_log"),
    //since 754(1.16.5)
    OAK_PLANKS("minecraft:oak_planks"),
    //since 754(1.16.5)
    OAK_PRESSURE_PLATE("minecraft:oak_pressure_plate"),
    //since 754(1.16.5)
    OAK_SAPLING("minecraft:oak_sapling"),
    //since 773(1.21.9)
    OAK_SHELF("minecraft:oak_shelf"),
    //since 754(1.16.5)
    OAK_SIGN("minecraft:oak_sign"),
    //since 754(1.16.5)
    OAK_SLAB("minecraft:oak_slab"),
    //since 754(1.16.5)
    OAK_STAIRS("minecraft:oak_stairs"),
    //since 754(1.16.5)
    OAK_TRAPDOOR("minecraft:oak_trapdoor"),
    //since 761(1.19.3)
    OAK_WALL_HANGING_SIGN("minecraft:oak_wall_hanging_sign"),
    //since 754(1.16.5)
    OAK_WALL_SIGN("minecraft:oak_wall_sign"),
    //since 754(1.16.5)
    OAK_WOOD("minecraft:oak_wood"),
    //since 754(1.16.5)
    OBSERVER("minecraft:observer"),
    //since 754(1.16.5)
    OBSIDIAN("minecraft:obsidian"),
    //since 759(1.19)
    OCHRE_FROGLIGHT("minecraft:ochre_froglight"),
    //since 769(1.21.4)
    OPEN_EYEBLOSSOM("minecraft:open_eyeblossom"),
    //since 754(1.16.5)
    ORANGE_BANNER("minecraft:orange_banner"),
    //since 754(1.16.5)
    ORANGE_BED("minecraft:orange_bed"),
    //since 755(1.17)
    ORANGE_CANDLE("minecraft:orange_candle"),
    //since 755(1.17)
    ORANGE_CANDLE_CAKE("minecraft:orange_candle_cake"),
    //since 754(1.16.5)
    ORANGE_CARPET("minecraft:orange_carpet"),
    //since 754(1.16.5)
    ORANGE_CONCRETE("minecraft:orange_concrete"),
    //since 754(1.16.5)
    ORANGE_CONCRETE_POWDER("minecraft:orange_concrete_powder"),
    //since 754(1.16.5)
    ORANGE_GLAZED_TERRACOTTA("minecraft:orange_glazed_terracotta"),
    //since 754(1.16.5)
    ORANGE_SHULKER_BOX("minecraft:orange_shulker_box"),
    //since 754(1.16.5)
    ORANGE_STAINED_GLASS("minecraft:orange_stained_glass"),
    //since 754(1.16.5)
    ORANGE_STAINED_GLASS_PANE("minecraft:orange_stained_glass_pane"),
    //since 754(1.16.5)
    ORANGE_TERRACOTTA("minecraft:orange_terracotta"),
    //since 754(1.16.5)
    ORANGE_TULIP("minecraft:orange_tulip"),
    //since 754(1.16.5)
    ORANGE_WALL_BANNER("minecraft:orange_wall_banner"),
    //since 754(1.16.5)
    ORANGE_WOOL("minecraft:orange_wool"),
    //since 754(1.16.5)
    OXEYE_DAISY("minecraft:oxeye_daisy"),
    //since 765(1.20.3)
    OXIDIZED_CHISELED_COPPER("minecraft:oxidized_chiseled_copper"),
    //since 755(1.17)
    OXIDIZED_COPPER("minecraft:oxidized_copper"),
    //since 773(1.21.9)
    OXIDIZED_COPPER_BARS("minecraft:oxidized_copper_bars"),
    //since 765(1.20.3)
    OXIDIZED_COPPER_BULB("minecraft:oxidized_copper_bulb"),
    //since 773(1.21.9)
    OXIDIZED_COPPER_CHAIN("minecraft:oxidized_copper_chain"),
    //since 773(1.21.9)
    OXIDIZED_COPPER_CHEST("minecraft:oxidized_copper_chest"),
    //since 765(1.20.3)
    OXIDIZED_COPPER_DOOR("minecraft:oxidized_copper_door"),
    //since 773(1.21.9)
    OXIDIZED_COPPER_GOLEM_STATUE("minecraft:oxidized_copper_golem_statue"),
    //since 765(1.20.3)
    OXIDIZED_COPPER_GRATE("minecraft:oxidized_copper_grate"),
    //since 773(1.21.9)
    OXIDIZED_COPPER_LANTERN("minecraft:oxidized_copper_lantern"),
    //since 765(1.20.3)
    OXIDIZED_COPPER_TRAPDOOR("minecraft:oxidized_copper_trapdoor"),
    //since 755(1.17)
    OXIDIZED_CUT_COPPER("minecraft:oxidized_cut_copper"),
    //since 755(1.17)
    OXIDIZED_CUT_COPPER_SLAB("minecraft:oxidized_cut_copper_slab"),
    //since 755(1.17)
    OXIDIZED_CUT_COPPER_STAIRS("minecraft:oxidized_cut_copper_stairs"),
    //since 773(1.21.9)
    OXIDIZED_LIGHTNING_ROD("minecraft:oxidized_lightning_rod"),
    //since 754(1.16.5)
    PACKED_ICE("minecraft:packed_ice"),
    //since 759(1.19)
    PACKED_MUD("minecraft:packed_mud"),
    //since 768(1.21.2)
    PALE_HANGING_MOSS("minecraft:pale_hanging_moss"),
    //since 768(1.21.2)
    PALE_MOSS_BLOCK("minecraft:pale_moss_block"),
    //since 768(1.21.2)
    PALE_MOSS_CARPET("minecraft:pale_moss_carpet"),
    //since 768(1.21.2)
    PALE_OAK_BUTTON("minecraft:pale_oak_button"),
    //since 768(1.21.2)
    PALE_OAK_DOOR("minecraft:pale_oak_door"),
    //since 768(1.21.2)
    PALE_OAK_FENCE("minecraft:pale_oak_fence"),
    //since 768(1.21.2)
    PALE_OAK_FENCE_GATE("minecraft:pale_oak_fence_gate"),
    //since 768(1.21.2)
    PALE_OAK_HANGING_SIGN("minecraft:pale_oak_hanging_sign"),
    //since 768(1.21.2)
    PALE_OAK_LEAVES("minecraft:pale_oak_leaves"),
    //since 768(1.21.2)
    PALE_OAK_LOG("minecraft:pale_oak_log"),
    //since 768(1.21.2)
    PALE_OAK_PLANKS("minecraft:pale_oak_planks"),
    //since 768(1.21.2)
    PALE_OAK_PRESSURE_PLATE("minecraft:pale_oak_pressure_plate"),
    //since 768(1.21.2)
    PALE_OAK_SAPLING("minecraft:pale_oak_sapling"),
    //since 773(1.21.9)
    PALE_OAK_SHELF("minecraft:pale_oak_shelf"),
    //since 768(1.21.2)
    PALE_OAK_SIGN("minecraft:pale_oak_sign"),
    //since 768(1.21.2)
    PALE_OAK_SLAB("minecraft:pale_oak_slab"),
    //since 768(1.21.2)
    PALE_OAK_STAIRS("minecraft:pale_oak_stairs"),
    //since 768(1.21.2)
    PALE_OAK_TRAPDOOR("minecraft:pale_oak_trapdoor"),
    //since 768(1.21.2)
    PALE_OAK_WALL_HANGING_SIGN("minecraft:pale_oak_wall_hanging_sign"),
    //since 768(1.21.2)
    PALE_OAK_WALL_SIGN("minecraft:pale_oak_wall_sign"),
    //since 768(1.21.2)
    PALE_OAK_WOOD("minecraft:pale_oak_wood"),
    //since 759(1.19)
    PEARLESCENT_FROGLIGHT("minecraft:pearlescent_froglight"),
    //since 754(1.16.5)
    PEONY("minecraft:peony"),
    //since 754(1.16.5)
    PETRIFIED_OAK_SLAB("minecraft:petrified_oak_slab"),
    //since 761(1.19.3)
    PIGLIN_HEAD("minecraft:piglin_head"),
    //since 761(1.19.3)
    PIGLIN_WALL_HEAD("minecraft:piglin_wall_head"),
    //since 754(1.16.5)
    PINK_BANNER("minecraft:pink_banner"),
    //since 754(1.16.5)
    PINK_BED("minecraft:pink_bed"),
    //since 755(1.17)
    PINK_CANDLE("minecraft:pink_candle"),
    //since 755(1.17)
    PINK_CANDLE_CAKE("minecraft:pink_candle_cake"),
    //since 754(1.16.5)
    PINK_CARPET("minecraft:pink_carpet"),
    //since 754(1.16.5)
    PINK_CONCRETE("minecraft:pink_concrete"),
    //since 754(1.16.5)
    PINK_CONCRETE_POWDER("minecraft:pink_concrete_powder"),
    //since 754(1.16.5)
    PINK_GLAZED_TERRACOTTA("minecraft:pink_glazed_terracotta"),
    //since 762(1.19.4)
    PINK_PETALS("minecraft:pink_petals"),
    //since 754(1.16.5)
    PINK_SHULKER_BOX("minecraft:pink_shulker_box"),
    //since 754(1.16.5)
    PINK_STAINED_GLASS("minecraft:pink_stained_glass"),
    //since 754(1.16.5)
    PINK_STAINED_GLASS_PANE("minecraft:pink_stained_glass_pane"),
    //since 754(1.16.5)
    PINK_TERRACOTTA("minecraft:pink_terracotta"),
    //since 754(1.16.5)
    PINK_TULIP("minecraft:pink_tulip"),
    //since 754(1.16.5)
    PINK_WALL_BANNER("minecraft:pink_wall_banner"),
    //since 754(1.16.5)
    PINK_WOOL("minecraft:pink_wool"),
    //since 754(1.16.5)
    PISTON("minecraft:piston"),
    //since 754(1.16.5)
    PISTON_HEAD("minecraft:piston_head"),
    //since 763(1.20)
    PITCHER_CROP("minecraft:pitcher_crop"),
    //since 763(1.20)
    PITCHER_PLANT("minecraft:pitcher_plant"),
    //since 754(1.16.5)
    PLAYER_HEAD("minecraft:player_head"),
    //since 754(1.16.5)
    PLAYER_WALL_HEAD("minecraft:player_wall_head"),
    //since 754(1.16.5)
    PODZOL("minecraft:podzol"),
    //since 755(1.17)
    POINTED_DRIPSTONE("minecraft:pointed_dripstone"),
    //since 754(1.16.5)
    POLISHED_ANDESITE("minecraft:polished_andesite"),
    //since 754(1.16.5)
    POLISHED_ANDESITE_SLAB("minecraft:polished_andesite_slab"),
    //since 754(1.16.5)
    POLISHED_ANDESITE_STAIRS("minecraft:polished_andesite_stairs"),
    //since 754(1.16.5)
    POLISHED_BASALT("minecraft:polished_basalt"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE("minecraft:polished_blackstone"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_BRICK_SLAB("minecraft:polished_blackstone_brick_slab"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_BRICK_STAIRS("minecraft:polished_blackstone_brick_stairs"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_BRICK_WALL("minecraft:polished_blackstone_brick_wall"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_BRICKS("minecraft:polished_blackstone_bricks"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_BUTTON("minecraft:polished_blackstone_button"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_PRESSURE_PLATE("minecraft:polished_blackstone_pressure_plate"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_SLAB("minecraft:polished_blackstone_slab"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_STAIRS("minecraft:polished_blackstone_stairs"),
    //since 754(1.16.5)
    POLISHED_BLACKSTONE_WALL("minecraft:polished_blackstone_wall"),
    //since 755(1.17)
    POLISHED_DEEPSLATE("minecraft:polished_deepslate"),
    //since 755(1.17)
    POLISHED_DEEPSLATE_SLAB("minecraft:polished_deepslate_slab"),
    //since 755(1.17)
    POLISHED_DEEPSLATE_STAIRS("minecraft:polished_deepslate_stairs"),
    //since 755(1.17)
    POLISHED_DEEPSLATE_WALL("minecraft:polished_deepslate_wall"),
    //since 754(1.16.5)
    POLISHED_DIORITE("minecraft:polished_diorite"),
    //since 754(1.16.5)
    POLISHED_DIORITE_SLAB("minecraft:polished_diorite_slab"),
    //since 754(1.16.5)
    POLISHED_DIORITE_STAIRS("minecraft:polished_diorite_stairs"),
    //since 754(1.16.5)
    POLISHED_GRANITE("minecraft:polished_granite"),
    //since 754(1.16.5)
    POLISHED_GRANITE_SLAB("minecraft:polished_granite_slab"),
    //since 754(1.16.5)
    POLISHED_GRANITE_STAIRS("minecraft:polished_granite_stairs"),
    //since 765(1.20.3)
    POLISHED_TUFF("minecraft:polished_tuff"),
    //since 765(1.20.3)
    POLISHED_TUFF_SLAB("minecraft:polished_tuff_slab"),
    //since 765(1.20.3)
    POLISHED_TUFF_STAIRS("minecraft:polished_tuff_stairs"),
    //since 765(1.20.3)
    POLISHED_TUFF_WALL("minecraft:polished_tuff_wall"),
    //since 754(1.16.5)
    POPPY("minecraft:poppy"),
    //since 754(1.16.5)
    POTATOES("minecraft:potatoes"),
    //since 754(1.16.5)
    POTTED_ACACIA_SAPLING("minecraft:potted_acacia_sapling"),
    //since 754(1.16.5)
    POTTED_ALLIUM("minecraft:potted_allium"),
    //since 755(1.17)
    POTTED_AZALEA_BUSH("minecraft:potted_azalea_bush"),
    //since 754(1.16.5)
    POTTED_AZURE_BLUET("minecraft:potted_azure_bluet"),
    //since 754(1.16.5)
    POTTED_BAMBOO("minecraft:potted_bamboo"),
    //since 754(1.16.5)
    POTTED_BIRCH_SAPLING("minecraft:potted_birch_sapling"),
    //since 754(1.16.5)
    POTTED_BLUE_ORCHID("minecraft:potted_blue_orchid"),
    //since 754(1.16.5)
    POTTED_BROWN_MUSHROOM("minecraft:potted_brown_mushroom"),
    //since 754(1.16.5)
    POTTED_CACTUS("minecraft:potted_cactus"),
    //since 762(1.19.4)
    POTTED_CHERRY_SAPLING("minecraft:potted_cherry_sapling"),
    //since 769(1.21.4)
    POTTED_CLOSED_EYEBLOSSOM("minecraft:potted_closed_eyeblossom"),
    //since 754(1.16.5)
    POTTED_CORNFLOWER("minecraft:potted_cornflower"),
    //since 754(1.16.5)
    POTTED_CRIMSON_FUNGUS("minecraft:potted_crimson_fungus"),
    //since 754(1.16.5)
    POTTED_CRIMSON_ROOTS("minecraft:potted_crimson_roots"),
    //since 754(1.16.5)
    POTTED_DANDELION("minecraft:potted_dandelion"),
    //since 754(1.16.5)
    POTTED_DARK_OAK_SAPLING("minecraft:potted_dark_oak_sapling"),
    //since 754(1.16.5)
    POTTED_DEAD_BUSH("minecraft:potted_dead_bush"),
    //since 754(1.16.5)
    POTTED_FERN("minecraft:potted_fern"),
    //since 755(1.17)
    POTTED_FLOWERING_AZALEA_BUSH("minecraft:potted_flowering_azalea_bush"),
    //since 754(1.16.5)
    POTTED_JUNGLE_SAPLING("minecraft:potted_jungle_sapling"),
    //since 754(1.16.5)
    POTTED_LILY_OF_THE_VALLEY("minecraft:potted_lily_of_the_valley"),
    //since 759(1.19)
    POTTED_MANGROVE_PROPAGULE("minecraft:potted_mangrove_propagule"),
    //since 754(1.16.5)
    POTTED_OAK_SAPLING("minecraft:potted_oak_sapling"),
    //since 769(1.21.4)
    POTTED_OPEN_EYEBLOSSOM("minecraft:potted_open_eyeblossom"),
    //since 754(1.16.5)
    POTTED_ORANGE_TULIP("minecraft:potted_orange_tulip"),
    //since 754(1.16.5)
    POTTED_OXEYE_DAISY("minecraft:potted_oxeye_daisy"),
    //since 768(1.21.2)
    POTTED_PALE_OAK_SAPLING("minecraft:potted_pale_oak_sapling"),
    //since 754(1.16.5)
    POTTED_PINK_TULIP("minecraft:potted_pink_tulip"),
    //since 754(1.16.5)
    POTTED_POPPY("minecraft:potted_poppy"),
    //since 754(1.16.5)
    POTTED_RED_MUSHROOM("minecraft:potted_red_mushroom"),
    //since 754(1.16.5)
    POTTED_RED_TULIP("minecraft:potted_red_tulip"),
    //since 754(1.16.5)
    POTTED_SPRUCE_SAPLING("minecraft:potted_spruce_sapling"),
    //since 762(1.19.4)
    POTTED_TORCHFLOWER("minecraft:potted_torchflower"),
    //since 754(1.16.5)
    POTTED_WARPED_FUNGUS("minecraft:potted_warped_fungus"),
    //since 754(1.16.5)
    POTTED_WARPED_ROOTS("minecraft:potted_warped_roots"),
    //since 754(1.16.5)
    POTTED_WHITE_TULIP("minecraft:potted_white_tulip"),
    //since 754(1.16.5)
    POTTED_WITHER_ROSE("minecraft:potted_wither_rose"),
    //since 755(1.17)
    POWDER_SNOW("minecraft:powder_snow"),
    //since 755(1.17)
    POWDER_SNOW_CAULDRON("minecraft:powder_snow_cauldron"),
    //since 754(1.16.5)
    POWERED_RAIL("minecraft:powered_rail"),
    //since 754(1.16.5)
    PRISMARINE("minecraft:prismarine"),
    //since 754(1.16.5)
    PRISMARINE_BRICK_SLAB("minecraft:prismarine_brick_slab"),
    //since 754(1.16.5)
    PRISMARINE_BRICK_STAIRS("minecraft:prismarine_brick_stairs"),
    //since 754(1.16.5)
    PRISMARINE_BRICKS("minecraft:prismarine_bricks"),
    //since 754(1.16.5)
    PRISMARINE_SLAB("minecraft:prismarine_slab"),
    //since 754(1.16.5)
    PRISMARINE_STAIRS("minecraft:prismarine_stairs"),
    //since 754(1.16.5)
    PRISMARINE_WALL("minecraft:prismarine_wall"),
    //since 754(1.16.5)
    PUMPKIN("minecraft:pumpkin"),
    //since 754(1.16.5)
    PUMPKIN_STEM("minecraft:pumpkin_stem"),
    //since 754(1.16.5)
    PURPLE_BANNER("minecraft:purple_banner"),
    //since 754(1.16.5)
    PURPLE_BED("minecraft:purple_bed"),
    //since 755(1.17)
    PURPLE_CANDLE("minecraft:purple_candle"),
    //since 755(1.17)
    PURPLE_CANDLE_CAKE("minecraft:purple_candle_cake"),
    //since 754(1.16.5)
    PURPLE_CARPET("minecraft:purple_carpet"),
    //since 754(1.16.5)
    PURPLE_CONCRETE("minecraft:purple_concrete"),
    //since 754(1.16.5)
    PURPLE_CONCRETE_POWDER("minecraft:purple_concrete_powder"),
    //since 754(1.16.5)
    PURPLE_GLAZED_TERRACOTTA("minecraft:purple_glazed_terracotta"),
    //since 754(1.16.5)
    PURPLE_SHULKER_BOX("minecraft:purple_shulker_box"),
    //since 754(1.16.5)
    PURPLE_STAINED_GLASS("minecraft:purple_stained_glass"),
    //since 754(1.16.5)
    PURPLE_STAINED_GLASS_PANE("minecraft:purple_stained_glass_pane"),
    //since 754(1.16.5)
    PURPLE_TERRACOTTA("minecraft:purple_terracotta"),
    //since 754(1.16.5)
    PURPLE_WALL_BANNER("minecraft:purple_wall_banner"),
    //since 754(1.16.5)
    PURPLE_WOOL("minecraft:purple_wool"),
    //since 754(1.16.5)
    PURPUR_BLOCK("minecraft:purpur_block"),
    //since 754(1.16.5)
    PURPUR_PILLAR("minecraft:purpur_pillar"),
    //since 754(1.16.5)
    PURPUR_SLAB("minecraft:purpur_slab"),
    //since 754(1.16.5)
    PURPUR_STAIRS("minecraft:purpur_stairs"),
    //since 754(1.16.5)
    QUARTZ_BLOCK("minecraft:quartz_block"),
    //since 754(1.16.5)
    QUARTZ_BRICKS("minecraft:quartz_bricks"),
    //since 754(1.16.5)
    QUARTZ_PILLAR("minecraft:quartz_pillar"),
    //since 754(1.16.5)
    QUARTZ_SLAB("minecraft:quartz_slab"),
    //since 754(1.16.5)
    QUARTZ_STAIRS("minecraft:quartz_stairs"),
    //since 754(1.16.5)
    RAIL("minecraft:rail"),
    //since 755(1.17)
    RAW_COPPER_BLOCK("minecraft:raw_copper_block"),
    //since 755(1.17)
    RAW_GOLD_BLOCK("minecraft:raw_gold_block"),
    //since 755(1.17)
    RAW_IRON_BLOCK("minecraft:raw_iron_block"),
    //since 754(1.16.5)
    RED_BANNER("minecraft:red_banner"),
    //since 754(1.16.5)
    RED_BED("minecraft:red_bed"),
    //since 755(1.17)
    RED_CANDLE("minecraft:red_candle"),
    //since 755(1.17)
    RED_CANDLE_CAKE("minecraft:red_candle_cake"),
    //since 754(1.16.5)
    RED_CARPET("minecraft:red_carpet"),
    //since 754(1.16.5)
    RED_CONCRETE("minecraft:red_concrete"),
    //since 754(1.16.5)
    RED_CONCRETE_POWDER("minecraft:red_concrete_powder"),
    //since 754(1.16.5)
    RED_GLAZED_TERRACOTTA("minecraft:red_glazed_terracotta"),
    //since 754(1.16.5)
    RED_MUSHROOM("minecraft:red_mushroom"),
    //since 754(1.16.5)
    RED_MUSHROOM_BLOCK("minecraft:red_mushroom_block"),
    //since 754(1.16.5)
    RED_NETHER_BRICK_SLAB("minecraft:red_nether_brick_slab"),
    //since 754(1.16.5)
    RED_NETHER_BRICK_STAIRS("minecraft:red_nether_brick_stairs"),
    //since 754(1.16.5)
    RED_NETHER_BRICK_WALL("minecraft:red_nether_brick_wall"),
    //since 754(1.16.5)
    RED_NETHER_BRICKS("minecraft:red_nether_bricks"),
    //since 754(1.16.5)
    RED_SAND("minecraft:red_sand"),
    //since 754(1.16.5)
    RED_SANDSTONE("minecraft:red_sandstone"),
    //since 754(1.16.5)
    RED_SANDSTONE_SLAB("minecraft:red_sandstone_slab"),
    //since 754(1.16.5)
    RED_SANDSTONE_STAIRS("minecraft:red_sandstone_stairs"),
    //since 754(1.16.5)
    RED_SANDSTONE_WALL("minecraft:red_sandstone_wall"),
    //since 754(1.16.5)
    RED_SHULKER_BOX("minecraft:red_shulker_box"),
    //since 754(1.16.5)
    RED_STAINED_GLASS("minecraft:red_stained_glass"),
    //since 754(1.16.5)
    RED_STAINED_GLASS_PANE("minecraft:red_stained_glass_pane"),
    //since 754(1.16.5)
    RED_TERRACOTTA("minecraft:red_terracotta"),
    //since 754(1.16.5)
    RED_TULIP("minecraft:red_tulip"),
    //since 754(1.16.5)
    RED_WALL_BANNER("minecraft:red_wall_banner"),
    //since 754(1.16.5)
    RED_WOOL("minecraft:red_wool"),
    //since 754(1.16.5)
    REDSTONE_BLOCK("minecraft:redstone_block"),
    //since 754(1.16.5)
    REDSTONE_LAMP("minecraft:redstone_lamp"),
    //since 754(1.16.5)
    REDSTONE_ORE("minecraft:redstone_ore"),
    //since 754(1.16.5)
    REDSTONE_TORCH("minecraft:redstone_torch"),
    //since 754(1.16.5)
    REDSTONE_WALL_TORCH("minecraft:redstone_wall_torch"),
    //since 754(1.16.5)
    REDSTONE_WIRE("minecraft:redstone_wire"),
    //since 759(1.19)
    REINFORCED_DEEPSLATE("minecraft:reinforced_deepslate"),
    //since 754(1.16.5)
    REPEATER("minecraft:repeater"),
    //since 754(1.16.5)
    REPEATING_COMMAND_BLOCK("minecraft:repeating_command_block"),
    //since 769(1.21.4)
    RESIN_BLOCK("minecraft:resin_block"),
    //since 769(1.21.4)
    RESIN_BRICK_SLAB("minecraft:resin_brick_slab"),
    //since 769(1.21.4)
    RESIN_BRICK_STAIRS("minecraft:resin_brick_stairs"),
    //since 769(1.21.4)
    RESIN_BRICK_WALL("minecraft:resin_brick_wall"),
    //since 769(1.21.4)
    RESIN_BRICKS("minecraft:resin_bricks"),
    //since 769(1.21.4)
    RESIN_CLUMP("minecraft:resin_clump"),
    //since 754(1.16.5)
    RESPAWN_ANCHOR("minecraft:respawn_anchor"),
    //since 755(1.17)
    ROOTED_DIRT("minecraft:rooted_dirt"),
    //since 754(1.16.5)
    ROSE_BUSH("minecraft:rose_bush"),
    //since 754(1.16.5)
    SAND("minecraft:sand"),
    //since 754(1.16.5)
    SANDSTONE("minecraft:sandstone"),
    //since 754(1.16.5)
    SANDSTONE_SLAB("minecraft:sandstone_slab"),
    //since 754(1.16.5)
    SANDSTONE_STAIRS("minecraft:sandstone_stairs"),
    //since 754(1.16.5)
    SANDSTONE_WALL("minecraft:sandstone_wall"),
    //since 754(1.16.5)
    SCAFFOLDING("minecraft:scaffolding"),
    //since 759(1.19)
    SCULK("minecraft:sculk"),
    //since 759(1.19)
    SCULK_CATALYST("minecraft:sculk_catalyst"),
    //since 755(1.17)
    SCULK_SENSOR("minecraft:sculk_sensor"),
    //since 759(1.19)
    SCULK_SHRIEKER("minecraft:sculk_shrieker"),
    //since 759(1.19)
    SCULK_VEIN("minecraft:sculk_vein"),
    //since 754(1.16.5)
    SEA_LANTERN("minecraft:sea_lantern"),
    //since 754(1.16.5)
    SEA_PICKLE("minecraft:sea_pickle"),
    //since 754(1.16.5)
    SEAGRASS("minecraft:seagrass"),
    //since 770(1.21.5)
    SHORT_DRY_GRASS("minecraft:short_dry_grass"),
    //since 765(1.20.3)
    SHORT_GRASS("minecraft:short_grass"),
    //since 754(1.16.5)
    SHROOMLIGHT("minecraft:shroomlight"),
    //since 754(1.16.5)
    SHULKER_BOX("minecraft:shulker_box"),
    //since 754(1.16.5)
    SKELETON_SKULL("minecraft:skeleton_skull"),
    //since 754(1.16.5)
    SKELETON_WALL_SKULL("minecraft:skeleton_wall_skull"),
    //since 754(1.16.5)
    SLIME_BLOCK("minecraft:slime_block"),
    //since 755(1.17)
    SMALL_AMETHYST_BUD("minecraft:small_amethyst_bud"),
    //since 755(1.17)
    SMALL_DRIPLEAF("minecraft:small_dripleaf"),
    //since 754(1.16.5)
    SMITHING_TABLE("minecraft:smithing_table"),
    //since 754(1.16.5)
    SMOKER("minecraft:smoker"),
    //since 755(1.17)
    SMOOTH_BASALT("minecraft:smooth_basalt"),
    //since 754(1.16.5)
    SMOOTH_QUARTZ("minecraft:smooth_quartz"),
    //since 754(1.16.5)
    SMOOTH_QUARTZ_SLAB("minecraft:smooth_quartz_slab"),
    //since 754(1.16.5)
    SMOOTH_QUARTZ_STAIRS("minecraft:smooth_quartz_stairs"),
    //since 754(1.16.5)
    SMOOTH_RED_SANDSTONE("minecraft:smooth_red_sandstone"),
    //since 754(1.16.5)
    SMOOTH_RED_SANDSTONE_SLAB("minecraft:smooth_red_sandstone_slab"),
    //since 754(1.16.5)
    SMOOTH_RED_SANDSTONE_STAIRS("minecraft:smooth_red_sandstone_stairs"),
    //since 754(1.16.5)
    SMOOTH_SANDSTONE("minecraft:smooth_sandstone"),
    //since 754(1.16.5)
    SMOOTH_SANDSTONE_SLAB("minecraft:smooth_sandstone_slab"),
    //since 754(1.16.5)
    SMOOTH_SANDSTONE_STAIRS("minecraft:smooth_sandstone_stairs"),
    //since 754(1.16.5)
    SMOOTH_STONE("minecraft:smooth_stone"),
    //since 754(1.16.5)
    SMOOTH_STONE_SLAB("minecraft:smooth_stone_slab"),
    //since 763(1.20)
    SNIFFER_EGG("minecraft:sniffer_egg"),
    //since 754(1.16.5)
    SNOW("minecraft:snow"),
    //since 754(1.16.5)
    SNOW_BLOCK("minecraft:snow_block"),
    //since 754(1.16.5)
    SOUL_CAMPFIRE("minecraft:soul_campfire"),
    //since 754(1.16.5)
    SOUL_FIRE("minecraft:soul_fire"),
    //since 754(1.16.5)
    SOUL_LANTERN("minecraft:soul_lantern"),
    //since 754(1.16.5)
    SOUL_SAND("minecraft:soul_sand"),
    //since 754(1.16.5)
    SOUL_SOIL("minecraft:soul_soil"),
    //since 754(1.16.5)
    SOUL_TORCH("minecraft:soul_torch"),
    //since 754(1.16.5)
    SOUL_WALL_TORCH("minecraft:soul_wall_torch"),
    //since 754(1.16.5)
    SPAWNER("minecraft:spawner"),
    //since 754(1.16.5)
    SPONGE("minecraft:sponge"),
    //since 755(1.17)
    SPORE_BLOSSOM("minecraft:spore_blossom"),
    //since 754(1.16.5)
    SPRUCE_BUTTON("minecraft:spruce_button"),
    //since 754(1.16.5)
    SPRUCE_DOOR("minecraft:spruce_door"),
    //since 754(1.16.5)
    SPRUCE_FENCE("minecraft:spruce_fence"),
    //since 754(1.16.5)
    SPRUCE_FENCE_GATE("minecraft:spruce_fence_gate"),
    //since 761(1.19.3)
    SPRUCE_HANGING_SIGN("minecraft:spruce_hanging_sign"),
    //since 754(1.16.5)
    SPRUCE_LEAVES("minecraft:spruce_leaves"),
    //since 754(1.16.5)
    SPRUCE_LOG("minecraft:spruce_log"),
    //since 754(1.16.5)
    SPRUCE_PLANKS("minecraft:spruce_planks"),
    //since 754(1.16.5)
    SPRUCE_PRESSURE_PLATE("minecraft:spruce_pressure_plate"),
    //since 754(1.16.5)
    SPRUCE_SAPLING("minecraft:spruce_sapling"),
    //since 773(1.21.9)
    SPRUCE_SHELF("minecraft:spruce_shelf"),
    //since 754(1.16.5)
    SPRUCE_SIGN("minecraft:spruce_sign"),
    //since 754(1.16.5)
    SPRUCE_SLAB("minecraft:spruce_slab"),
    //since 754(1.16.5)
    SPRUCE_STAIRS("minecraft:spruce_stairs"),
    //since 754(1.16.5)
    SPRUCE_TRAPDOOR("minecraft:spruce_trapdoor"),
    //since 761(1.19.3)
    SPRUCE_WALL_HANGING_SIGN("minecraft:spruce_wall_hanging_sign"),
    //since 754(1.16.5)
    SPRUCE_WALL_SIGN("minecraft:spruce_wall_sign"),
    //since 754(1.16.5)
    SPRUCE_WOOD("minecraft:spruce_wood"),
    //since 754(1.16.5)
    STICKY_PISTON("minecraft:sticky_piston"),
    //since 754(1.16.5)
    STONE("minecraft:stone"),
    //since 754(1.16.5)
    STONE_BRICK_SLAB("minecraft:stone_brick_slab"),
    //since 754(1.16.5)
    STONE_BRICK_STAIRS("minecraft:stone_brick_stairs"),
    //since 754(1.16.5)
    STONE_BRICK_WALL("minecraft:stone_brick_wall"),
    //since 754(1.16.5)
    STONE_BRICKS("minecraft:stone_bricks"),
    //since 754(1.16.5)
    STONE_BUTTON("minecraft:stone_button"),
    //since 754(1.16.5)
    STONE_PRESSURE_PLATE("minecraft:stone_pressure_plate"),
    //since 754(1.16.5)
    STONE_SLAB("minecraft:stone_slab"),
    //since 754(1.16.5)
    STONE_STAIRS("minecraft:stone_stairs"),
    //since 754(1.16.5)
    STONECUTTER("minecraft:stonecutter"),
    //since 754(1.16.5)
    STRIPPED_ACACIA_LOG("minecraft:stripped_acacia_log"),
    //since 754(1.16.5)
    STRIPPED_ACACIA_WOOD("minecraft:stripped_acacia_wood"),
    //since 761(1.19.3)
    STRIPPED_BAMBOO_BLOCK("minecraft:stripped_bamboo_block"),
    //since 754(1.16.5)
    STRIPPED_BIRCH_LOG("minecraft:stripped_birch_log"),
    //since 754(1.16.5)
    STRIPPED_BIRCH_WOOD("minecraft:stripped_birch_wood"),
    //since 762(1.19.4)
    STRIPPED_CHERRY_LOG("minecraft:stripped_cherry_log"),
    //since 762(1.19.4)
    STRIPPED_CHERRY_WOOD("minecraft:stripped_cherry_wood"),
    //since 754(1.16.5)
    STRIPPED_CRIMSON_HYPHAE("minecraft:stripped_crimson_hyphae"),
    //since 754(1.16.5)
    STRIPPED_CRIMSON_STEM("minecraft:stripped_crimson_stem"),
    //since 754(1.16.5)
    STRIPPED_DARK_OAK_LOG("minecraft:stripped_dark_oak_log"),
    //since 754(1.16.5)
    STRIPPED_DARK_OAK_WOOD("minecraft:stripped_dark_oak_wood"),
    //since 754(1.16.5)
    STRIPPED_JUNGLE_LOG("minecraft:stripped_jungle_log"),
    //since 754(1.16.5)
    STRIPPED_JUNGLE_WOOD("minecraft:stripped_jungle_wood"),
    //since 759(1.19)
    STRIPPED_MANGROVE_LOG("minecraft:stripped_mangrove_log"),
    //since 759(1.19)
    STRIPPED_MANGROVE_WOOD("minecraft:stripped_mangrove_wood"),
    //since 754(1.16.5)
    STRIPPED_OAK_LOG("minecraft:stripped_oak_log"),
    //since 754(1.16.5)
    STRIPPED_OAK_WOOD("minecraft:stripped_oak_wood"),
    //since 768(1.21.2)
    STRIPPED_PALE_OAK_LOG("minecraft:stripped_pale_oak_log"),
    //since 768(1.21.2)
    STRIPPED_PALE_OAK_WOOD("minecraft:stripped_pale_oak_wood"),
    //since 754(1.16.5)
    STRIPPED_SPRUCE_LOG("minecraft:stripped_spruce_log"),
    //since 754(1.16.5)
    STRIPPED_SPRUCE_WOOD("minecraft:stripped_spruce_wood"),
    //since 754(1.16.5)
    STRIPPED_WARPED_HYPHAE("minecraft:stripped_warped_hyphae"),
    //since 754(1.16.5)
    STRIPPED_WARPED_STEM("minecraft:stripped_warped_stem"),
    //since 754(1.16.5)
    STRUCTURE_BLOCK("minecraft:structure_block"),
    //since 754(1.16.5)
    STRUCTURE_VOID("minecraft:structure_void"),
    //since 754(1.16.5)
    SUGAR_CANE("minecraft:sugar_cane"),
    //since 754(1.16.5)
    SUNFLOWER("minecraft:sunflower"),
    //since 763(1.20)
    SUSPICIOUS_GRAVEL("minecraft:suspicious_gravel"),
    //since 762(1.19.4)
    SUSPICIOUS_SAND("minecraft:suspicious_sand"),
    //since 754(1.16.5)
    SWEET_BERRY_BUSH("minecraft:sweet_berry_bush"),
    //since 770(1.21.5)
    TALL_DRY_GRASS("minecraft:tall_dry_grass"),
    //since 754(1.16.5)
    TALL_GRASS("minecraft:tall_grass"),
    //since 754(1.16.5)
    TALL_SEAGRASS("minecraft:tall_seagrass"),
    //since 754(1.16.5)
    TARGET("minecraft:target"),
    //since 754(1.16.5)
    TERRACOTTA("minecraft:terracotta"),
    //since 770(1.21.5)
    TEST_BLOCK("minecraft:test_block"),
    //since 770(1.21.5)
    TEST_INSTANCE_BLOCK("minecraft:test_instance_block"),
    //since 755(1.17)
    TINTED_GLASS("minecraft:tinted_glass"),
    //since 754(1.16.5)
    TNT("minecraft:tnt"),
    //since 754(1.16.5)
    TORCH("minecraft:torch"),
    //since 762(1.19.4)
    TORCHFLOWER("minecraft:torchflower"),
    //since 762(1.19.4)
    TORCHFLOWER_CROP("minecraft:torchflower_crop"),
    //since 754(1.16.5)
    TRAPPED_CHEST("minecraft:trapped_chest"),
    //since 765(1.20.3)
    TRIAL_SPAWNER("minecraft:trial_spawner"),
    //since 754(1.16.5)
    TRIPWIRE("minecraft:tripwire"),
    //since 754(1.16.5)
    TRIPWIRE_HOOK("minecraft:tripwire_hook"),
    //since 754(1.16.5)
    TUBE_CORAL("minecraft:tube_coral"),
    //since 754(1.16.5)
    TUBE_CORAL_BLOCK("minecraft:tube_coral_block"),
    //since 754(1.16.5)
    TUBE_CORAL_FAN("minecraft:tube_coral_fan"),
    //since 754(1.16.5)
    TUBE_CORAL_WALL_FAN("minecraft:tube_coral_wall_fan"),
    //since 755(1.17)
    TUFF("minecraft:tuff"),
    //since 765(1.20.3)
    TUFF_BRICK_SLAB("minecraft:tuff_brick_slab"),
    //since 765(1.20.3)
    TUFF_BRICK_STAIRS("minecraft:tuff_brick_stairs"),
    //since 765(1.20.3)
    TUFF_BRICK_WALL("minecraft:tuff_brick_wall"),
    //since 765(1.20.3)
    TUFF_BRICKS("minecraft:tuff_bricks"),
    //since 765(1.20.3)
    TUFF_SLAB("minecraft:tuff_slab"),
    //since 765(1.20.3)
    TUFF_STAIRS("minecraft:tuff_stairs"),
    //since 765(1.20.3)
    TUFF_WALL("minecraft:tuff_wall"),
    //since 754(1.16.5)
    TURTLE_EGG("minecraft:turtle_egg"),
    //since 754(1.16.5)
    TWISTING_VINES("minecraft:twisting_vines"),
    //since 754(1.16.5)
    TWISTING_VINES_PLANT("minecraft:twisting_vines_plant"),
    //since 766(1.20.5)
    VAULT("minecraft:vault"),
    //since 759(1.19)
    VERDANT_FROGLIGHT("minecraft:verdant_froglight"),
    //since 754(1.16.5)
    VINE("minecraft:vine"),
    //since 754(1.16.5)
    VOID_AIR("minecraft:void_air"),
    //since 754(1.16.5)
    WALL_TORCH("minecraft:wall_torch"),
    //since 754(1.16.5)
    WARPED_BUTTON("minecraft:warped_button"),
    //since 754(1.16.5)
    WARPED_DOOR("minecraft:warped_door"),
    //since 754(1.16.5)
    WARPED_FENCE("minecraft:warped_fence"),
    //since 754(1.16.5)
    WARPED_FENCE_GATE("minecraft:warped_fence_gate"),
    //since 754(1.16.5)
    WARPED_FUNGUS("minecraft:warped_fungus"),
    //since 761(1.19.3)
    WARPED_HANGING_SIGN("minecraft:warped_hanging_sign"),
    //since 754(1.16.5)
    WARPED_HYPHAE("minecraft:warped_hyphae"),
    //since 754(1.16.5)
    WARPED_NYLIUM("minecraft:warped_nylium"),
    //since 754(1.16.5)
    WARPED_PLANKS("minecraft:warped_planks"),
    //since 754(1.16.5)
    WARPED_PRESSURE_PLATE("minecraft:warped_pressure_plate"),
    //since 754(1.16.5)
    WARPED_ROOTS("minecraft:warped_roots"),
    //since 773(1.21.9)
    WARPED_SHELF("minecraft:warped_shelf"),
    //since 754(1.16.5)
    WARPED_SIGN("minecraft:warped_sign"),
    //since 754(1.16.5)
    WARPED_SLAB("minecraft:warped_slab"),
    //since 754(1.16.5)
    WARPED_STAIRS("minecraft:warped_stairs"),
    //since 754(1.16.5)
    WARPED_STEM("minecraft:warped_stem"),
    //since 754(1.16.5)
    WARPED_TRAPDOOR("minecraft:warped_trapdoor"),
    //since 761(1.19.3)
    WARPED_WALL_HANGING_SIGN("minecraft:warped_wall_hanging_sign"),
    //since 754(1.16.5)
    WARPED_WALL_SIGN("minecraft:warped_wall_sign"),
    //since 754(1.16.5)
    WARPED_WART_BLOCK("minecraft:warped_wart_block"),
    //since 754(1.16.5)
    WATER("minecraft:water"),
    //since 755(1.17)
    WATER_CAULDRON("minecraft:water_cauldron"),
    //since 765(1.20.3)
    WAXED_CHISELED_COPPER("minecraft:waxed_chiseled_copper"),
    //since 773(1.21.9)
    WAXED_COPPER_BARS("minecraft:waxed_copper_bars"),
    //since 755(1.17)
    WAXED_COPPER_BLOCK("minecraft:waxed_copper_block"),
    //since 765(1.20.3)
    WAXED_COPPER_BULB("minecraft:waxed_copper_bulb"),
    //since 773(1.21.9)
    WAXED_COPPER_CHAIN("minecraft:waxed_copper_chain"),
    //since 773(1.21.9)
    WAXED_COPPER_CHEST("minecraft:waxed_copper_chest"),
    //since 765(1.20.3)
    WAXED_COPPER_DOOR("minecraft:waxed_copper_door"),
    //since 773(1.21.9)
    WAXED_COPPER_GOLEM_STATUE("minecraft:waxed_copper_golem_statue"),
    //since 765(1.20.3)
    WAXED_COPPER_GRATE("minecraft:waxed_copper_grate"),
    //since 773(1.21.9)
    WAXED_COPPER_LANTERN("minecraft:waxed_copper_lantern"),
    //since 765(1.20.3)
    WAXED_COPPER_TRAPDOOR("minecraft:waxed_copper_trapdoor"),
    //since 755(1.17)
    WAXED_CUT_COPPER("minecraft:waxed_cut_copper"),
    //since 755(1.17)
    WAXED_CUT_COPPER_SLAB("minecraft:waxed_cut_copper_slab"),
    //since 755(1.17)
    WAXED_CUT_COPPER_STAIRS("minecraft:waxed_cut_copper_stairs"),
    //since 765(1.20.3)
    WAXED_EXPOSED_CHISELED_COPPER("minecraft:waxed_exposed_chiseled_copper"),
    //since 755(1.17)
    WAXED_EXPOSED_COPPER("minecraft:waxed_exposed_copper"),
    //since 773(1.21.9)
    WAXED_EXPOSED_COPPER_BARS("minecraft:waxed_exposed_copper_bars"),
    //since 765(1.20.3)
    WAXED_EXPOSED_COPPER_BULB("minecraft:waxed_exposed_copper_bulb"),
    //since 773(1.21.9)
    WAXED_EXPOSED_COPPER_CHAIN("minecraft:waxed_exposed_copper_chain"),
    //since 773(1.21.9)
    WAXED_EXPOSED_COPPER_CHEST("minecraft:waxed_exposed_copper_chest"),
    //since 765(1.20.3)
    WAXED_EXPOSED_COPPER_DOOR("minecraft:waxed_exposed_copper_door"),
    //since 773(1.21.9)
    WAXED_EXPOSED_COPPER_GOLEM_STATUE("minecraft:waxed_exposed_copper_golem_statue"),
    //since 765(1.20.3)
    WAXED_EXPOSED_COPPER_GRATE("minecraft:waxed_exposed_copper_grate"),
    //since 773(1.21.9)
    WAXED_EXPOSED_COPPER_LANTERN("minecraft:waxed_exposed_copper_lantern"),
    //since 765(1.20.3)
    WAXED_EXPOSED_COPPER_TRAPDOOR("minecraft:waxed_exposed_copper_trapdoor"),
    //since 755(1.17)
    WAXED_EXPOSED_CUT_COPPER("minecraft:waxed_exposed_cut_copper"),
    //since 755(1.17)
    WAXED_EXPOSED_CUT_COPPER_SLAB("minecraft:waxed_exposed_cut_copper_slab"),
    //since 755(1.17)
    WAXED_EXPOSED_CUT_COPPER_STAIRS("minecraft:waxed_exposed_cut_copper_stairs"),
    //since 773(1.21.9)
    WAXED_EXPOSED_LIGHTNING_ROD("minecraft:waxed_exposed_lightning_rod"),
    //since 773(1.21.9)
    WAXED_LIGHTNING_ROD("minecraft:waxed_lightning_rod"),
    //since 765(1.20.3)
    WAXED_OXIDIZED_CHISELED_COPPER("minecraft:waxed_oxidized_chiseled_copper"),
    //since 755(1.17)
    WAXED_OXIDIZED_COPPER("minecraft:waxed_oxidized_copper"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_COPPER_BARS("minecraft:waxed_oxidized_copper_bars"),
    //since 765(1.20.3)
    WAXED_OXIDIZED_COPPER_BULB("minecraft:waxed_oxidized_copper_bulb"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_COPPER_CHAIN("minecraft:waxed_oxidized_copper_chain"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_COPPER_CHEST("minecraft:waxed_oxidized_copper_chest"),
    //since 765(1.20.3)
    WAXED_OXIDIZED_COPPER_DOOR("minecraft:waxed_oxidized_copper_door"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_COPPER_GOLEM_STATUE("minecraft:waxed_oxidized_copper_golem_statue"),
    //since 765(1.20.3)
    WAXED_OXIDIZED_COPPER_GRATE("minecraft:waxed_oxidized_copper_grate"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_COPPER_LANTERN("minecraft:waxed_oxidized_copper_lantern"),
    //since 765(1.20.3)
    WAXED_OXIDIZED_COPPER_TRAPDOOR("minecraft:waxed_oxidized_copper_trapdoor"),
    //since 755(1.17)
    WAXED_OXIDIZED_CUT_COPPER("minecraft:waxed_oxidized_cut_copper"),
    //since 755(1.17)
    WAXED_OXIDIZED_CUT_COPPER_SLAB("minecraft:waxed_oxidized_cut_copper_slab"),
    //since 755(1.17)
    WAXED_OXIDIZED_CUT_COPPER_STAIRS("minecraft:waxed_oxidized_cut_copper_stairs"),
    //since 773(1.21.9)
    WAXED_OXIDIZED_LIGHTNING_ROD("minecraft:waxed_oxidized_lightning_rod"),
    //since 765(1.20.3)
    WAXED_WEATHERED_CHISELED_COPPER("minecraft:waxed_weathered_chiseled_copper"),
    //since 755(1.17)
    WAXED_WEATHERED_COPPER("minecraft:waxed_weathered_copper"),
    //since 773(1.21.9)
    WAXED_WEATHERED_COPPER_BARS("minecraft:waxed_weathered_copper_bars"),
    //since 765(1.20.3)
    WAXED_WEATHERED_COPPER_BULB("minecraft:waxed_weathered_copper_bulb"),
    //since 773(1.21.9)
    WAXED_WEATHERED_COPPER_CHAIN("minecraft:waxed_weathered_copper_chain"),
    //since 773(1.21.9)
    WAXED_WEATHERED_COPPER_CHEST("minecraft:waxed_weathered_copper_chest"),
    //since 765(1.20.3)
    WAXED_WEATHERED_COPPER_DOOR("minecraft:waxed_weathered_copper_door"),
    //since 773(1.21.9)
    WAXED_WEATHERED_COPPER_GOLEM_STATUE("minecraft:waxed_weathered_copper_golem_statue"),
    //since 765(1.20.3)
    WAXED_WEATHERED_COPPER_GRATE("minecraft:waxed_weathered_copper_grate"),
    //since 773(1.21.9)
    WAXED_WEATHERED_COPPER_LANTERN("minecraft:waxed_weathered_copper_lantern"),
    //since 765(1.20.3)
    WAXED_WEATHERED_COPPER_TRAPDOOR("minecraft:waxed_weathered_copper_trapdoor"),
    //since 755(1.17)
    WAXED_WEATHERED_CUT_COPPER("minecraft:waxed_weathered_cut_copper"),
    //since 755(1.17)
    WAXED_WEATHERED_CUT_COPPER_SLAB("minecraft:waxed_weathered_cut_copper_slab"),
    //since 755(1.17)
    WAXED_WEATHERED_CUT_COPPER_STAIRS("minecraft:waxed_weathered_cut_copper_stairs"),
    //since 773(1.21.9)
    WAXED_WEATHERED_LIGHTNING_ROD("minecraft:waxed_weathered_lightning_rod"),
    //since 765(1.20.3)
    WEATHERED_CHISELED_COPPER("minecraft:weathered_chiseled_copper"),
    //since 755(1.17)
    WEATHERED_COPPER("minecraft:weathered_copper"),
    //since 773(1.21.9)
    WEATHERED_COPPER_BARS("minecraft:weathered_copper_bars"),
    //since 765(1.20.3)
    WEATHERED_COPPER_BULB("minecraft:weathered_copper_bulb"),
    //since 773(1.21.9)
    WEATHERED_COPPER_CHAIN("minecraft:weathered_copper_chain"),
    //since 773(1.21.9)
    WEATHERED_COPPER_CHEST("minecraft:weathered_copper_chest"),
    //since 765(1.20.3)
    WEATHERED_COPPER_DOOR("minecraft:weathered_copper_door"),
    //since 773(1.21.9)
    WEATHERED_COPPER_GOLEM_STATUE("minecraft:weathered_copper_golem_statue"),
    //since 765(1.20.3)
    WEATHERED_COPPER_GRATE("minecraft:weathered_copper_grate"),
    //since 773(1.21.9)
    WEATHERED_COPPER_LANTERN("minecraft:weathered_copper_lantern"),
    //since 765(1.20.3)
    WEATHERED_COPPER_TRAPDOOR("minecraft:weathered_copper_trapdoor"),
    //since 755(1.17)
    WEATHERED_CUT_COPPER("minecraft:weathered_cut_copper"),
    //since 755(1.17)
    WEATHERED_CUT_COPPER_SLAB("minecraft:weathered_cut_copper_slab"),
    //since 755(1.17)
    WEATHERED_CUT_COPPER_STAIRS("minecraft:weathered_cut_copper_stairs"),
    //since 773(1.21.9)
    WEATHERED_LIGHTNING_ROD("minecraft:weathered_lightning_rod"),
    //since 754(1.16.5)
    WEEPING_VINES("minecraft:weeping_vines"),
    //since 754(1.16.5)
    WEEPING_VINES_PLANT("minecraft:weeping_vines_plant"),
    //since 754(1.16.5)
    WET_SPONGE("minecraft:wet_sponge"),
    //since 754(1.16.5)
    WHEAT("minecraft:wheat"),
    //since 754(1.16.5)
    WHITE_BANNER("minecraft:white_banner"),
    //since 754(1.16.5)
    WHITE_BED("minecraft:white_bed"),
    //since 755(1.17)
    WHITE_CANDLE("minecraft:white_candle"),
    //since 755(1.17)
    WHITE_CANDLE_CAKE("minecraft:white_candle_cake"),
    //since 754(1.16.5)
    WHITE_CARPET("minecraft:white_carpet"),
    //since 754(1.16.5)
    WHITE_CONCRETE("minecraft:white_concrete"),
    //since 754(1.16.5)
    WHITE_CONCRETE_POWDER("minecraft:white_concrete_powder"),
    //since 754(1.16.5)
    WHITE_GLAZED_TERRACOTTA("minecraft:white_glazed_terracotta"),
    //since 754(1.16.5)
    WHITE_SHULKER_BOX("minecraft:white_shulker_box"),
    //since 754(1.16.5)
    WHITE_STAINED_GLASS("minecraft:white_stained_glass"),
    //since 754(1.16.5)
    WHITE_STAINED_GLASS_PANE("minecraft:white_stained_glass_pane"),
    //since 754(1.16.5)
    WHITE_TERRACOTTA("minecraft:white_terracotta"),
    //since 754(1.16.5)
    WHITE_TULIP("minecraft:white_tulip"),
    //since 754(1.16.5)
    WHITE_WALL_BANNER("minecraft:white_wall_banner"),
    //since 754(1.16.5)
    WHITE_WOOL("minecraft:white_wool"),
    //since 770(1.21.5)
    WILDFLOWERS("minecraft:wildflowers"),
    //since 754(1.16.5)
    WITHER_ROSE("minecraft:wither_rose"),
    //since 754(1.16.5)
    WITHER_SKELETON_SKULL("minecraft:wither_skeleton_skull"),
    //since 754(1.16.5)
    WITHER_SKELETON_WALL_SKULL("minecraft:wither_skeleton_wall_skull"),
    //since 754(1.16.5)
    YELLOW_BANNER("minecraft:yellow_banner"),
    //since 754(1.16.5)
    YELLOW_BED("minecraft:yellow_bed"),
    //since 755(1.17)
    YELLOW_CANDLE("minecraft:yellow_candle"),
    //since 755(1.17)
    YELLOW_CANDLE_CAKE("minecraft:yellow_candle_cake"),
    //since 754(1.16.5)
    YELLOW_CARPET("minecraft:yellow_carpet"),
    //since 754(1.16.5)
    YELLOW_CONCRETE("minecraft:yellow_concrete"),
    //since 754(1.16.5)
    YELLOW_CONCRETE_POWDER("minecraft:yellow_concrete_powder"),
    //since 754(1.16.5)
    YELLOW_GLAZED_TERRACOTTA("minecraft:yellow_glazed_terracotta"),
    //since 754(1.16.5)
    YELLOW_SHULKER_BOX("minecraft:yellow_shulker_box"),
    //since 754(1.16.5)
    YELLOW_STAINED_GLASS("minecraft:yellow_stained_glass"),
    //since 754(1.16.5)
    YELLOW_STAINED_GLASS_PANE("minecraft:yellow_stained_glass_pane"),
    //since 754(1.16.5)
    YELLOW_TERRACOTTA("minecraft:yellow_terracotta"),
    //since 754(1.16.5)
    YELLOW_WALL_BANNER("minecraft:yellow_wall_banner"),
    //since 754(1.16.5)
    YELLOW_WOOL("minecraft:yellow_wool"),
    //since 754(1.16.5)
    ZOMBIE_HEAD("minecraft:zombie_head"),
    //since 754(1.16.5)
    ZOMBIE_WALL_HEAD("minecraft:zombie_wall_head"),
    ;
    public static final int SIZE = values().length;
    private static final Map<String, BlockType> BLOCK_MAP = new HashMap<>();

    private final String id;
    private final NamespacedKey key;

    BlockType(String id) {
        this.id = id;
        key = NamespacedKey.fromString(id);
    }

    public String id() {
        return id;
    }

    public static BlockType getById(String id) {
        return BLOCK_MAP.get(id);
    }

    public int getProtocolId(int version) {
        return Mappings.getBlockId(this, version);
    }

    static {
        for (BlockType blockType : values()) {
            BLOCK_MAP.put(blockType.id, blockType);
        }
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }
}
