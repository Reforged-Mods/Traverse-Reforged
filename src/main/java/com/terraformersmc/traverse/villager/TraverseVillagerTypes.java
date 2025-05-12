package com.terraformersmc.traverse.villager;

import com.terraformersmc.terraform.utils.mixin.VillagerTypeAccessor;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;

import java.util.Objects;

public class TraverseVillagerTypes extends TraverseBiomes {
	public static void register() {
		register(VillagerType.PLAINS, AUTUMNAL_WOODS);
		register(VillagerType.PLAINS, CONIFEROUS_FOREST);
		register(VillagerType.DESERT, DESERT_SHRUBLAND);
		register(VillagerType.SWAMP, LUSH_SWAMP);
		register(VillagerType.PLAINS, FLATLANDS);
		register(VillagerType.TAIGA, SNOWY_CONIFEROUS_FOREST);
		register(VillagerType.PLAINS, WOODLANDS);
	}

	@SafeVarargs
	private static void register(VillagerType type, RegistryKey<Biome>... biomes) {
		for (RegistryKey<Biome> biome : biomes) {
			addVillagerTypeToBiome(biome, type);
		}
	}

	public static void addVillagerTypeToBiome(RegistryKey<Biome> biomeKey, VillagerType villagerType) {
		Objects.requireNonNull(biomeKey, "Biome registry key cannot be null");
		Objects.requireNonNull(villagerType, "Villager type cannot be null");

		if (VillagerTypeAccessor.getBiomeTypeToIdMap().put(biomeKey, villagerType) != null) {
			Traverse.LOGGER.debug("Overriding existing Biome -> VillagerType registration for Biome {}", biomeKey.getValue().toString());
		}
	}
}
