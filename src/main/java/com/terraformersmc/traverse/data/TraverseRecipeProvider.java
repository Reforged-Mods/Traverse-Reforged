package com.terraformersmc.traverse.data;

import com.terraformersmc.terraform.utils.TerraformRecipeProvider;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class TraverseRecipeProvider extends TerraformRecipeProvider {
	public TraverseRecipeProvider(DataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	protected void generate(Consumer<RecipeJsonProvider> exporter) {
		offerBoatRecipe(exporter, TraverseBoatTypes.FIR_BOAT, TraverseBlocks.FIR_PLANKS);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, TraverseBoatTypes.FIR_CHEST_BOAT).input(Blocks.CHEST).input(TraverseBoatTypes.FIR_BOAT).group("chest_boat").criterion("has_boat", conditionsFromTag(ItemTags.BOATS)).offerTo(exporter);

		offerSingleOutputShapelessRecipe(exporter, TraverseBlocks.FIR_BUTTON, TraverseBlocks.FIR_PLANKS, "wooden_button");

		createDoorRecipe(TraverseBlocks.FIR_DOOR, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createFenceRecipe(TraverseBlocks.FIR_FENCE, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createFenceGateRecipe(TraverseBlocks.FIR_FENCE_GATE, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		offerHangingSignRecipe(exporter, TraverseItems.FIR_HANGING_SIGN, TraverseBlocks.STRIPPED_FIR_LOG);

		offerPlanksRecipe(exporter, TraverseBlocks.FIR_PLANKS, TraverseItemTags.FIR_LOGS, 4);

		offerPressurePlateRecipe(exporter, TraverseBlocks.FIR_PRESSURE_PLATE, TraverseBlocks.FIR_PLANKS);

		createSignRecipe(TraverseItems.FIR_SIGN, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TraverseBlocks.FIR_SLAB, TraverseBlocks.FIR_PLANKS);

		createStairsRecipe(TraverseBlocks.FIR_STAIRS, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createTrapdoorRecipe(TraverseBlocks.FIR_TRAPDOOR, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		new ShapedRecipeJsonBuilder(RecipeCategory.BUILDING_BLOCKS, TraverseBlocks.FIR_WOOD, 3)
			.group("bark")
			.pattern("LL")
			.pattern("LL")
			.input('L', TraverseBlocks.FIR_LOG)
			.criterion("has_logs", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_LOG))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_wood"));

		new ShapedRecipeJsonBuilder(RecipeCategory.BUILDING_BLOCKS, TraverseBlocks.STRIPPED_FIR_WOOD, 3)
			.group("bark")
			.pattern("LL")
			.pattern("LL")
			.input('L', TraverseBlocks.STRIPPED_FIR_LOG)
			.criterion("has_logs", InventoryChangedCriterion.Conditions.items(TraverseBlocks.STRIPPED_FIR_LOG))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "stripped_fir_wood"));
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return new Identifier(Traverse.MOD_ID, identifier.getPath());
	}
}
