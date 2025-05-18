package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.vanilla.VanillaBiomeTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TraverseBiomeTagProvider extends VanillaBiomeTagProvider {
	public TraverseBiomeTagProvider(DataOutput arg, CompletableFuture<WrapperLookup> completableFuture, ExistingFileHelper helper) {
		super(arg, completableFuture, Traverse.MOD_ID, helper);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		/*
		 * Vanilla biome categories
		 */
		this.getOrCreateTagBuilder(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());

		this.getOrCreateTagBuilder(BiomeTags.IS_FOREST)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS.getValue())
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(BiomeTags.IS_TAIGA)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue());

		this.getOrCreateTagBuilder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue());

		this.getOrCreateTagBuilder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue());

		this.getOrCreateTagBuilder(BiomeTags.WATER_ON_MAP_OUTLINES)
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());


		/*
		 * Conventional biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_temperate")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS.getValue())
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SANDY)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_PLAINS)
			.addOptional(TraverseBiomes.FLATLANDS.getValue());

		this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS.getValue())
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue())
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SNOWY)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SWAMP)
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());

		this.getOrCreateTagBuilder(Tags.Biomes.IS_CONIFEROUS)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue());

		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_deciduous")))
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS.getValue())
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());


		/*
		 * Biome structure generation tags
		 */
		this.getOrCreateTagBuilder(BiomeTags.IGLOO_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue());

		this.getOrCreateTagBuilder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());

		this.getOrCreateTagBuilder(BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue());

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());

		this.getOrCreateTagBuilder(BiomeTags.STRONGHOLD_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.AUTUMNAL_WOODS.getValue())
			.addOptional(TraverseBiomes.CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue())
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue())
			.addOptional(TraverseBiomes.SNOWY_CONIFEROUS_FOREST.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());

		this.getOrCreateTagBuilder(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.LUSH_SWAMP.getValue());

		this.getOrCreateTagBuilder(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.DESERT_SHRUBLAND.getValue());

		this.getOrCreateTagBuilder(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE)
			.addOptional(TraverseBiomes.FLATLANDS.getValue())
			.addOptional(TraverseBiomes.WOODLANDS.getValue());
	}
}
