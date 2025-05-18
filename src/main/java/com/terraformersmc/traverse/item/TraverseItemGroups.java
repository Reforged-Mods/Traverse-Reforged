package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroup.StackVisibility;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;
import java.util.stream.Stream;

import static com.terraformersmc.traverse.block.TraverseBlocks.*;

public class TraverseItemGroups {
	public static ItemGroup TRAVERSE_ITEM_GROUP = ItemGroup.builder()
		.displayName(Text.translatable("itemGroup.traverse.items"))
		.icon(() -> new ItemStack(TraverseBlocks.FIR_SAPLING))
		.entries((displayContext, entries) -> {
			entries.addAll(TraverseItems.ITEMS.stream().map(ItemStack::new).toList());
			entries.add(TraverseBoatTypes.FIR_BOAT);
			entries.add(TraverseBoatTypes.FIR_CHEST_BOAT);
		}).build();

	public static void register() {
		Registry.register(Registries.ITEM_GROUP, Identifier.of(Traverse.MOD_ID, "items"), TRAVERSE_ITEM_GROUP);
	}

	public static void onCreativeTabPopulate(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == ItemGroups.BUILDING_BLOCKS){
			List<Block> list = List.of(FIR_LOG, FIR_WOOD, STRIPPED_FIR_LOG, STRIPPED_FIR_WOOD, FIR_PLANKS, FIR_STAIRS, FIR_SLAB,
				FIR_FENCE, FIR_FENCE_GATE, FIR_DOOR, FIR_TRAPDOOR, FIR_PRESSURE_PLATE, FIR_BUTTON);
			for (int i = list.size() - 1; i >= 0; i--) {
				event.getEntries().putAfter(new ItemStack(Items.CHERRY_BUTTON), new ItemStack(list.get(i)), StackVisibility.PARENT_AND_SEARCH_TABS);
			}
		}
		if (event.getTabKey() == ItemGroups.NATURAL){
			final ItemStack NATURAL_LEAVES = Items.FLOWERING_AZALEA_LEAVES.getDefaultStack();
			final ItemStack NATURAL_SAPLING = Items.CHERRY_SAPLING.getDefaultStack();
			event.getEntries().putAfter(new ItemStack(Blocks.CHERRY_LOG), new ItemStack(FIR_LOG), StackVisibility.PARENT_AND_SEARCH_TABS);
			List<Block> list = List.of(BROWN_AUTUMNAL_SAPLING, ORANGE_AUTUMNAL_SAPLING, RED_AUTUMNAL_SAPLING, YELLOW_AUTUMNAL_SAPLING, FIR_SAPLING);
			for (int i = list.size() - 1; i >= 0; i--) {
				event.getEntries().putAfter(NATURAL_SAPLING, new ItemStack(list.get(i)), StackVisibility.PARENT_AND_SEARCH_TABS);
			}
			list = List.of(BROWN_AUTUMNAL_LEAVES, ORANGE_AUTUMNAL_LEAVES, RED_AUTUMNAL_LEAVES, YELLOW_AUTUMNAL_LEAVES, FIR_LEAVES);
			for (int i = list.size() - 1; i >= 0; i--) {
				event.getEntries().putAfter(NATURAL_LEAVES, new ItemStack(list.get(i)), StackVisibility.PARENT_AND_SEARCH_TABS);
			}
		}
		if (event.getTabKey() == ItemGroups.FUNCTIONAL){
			final ItemStack FUNCTIONAL_SIGN = Items.CHERRY_HANGING_SIGN.getDefaultStack();
			event.getEntries().putAfter(FUNCTIONAL_SIGN, new ItemStack(TraverseItems.FIR_HANGING_SIGN), StackVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(FUNCTIONAL_SIGN, new ItemStack(TraverseItems.FIR_SIGN), StackVisibility.PARENT_AND_SEARCH_TABS);
		}
		if (event.getTabKey() == ItemGroups.TOOLS){
			final ItemStack TOOLS_BOAT = Items.CHERRY_CHEST_BOAT.getDefaultStack();
			event.getEntries().putAfter(TOOLS_BOAT, new ItemStack(TraverseBoatTypes.FIR_CHEST_BOAT), StackVisibility.PARENT_AND_SEARCH_TABS);
			event.getEntries().putAfter(TOOLS_BOAT, new ItemStack(TraverseBoatTypes.FIR_BOAT), StackVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
