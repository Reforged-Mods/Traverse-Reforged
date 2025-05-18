package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TraverseDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
	public static final RegistryBuilder BUILDER = new RegistryBuilder()
		.addRegistry(RegistryKeys.BIOME, TraverseBiomes::populate)
		.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TraverseConfiguredFeatures::populate)
		.addRegistry(RegistryKeys.PLACED_FEATURE, TraversePlacedFeatures::populate);
	public TraverseDatapackBuiltinEntriesProvider(DataOutput output, CompletableFuture<WrapperLookup> registries) {
		super(output, registries, BUILDER, Set.of(Traverse.MOD_ID, "minecraft"));
	}

}
