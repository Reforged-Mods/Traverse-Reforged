package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static com.terraformersmc.traverse.block.TraverseBlocks.FIR_WALL_HANGING_SIGN;
import static com.terraformersmc.traverse.block.TraverseBlocks.FIR_WALL_SIGN;

public class TraverseItems {
	public static final List<Item> ITEMS = new ArrayList<>();
	public static Item FIR_SIGN;
	public static Item FIR_HANGING_SIGN;
	public static <I extends Item> I add(String name, I item) {
		ForgeRegistries.ITEMS.register(Identifier.of(Traverse.MOD_ID, name), item);
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}
		ITEMS.add(item);
		return item;
	}

	public static void register() {
		FIR_SIGN = TraverseItems.add("fir_sign", new SignItem(new Item.Settings().maxCount(16), TraverseBlocks.FIR_SIGN, FIR_WALL_SIGN));
		FIR_HANGING_SIGN = TraverseItems.add("fir_hanging_sign", new HangingSignItem(TraverseBlocks.FIR_HANGING_SIGN, FIR_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
	}
}
