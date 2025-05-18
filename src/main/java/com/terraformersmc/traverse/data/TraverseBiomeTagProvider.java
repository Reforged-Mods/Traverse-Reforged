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
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(BiomeTags.IS_FOREST)
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(BiomeTags.IS_TAIGA)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(BiomeTags.WATER_ON_MAP_OUTLINES)
			.add(TraverseBiomes.LUSH_SWAMP);


		/*
		 * Conventional biome categories
		 */
		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_temperate")))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SANDY)
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(Tags.Biomes.IS_PLAINS)
			.add(TraverseBiomes.FLATLANDS);

		this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SNOWY)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(Tags.Biomes.IS_SWAMP)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(Tags.Biomes.IS_CONIFEROUS)
			.add(TraverseBiomes.CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(TagKey.of(this.registryRef, new Identifier("forge", "is_deciduous")))
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.WOODLANDS);


		/*
		 * Biome structure generation tags
		 */
		this.getOrCreateTagBuilder(BiomeTags.IGLOO_HAS_STRUCTURE)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST);

		this.getOrCreateTagBuilder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(BiomeTags.PILLAGER_OUTPOST_HAS_STRUCTURE)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_DESERT_HAS_STRUCTURE)
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_SWAMP_HAS_STRUCTURE)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(BiomeTags.STRONGHOLD_HAS_STRUCTURE)
			.add(TraverseBiomes.AUTUMNAL_WOODS)
			.add(TraverseBiomes.CONIFEROUS_FOREST)
			.add(TraverseBiomes.DESERT_SHRUBLAND)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.LUSH_SWAMP)
			.add(TraverseBiomes.SNOWY_CONIFEROUS_FOREST)
			.add(TraverseBiomes.WOODLANDS);

		this.getOrCreateTagBuilder(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
			.add(TraverseBiomes.LUSH_SWAMP);

		this.getOrCreateTagBuilder(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
			.add(TraverseBiomes.DESERT_SHRUBLAND);

		this.getOrCreateTagBuilder(BiomeTags.VILLAGE_PLAINS_HAS_STRUCTURE)
			.add(TraverseBiomes.FLATLANDS)
			.add(TraverseBiomes.WOODLANDS);
	}
}
