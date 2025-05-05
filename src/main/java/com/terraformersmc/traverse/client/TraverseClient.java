package com.terraformersmc.traverse.client;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class TraverseClient {

	public TraverseClient(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerTextures);
		registerEntityRenderers();
	}

	private void clientSetup(FMLClientSetupEvent event){
		onInitializeClient();
	}

	public void onInitializeClient() {
		registerRenderLayers();
	}

	private static void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayers(new Identifier(Traverse.MOD_ID, "fir"));
	}

	private static void registerRenderLayers() {
		RenderLayer cutout = RenderLayer.getCutout();
		addArrayToLayer(cutout, TraverseBlocks.FIR_SAPLING, TraverseBlocks.FIR_DOOR, TraverseBlocks.FIR_TRAPDOOR);
		addArrayToLayer(cutout, TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);
		addArrayToLayer(cutout, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING);
	}

	private void registerTextures(TextureStitchEvent.Pre event) {
		if (event.getAtlas().equals(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE)){
			TexturedRenderLayers.addWoodType(TraverseBlocks.FIR_SIGN_TYPE);
			event.addSprite(new Identifier(Traverse.MOD_ID, "entity/sign/fir"));
		}
	}

	public static void addArrayToLayer(RenderLayer layer, Block... blocks){
		for (Block block : blocks) {
			RenderLayers.setRenderLayer(block, layer);
		}
	}
}
