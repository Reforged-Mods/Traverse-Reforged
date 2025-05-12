package com.terraformersmc.traverse.worldgen;


import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biomegen.TraverseBiolithGeneration;
import com.terraformersmc.traverse.biomegen.TraverseTerraBlenderGeneration;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

public class TraverseWorldgen {
	public TraverseWorldgen(){
		onInitialize();
	}

	public void onInitialize() {

		if (ModList.get().isLoaded("biolith")) {
			Traverse.LOGGER.info("Enabling Traverse's Biolith worldgen module.");
			Traverse.callbackWhenInitialized(new TraverseBiolithGeneration());
		} else {
			Traverse.LOGGER.warn("Traverse world generation disabled; Biolith is not present.");
		}
	}
}
