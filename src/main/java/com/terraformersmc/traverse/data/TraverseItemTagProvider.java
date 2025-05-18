package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TraverseItemTagProvider extends ItemTagProvider {
	public TraverseItemTagProvider(DataOutput dataOutput, CompletableFuture<WrapperLookup> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataOutput, completableFuture, completableFuture2, Traverse.MOD_ID, existingFileHelper);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		this.getOrCreateTagBuilder(ItemTags.BOATS)
			.add(TraverseBoatTypes.FIR_BOAT);

		this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
			.add(TraverseBoatTypes.FIR_CHEST_BOAT);

		copy(BlockTags.LEAVES, ItemTags.LEAVES);

		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);

		copy(TraverseBlockTags.FIR_LOGS, TraverseItemTags.FIR_LOGS);

		copy(TraverseBlockTags.PLANKS_THAT_BURN, TraverseItemTags.PLANKS_THAT_BURN);

		copy(TraverseBlockTags.STRIPPED_LOGS, TraverseItemTags.STRIPPED_LOGS);

		copy(TraverseBlockTags.STRIPPED_WOOD, TraverseItemTags.STRIPPED_WOOD);
	}
}
