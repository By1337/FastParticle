package dev.by1337.fparticle;

import dev.by1337.fparticle.via.Mappings;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ItemType implements Keyed {
    //since 754(1.16.5)
    ACACIA_BOAT("minecraft:acacia_boat"),
    //since 754(1.16.5)
    ACACIA_BUTTON("minecraft:acacia_button"),
    //since 759(1.19)
    ACACIA_CHEST_BOAT("minecraft:acacia_chest_boat"),
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
    //since 754(1.16.5)
    ACACIA_WOOD("minecraft:acacia_wood"),
    //since 754(1.16.5)
    ACTIVATOR_RAIL("minecraft:activator_rail"),
    //since 754(1.16.5)
    AIR("minecraft:air"),
    //since 759(1.19)
    ALLAY_SPAWN_EGG("minecraft:allay_spawn_egg"),
    //since 754(1.16.5)
    ALLIUM("minecraft:allium"),
    //since 755(1.17)
    AMETHYST_BLOCK("minecraft:amethyst_block"),
    //since 755(1.17)
    AMETHYST_CLUSTER("minecraft:amethyst_cluster"),
    //since 755(1.17)
    AMETHYST_SHARD("minecraft:amethyst_shard"),
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
    //since 763(1.20)
    ANGLER_POTTERY_SHERD("minecraft:angler_pottery_sherd"),
    //since 754(1.16.5)
    ANVIL("minecraft:anvil"),
    //since 754(1.16.5)
    APPLE("minecraft:apple"),
    //since 763(1.20)
    ARCHER_POTTERY_SHERD("minecraft:archer_pottery_sherd"),
    //since 766(1.20.5)
    ARMADILLO_SCUTE("minecraft:armadillo_scute"),
    //since 766(1.20.5)
    ARMADILLO_SPAWN_EGG("minecraft:armadillo_spawn_egg"),
    //since 754(1.16.5)
    ARMOR_STAND("minecraft:armor_stand"),
    //since 763(1.20)
    ARMS_UP_POTTERY_SHERD("minecraft:arms_up_pottery_sherd"),
    //since 754(1.16.5)
    ARROW("minecraft:arrow"),
    //since 755(1.17)
    AXOLOTL_BUCKET("minecraft:axolotl_bucket"),
    //since 755(1.17)
    AXOLOTL_SPAWN_EGG("minecraft:axolotl_spawn_egg"),
    //since 755(1.17)
    AZALEA("minecraft:azalea"),
    //since 755(1.17)
    AZALEA_LEAVES("minecraft:azalea_leaves"),
    //since 754(1.16.5)
    AZURE_BLUET("minecraft:azure_bluet"),
    //since 754(1.16.5)
    BAKED_POTATO("minecraft:baked_potato"),
    //since 754(1.16.5)
    BAMBOO("minecraft:bamboo"),
    //since 761(1.19.3)
    BAMBOO_BLOCK("minecraft:bamboo_block"),
    //since 761(1.19.3)
    BAMBOO_BUTTON("minecraft:bamboo_button"),
    //since 761(1.19.3)
    BAMBOO_CHEST_RAFT("minecraft:bamboo_chest_raft"),
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
    //since 761(1.19.3)
    BAMBOO_RAFT("minecraft:bamboo_raft"),
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
    //since 754(1.16.5)
    BARREL("minecraft:barrel"),
    //since 754(1.16.5)
    BARRIER("minecraft:barrier"),
    //since 754(1.16.5)
    BASALT("minecraft:basalt"),
    //since 754(1.16.5)
    BAT_SPAWN_EGG("minecraft:bat_spawn_egg"),
    //since 754(1.16.5)
    BEACON("minecraft:beacon"),
    //since 754(1.16.5)
    BEDROCK("minecraft:bedrock"),
    //since 754(1.16.5)
    BEE_NEST("minecraft:bee_nest"),
    //since 754(1.16.5)
    BEE_SPAWN_EGG("minecraft:bee_spawn_egg"),
    //since 754(1.16.5)
    BEEF("minecraft:beef"),
    //since 754(1.16.5)
    BEEHIVE("minecraft:beehive"),
    //since 754(1.16.5)
    BEETROOT("minecraft:beetroot"),
    //since 754(1.16.5)
    BEETROOT_SEEDS("minecraft:beetroot_seeds"),
    //since 754(1.16.5)
    BEETROOT_SOUP("minecraft:beetroot_soup"),
    //since 754(1.16.5)
    BELL("minecraft:bell"),
    //since 755(1.17)
    BIG_DRIPLEAF("minecraft:big_dripleaf"),
    //since 754(1.16.5)
    BIRCH_BOAT("minecraft:birch_boat"),
    //since 754(1.16.5)
    BIRCH_BUTTON("minecraft:birch_button"),
    //since 759(1.19)
    BIRCH_CHEST_BOAT("minecraft:birch_chest_boat"),
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
    //since 754(1.16.5)
    BIRCH_WOOD("minecraft:birch_wood"),
    //since 754(1.16.5)
    BLACK_BANNER("minecraft:black_banner"),
    //since 754(1.16.5)
    BLACK_BED("minecraft:black_bed"),
    //since 768(1.21.2)
    BLACK_BUNDLE("minecraft:black_bundle"),
    //since 755(1.17)
    BLACK_CANDLE("minecraft:black_candle"),
    //since 754(1.16.5)
    BLACK_CARPET("minecraft:black_carpet"),
    //since 754(1.16.5)
    BLACK_CONCRETE("minecraft:black_concrete"),
    //since 754(1.16.5)
    BLACK_CONCRETE_POWDER("minecraft:black_concrete_powder"),
    //since 754(1.16.5)
    BLACK_DYE("minecraft:black_dye"),
    //since 754(1.16.5)
    BLACK_GLAZED_TERRACOTTA("minecraft:black_glazed_terracotta"),
    //since 771(1.21.6)
    BLACK_HARNESS("minecraft:black_harness"),
    //since 754(1.16.5)
    BLACK_SHULKER_BOX("minecraft:black_shulker_box"),
    //since 754(1.16.5)
    BLACK_STAINED_GLASS("minecraft:black_stained_glass"),
    //since 754(1.16.5)
    BLACK_STAINED_GLASS_PANE("minecraft:black_stained_glass_pane"),
    //since 754(1.16.5)
    BLACK_TERRACOTTA("minecraft:black_terracotta"),
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
    //since 763(1.20)
    BLADE_POTTERY_SHERD("minecraft:blade_pottery_sherd"),
    //since 754(1.16.5)
    BLAST_FURNACE("minecraft:blast_furnace"),
    //since 754(1.16.5)
    BLAZE_POWDER("minecraft:blaze_powder"),
    //since 754(1.16.5)
    BLAZE_ROD("minecraft:blaze_rod"),
    //since 754(1.16.5)
    BLAZE_SPAWN_EGG("minecraft:blaze_spawn_egg"),
    //since 754(1.16.5)
    BLUE_BANNER("minecraft:blue_banner"),
    //since 754(1.16.5)
    BLUE_BED("minecraft:blue_bed"),
    //since 768(1.21.2)
    BLUE_BUNDLE("minecraft:blue_bundle"),
    //since 755(1.17)
    BLUE_CANDLE("minecraft:blue_candle"),
    //since 754(1.16.5)
    BLUE_CARPET("minecraft:blue_carpet"),
    //since 754(1.16.5)
    BLUE_CONCRETE("minecraft:blue_concrete"),
    //since 754(1.16.5)
    BLUE_CONCRETE_POWDER("minecraft:blue_concrete_powder"),
    //since 754(1.16.5)
    BLUE_DYE("minecraft:blue_dye"),
    //since 770(1.21.5)
    BLUE_EGG("minecraft:blue_egg"),
    //since 754(1.16.5)
    BLUE_GLAZED_TERRACOTTA("minecraft:blue_glazed_terracotta"),
    //since 771(1.21.6)
    BLUE_HARNESS("minecraft:blue_harness"),
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
    BLUE_WOOL("minecraft:blue_wool"),
    //since 766(1.20.5)
    BOGGED_SPAWN_EGG("minecraft:bogged_spawn_egg"),
    //since 766(1.20.5)
    BOLT_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:bolt_armor_trim_smithing_template"),
    //since 754(1.16.5)
    BONE("minecraft:bone"),
    //since 754(1.16.5)
    BONE_BLOCK("minecraft:bone_block"),
    //since 754(1.16.5)
    BONE_MEAL("minecraft:bone_meal"),
    //since 754(1.16.5)
    BOOK("minecraft:book"),
    //since 754(1.16.5)
    BOOKSHELF("minecraft:bookshelf"),
    //since 768(1.21.2)
    BORDURE_INDENTED_BANNER_PATTERN("minecraft:bordure_indented_banner_pattern"),
    //since 754(1.16.5)
    BOW("minecraft:bow"),
    //since 754(1.16.5)
    BOWL("minecraft:bowl"),
    //since 754(1.16.5)
    BRAIN_CORAL("minecraft:brain_coral"),
    //since 754(1.16.5)
    BRAIN_CORAL_BLOCK("minecraft:brain_coral_block"),
    //since 754(1.16.5)
    BRAIN_CORAL_FAN("minecraft:brain_coral_fan"),
    //since 754(1.16.5)
    BREAD("minecraft:bread"),
    //since 766(1.20.5)
    BREEZE_ROD("minecraft:breeze_rod"),
    //since 765(1.20.3)
    BREEZE_SPAWN_EGG("minecraft:breeze_spawn_egg"),
    //since 763(1.20)
    BREWER_POTTERY_SHERD("minecraft:brewer_pottery_sherd"),
    //since 754(1.16.5)
    BREWING_STAND("minecraft:brewing_stand"),
    //since 754(1.16.5)
    BRICK("minecraft:brick"),
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
    //since 768(1.21.2)
    BROWN_BUNDLE("minecraft:brown_bundle"),
    //since 755(1.17)
    BROWN_CANDLE("minecraft:brown_candle"),
    //since 754(1.16.5)
    BROWN_CARPET("minecraft:brown_carpet"),
    //since 754(1.16.5)
    BROWN_CONCRETE("minecraft:brown_concrete"),
    //since 754(1.16.5)
    BROWN_CONCRETE_POWDER("minecraft:brown_concrete_powder"),
    //since 754(1.16.5)
    BROWN_DYE("minecraft:brown_dye"),
    //since 770(1.21.5)
    BROWN_EGG("minecraft:brown_egg"),
    //since 754(1.16.5)
    BROWN_GLAZED_TERRACOTTA("minecraft:brown_glazed_terracotta"),
    //since 771(1.21.6)
    BROWN_HARNESS("minecraft:brown_harness"),
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
    BROWN_WOOL("minecraft:brown_wool"),
    //since 762(1.19.4)
    BRUSH("minecraft:brush"),
    //since 754(1.16.5)
    BUBBLE_CORAL("minecraft:bubble_coral"),
    //since 754(1.16.5)
    BUBBLE_CORAL_BLOCK("minecraft:bubble_coral_block"),
    //since 754(1.16.5)
    BUBBLE_CORAL_FAN("minecraft:bubble_coral_fan"),
    //since 754(1.16.5)
    BUCKET("minecraft:bucket"),
    //since 755(1.17)
    BUDDING_AMETHYST("minecraft:budding_amethyst"),
    //since 755(1.17)
    BUNDLE("minecraft:bundle"),
    //since 763(1.20)
    BURN_POTTERY_SHERD("minecraft:burn_pottery_sherd"),
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
    //since 761(1.19.3)
    CAMEL_SPAWN_EGG("minecraft:camel_spawn_egg"),
    //since 754(1.16.5)
    CAMPFIRE("minecraft:campfire"),
    //since 755(1.17)
    CANDLE("minecraft:candle"),
    //since 754(1.16.5)
    CARROT("minecraft:carrot"),
    //since 754(1.16.5)
    CARROT_ON_A_STICK("minecraft:carrot_on_a_stick"),
    //since 754(1.16.5)
    CARTOGRAPHY_TABLE("minecraft:cartography_table"),
    //since 754(1.16.5)
    CARVED_PUMPKIN("minecraft:carved_pumpkin"),
    //since 754(1.16.5)
    CAT_SPAWN_EGG("minecraft:cat_spawn_egg"),
    //since 754(1.16.5)
    CAULDRON("minecraft:cauldron"),
    //since 754(1.16.5)
    CAVE_SPIDER_SPAWN_EGG("minecraft:cave_spider_spawn_egg"),
    //since 754(1.16.5)
    @Deprecated
    CHAIN("minecraft:chain"),
    //since 754(1.16.5)
    CHAIN_COMMAND_BLOCK("minecraft:chain_command_block"),
    //since 754(1.16.5)
    CHAINMAIL_BOOTS("minecraft:chainmail_boots"),
    //since 754(1.16.5)
    CHAINMAIL_CHESTPLATE("minecraft:chainmail_chestplate"),
    //since 754(1.16.5)
    CHAINMAIL_HELMET("minecraft:chainmail_helmet"),
    //since 754(1.16.5)
    CHAINMAIL_LEGGINGS("minecraft:chainmail_leggings"),
    //since 754(1.16.5)
    CHARCOAL("minecraft:charcoal"),
    //since 762(1.19.4)
    CHERRY_BOAT("minecraft:cherry_boat"),
    //since 762(1.19.4)
    CHERRY_BUTTON("minecraft:cherry_button"),
    //since 762(1.19.4)
    CHERRY_CHEST_BOAT("minecraft:cherry_chest_boat"),
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
    CHERRY_WOOD("minecraft:cherry_wood"),
    //since 754(1.16.5)
    CHEST("minecraft:chest"),
    //since 754(1.16.5)
    CHEST_MINECART("minecraft:chest_minecart"),
    //since 754(1.16.5)
    CHICKEN("minecraft:chicken"),
    //since 754(1.16.5)
    CHICKEN_SPAWN_EGG("minecraft:chicken_spawn_egg"),
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
    CHORUS_FRUIT("minecraft:chorus_fruit"),
    //since 754(1.16.5)
    CHORUS_PLANT("minecraft:chorus_plant"),
    //since 754(1.16.5)
    CLAY("minecraft:clay"),
    //since 754(1.16.5)
    CLAY_BALL("minecraft:clay_ball"),
    //since 754(1.16.5)
    CLOCK("minecraft:clock"),
    //since 769(1.21.4)
    CLOSED_EYEBLOSSOM("minecraft:closed_eyeblossom"),
    //since 754(1.16.5)
    COAL("minecraft:coal"),
    //since 754(1.16.5)
    COAL_BLOCK("minecraft:coal_block"),
    //since 754(1.16.5)
    COAL_ORE("minecraft:coal_ore"),
    //since 754(1.16.5)
    COARSE_DIRT("minecraft:coarse_dirt"),
    //since 762(1.19.4)
    COAST_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:coast_armor_trim_smithing_template"),
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
    COCOA_BEANS("minecraft:cocoa_beans"),
    //since 754(1.16.5)
    COD("minecraft:cod"),
    //since 754(1.16.5)
    COD_BUCKET("minecraft:cod_bucket"),
    //since 754(1.16.5)
    COD_SPAWN_EGG("minecraft:cod_spawn_egg"),
    //since 754(1.16.5)
    COMMAND_BLOCK("minecraft:command_block"),
    //since 754(1.16.5)
    COMMAND_BLOCK_MINECART("minecraft:command_block_minecart"),
    //since 754(1.16.5)
    COMPARATOR("minecraft:comparator"),
    //since 754(1.16.5)
    COMPASS("minecraft:compass"),
    //since 754(1.16.5)
    COMPOSTER("minecraft:composter"),
    //since 754(1.16.5)
    CONDUIT("minecraft:conduit"),
    //since 754(1.16.5)
    COOKED_BEEF("minecraft:cooked_beef"),
    //since 754(1.16.5)
    COOKED_CHICKEN("minecraft:cooked_chicken"),
    //since 754(1.16.5)
    COOKED_COD("minecraft:cooked_cod"),
    //since 754(1.16.5)
    COOKED_MUTTON("minecraft:cooked_mutton"),
    //since 754(1.16.5)
    COOKED_PORKCHOP("minecraft:cooked_porkchop"),
    //since 754(1.16.5)
    COOKED_RABBIT("minecraft:cooked_rabbit"),
    //since 754(1.16.5)
    COOKED_SALMON("minecraft:cooked_salmon"),
    //since 754(1.16.5)
    COOKIE("minecraft:cookie"),
    //since 773(1.21.9)
    COPPER_AXE("minecraft:copper_axe"),
    //since 773(1.21.9)
    COPPER_BARS("minecraft:copper_bars"),
    //since 755(1.17)
    COPPER_BLOCK("minecraft:copper_block"),
    //since 773(1.21.9)
    COPPER_BOOTS("minecraft:copper_boots"),
    //since 765(1.20.3)
    COPPER_BULB("minecraft:copper_bulb"),
    //since 773(1.21.9)
    COPPER_CHAIN("minecraft:copper_chain"),
    //since 773(1.21.9)
    COPPER_CHEST("minecraft:copper_chest"),
    //since 773(1.21.9)
    COPPER_CHESTPLATE("minecraft:copper_chestplate"),
    //since 765(1.20.3)
    COPPER_DOOR("minecraft:copper_door"),
    //since 773(1.21.9)
    COPPER_GOLEM_SPAWN_EGG("minecraft:copper_golem_spawn_egg"),
    //since 773(1.21.9)
    COPPER_GOLEM_STATUE("minecraft:copper_golem_statue"),
    //since 765(1.20.3)
    COPPER_GRATE("minecraft:copper_grate"),
    //since 773(1.21.9)
    COPPER_HELMET("minecraft:copper_helmet"),
    //since 773(1.21.9)
    COPPER_HOE("minecraft:copper_hoe"),
    //since 773(1.21.9)
    COPPER_HORSE_ARMOR("minecraft:copper_horse_armor"),
    //since 755(1.17)
    COPPER_INGOT("minecraft:copper_ingot"),
    //since 773(1.21.9)
    COPPER_LANTERN("minecraft:copper_lantern"),
    //since 773(1.21.9)
    COPPER_LEGGINGS("minecraft:copper_leggings"),
    //since 773(1.21.9)
    COPPER_NUGGET("minecraft:copper_nugget"),
    //since 755(1.17)
    COPPER_ORE("minecraft:copper_ore"),
    //since 773(1.21.9)
    COPPER_PICKAXE("minecraft:copper_pickaxe"),
    //since 773(1.21.9)
    COPPER_SHOVEL("minecraft:copper_shovel"),
    //since 773(1.21.9)
    COPPER_SWORD("minecraft:copper_sword"),
    //since 773(1.21.9)
    COPPER_TORCH("minecraft:copper_torch"),
    //since 765(1.20.3)
    COPPER_TRAPDOOR("minecraft:copper_trapdoor"),
    //since 754(1.16.5)
    CORNFLOWER("minecraft:cornflower"),
    //since 754(1.16.5)
    COW_SPAWN_EGG("minecraft:cow_spawn_egg"),
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
    //since 768(1.21.2)
    CREAKING_SPAWN_EGG("minecraft:creaking_spawn_egg"),
    //since 754(1.16.5)
    CREEPER_BANNER_PATTERN("minecraft:creeper_banner_pattern"),
    //since 754(1.16.5)
    CREEPER_HEAD("minecraft:creeper_head"),
    //since 754(1.16.5)
    CREEPER_SPAWN_EGG("minecraft:creeper_spawn_egg"),
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
    //since 754(1.16.5)
    CROSSBOW("minecraft:crossbow"),
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
    //since 768(1.21.2)
    CYAN_BUNDLE("minecraft:cyan_bundle"),
    //since 755(1.17)
    CYAN_CANDLE("minecraft:cyan_candle"),
    //since 754(1.16.5)
    CYAN_CARPET("minecraft:cyan_carpet"),
    //since 754(1.16.5)
    CYAN_CONCRETE("minecraft:cyan_concrete"),
    //since 754(1.16.5)
    CYAN_CONCRETE_POWDER("minecraft:cyan_concrete_powder"),
    //since 754(1.16.5)
    CYAN_DYE("minecraft:cyan_dye"),
    //since 754(1.16.5)
    CYAN_GLAZED_TERRACOTTA("minecraft:cyan_glazed_terracotta"),
    //since 771(1.21.6)
    CYAN_HARNESS("minecraft:cyan_harness"),
    //since 754(1.16.5)
    CYAN_SHULKER_BOX("minecraft:cyan_shulker_box"),
    //since 754(1.16.5)
    CYAN_STAINED_GLASS("minecraft:cyan_stained_glass"),
    //since 754(1.16.5)
    CYAN_STAINED_GLASS_PANE("minecraft:cyan_stained_glass_pane"),
    //since 754(1.16.5)
    CYAN_TERRACOTTA("minecraft:cyan_terracotta"),
    //since 754(1.16.5)
    CYAN_WOOL("minecraft:cyan_wool"),
    //since 754(1.16.5)
    DAMAGED_ANVIL("minecraft:damaged_anvil"),
    //since 754(1.16.5)
    DANDELION("minecraft:dandelion"),
    //since 763(1.20)
    DANGER_POTTERY_SHERD("minecraft:danger_pottery_sherd"),
    //since 754(1.16.5)
    DARK_OAK_BOAT("minecraft:dark_oak_boat"),
    //since 754(1.16.5)
    DARK_OAK_BUTTON("minecraft:dark_oak_button"),
    //since 759(1.19)
    DARK_OAK_CHEST_BOAT("minecraft:dark_oak_chest_boat"),
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
    DEAD_BUBBLE_CORAL("minecraft:dead_bubble_coral"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL_BLOCK("minecraft:dead_bubble_coral_block"),
    //since 754(1.16.5)
    DEAD_BUBBLE_CORAL_FAN("minecraft:dead_bubble_coral_fan"),
    //since 754(1.16.5)
    DEAD_BUSH("minecraft:dead_bush"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL("minecraft:dead_fire_coral"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL_BLOCK("minecraft:dead_fire_coral_block"),
    //since 754(1.16.5)
    DEAD_FIRE_CORAL_FAN("minecraft:dead_fire_coral_fan"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL("minecraft:dead_horn_coral"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL_BLOCK("minecraft:dead_horn_coral_block"),
    //since 754(1.16.5)
    DEAD_HORN_CORAL_FAN("minecraft:dead_horn_coral_fan"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL("minecraft:dead_tube_coral"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL_BLOCK("minecraft:dead_tube_coral_block"),
    //since 754(1.16.5)
    DEAD_TUBE_CORAL_FAN("minecraft:dead_tube_coral_fan"),
    //since 754(1.16.5)
    DEBUG_STICK("minecraft:debug_stick"),
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
    DIAMOND("minecraft:diamond"),
    //since 754(1.16.5)
    DIAMOND_AXE("minecraft:diamond_axe"),
    //since 754(1.16.5)
    DIAMOND_BLOCK("minecraft:diamond_block"),
    //since 754(1.16.5)
    DIAMOND_BOOTS("minecraft:diamond_boots"),
    //since 754(1.16.5)
    DIAMOND_CHESTPLATE("minecraft:diamond_chestplate"),
    //since 754(1.16.5)
    DIAMOND_HELMET("minecraft:diamond_helmet"),
    //since 754(1.16.5)
    DIAMOND_HOE("minecraft:diamond_hoe"),
    //since 754(1.16.5)
    DIAMOND_HORSE_ARMOR("minecraft:diamond_horse_armor"),
    //since 754(1.16.5)
    DIAMOND_LEGGINGS("minecraft:diamond_leggings"),
    //since 754(1.16.5)
    DIAMOND_ORE("minecraft:diamond_ore"),
    //since 754(1.16.5)
    DIAMOND_PICKAXE("minecraft:diamond_pickaxe"),
    //since 754(1.16.5)
    DIAMOND_SHOVEL("minecraft:diamond_shovel"),
    //since 754(1.16.5)
    DIAMOND_SWORD("minecraft:diamond_sword"),
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
    //since 759(1.19)
    DISC_FRAGMENT_5("minecraft:disc_fragment_5"),
    //since 754(1.16.5)
    DISPENSER("minecraft:dispenser"),
    //since 754(1.16.5)
    DOLPHIN_SPAWN_EGG("minecraft:dolphin_spawn_egg"),
    //since 754(1.16.5)
    DONKEY_SPAWN_EGG("minecraft:donkey_spawn_egg"),
    //since 754(1.16.5)
    DRAGON_BREATH("minecraft:dragon_breath"),
    //since 754(1.16.5)
    DRAGON_EGG("minecraft:dragon_egg"),
    //since 754(1.16.5)
    DRAGON_HEAD("minecraft:dragon_head"),
    //since 771(1.21.6)
    DRIED_GHAST("minecraft:dried_ghast"),
    //since 754(1.16.5)
    DRIED_KELP("minecraft:dried_kelp"),
    //since 754(1.16.5)
    DRIED_KELP_BLOCK("minecraft:dried_kelp_block"),
    //since 755(1.17)
    DRIPSTONE_BLOCK("minecraft:dripstone_block"),
    //since 754(1.16.5)
    DROPPER("minecraft:dropper"),
    //since 754(1.16.5)
    DROWNED_SPAWN_EGG("minecraft:drowned_spawn_egg"),
    //since 762(1.19.4)
    DUNE_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:dune_armor_trim_smithing_template"),
    //since 759(1.19)
    ECHO_SHARD("minecraft:echo_shard"),
    //since 754(1.16.5)
    EGG("minecraft:egg"),
    //since 754(1.16.5)
    ELDER_GUARDIAN_SPAWN_EGG("minecraft:elder_guardian_spawn_egg"),
    //since 754(1.16.5)
    ELYTRA("minecraft:elytra"),
    //since 754(1.16.5)
    EMERALD("minecraft:emerald"),
    //since 754(1.16.5)
    EMERALD_BLOCK("minecraft:emerald_block"),
    //since 754(1.16.5)
    EMERALD_ORE("minecraft:emerald_ore"),
    //since 754(1.16.5)
    ENCHANTED_BOOK("minecraft:enchanted_book"),
    //since 754(1.16.5)
    ENCHANTED_GOLDEN_APPLE("minecraft:enchanted_golden_apple"),
    //since 754(1.16.5)
    ENCHANTING_TABLE("minecraft:enchanting_table"),
    //since 754(1.16.5)
    END_CRYSTAL("minecraft:end_crystal"),
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
    //since 761(1.19.3)
    ENDER_DRAGON_SPAWN_EGG("minecraft:ender_dragon_spawn_egg"),
    //since 754(1.16.5)
    ENDER_EYE("minecraft:ender_eye"),
    //since 754(1.16.5)
    ENDER_PEARL("minecraft:ender_pearl"),
    //since 754(1.16.5)
    ENDERMAN_SPAWN_EGG("minecraft:enderman_spawn_egg"),
    //since 754(1.16.5)
    ENDERMITE_SPAWN_EGG("minecraft:endermite_spawn_egg"),
    //since 754(1.16.5)
    EVOKER_SPAWN_EGG("minecraft:evoker_spawn_egg"),
    //since 754(1.16.5)
    EXPERIENCE_BOTTLE("minecraft:experience_bottle"),
    //since 763(1.20)
    EXPLORER_POTTERY_SHERD("minecraft:explorer_pottery_sherd"),
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
    //since 762(1.19.4)
    EYE_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:eye_armor_trim_smithing_template"),
    //since 754(1.16.5)
    FARMLAND("minecraft:farmland"),
    //since 754(1.16.5)
    FEATHER("minecraft:feather"),
    //since 754(1.16.5)
    FERMENTED_SPIDER_EYE("minecraft:fermented_spider_eye"),
    //since 754(1.16.5)
    FERN("minecraft:fern"),
    //since 768(1.21.2)
    FIELD_MASONED_BANNER_PATTERN("minecraft:field_masoned_banner_pattern"),
    //since 754(1.16.5)
    FILLED_MAP("minecraft:filled_map"),
    //since 754(1.16.5)
    FIRE_CHARGE("minecraft:fire_charge"),
    //since 754(1.16.5)
    FIRE_CORAL("minecraft:fire_coral"),
    //since 754(1.16.5)
    FIRE_CORAL_BLOCK("minecraft:fire_coral_block"),
    //since 754(1.16.5)
    FIRE_CORAL_FAN("minecraft:fire_coral_fan"),
    //since 770(1.21.5)
    FIREFLY_BUSH("minecraft:firefly_bush"),
    //since 754(1.16.5)
    FIREWORK_ROCKET("minecraft:firework_rocket"),
    //since 754(1.16.5)
    FIREWORK_STAR("minecraft:firework_star"),
    //since 754(1.16.5)
    FISHING_ROD("minecraft:fishing_rod"),
    //since 754(1.16.5)
    FLETCHING_TABLE("minecraft:fletching_table"),
    //since 754(1.16.5)
    FLINT("minecraft:flint"),
    //since 754(1.16.5)
    FLINT_AND_STEEL("minecraft:flint_and_steel"),
    //since 766(1.20.5)
    FLOW_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:flow_armor_trim_smithing_template"),
    //since 766(1.20.5)
    FLOW_BANNER_PATTERN("minecraft:flow_banner_pattern"),
    //since 766(1.20.5)
    FLOW_POTTERY_SHERD("minecraft:flow_pottery_sherd"),
    //since 754(1.16.5)
    FLOWER_BANNER_PATTERN("minecraft:flower_banner_pattern"),
    //since 754(1.16.5)
    FLOWER_POT("minecraft:flower_pot"),
    //since 755(1.17)
    FLOWERING_AZALEA("minecraft:flowering_azalea"),
    //since 755(1.17)
    FLOWERING_AZALEA_LEAVES("minecraft:flowering_azalea_leaves"),
    //since 754(1.16.5)
    FOX_SPAWN_EGG("minecraft:fox_spawn_egg"),
    //since 763(1.20)
    FRIEND_POTTERY_SHERD("minecraft:friend_pottery_sherd"),
    //since 759(1.19)
    FROG_SPAWN_EGG("minecraft:frog_spawn_egg"),
    //since 759(1.19)
    FROGSPAWN("minecraft:frogspawn"),
    //since 754(1.16.5)
    FURNACE("minecraft:furnace"),
    //since 754(1.16.5)
    FURNACE_MINECART("minecraft:furnace_minecart"),
    //since 754(1.16.5)
    GHAST_SPAWN_EGG("minecraft:ghast_spawn_egg"),
    //since 754(1.16.5)
    GHAST_TEAR("minecraft:ghast_tear"),
    //since 754(1.16.5)
    GILDED_BLACKSTONE("minecraft:gilded_blackstone"),
    //since 754(1.16.5)
    GLASS("minecraft:glass"),
    //since 754(1.16.5)
    GLASS_BOTTLE("minecraft:glass_bottle"),
    //since 754(1.16.5)
    GLASS_PANE("minecraft:glass_pane"),
    //since 754(1.16.5)
    GLISTERING_MELON_SLICE("minecraft:glistering_melon_slice"),
    //since 754(1.16.5)
    GLOBE_BANNER_PATTERN("minecraft:globe_banner_pattern"),
    //since 755(1.17)
    GLOW_BERRIES("minecraft:glow_berries"),
    //since 755(1.17)
    GLOW_INK_SAC("minecraft:glow_ink_sac"),
    //since 755(1.17)
    GLOW_ITEM_FRAME("minecraft:glow_item_frame"),
    //since 755(1.17)
    GLOW_LICHEN("minecraft:glow_lichen"),
    //since 755(1.17)
    GLOW_SQUID_SPAWN_EGG("minecraft:glow_squid_spawn_egg"),
    //since 754(1.16.5)
    GLOWSTONE("minecraft:glowstone"),
    //since 754(1.16.5)
    GLOWSTONE_DUST("minecraft:glowstone_dust"),
    //since 759(1.19)
    GOAT_HORN("minecraft:goat_horn"),
    //since 755(1.17)
    GOAT_SPAWN_EGG("minecraft:goat_spawn_egg"),
    //since 754(1.16.5)
    GOLD_BLOCK("minecraft:gold_block"),
    //since 754(1.16.5)
    GOLD_INGOT("minecraft:gold_ingot"),
    //since 754(1.16.5)
    GOLD_NUGGET("minecraft:gold_nugget"),
    //since 754(1.16.5)
    GOLD_ORE("minecraft:gold_ore"),
    //since 754(1.16.5)
    GOLDEN_APPLE("minecraft:golden_apple"),
    //since 754(1.16.5)
    GOLDEN_AXE("minecraft:golden_axe"),
    //since 754(1.16.5)
    GOLDEN_BOOTS("minecraft:golden_boots"),
    //since 754(1.16.5)
    GOLDEN_CARROT("minecraft:golden_carrot"),
    //since 754(1.16.5)
    GOLDEN_CHESTPLATE("minecraft:golden_chestplate"),
    //since 754(1.16.5)
    GOLDEN_HELMET("minecraft:golden_helmet"),
    //since 754(1.16.5)
    GOLDEN_HOE("minecraft:golden_hoe"),
    //since 754(1.16.5)
    GOLDEN_HORSE_ARMOR("minecraft:golden_horse_armor"),
    //since 754(1.16.5)
    GOLDEN_LEGGINGS("minecraft:golden_leggings"),
    //since 754(1.16.5)
    GOLDEN_PICKAXE("minecraft:golden_pickaxe"),
    //since 754(1.16.5)
    GOLDEN_SHOVEL("minecraft:golden_shovel"),
    //since 754(1.16.5)
    GOLDEN_SWORD("minecraft:golden_sword"),
    //since 754(1.16.5)
    GRANITE("minecraft:granite"),
    //since 754(1.16.5)
    GRANITE_SLAB("minecraft:granite_slab"),
    //since 754(1.16.5)
    GRANITE_STAIRS("minecraft:granite_stairs"),
    //since 754(1.16.5)
    GRANITE_WALL("minecraft:granite_wall"),
    //since 754(1.16.5)
    @Deprecated
    GRASS("minecraft:grass"),
    //since 754(1.16.5)
    GRASS_BLOCK("minecraft:grass_block"),
    //since 754(1.16.5)
    @Deprecated
    GRASS_PATH("minecraft:grass_path"),
    //since 754(1.16.5)
    GRAVEL("minecraft:gravel"),
    //since 754(1.16.5)
    GRAY_BANNER("minecraft:gray_banner"),
    //since 754(1.16.5)
    GRAY_BED("minecraft:gray_bed"),
    //since 768(1.21.2)
    GRAY_BUNDLE("minecraft:gray_bundle"),
    //since 755(1.17)
    GRAY_CANDLE("minecraft:gray_candle"),
    //since 754(1.16.5)
    GRAY_CARPET("minecraft:gray_carpet"),
    //since 754(1.16.5)
    GRAY_CONCRETE("minecraft:gray_concrete"),
    //since 754(1.16.5)
    GRAY_CONCRETE_POWDER("minecraft:gray_concrete_powder"),
    //since 754(1.16.5)
    GRAY_DYE("minecraft:gray_dye"),
    //since 754(1.16.5)
    GRAY_GLAZED_TERRACOTTA("minecraft:gray_glazed_terracotta"),
    //since 771(1.21.6)
    GRAY_HARNESS("minecraft:gray_harness"),
    //since 754(1.16.5)
    GRAY_SHULKER_BOX("minecraft:gray_shulker_box"),
    //since 754(1.16.5)
    GRAY_STAINED_GLASS("minecraft:gray_stained_glass"),
    //since 754(1.16.5)
    GRAY_STAINED_GLASS_PANE("minecraft:gray_stained_glass_pane"),
    //since 754(1.16.5)
    GRAY_TERRACOTTA("minecraft:gray_terracotta"),
    //since 754(1.16.5)
    GRAY_WOOL("minecraft:gray_wool"),
    //since 754(1.16.5)
    GREEN_BANNER("minecraft:green_banner"),
    //since 754(1.16.5)
    GREEN_BED("minecraft:green_bed"),
    //since 768(1.21.2)
    GREEN_BUNDLE("minecraft:green_bundle"),
    //since 755(1.17)
    GREEN_CANDLE("minecraft:green_candle"),
    //since 754(1.16.5)
    GREEN_CARPET("minecraft:green_carpet"),
    //since 754(1.16.5)
    GREEN_CONCRETE("minecraft:green_concrete"),
    //since 754(1.16.5)
    GREEN_CONCRETE_POWDER("minecraft:green_concrete_powder"),
    //since 754(1.16.5)
    GREEN_DYE("minecraft:green_dye"),
    //since 754(1.16.5)
    GREEN_GLAZED_TERRACOTTA("minecraft:green_glazed_terracotta"),
    //since 771(1.21.6)
    GREEN_HARNESS("minecraft:green_harness"),
    //since 754(1.16.5)
    GREEN_SHULKER_BOX("minecraft:green_shulker_box"),
    //since 754(1.16.5)
    GREEN_STAINED_GLASS("minecraft:green_stained_glass"),
    //since 754(1.16.5)
    GREEN_STAINED_GLASS_PANE("minecraft:green_stained_glass_pane"),
    //since 754(1.16.5)
    GREEN_TERRACOTTA("minecraft:green_terracotta"),
    //since 754(1.16.5)
    GREEN_WOOL("minecraft:green_wool"),
    //since 754(1.16.5)
    GRINDSTONE("minecraft:grindstone"),
    //since 754(1.16.5)
    GUARDIAN_SPAWN_EGG("minecraft:guardian_spawn_egg"),
    //since 754(1.16.5)
    GUNPOWDER("minecraft:gunpowder"),
    //since 766(1.20.5)
    GUSTER_BANNER_PATTERN("minecraft:guster_banner_pattern"),
    //since 766(1.20.5)
    GUSTER_POTTERY_SHERD("minecraft:guster_pottery_sherd"),
    //since 755(1.17)
    HANGING_ROOTS("minecraft:hanging_roots"),
    //since 771(1.21.6)
    HAPPY_GHAST_SPAWN_EGG("minecraft:happy_ghast_spawn_egg"),
    //since 754(1.16.5)
    HAY_BLOCK("minecraft:hay_block"),
    //since 754(1.16.5)
    HEART_OF_THE_SEA("minecraft:heart_of_the_sea"),
    //since 763(1.20)
    HEART_POTTERY_SHERD("minecraft:heart_pottery_sherd"),
    //since 763(1.20)
    HEARTBREAK_POTTERY_SHERD("minecraft:heartbreak_pottery_sherd"),
    //since 766(1.20.5)
    HEAVY_CORE("minecraft:heavy_core"),
    //since 754(1.16.5)
    HEAVY_WEIGHTED_PRESSURE_PLATE("minecraft:heavy_weighted_pressure_plate"),
    //since 754(1.16.5)
    HOGLIN_SPAWN_EGG("minecraft:hoglin_spawn_egg"),
    //since 754(1.16.5)
    HONEY_BLOCK("minecraft:honey_block"),
    //since 754(1.16.5)
    HONEY_BOTTLE("minecraft:honey_bottle"),
    //since 754(1.16.5)
    HONEYCOMB("minecraft:honeycomb"),
    //since 754(1.16.5)
    HONEYCOMB_BLOCK("minecraft:honeycomb_block"),
    //since 754(1.16.5)
    HOPPER("minecraft:hopper"),
    //since 754(1.16.5)
    HOPPER_MINECART("minecraft:hopper_minecart"),
    //since 754(1.16.5)
    HORN_CORAL("minecraft:horn_coral"),
    //since 754(1.16.5)
    HORN_CORAL_BLOCK("minecraft:horn_coral_block"),
    //since 754(1.16.5)
    HORN_CORAL_FAN("minecraft:horn_coral_fan"),
    //since 754(1.16.5)
    HORSE_SPAWN_EGG("minecraft:horse_spawn_egg"),
    //since 763(1.20)
    HOST_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:host_armor_trim_smithing_template"),
    //since 763(1.20)
    HOWL_POTTERY_SHERD("minecraft:howl_pottery_sherd"),
    //since 754(1.16.5)
    HUSK_SPAWN_EGG("minecraft:husk_spawn_egg"),
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
    INK_SAC("minecraft:ink_sac"),
    //since 754(1.16.5)
    IRON_AXE("minecraft:iron_axe"),
    //since 754(1.16.5)
    IRON_BARS("minecraft:iron_bars"),
    //since 754(1.16.5)
    IRON_BLOCK("minecraft:iron_block"),
    //since 754(1.16.5)
    IRON_BOOTS("minecraft:iron_boots"),
    //since 773(1.21.9)
    IRON_CHAIN("minecraft:iron_chain"),
    //since 754(1.16.5)
    IRON_CHESTPLATE("minecraft:iron_chestplate"),
    //since 754(1.16.5)
    IRON_DOOR("minecraft:iron_door"),
    //since 761(1.19.3)
    IRON_GOLEM_SPAWN_EGG("minecraft:iron_golem_spawn_egg"),
    //since 754(1.16.5)
    IRON_HELMET("minecraft:iron_helmet"),
    //since 754(1.16.5)
    IRON_HOE("minecraft:iron_hoe"),
    //since 754(1.16.5)
    IRON_HORSE_ARMOR("minecraft:iron_horse_armor"),
    //since 754(1.16.5)
    IRON_INGOT("minecraft:iron_ingot"),
    //since 754(1.16.5)
    IRON_LEGGINGS("minecraft:iron_leggings"),
    //since 754(1.16.5)
    IRON_NUGGET("minecraft:iron_nugget"),
    //since 754(1.16.5)
    IRON_ORE("minecraft:iron_ore"),
    //since 754(1.16.5)
    IRON_PICKAXE("minecraft:iron_pickaxe"),
    //since 754(1.16.5)
    IRON_SHOVEL("minecraft:iron_shovel"),
    //since 754(1.16.5)
    IRON_SWORD("minecraft:iron_sword"),
    //since 754(1.16.5)
    IRON_TRAPDOOR("minecraft:iron_trapdoor"),
    //since 754(1.16.5)
    ITEM_FRAME("minecraft:item_frame"),
    //since 754(1.16.5)
    JACK_O_LANTERN("minecraft:jack_o_lantern"),
    //since 754(1.16.5)
    JIGSAW("minecraft:jigsaw"),
    //since 754(1.16.5)
    JUKEBOX("minecraft:jukebox"),
    //since 754(1.16.5)
    JUNGLE_BOAT("minecraft:jungle_boat"),
    //since 754(1.16.5)
    JUNGLE_BUTTON("minecraft:jungle_button"),
    //since 759(1.19)
    JUNGLE_CHEST_BOAT("minecraft:jungle_chest_boat"),
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
    //since 754(1.16.5)
    JUNGLE_WOOD("minecraft:jungle_wood"),
    //since 754(1.16.5)
    KELP("minecraft:kelp"),
    //since 754(1.16.5)
    KNOWLEDGE_BOOK("minecraft:knowledge_book"),
    //since 754(1.16.5)
    LADDER("minecraft:ladder"),
    //since 754(1.16.5)
    LANTERN("minecraft:lantern"),
    //since 754(1.16.5)
    LAPIS_BLOCK("minecraft:lapis_block"),
    //since 754(1.16.5)
    LAPIS_LAZULI("minecraft:lapis_lazuli"),
    //since 754(1.16.5)
    LAPIS_ORE("minecraft:lapis_ore"),
    //since 755(1.17)
    LARGE_AMETHYST_BUD("minecraft:large_amethyst_bud"),
    //since 754(1.16.5)
    LARGE_FERN("minecraft:large_fern"),
    //since 754(1.16.5)
    LAVA_BUCKET("minecraft:lava_bucket"),
    //since 754(1.16.5)
    LEAD("minecraft:lead"),
    //since 770(1.21.5)
    LEAF_LITTER("minecraft:leaf_litter"),
    //since 754(1.16.5)
    LEATHER("minecraft:leather"),
    //since 754(1.16.5)
    LEATHER_BOOTS("minecraft:leather_boots"),
    //since 754(1.16.5)
    LEATHER_CHESTPLATE("minecraft:leather_chestplate"),
    //since 754(1.16.5)
    LEATHER_HELMET("minecraft:leather_helmet"),
    //since 754(1.16.5)
    LEATHER_HORSE_ARMOR("minecraft:leather_horse_armor"),
    //since 754(1.16.5)
    LEATHER_LEGGINGS("minecraft:leather_leggings"),
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
    //since 768(1.21.2)
    LIGHT_BLUE_BUNDLE("minecraft:light_blue_bundle"),
    //since 755(1.17)
    LIGHT_BLUE_CANDLE("minecraft:light_blue_candle"),
    //since 754(1.16.5)
    LIGHT_BLUE_CARPET("minecraft:light_blue_carpet"),
    //since 754(1.16.5)
    LIGHT_BLUE_CONCRETE("minecraft:light_blue_concrete"),
    //since 754(1.16.5)
    LIGHT_BLUE_CONCRETE_POWDER("minecraft:light_blue_concrete_powder"),
    //since 754(1.16.5)
    LIGHT_BLUE_DYE("minecraft:light_blue_dye"),
    //since 754(1.16.5)
    LIGHT_BLUE_GLAZED_TERRACOTTA("minecraft:light_blue_glazed_terracotta"),
    //since 771(1.21.6)
    LIGHT_BLUE_HARNESS("minecraft:light_blue_harness"),
    //since 754(1.16.5)
    LIGHT_BLUE_SHULKER_BOX("minecraft:light_blue_shulker_box"),
    //since 754(1.16.5)
    LIGHT_BLUE_STAINED_GLASS("minecraft:light_blue_stained_glass"),
    //since 754(1.16.5)
    LIGHT_BLUE_STAINED_GLASS_PANE("minecraft:light_blue_stained_glass_pane"),
    //since 754(1.16.5)
    LIGHT_BLUE_TERRACOTTA("minecraft:light_blue_terracotta"),
    //since 754(1.16.5)
    LIGHT_BLUE_WOOL("minecraft:light_blue_wool"),
    //since 754(1.16.5)
    LIGHT_GRAY_BANNER("minecraft:light_gray_banner"),
    //since 754(1.16.5)
    LIGHT_GRAY_BED("minecraft:light_gray_bed"),
    //since 768(1.21.2)
    LIGHT_GRAY_BUNDLE("minecraft:light_gray_bundle"),
    //since 755(1.17)
    LIGHT_GRAY_CANDLE("minecraft:light_gray_candle"),
    //since 754(1.16.5)
    LIGHT_GRAY_CARPET("minecraft:light_gray_carpet"),
    //since 754(1.16.5)
    LIGHT_GRAY_CONCRETE("minecraft:light_gray_concrete"),
    //since 754(1.16.5)
    LIGHT_GRAY_CONCRETE_POWDER("minecraft:light_gray_concrete_powder"),
    //since 754(1.16.5)
    LIGHT_GRAY_DYE("minecraft:light_gray_dye"),
    //since 754(1.16.5)
    LIGHT_GRAY_GLAZED_TERRACOTTA("minecraft:light_gray_glazed_terracotta"),
    //since 771(1.21.6)
    LIGHT_GRAY_HARNESS("minecraft:light_gray_harness"),
    //since 754(1.16.5)
    LIGHT_GRAY_SHULKER_BOX("minecraft:light_gray_shulker_box"),
    //since 754(1.16.5)
    LIGHT_GRAY_STAINED_GLASS("minecraft:light_gray_stained_glass"),
    //since 754(1.16.5)
    LIGHT_GRAY_STAINED_GLASS_PANE("minecraft:light_gray_stained_glass_pane"),
    //since 754(1.16.5)
    LIGHT_GRAY_TERRACOTTA("minecraft:light_gray_terracotta"),
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
    //since 768(1.21.2)
    LIME_BUNDLE("minecraft:lime_bundle"),
    //since 755(1.17)
    LIME_CANDLE("minecraft:lime_candle"),
    //since 754(1.16.5)
    LIME_CARPET("minecraft:lime_carpet"),
    //since 754(1.16.5)
    LIME_CONCRETE("minecraft:lime_concrete"),
    //since 754(1.16.5)
    LIME_CONCRETE_POWDER("minecraft:lime_concrete_powder"),
    //since 754(1.16.5)
    LIME_DYE("minecraft:lime_dye"),
    //since 754(1.16.5)
    LIME_GLAZED_TERRACOTTA("minecraft:lime_glazed_terracotta"),
    //since 771(1.21.6)
    LIME_HARNESS("minecraft:lime_harness"),
    //since 754(1.16.5)
    LIME_SHULKER_BOX("minecraft:lime_shulker_box"),
    //since 754(1.16.5)
    LIME_STAINED_GLASS("minecraft:lime_stained_glass"),
    //since 754(1.16.5)
    LIME_STAINED_GLASS_PANE("minecraft:lime_stained_glass_pane"),
    //since 754(1.16.5)
    LIME_TERRACOTTA("minecraft:lime_terracotta"),
    //since 754(1.16.5)
    LIME_WOOL("minecraft:lime_wool"),
    //since 754(1.16.5)
    LINGERING_POTION("minecraft:lingering_potion"),
    //since 754(1.16.5)
    LLAMA_SPAWN_EGG("minecraft:llama_spawn_egg"),
    //since 754(1.16.5)
    LODESTONE("minecraft:lodestone"),
    //since 754(1.16.5)
    LOOM("minecraft:loom"),
    //since 766(1.20.5)
    MACE("minecraft:mace"),
    //since 754(1.16.5)
    MAGENTA_BANNER("minecraft:magenta_banner"),
    //since 754(1.16.5)
    MAGENTA_BED("minecraft:magenta_bed"),
    //since 768(1.21.2)
    MAGENTA_BUNDLE("minecraft:magenta_bundle"),
    //since 755(1.17)
    MAGENTA_CANDLE("minecraft:magenta_candle"),
    //since 754(1.16.5)
    MAGENTA_CARPET("minecraft:magenta_carpet"),
    //since 754(1.16.5)
    MAGENTA_CONCRETE("minecraft:magenta_concrete"),
    //since 754(1.16.5)
    MAGENTA_CONCRETE_POWDER("minecraft:magenta_concrete_powder"),
    //since 754(1.16.5)
    MAGENTA_DYE("minecraft:magenta_dye"),
    //since 754(1.16.5)
    MAGENTA_GLAZED_TERRACOTTA("minecraft:magenta_glazed_terracotta"),
    //since 771(1.21.6)
    MAGENTA_HARNESS("minecraft:magenta_harness"),
    //since 754(1.16.5)
    MAGENTA_SHULKER_BOX("minecraft:magenta_shulker_box"),
    //since 754(1.16.5)
    MAGENTA_STAINED_GLASS("minecraft:magenta_stained_glass"),
    //since 754(1.16.5)
    MAGENTA_STAINED_GLASS_PANE("minecraft:magenta_stained_glass_pane"),
    //since 754(1.16.5)
    MAGENTA_TERRACOTTA("minecraft:magenta_terracotta"),
    //since 754(1.16.5)
    MAGENTA_WOOL("minecraft:magenta_wool"),
    //since 754(1.16.5)
    MAGMA_BLOCK("minecraft:magma_block"),
    //since 754(1.16.5)
    MAGMA_CREAM("minecraft:magma_cream"),
    //since 754(1.16.5)
    MAGMA_CUBE_SPAWN_EGG("minecraft:magma_cube_spawn_egg"),
    //since 759(1.19)
    MANGROVE_BOAT("minecraft:mangrove_boat"),
    //since 759(1.19)
    MANGROVE_BUTTON("minecraft:mangrove_button"),
    //since 759(1.19)
    MANGROVE_CHEST_BOAT("minecraft:mangrove_chest_boat"),
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
    //since 759(1.19)
    MANGROVE_WOOD("minecraft:mangrove_wood"),
    //since 754(1.16.5)
    MAP("minecraft:map"),
    //since 755(1.17)
    MEDIUM_AMETHYST_BUD("minecraft:medium_amethyst_bud"),
    //since 754(1.16.5)
    MELON("minecraft:melon"),
    //since 754(1.16.5)
    MELON_SEEDS("minecraft:melon_seeds"),
    //since 754(1.16.5)
    MELON_SLICE("minecraft:melon_slice"),
    //since 754(1.16.5)
    MILK_BUCKET("minecraft:milk_bucket"),
    //since 754(1.16.5)
    MINECART("minecraft:minecart"),
    //since 763(1.20)
    MINER_POTTERY_SHERD("minecraft:miner_pottery_sherd"),
    //since 754(1.16.5)
    MOJANG_BANNER_PATTERN("minecraft:mojang_banner_pattern"),
    //since 754(1.16.5)
    MOOSHROOM_SPAWN_EGG("minecraft:mooshroom_spawn_egg"),
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
    //since 763(1.20)
    MOURNER_POTTERY_SHERD("minecraft:mourner_pottery_sherd"),
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
    MULE_SPAWN_EGG("minecraft:mule_spawn_egg"),
    //since 754(1.16.5)
    MUSHROOM_STEM("minecraft:mushroom_stem"),
    //since 754(1.16.5)
    MUSHROOM_STEW("minecraft:mushroom_stew"),
    //since 754(1.16.5)
    MUSIC_DISC_11("minecraft:music_disc_11"),
    //since 754(1.16.5)
    MUSIC_DISC_13("minecraft:music_disc_13"),
    //since 759(1.19)
    MUSIC_DISC_5("minecraft:music_disc_5"),
    //since 754(1.16.5)
    MUSIC_DISC_BLOCKS("minecraft:music_disc_blocks"),
    //since 754(1.16.5)
    MUSIC_DISC_CAT("minecraft:music_disc_cat"),
    //since 754(1.16.5)
    MUSIC_DISC_CHIRP("minecraft:music_disc_chirp"),
    //since 767(1.21)
    MUSIC_DISC_CREATOR("minecraft:music_disc_creator"),
    //since 767(1.21)
    MUSIC_DISC_CREATOR_MUSIC_BOX("minecraft:music_disc_creator_music_box"),
    //since 754(1.16.5)
    MUSIC_DISC_FAR("minecraft:music_disc_far"),
    //since 772(1.21.7)
    MUSIC_DISC_LAVA_CHICKEN("minecraft:music_disc_lava_chicken"),
    //since 754(1.16.5)
    MUSIC_DISC_MALL("minecraft:music_disc_mall"),
    //since 754(1.16.5)
    MUSIC_DISC_MELLOHI("minecraft:music_disc_mellohi"),
    //since 757(1.18)
    MUSIC_DISC_OTHERSIDE("minecraft:music_disc_otherside"),
    //since 754(1.16.5)
    MUSIC_DISC_PIGSTEP("minecraft:music_disc_pigstep"),
    //since 767(1.21)
    MUSIC_DISC_PRECIPICE("minecraft:music_disc_precipice"),
    //since 763(1.20)
    MUSIC_DISC_RELIC("minecraft:music_disc_relic"),
    //since 754(1.16.5)
    MUSIC_DISC_STAL("minecraft:music_disc_stal"),
    //since 754(1.16.5)
    MUSIC_DISC_STRAD("minecraft:music_disc_strad"),
    //since 771(1.21.6)
    MUSIC_DISC_TEARS("minecraft:music_disc_tears"),
    //since 754(1.16.5)
    MUSIC_DISC_WAIT("minecraft:music_disc_wait"),
    //since 754(1.16.5)
    MUSIC_DISC_WARD("minecraft:music_disc_ward"),
    //since 754(1.16.5)
    MUTTON("minecraft:mutton"),
    //since 754(1.16.5)
    MYCELIUM("minecraft:mycelium"),
    //since 754(1.16.5)
    NAME_TAG("minecraft:name_tag"),
    //since 754(1.16.5)
    NAUTILUS_SHELL("minecraft:nautilus_shell"),
    //since 754(1.16.5)
    NETHER_BRICK("minecraft:nether_brick"),
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
    NETHER_QUARTZ_ORE("minecraft:nether_quartz_ore"),
    //since 754(1.16.5)
    NETHER_SPROUTS("minecraft:nether_sprouts"),
    //since 754(1.16.5)
    NETHER_STAR("minecraft:nether_star"),
    //since 754(1.16.5)
    NETHER_WART("minecraft:nether_wart"),
    //since 754(1.16.5)
    NETHER_WART_BLOCK("minecraft:nether_wart_block"),
    //since 754(1.16.5)
    NETHERITE_AXE("minecraft:netherite_axe"),
    //since 754(1.16.5)
    NETHERITE_BLOCK("minecraft:netherite_block"),
    //since 754(1.16.5)
    NETHERITE_BOOTS("minecraft:netherite_boots"),
    //since 754(1.16.5)
    NETHERITE_CHESTPLATE("minecraft:netherite_chestplate"),
    //since 754(1.16.5)
    NETHERITE_HELMET("minecraft:netherite_helmet"),
    //since 754(1.16.5)
    NETHERITE_HOE("minecraft:netherite_hoe"),
    //since 754(1.16.5)
    NETHERITE_INGOT("minecraft:netherite_ingot"),
    //since 754(1.16.5)
    NETHERITE_LEGGINGS("minecraft:netherite_leggings"),
    //since 754(1.16.5)
    NETHERITE_PICKAXE("minecraft:netherite_pickaxe"),
    //since 754(1.16.5)
    NETHERITE_SCRAP("minecraft:netherite_scrap"),
    //since 754(1.16.5)
    NETHERITE_SHOVEL("minecraft:netherite_shovel"),
    //since 754(1.16.5)
    NETHERITE_SWORD("minecraft:netherite_sword"),
    //since 762(1.19.4)
    NETHERITE_UPGRADE_SMITHING_TEMPLATE("minecraft:netherite_upgrade_smithing_template"),
    //since 754(1.16.5)
    NETHERRACK("minecraft:netherrack"),
    //since 754(1.16.5)
    NOTE_BLOCK("minecraft:note_block"),
    //since 754(1.16.5)
    OAK_BOAT("minecraft:oak_boat"),
    //since 754(1.16.5)
    OAK_BUTTON("minecraft:oak_button"),
    //since 759(1.19)
    OAK_CHEST_BOAT("minecraft:oak_chest_boat"),
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
    //since 754(1.16.5)
    OAK_WOOD("minecraft:oak_wood"),
    //since 754(1.16.5)
    OBSERVER("minecraft:observer"),
    //since 754(1.16.5)
    OBSIDIAN("minecraft:obsidian"),
    //since 754(1.16.5)
    OCELOT_SPAWN_EGG("minecraft:ocelot_spawn_egg"),
    //since 759(1.19)
    OCHRE_FROGLIGHT("minecraft:ochre_froglight"),
    //since 766(1.20.5)
    OMINOUS_BOTTLE("minecraft:ominous_bottle"),
    //since 766(1.20.5)
    OMINOUS_TRIAL_KEY("minecraft:ominous_trial_key"),
    //since 769(1.21.4)
    OPEN_EYEBLOSSOM("minecraft:open_eyeblossom"),
    //since 754(1.16.5)
    ORANGE_BANNER("minecraft:orange_banner"),
    //since 754(1.16.5)
    ORANGE_BED("minecraft:orange_bed"),
    //since 768(1.21.2)
    ORANGE_BUNDLE("minecraft:orange_bundle"),
    //since 755(1.17)
    ORANGE_CANDLE("minecraft:orange_candle"),
    //since 754(1.16.5)
    ORANGE_CARPET("minecraft:orange_carpet"),
    //since 754(1.16.5)
    ORANGE_CONCRETE("minecraft:orange_concrete"),
    //since 754(1.16.5)
    ORANGE_CONCRETE_POWDER("minecraft:orange_concrete_powder"),
    //since 754(1.16.5)
    ORANGE_DYE("minecraft:orange_dye"),
    //since 754(1.16.5)
    ORANGE_GLAZED_TERRACOTTA("minecraft:orange_glazed_terracotta"),
    //since 771(1.21.6)
    ORANGE_HARNESS("minecraft:orange_harness"),
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
    //since 754(1.16.5)
    PAINTING("minecraft:painting"),
    //since 768(1.21.2)
    PALE_HANGING_MOSS("minecraft:pale_hanging_moss"),
    //since 768(1.21.2)
    PALE_MOSS_BLOCK("minecraft:pale_moss_block"),
    //since 768(1.21.2)
    PALE_MOSS_CARPET("minecraft:pale_moss_carpet"),
    //since 768(1.21.2)
    PALE_OAK_BOAT("minecraft:pale_oak_boat"),
    //since 768(1.21.2)
    PALE_OAK_BUTTON("minecraft:pale_oak_button"),
    //since 768(1.21.2)
    PALE_OAK_CHEST_BOAT("minecraft:pale_oak_chest_boat"),
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
    PALE_OAK_WOOD("minecraft:pale_oak_wood"),
    //since 754(1.16.5)
    PANDA_SPAWN_EGG("minecraft:panda_spawn_egg"),
    //since 754(1.16.5)
    PAPER("minecraft:paper"),
    //since 754(1.16.5)
    PARROT_SPAWN_EGG("minecraft:parrot_spawn_egg"),
    //since 759(1.19)
    PEARLESCENT_FROGLIGHT("minecraft:pearlescent_froglight"),
    //since 754(1.16.5)
    PEONY("minecraft:peony"),
    //since 754(1.16.5)
    PETRIFIED_OAK_SLAB("minecraft:petrified_oak_slab"),
    //since 754(1.16.5)
    PHANTOM_MEMBRANE("minecraft:phantom_membrane"),
    //since 754(1.16.5)
    PHANTOM_SPAWN_EGG("minecraft:phantom_spawn_egg"),
    //since 754(1.16.5)
    PIG_SPAWN_EGG("minecraft:pig_spawn_egg"),
    //since 754(1.16.5)
    PIGLIN_BANNER_PATTERN("minecraft:piglin_banner_pattern"),
    //since 754(1.16.5)
    PIGLIN_BRUTE_SPAWN_EGG("minecraft:piglin_brute_spawn_egg"),
    //since 761(1.19.3)
    PIGLIN_HEAD("minecraft:piglin_head"),
    //since 754(1.16.5)
    PIGLIN_SPAWN_EGG("minecraft:piglin_spawn_egg"),
    //since 754(1.16.5)
    PILLAGER_SPAWN_EGG("minecraft:pillager_spawn_egg"),
    //since 754(1.16.5)
    PINK_BANNER("minecraft:pink_banner"),
    //since 754(1.16.5)
    PINK_BED("minecraft:pink_bed"),
    //since 768(1.21.2)
    PINK_BUNDLE("minecraft:pink_bundle"),
    //since 755(1.17)
    PINK_CANDLE("minecraft:pink_candle"),
    //since 754(1.16.5)
    PINK_CARPET("minecraft:pink_carpet"),
    //since 754(1.16.5)
    PINK_CONCRETE("minecraft:pink_concrete"),
    //since 754(1.16.5)
    PINK_CONCRETE_POWDER("minecraft:pink_concrete_powder"),
    //since 754(1.16.5)
    PINK_DYE("minecraft:pink_dye"),
    //since 754(1.16.5)
    PINK_GLAZED_TERRACOTTA("minecraft:pink_glazed_terracotta"),
    //since 771(1.21.6)
    PINK_HARNESS("minecraft:pink_harness"),
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
    PINK_WOOL("minecraft:pink_wool"),
    //since 754(1.16.5)
    PISTON("minecraft:piston"),
    //since 763(1.20)
    PITCHER_PLANT("minecraft:pitcher_plant"),
    //since 763(1.20)
    PITCHER_POD("minecraft:pitcher_pod"),
    //since 754(1.16.5)
    PLAYER_HEAD("minecraft:player_head"),
    //since 763(1.20)
    PLENTY_POTTERY_SHERD("minecraft:plenty_pottery_sherd"),
    //since 754(1.16.5)
    PODZOL("minecraft:podzol"),
    //since 755(1.17)
    POINTED_DRIPSTONE("minecraft:pointed_dripstone"),
    //since 754(1.16.5)
    POISONOUS_POTATO("minecraft:poisonous_potato"),
    //since 754(1.16.5)
    POLAR_BEAR_SPAWN_EGG("minecraft:polar_bear_spawn_egg"),
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
    POPPED_CHORUS_FRUIT("minecraft:popped_chorus_fruit"),
    //since 754(1.16.5)
    POPPY("minecraft:poppy"),
    //since 754(1.16.5)
    PORKCHOP("minecraft:porkchop"),
    //since 754(1.16.5)
    POTATO("minecraft:potato"),
    //since 754(1.16.5)
    POTION("minecraft:potion"),
    //since 762(1.19.4)
    @Deprecated
    POTTERY_SHARD_ARCHER("minecraft:pottery_shard_archer"),
    //since 762(1.19.4)
    @Deprecated
    POTTERY_SHARD_ARMS_UP("minecraft:pottery_shard_arms_up"),
    //since 762(1.19.4)
    @Deprecated
    POTTERY_SHARD_PRIZE("minecraft:pottery_shard_prize"),
    //since 762(1.19.4)
    @Deprecated
    POTTERY_SHARD_SKULL("minecraft:pottery_shard_skull"),
    //since 755(1.17)
    POWDER_SNOW_BUCKET("minecraft:powder_snow_bucket"),
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
    PRISMARINE_CRYSTALS("minecraft:prismarine_crystals"),
    //since 754(1.16.5)
    PRISMARINE_SHARD("minecraft:prismarine_shard"),
    //since 754(1.16.5)
    PRISMARINE_SLAB("minecraft:prismarine_slab"),
    //since 754(1.16.5)
    PRISMARINE_STAIRS("minecraft:prismarine_stairs"),
    //since 754(1.16.5)
    PRISMARINE_WALL("minecraft:prismarine_wall"),
    //since 763(1.20)
    PRIZE_POTTERY_SHERD("minecraft:prize_pottery_sherd"),
    //since 754(1.16.5)
    PUFFERFISH("minecraft:pufferfish"),
    //since 754(1.16.5)
    PUFFERFISH_BUCKET("minecraft:pufferfish_bucket"),
    //since 754(1.16.5)
    PUFFERFISH_SPAWN_EGG("minecraft:pufferfish_spawn_egg"),
    //since 754(1.16.5)
    PUMPKIN("minecraft:pumpkin"),
    //since 754(1.16.5)
    PUMPKIN_PIE("minecraft:pumpkin_pie"),
    //since 754(1.16.5)
    PUMPKIN_SEEDS("minecraft:pumpkin_seeds"),
    //since 754(1.16.5)
    PURPLE_BANNER("minecraft:purple_banner"),
    //since 754(1.16.5)
    PURPLE_BED("minecraft:purple_bed"),
    //since 768(1.21.2)
    PURPLE_BUNDLE("minecraft:purple_bundle"),
    //since 755(1.17)
    PURPLE_CANDLE("minecraft:purple_candle"),
    //since 754(1.16.5)
    PURPLE_CARPET("minecraft:purple_carpet"),
    //since 754(1.16.5)
    PURPLE_CONCRETE("minecraft:purple_concrete"),
    //since 754(1.16.5)
    PURPLE_CONCRETE_POWDER("minecraft:purple_concrete_powder"),
    //since 754(1.16.5)
    PURPLE_DYE("minecraft:purple_dye"),
    //since 754(1.16.5)
    PURPLE_GLAZED_TERRACOTTA("minecraft:purple_glazed_terracotta"),
    //since 771(1.21.6)
    PURPLE_HARNESS("minecraft:purple_harness"),
    //since 754(1.16.5)
    PURPLE_SHULKER_BOX("minecraft:purple_shulker_box"),
    //since 754(1.16.5)
    PURPLE_STAINED_GLASS("minecraft:purple_stained_glass"),
    //since 754(1.16.5)
    PURPLE_STAINED_GLASS_PANE("minecraft:purple_stained_glass_pane"),
    //since 754(1.16.5)
    PURPLE_TERRACOTTA("minecraft:purple_terracotta"),
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
    QUARTZ("minecraft:quartz"),
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
    RABBIT("minecraft:rabbit"),
    //since 754(1.16.5)
    RABBIT_FOOT("minecraft:rabbit_foot"),
    //since 754(1.16.5)
    RABBIT_HIDE("minecraft:rabbit_hide"),
    //since 754(1.16.5)
    RABBIT_SPAWN_EGG("minecraft:rabbit_spawn_egg"),
    //since 754(1.16.5)
    RABBIT_STEW("minecraft:rabbit_stew"),
    //since 754(1.16.5)
    RAIL("minecraft:rail"),
    //since 763(1.20)
    RAISER_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:raiser_armor_trim_smithing_template"),
    //since 754(1.16.5)
    RAVAGER_SPAWN_EGG("minecraft:ravager_spawn_egg"),
    //since 755(1.17)
    RAW_COPPER("minecraft:raw_copper"),
    //since 755(1.17)
    RAW_COPPER_BLOCK("minecraft:raw_copper_block"),
    //since 755(1.17)
    RAW_GOLD("minecraft:raw_gold"),
    //since 755(1.17)
    RAW_GOLD_BLOCK("minecraft:raw_gold_block"),
    //since 755(1.17)
    RAW_IRON("minecraft:raw_iron"),
    //since 755(1.17)
    RAW_IRON_BLOCK("minecraft:raw_iron_block"),
    //since 759(1.19)
    RECOVERY_COMPASS("minecraft:recovery_compass"),
    //since 754(1.16.5)
    RED_BANNER("minecraft:red_banner"),
    //since 754(1.16.5)
    RED_BED("minecraft:red_bed"),
    //since 768(1.21.2)
    RED_BUNDLE("minecraft:red_bundle"),
    //since 755(1.17)
    RED_CANDLE("minecraft:red_candle"),
    //since 754(1.16.5)
    RED_CARPET("minecraft:red_carpet"),
    //since 754(1.16.5)
    RED_CONCRETE("minecraft:red_concrete"),
    //since 754(1.16.5)
    RED_CONCRETE_POWDER("minecraft:red_concrete_powder"),
    //since 754(1.16.5)
    RED_DYE("minecraft:red_dye"),
    //since 754(1.16.5)
    RED_GLAZED_TERRACOTTA("minecraft:red_glazed_terracotta"),
    //since 771(1.21.6)
    RED_HARNESS("minecraft:red_harness"),
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
    RED_WOOL("minecraft:red_wool"),
    //since 754(1.16.5)
    REDSTONE("minecraft:redstone"),
    //since 754(1.16.5)
    REDSTONE_BLOCK("minecraft:redstone_block"),
    //since 754(1.16.5)
    REDSTONE_LAMP("minecraft:redstone_lamp"),
    //since 754(1.16.5)
    REDSTONE_ORE("minecraft:redstone_ore"),
    //since 754(1.16.5)
    REDSTONE_TORCH("minecraft:redstone_torch"),
    //since 759(1.19)
    REINFORCED_DEEPSLATE("minecraft:reinforced_deepslate"),
    //since 754(1.16.5)
    REPEATER("minecraft:repeater"),
    //since 754(1.16.5)
    REPEATING_COMMAND_BLOCK("minecraft:repeating_command_block"),
    //since 769(1.21.4)
    RESIN_BLOCK("minecraft:resin_block"),
    //since 769(1.21.4)
    RESIN_BRICK("minecraft:resin_brick"),
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
    //since 762(1.19.4)
    RIB_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:rib_armor_trim_smithing_template"),
    //since 755(1.17)
    ROOTED_DIRT("minecraft:rooted_dirt"),
    //since 754(1.16.5)
    ROSE_BUSH("minecraft:rose_bush"),
    //since 754(1.16.5)
    ROTTEN_FLESH("minecraft:rotten_flesh"),
    //since 754(1.16.5)
    SADDLE("minecraft:saddle"),
    //since 754(1.16.5)
    SALMON("minecraft:salmon"),
    //since 754(1.16.5)
    SALMON_BUCKET("minecraft:salmon_bucket"),
    //since 754(1.16.5)
    SALMON_SPAWN_EGG("minecraft:salmon_spawn_egg"),
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
    //since 766(1.20.5)
    SCRAPE_POTTERY_SHERD("minecraft:scrape_pottery_sherd"),
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
    @Deprecated
    SCUTE("minecraft:scute"),
    //since 754(1.16.5)
    SEA_LANTERN("minecraft:sea_lantern"),
    //since 754(1.16.5)
    SEA_PICKLE("minecraft:sea_pickle"),
    //since 754(1.16.5)
    SEAGRASS("minecraft:seagrass"),
    //since 762(1.19.4)
    SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:sentry_armor_trim_smithing_template"),
    //since 763(1.20)
    SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:shaper_armor_trim_smithing_template"),
    //since 763(1.20)
    SHEAF_POTTERY_SHERD("minecraft:sheaf_pottery_sherd"),
    //since 754(1.16.5)
    SHEARS("minecraft:shears"),
    //since 754(1.16.5)
    SHEEP_SPAWN_EGG("minecraft:sheep_spawn_egg"),
    //since 763(1.20)
    SHELTER_POTTERY_SHERD("minecraft:shelter_pottery_sherd"),
    //since 754(1.16.5)
    SHIELD("minecraft:shield"),
    //since 770(1.21.5)
    SHORT_DRY_GRASS("minecraft:short_dry_grass"),
    //since 765(1.20.3)
    SHORT_GRASS("minecraft:short_grass"),
    //since 754(1.16.5)
    SHROOMLIGHT("minecraft:shroomlight"),
    //since 754(1.16.5)
    SHULKER_BOX("minecraft:shulker_box"),
    //since 754(1.16.5)
    SHULKER_SHELL("minecraft:shulker_shell"),
    //since 754(1.16.5)
    SHULKER_SPAWN_EGG("minecraft:shulker_spawn_egg"),
    //since 763(1.20)
    SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:silence_armor_trim_smithing_template"),
    //since 754(1.16.5)
    SILVERFISH_SPAWN_EGG("minecraft:silverfish_spawn_egg"),
    //since 754(1.16.5)
    SKELETON_HORSE_SPAWN_EGG("minecraft:skeleton_horse_spawn_egg"),
    //since 754(1.16.5)
    SKELETON_SKULL("minecraft:skeleton_skull"),
    //since 754(1.16.5)
    SKELETON_SPAWN_EGG("minecraft:skeleton_spawn_egg"),
    //since 754(1.16.5)
    SKULL_BANNER_PATTERN("minecraft:skull_banner_pattern"),
    //since 763(1.20)
    SKULL_POTTERY_SHERD("minecraft:skull_pottery_sherd"),
    //since 754(1.16.5)
    SLIME_BALL("minecraft:slime_ball"),
    //since 754(1.16.5)
    SLIME_BLOCK("minecraft:slime_block"),
    //since 754(1.16.5)
    SLIME_SPAWN_EGG("minecraft:slime_spawn_egg"),
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
    //since 762(1.19.4)
    SNIFFER_SPAWN_EGG("minecraft:sniffer_spawn_egg"),
    //since 763(1.20)
    SNORT_POTTERY_SHERD("minecraft:snort_pottery_sherd"),
    //since 762(1.19.4)
    SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:snout_armor_trim_smithing_template"),
    //since 754(1.16.5)
    SNOW("minecraft:snow"),
    //since 754(1.16.5)
    SNOW_BLOCK("minecraft:snow_block"),
    //since 761(1.19.3)
    SNOW_GOLEM_SPAWN_EGG("minecraft:snow_golem_spawn_egg"),
    //since 754(1.16.5)
    SNOWBALL("minecraft:snowball"),
    //since 754(1.16.5)
    SOUL_CAMPFIRE("minecraft:soul_campfire"),
    //since 754(1.16.5)
    SOUL_LANTERN("minecraft:soul_lantern"),
    //since 754(1.16.5)
    SOUL_SAND("minecraft:soul_sand"),
    //since 754(1.16.5)
    SOUL_SOIL("minecraft:soul_soil"),
    //since 754(1.16.5)
    SOUL_TORCH("minecraft:soul_torch"),
    //since 754(1.16.5)
    SPAWNER("minecraft:spawner"),
    //since 754(1.16.5)
    SPECTRAL_ARROW("minecraft:spectral_arrow"),
    //since 754(1.16.5)
    SPIDER_EYE("minecraft:spider_eye"),
    //since 754(1.16.5)
    SPIDER_SPAWN_EGG("minecraft:spider_spawn_egg"),
    //since 762(1.19.4)
    SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:spire_armor_trim_smithing_template"),
    //since 754(1.16.5)
    SPLASH_POTION("minecraft:splash_potion"),
    //since 754(1.16.5)
    SPONGE("minecraft:sponge"),
    //since 755(1.17)
    SPORE_BLOSSOM("minecraft:spore_blossom"),
    //since 754(1.16.5)
    SPRUCE_BOAT("minecraft:spruce_boat"),
    //since 754(1.16.5)
    SPRUCE_BUTTON("minecraft:spruce_button"),
    //since 759(1.19)
    SPRUCE_CHEST_BOAT("minecraft:spruce_chest_boat"),
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
    //since 754(1.16.5)
    SPRUCE_WOOD("minecraft:spruce_wood"),
    //since 755(1.17)
    SPYGLASS("minecraft:spyglass"),
    //since 754(1.16.5)
    SQUID_SPAWN_EGG("minecraft:squid_spawn_egg"),
    //since 754(1.16.5)
    STICK("minecraft:stick"),
    //since 754(1.16.5)
    STICKY_PISTON("minecraft:sticky_piston"),
    //since 754(1.16.5)
    STONE("minecraft:stone"),
    //since 754(1.16.5)
    STONE_AXE("minecraft:stone_axe"),
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
    STONE_HOE("minecraft:stone_hoe"),
    //since 754(1.16.5)
    STONE_PICKAXE("minecraft:stone_pickaxe"),
    //since 754(1.16.5)
    STONE_PRESSURE_PLATE("minecraft:stone_pressure_plate"),
    //since 754(1.16.5)
    STONE_SHOVEL("minecraft:stone_shovel"),
    //since 754(1.16.5)
    STONE_SLAB("minecraft:stone_slab"),
    //since 754(1.16.5)
    STONE_STAIRS("minecraft:stone_stairs"),
    //since 754(1.16.5)
    STONE_SWORD("minecraft:stone_sword"),
    //since 754(1.16.5)
    STONECUTTER("minecraft:stonecutter"),
    //since 754(1.16.5)
    STRAY_SPAWN_EGG("minecraft:stray_spawn_egg"),
    //since 754(1.16.5)
    STRIDER_SPAWN_EGG("minecraft:strider_spawn_egg"),
    //since 754(1.16.5)
    STRING("minecraft:string"),
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
    SUGAR("minecraft:sugar"),
    //since 754(1.16.5)
    SUGAR_CANE("minecraft:sugar_cane"),
    //since 754(1.16.5)
    SUNFLOWER("minecraft:sunflower"),
    //since 763(1.20)
    SUSPICIOUS_GRAVEL("minecraft:suspicious_gravel"),
    //since 762(1.19.4)
    SUSPICIOUS_SAND("minecraft:suspicious_sand"),
    //since 754(1.16.5)
    SUSPICIOUS_STEW("minecraft:suspicious_stew"),
    //since 754(1.16.5)
    SWEET_BERRIES("minecraft:sweet_berries"),
    //since 759(1.19)
    TADPOLE_BUCKET("minecraft:tadpole_bucket"),
    //since 759(1.19)
    TADPOLE_SPAWN_EGG("minecraft:tadpole_spawn_egg"),
    //since 770(1.21.5)
    TALL_DRY_GRASS("minecraft:tall_dry_grass"),
    //since 754(1.16.5)
    TALL_GRASS("minecraft:tall_grass"),
    //since 754(1.16.5)
    TARGET("minecraft:target"),
    //since 754(1.16.5)
    TERRACOTTA("minecraft:terracotta"),
    //since 770(1.21.5)
    TEST_BLOCK("minecraft:test_block"),
    //since 770(1.21.5)
    TEST_INSTANCE_BLOCK("minecraft:test_instance_block"),
    //since 762(1.19.4)
    TIDE_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:tide_armor_trim_smithing_template"),
    //since 755(1.17)
    TINTED_GLASS("minecraft:tinted_glass"),
    //since 754(1.16.5)
    TIPPED_ARROW("minecraft:tipped_arrow"),
    //since 754(1.16.5)
    TNT("minecraft:tnt"),
    //since 754(1.16.5)
    TNT_MINECART("minecraft:tnt_minecart"),
    //since 754(1.16.5)
    TORCH("minecraft:torch"),
    //since 762(1.19.4)
    TORCHFLOWER("minecraft:torchflower"),
    //since 762(1.19.4)
    TORCHFLOWER_SEEDS("minecraft:torchflower_seeds"),
    //since 754(1.16.5)
    TOTEM_OF_UNDYING("minecraft:totem_of_undying"),
    //since 754(1.16.5)
    TRADER_LLAMA_SPAWN_EGG("minecraft:trader_llama_spawn_egg"),
    //since 754(1.16.5)
    TRAPPED_CHEST("minecraft:trapped_chest"),
    //since 765(1.20.3)
    TRIAL_KEY("minecraft:trial_key"),
    //since 765(1.20.3)
    TRIAL_SPAWNER("minecraft:trial_spawner"),
    //since 754(1.16.5)
    TRIDENT("minecraft:trident"),
    //since 754(1.16.5)
    TRIPWIRE_HOOK("minecraft:tripwire_hook"),
    //since 754(1.16.5)
    TROPICAL_FISH("minecraft:tropical_fish"),
    //since 754(1.16.5)
    TROPICAL_FISH_BUCKET("minecraft:tropical_fish_bucket"),
    //since 754(1.16.5)
    TROPICAL_FISH_SPAWN_EGG("minecraft:tropical_fish_spawn_egg"),
    //since 754(1.16.5)
    TUBE_CORAL("minecraft:tube_coral"),
    //since 754(1.16.5)
    TUBE_CORAL_BLOCK("minecraft:tube_coral_block"),
    //since 754(1.16.5)
    TUBE_CORAL_FAN("minecraft:tube_coral_fan"),
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
    TURTLE_HELMET("minecraft:turtle_helmet"),
    //since 766(1.20.5)
    TURTLE_SCUTE("minecraft:turtle_scute"),
    //since 754(1.16.5)
    TURTLE_SPAWN_EGG("minecraft:turtle_spawn_egg"),
    //since 754(1.16.5)
    TWISTING_VINES("minecraft:twisting_vines"),
    //since 766(1.20.5)
    VAULT("minecraft:vault"),
    //since 759(1.19)
    VERDANT_FROGLIGHT("minecraft:verdant_froglight"),
    //since 762(1.19.4)
    VEX_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:vex_armor_trim_smithing_template"),
    //since 754(1.16.5)
    VEX_SPAWN_EGG("minecraft:vex_spawn_egg"),
    //since 754(1.16.5)
    VILLAGER_SPAWN_EGG("minecraft:villager_spawn_egg"),
    //since 754(1.16.5)
    VINDICATOR_SPAWN_EGG("minecraft:vindicator_spawn_egg"),
    //since 754(1.16.5)
    VINE("minecraft:vine"),
    //since 754(1.16.5)
    WANDERING_TRADER_SPAWN_EGG("minecraft:wandering_trader_spawn_egg"),
    //since 762(1.19.4)
    WARD_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:ward_armor_trim_smithing_template"),
    //since 759(1.19)
    WARDEN_SPAWN_EGG("minecraft:warden_spawn_egg"),
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
    //since 754(1.16.5)
    WARPED_FUNGUS_ON_A_STICK("minecraft:warped_fungus_on_a_stick"),
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
    //since 754(1.16.5)
    WARPED_WART_BLOCK("minecraft:warped_wart_block"),
    //since 754(1.16.5)
    WATER_BUCKET("minecraft:water_bucket"),
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
    //since 763(1.20)
    WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:wayfinder_armor_trim_smithing_template"),
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
    WET_SPONGE("minecraft:wet_sponge"),
    //since 754(1.16.5)
    WHEAT("minecraft:wheat"),
    //since 754(1.16.5)
    WHEAT_SEEDS("minecraft:wheat_seeds"),
    //since 754(1.16.5)
    WHITE_BANNER("minecraft:white_banner"),
    //since 754(1.16.5)
    WHITE_BED("minecraft:white_bed"),
    //since 768(1.21.2)
    WHITE_BUNDLE("minecraft:white_bundle"),
    //since 755(1.17)
    WHITE_CANDLE("minecraft:white_candle"),
    //since 754(1.16.5)
    WHITE_CARPET("minecraft:white_carpet"),
    //since 754(1.16.5)
    WHITE_CONCRETE("minecraft:white_concrete"),
    //since 754(1.16.5)
    WHITE_CONCRETE_POWDER("minecraft:white_concrete_powder"),
    //since 754(1.16.5)
    WHITE_DYE("minecraft:white_dye"),
    //since 754(1.16.5)
    WHITE_GLAZED_TERRACOTTA("minecraft:white_glazed_terracotta"),
    //since 771(1.21.6)
    WHITE_HARNESS("minecraft:white_harness"),
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
    WHITE_WOOL("minecraft:white_wool"),
    //since 762(1.19.4)
    WILD_ARMOR_TRIM_SMITHING_TEMPLATE("minecraft:wild_armor_trim_smithing_template"),
    //since 770(1.21.5)
    WILDFLOWERS("minecraft:wildflowers"),
    //since 766(1.20.5)
    WIND_CHARGE("minecraft:wind_charge"),
    //since 754(1.16.5)
    WITCH_SPAWN_EGG("minecraft:witch_spawn_egg"),
    //since 754(1.16.5)
    WITHER_ROSE("minecraft:wither_rose"),
    //since 754(1.16.5)
    WITHER_SKELETON_SKULL("minecraft:wither_skeleton_skull"),
    //since 754(1.16.5)
    WITHER_SKELETON_SPAWN_EGG("minecraft:wither_skeleton_spawn_egg"),
    //since 761(1.19.3)
    WITHER_SPAWN_EGG("minecraft:wither_spawn_egg"),
    //since 766(1.20.5)
    WOLF_ARMOR("minecraft:wolf_armor"),
    //since 754(1.16.5)
    WOLF_SPAWN_EGG("minecraft:wolf_spawn_egg"),
    //since 754(1.16.5)
    WOODEN_AXE("minecraft:wooden_axe"),
    //since 754(1.16.5)
    WOODEN_HOE("minecraft:wooden_hoe"),
    //since 754(1.16.5)
    WOODEN_PICKAXE("minecraft:wooden_pickaxe"),
    //since 754(1.16.5)
    WOODEN_SHOVEL("minecraft:wooden_shovel"),
    //since 754(1.16.5)
    WOODEN_SWORD("minecraft:wooden_sword"),
    //since 754(1.16.5)
    WRITABLE_BOOK("minecraft:writable_book"),
    //since 754(1.16.5)
    WRITTEN_BOOK("minecraft:written_book"),
    //since 754(1.16.5)
    YELLOW_BANNER("minecraft:yellow_banner"),
    //since 754(1.16.5)
    YELLOW_BED("minecraft:yellow_bed"),
    //since 768(1.21.2)
    YELLOW_BUNDLE("minecraft:yellow_bundle"),
    //since 755(1.17)
    YELLOW_CANDLE("minecraft:yellow_candle"),
    //since 754(1.16.5)
    YELLOW_CARPET("minecraft:yellow_carpet"),
    //since 754(1.16.5)
    YELLOW_CONCRETE("minecraft:yellow_concrete"),
    //since 754(1.16.5)
    YELLOW_CONCRETE_POWDER("minecraft:yellow_concrete_powder"),
    //since 754(1.16.5)
    YELLOW_DYE("minecraft:yellow_dye"),
    //since 754(1.16.5)
    YELLOW_GLAZED_TERRACOTTA("minecraft:yellow_glazed_terracotta"),
    //since 771(1.21.6)
    YELLOW_HARNESS("minecraft:yellow_harness"),
    //since 754(1.16.5)
    YELLOW_SHULKER_BOX("minecraft:yellow_shulker_box"),
    //since 754(1.16.5)
    YELLOW_STAINED_GLASS("minecraft:yellow_stained_glass"),
    //since 754(1.16.5)
    YELLOW_STAINED_GLASS_PANE("minecraft:yellow_stained_glass_pane"),
    //since 754(1.16.5)
    YELLOW_TERRACOTTA("minecraft:yellow_terracotta"),
    //since 754(1.16.5)
    YELLOW_WOOL("minecraft:yellow_wool"),
    //since 754(1.16.5)
    ZOGLIN_SPAWN_EGG("minecraft:zoglin_spawn_egg"),
    //since 754(1.16.5)
    ZOMBIE_HEAD("minecraft:zombie_head"),
    //since 754(1.16.5)
    ZOMBIE_HORSE_SPAWN_EGG("minecraft:zombie_horse_spawn_egg"),
    //since 754(1.16.5)
    ZOMBIE_SPAWN_EGG("minecraft:zombie_spawn_egg"),
    //since 754(1.16.5)
    ZOMBIE_VILLAGER_SPAWN_EGG("minecraft:zombie_villager_spawn_egg"),
    //since 754(1.16.5)
    ZOMBIFIED_PIGLIN_SPAWN_EGG("minecraft:zombified_piglin_spawn_egg"),
    ;
    public static final int SIZE = values().length;
    private static final Map<String, ItemType> BY_ID;
    private static final Map<NamespacedKey, ItemType> BY_NAMESPACED_KEY;
    public static final Registry<ItemType> REGISTRY = new Registry<>() {
        @Override
        public @NotNull Iterator<ItemType> iterator() {
            return BY_ID.values().iterator();
        }

        @Override
        public @Nullable ItemType get(@NotNull NamespacedKey namespacedKey) {
            return BY_NAMESPACED_KEY.get(namespacedKey);
        }
    };
    private final String id;
    private final NamespacedKey key;

    ItemType(String id) {
        this.id = id;
        key = NamespacedKey.fromString(id);
    }

    public String id() {
        return id;
    }

    public static ItemType getById(String id) {
        return BY_ID.get(id);
    }

    public int getProtocolId(int version) {
         return Mappings.getItemId(this, version);
    }

    public boolean isAir(){
        return this == AIR;
    }

    static {
        Map<String, ItemType> by_id = new HashMap<>();
        BY_NAMESPACED_KEY = new HashMap<>();
        for (ItemType value : values()) {
            by_id.put(value.id, value);
            BY_NAMESPACED_KEY.put(value.key, value);
        }
        BY_ID = Collections.unmodifiableMap(by_id);
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }
}
