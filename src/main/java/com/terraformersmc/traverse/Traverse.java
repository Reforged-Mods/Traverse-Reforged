package com.terraformersmc.traverse;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.client.TraverseClient;
import com.terraformersmc.traverse.config.TraverseConfigManager;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import com.terraformersmc.traverse.feature.placer.TraversePlacerTypes;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.villager.TraverseVillagerTypes;
import com.terraformersmc.traverse.worldgen.TraverseWorldgen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Mod(Traverse.MOD_ID)
public class Traverse {
	public static final String MOD_ID = "traverse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final TraverseConfigManager CONFIG_MANAGER = new TraverseConfigManager();

	private static Boolean initialized = false;
	public static ItemGroup itemGroup;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	public Traverse(){
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::commonLoad);
		eventBus.register(this);
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TraverseClient::new);
		new TraverseWorldgen();
	}

	@SubscribeEvent
	public void onRegister(final RegisterEvent event){
		if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCKS) {
			onInitialize();
		}
	}

	private void commonLoad(FMLCommonSetupEvent event){
		runnables.forEach(event::enqueueWork);
	}

	private static void register() {
		TraverseBlocks.register();
		TraverseItems.register();
		TraverseBoatTypes.register();
		TraverseConfiguredFeatures.register();
		TraversePlacedFeatures.register();
		TraverseBiomes.register();
		TraverseVillagerTypes.register();
		TraversePlacerTypes.register();

		// This must be after TraverseBiomes.init()
		CONFIG_MANAGER.getBiomeConfig();

		itemGroup = new ItemGroup(MOD_ID + ".items") {

			@Override
			public void appendStacks(DefaultedList<ItemStack> stacks) {
				super.appendStacks(stacks);
				Registry.ITEM.forEach(item -> {
					if (Registry.ITEM.getId(item).getNamespace().equals(MOD_ID)) {
						item.appendStacks(item.getGroup(), stacks);
					}
				});
			}

			@Override
			public ItemStack createIcon() {
				return new ItemStack(TraverseBlocks.FIR_SAPLING.asItem());
			}
		};
	}

	public void onInitialize() {
		register();

		if (!ModList.get().isLoaded("traverse_worldgen")) {
			Traverse.LOGGER.info("No Traverse worldgen module present; Traverse biomes will not generate.");
		}

		// At this point Traverse is completely initialized.
		initialized = true;
	}

	public static void callbackWhenInitialized(Runnable callback) {
		if (initialized) {
			callback.run();
		} else {
			runnables.add(callback);
		}
	}

	public static TraverseConfigManager getConfigManager() {
		return CONFIG_MANAGER;
	}
}
