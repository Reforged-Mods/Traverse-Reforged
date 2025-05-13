package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.data.DataGenerator;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Traverse.MOD_ID + "_common", bus = Mod.EventBusSubscriber.Bus.MOD)
public class TraverseDatagen {
	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper, CompletableFuture<WrapperLookup> lookup) {
		dataGenerator.addProvider(true, new TraverseBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(true, new TraverseLootTableProvider(dataGenerator));
		BlockTagProvider provider = new TraverseBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(true, provider);
		dataGenerator.addProvider(true, new TraverseItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(true, new TraverseRecipeProvider(dataGenerator));
		dataGenerator.addProvider(true, new TraverseDatapackBuiltinEntriesProvider(dataGenerator.getPackOutput(), lookup))
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper(), event.getLookupProvider());
	}
}
