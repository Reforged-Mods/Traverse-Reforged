package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

import static com.terraformersmc.traverse.feature.TraverseConfiguredFeatures.register;

public class TraversePlacedFeatures {
	/* Shrubs */
	public static final RegistryKey<PlacedFeature> DESERT_EXTRA_CACTUS = createRegistryKey("desert_extra_cactus");
	public static final RegistryKey<PlacedFeature> DESERT_SHRUBS = createRegistryKey("desert_shrubs");

	/* Autumnal Trees */
	static final RegistryKey<PlacedFeature> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	static final RegistryKey<PlacedFeature> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	static final RegistryKey<PlacedFeature> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	static final RegistryKey<PlacedFeature> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");
	static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMNAL_TREES_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("autumnal_trees");
	public static final RegistryKey<PlacedFeature> AUTUMNAL_TREES = createRegistryKey("autumnal_trees");

	/* Fir Trees */
	public static final RegistryKey<PlacedFeature> CONIFEROUS_TREES = createRegistryKey("coniferous_trees");

	/* Swamp Trees */
	public static final RegistryKey<PlacedFeature> LUSH_SWAMP_TREES = createRegistryKey("lush_swamp_trees");
	static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_FUNGUS_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("swamp_fungus");
	public static final RegistryKey<PlacedFeature> SWAMP_FUNGUS = createRegistryKey("swamp_fungus");

	/* Lush Vegetation */
	public static final RegistryKey<PlacedFeature> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<PlacedFeature> FLATLANDS_TREES = createRegistryKey("flatlands_trees");
	public static final RegistryKey<PlacedFeature> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	/* Woodlands */
	static final RegistryKey<PlacedFeature> WOODLANDS_SHRUB = createRegistryKey("woodlands_shrub");
	static final RegistryKey<PlacedFeature> WOODLANDS_FALLEN_LOG = createRegistryKey("woodlands_fallen_log");
	static final RegistryKey<ConfiguredFeature<?, ?>> WOODLANDS_TREES_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("woodlands_trees");
	public static final RegistryKey<PlacedFeature> WOODLANDS_TREES = createRegistryKey("woodlands_trees");

	public static void populate(Registerable<PlacedFeature> context) {
		/* Shrubs */
		context.register(DESERT_EXTRA_CACTUS, placeFeature(context, VegetationConfiguredFeatures.PATCH_CACTUS, RarityFilterPlacementModifier.of(13), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP));
		context.register(DESERT_SHRUBS, placeFeature(context, TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Autumnal Trees */
		context.register(BROWN_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE));
		context.register(ORANGE_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE));
		context.register(RED_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.RED_AUTUMNAL_TREE));
		context.register(YELLOW_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE));

		context.register(AUTUMNAL_TREES, placeFeature(context, AUTUMNAL_TREES_CONFIGURED, PlacedFeatures.createCountExtraModifier(10, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Fir Trees */
		context.register(CONIFEROUS_TREES, placeFeature(context, TraverseConfiguredFeatures.FIR_TREE, PlacedFeatures.createCountExtraModifier(7, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Swamp Trees */
		context.register(LUSH_SWAMP_TREES, placeFeature(context, TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacedFeatures.createCountExtraModifier(2, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, SurfaceWaterDepthFilterPlacementModifier.of(3), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		context.register(SWAMP_FUNGUS, placeFeature(context, SWAMP_FUNGUS_CONFIGURED, PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Lush Vegetation */
		context.register(FLATLANDS_GRASS, placeFeature(context, TraverseConfiguredFeatures.FLATLANDS_GRASS, VegetationPlacedFeatures.modifiers(15)));
		context.register(FLATLANDS_TREES, placeFeature(context, TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.createCountExtraModifier(0, 0.2F, 1), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));
		context.register(LUSH_FLOWERS, placeFeature(context, TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilterPlacementModifier.of(32), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Woodlands */
		context.register(WOODLANDS_SHRUB, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.OAK_SHRUB));
		context.register(WOODLANDS_FALLEN_LOG, placeFeatureWithoutBiomeFilter(context, TraverseConfiguredFeatures.FALLEN_OAK_TREE));

		context.register(WOODLANDS_TREES, placeFeature(context, WOODLANDS_TREES_CONFIGURED, CountPlacementModifier.of(7), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));
	}



	public static RegistryKey<PlacedFeature> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	private static PlacedFeature placeFeature(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		list.add(BiomePlacementModifier.of());
		return placeFeature(entries, feature, list);

	}

	private static PlacedFeature placeFeatureWithoutBiomeFilter(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		return placeFeature(entries, feature, list);
	}

	private static PlacedFeature placeFeature(Registerable<PlacedFeature> entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
		return new PlacedFeature(entries.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(feature), list);
	}

	public static void register() {
		// This just creates the registry keys.  Placed Features are requested and consumed by datagen now.
	}
}
