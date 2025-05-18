package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.item.ItemGroup;
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
			event.addAll(Stream.of(FIR_LOG, FIR_WOOD, STRIPPED_FIR_LOG, STRIPPED_FIR_WOOD, FIR_PLANKS, FIR_STAIRS, FIR_SLAB,
				FIR_FENCE, FIR_FENCE_GATE, FIR_DOOR, FIR_TRAPDOOR, FIR_PRESSURE_PLATE, FIR_BUTTON).map(ItemStack::new).toList());
		}
		if (event.getTabKey() == ItemGroups.NATURAL){
			event.addAll(Stream.of(FIR_LOG, BROWN_AUTUMNAL_SAPLING, ORANGE_AUTUMNAL_SAPLING, RED_AUTUMNAL_SAPLING, YELLOW_AUTUMNAL_SAPLING, FIR_SAPLING).map(ItemStack::new).toList());
		}
	}
}
