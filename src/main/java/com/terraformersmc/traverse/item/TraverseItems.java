package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraftforge.registries.ForgeRegistries;

import static com.terraformersmc.traverse.block.TraverseBlocks.FIR_WALL_HANGING_SIGN;
import static com.terraformersmc.traverse.block.TraverseBlocks.FIR_WALL_SIGN;

public class TraverseItems {
	public static final Item FIR_SIGN = TraverseItems.add("fir_sign", new SignItem(new Item.Settings().maxCount(16), TraverseBlocks.FIR_SIGN, FIR_WALL_SIGN));
	public static final Item FIR_HANGING_SIGN = TraverseItems.add("fir_hanging_sign", new HangingSignItem(TraverseBlocks.FIR_HANGING_SIGN, FIR_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
	public static <I extends Item> I add(String name, I item) {
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}

		ForgeRegistries.ITEMS.register(Identifier.of(Traverse.MOD_ID, name), item);
		return item;
	}

	public static void register() {	}
}
