package com.terraformersmc.traverse.feature;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomBooleanFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.SimpleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.TreePlacedFeatures;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

import static com.terraformersmc.traverse.feature.TraversePlacedFeatures.*;

public class TraverseConfiguredFeatures {

	/* Logs and Shrubs */
	static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = createRegistryKey("fallen_oak_tree");
	static final RegistryKey<ConfiguredFeature<?, ?>> OAK_SHRUB = createRegistryKey("oak_shrub");

	/* Autumnal Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");

	/* Fir Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FIR_TREE = createRegistryKey("fir_tree");

	/* Swamp Trees */
	static final RegistryKey<ConfiguredFeature<?, ?>> TALL_SWAMP_TREE = createRegistryKey("tall_swamp_tree");

	/* Lush Vegetation */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	public static void populate(Registerable<ConfiguredFeature<?, ?>> context) {
		/* Logs and Shrubs */
		context.register(FALLEN_OAK_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG));
		context.register(OAK_SHRUB, configureFeature(Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG));

		/* Autumnal Trees */
		context.register(BROWN_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG));
		context.register(ORANGE_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG));
		context.register(RED_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG));
		context.register(YELLOW_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG));

		context.register(AUTUMNAL_TREES_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
			Feature.SIMPLE_RANDOM_SELECTOR,
			new SimpleRandomFeatureConfig(
				RegistryEntryList.of(
					context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TraversePlacedFeatures.BROWN_AUTUMNAL_TREE),
					context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TraversePlacedFeatures.ORANGE_AUTUMNAL_TREE),
					context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TraversePlacedFeatures.RED_AUTUMNAL_TREE),
					context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TraversePlacedFeatures.YELLOW_AUTUMNAL_TREE),
					context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TreePlacedFeatures.OAK_CHECKED)
				)
			)
		));
		/* Fir Trees */
		context.register(FIR_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG));

		/* Swamp Trees */
		context.register(TALL_SWAMP_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG));

		context.register(TraversePlacedFeatures.SWAMP_FUNGUS_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
			Feature.RANDOM_BOOLEAN_SELECTOR,
			new RandomBooleanFeatureConfig(
				PlacedFeatures.createEntry(context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM)),
				PlacedFeatures.createEntry(context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM))
			)
		));

		/* Lush Vegetation */
		context.register(FLATLANDS_GRASS, configureFeature(Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS)), List.of(), 32)));
		context.register(LUSH_FLOWERS, configureFeature(Feature.FLOWER, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG));
		context.register(TraversePlacedFeatures.WOODLANDS_TREES_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
			Feature.RANDOM_SELECTOR,
			new RandomFeatureConfig(
				ImmutableList.of(
					new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WOODLANDS_SHRUB), 0.2F),
					new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WOODLANDS_FALLEN_LOG), 0.3F)
				), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TreePlacedFeatures.OAK_CHECKED)
			)
		));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	public static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, ?> configureFeature(F feature, FC config) {
		return new ConfiguredFeature<>(feature, config);
	}

	public static void register() {
		// This just creates the registry keys.  Configured Features are requested and consumed by datagen now.
	}
}
