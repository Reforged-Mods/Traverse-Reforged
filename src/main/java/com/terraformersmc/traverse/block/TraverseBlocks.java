package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.utils.TerraformBlockSettings;
import com.terraformersmc.terraform.utils.TerraformFuelRegistry;
import com.terraformersmc.terraform.utils.mixin.FireBlockAccessor;
import com.terraformersmc.terraform.wood.StrippableBlockRegistry;
import com.terraformersmc.terraform.wood.block.*;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.sapling.TraverseSaplingGenerator;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.item.TraverseItems;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class TraverseBlocks {
	public static final List<Block> BLOCKS = new ArrayList<>();

	public static final Block RED_AUTUMNAL_LEAVES = withItem("red_autumnal_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block RED_AUTUMNAL_SAPLING = withItem("red_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.RED_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_RED)));
	public static final Block BROWN_AUTUMNAL_LEAVES = withItem("brown_autumnal_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_BROWN).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block BROWN_AUTUMNAL_SAPLING = withItem("brown_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_BROWN)));
	public static final Block ORANGE_AUTUMNAL_LEAVES = withItem("orange_autumnal_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_ORANGE).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block ORANGE_AUTUMNAL_SAPLING = withItem("orange_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_ORANGE)));
	public static final Block YELLOW_AUTUMNAL_LEAVES = withItem("yellow_autumnal_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_YELLOW).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block YELLOW_AUTUMNAL_SAPLING = withItem("yellow_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_YELLOW)));

	public static final Block FIR_LEAVES = withItem("fir_leaves", new LeavesBlock(TerraformBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block FIR_SAPLING = withItem("fir_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.FIR_TREE), TerraformBlockSettings.copyOf(Blocks.OAK_SAPLING)));


	public static BlockSetType FIR_SET = new BlockSetType(Traverse.MOD_ID + ":fir");
	public static WoodType FIR_WOOD_TYPE = WoodType.register(new WoodType(Traverse.MOD_ID + ":fir", FIR_SET));
	public static final Block FIR_LOG = withItem("fir_log", PillarLogHelper.of(MapColor.OAK_TAN, MapColor.BROWN));
	public static final Block FIR_WOOD = withItem("fir_wood", PillarLogHelper.of(MapColor.BROWN));
	public static final Block STRIPPED_FIR_LOG = withItem("stripped_fir_log", PillarLogHelper.of(MapColor.OAK_TAN));
	public static final Block STRIPPED_FIR_WOOD = withItem("stripped_fir_wood", PillarLogHelper.of(MapColor.OAK_TAN));
	public static final Block FIR_PLANKS = withItem("fir_planks", new Block(TerraformBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block FIR_SLAB = withItem("fir_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block FIR_PRESSURE_PLATE = withItem("fir_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, TerraformBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), FIR_SET));
	public static final Block FIR_FENCE = withItem("fir_fence", new FenceBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block FIR_TRAPDOOR = withItem("fir_trapdoor", new TrapdoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), FIR_SET));
	public static final Block FIR_FENCE_GATE = withItem("fir_fence_gate", new FenceGateBlock(TerraformBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), FIR_WOOD_TYPE));
	public static final Block FIR_STAIRS = withItem("fir_stairs", new StairsBlock(FIR_PLANKS::getDefaultState, TerraformBlockSettings.copyOf(Blocks.OAK_STAIRS)));
	public static final Block FIR_BUTTON = withItem("fir_button", new ButtonBlock(TerraformBlockSettings.copyOf(Blocks.OAK_BUTTON), FIR_SET, 30, true));
	public static final Block FIR_DOOR = withItem("fir_door", new DoorBlock(TerraformBlockSettings.copyOf(Blocks.OAK_DOOR), FIR_SET));
	public static final SignBlock FIR_SIGN = add("fir_sign", new TerraformSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_SIGN), FIR_WOOD_TYPE));
	public static final Block FIR_WALL_SIGN = add("fir_wall_sign", new TerraformWallSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), FIR_WOOD_TYPE));
	public static final Block FIR_HANGING_SIGN = add("fir_hanging_sign", new TerraformHangingSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN), FIR_WOOD_TYPE));
	public static final Block FIR_WALL_HANGING_SIGN = add("fir_wall_hanging_sign", new TerraformWallHangingSignBlock(TerraformBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(FIR_HANGING_SIGN), FIR_WOOD_TYPE));
	public static final Item FIR_SIGN_ITEM = TraverseItems.add("fir_sign", new SignItem(new Item.Settings().maxCount(16), FIR_SIGN, FIR_WALL_SIGN));

	public static final Block POTTED_RED_AUTUMNAL_SAPLING = add("potted_red_autumnal_sapling", new FlowerPotBlock(RED_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_BROWN_AUTUMNAL_SAPLING = add("potted_brown_autumnal_sapling", new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_ORANGE_AUTUMNAL_SAPLING = add("potted_orange_autumnal_sapling", new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_YELLOW_AUTUMNAL_SAPLING = add("potted_yellow_autumnal_sapling", new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_FIR_SAPLING = add("potted_fir_sapling", new FlowerPotBlock(FIR_SAPLING, TerraformBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

	private static <B extends Block> B withItem(String name, B block) {
		add(name, block);
		TraverseItems.add(name, new BlockItem(block, new Item.Settings()));

		return block;
	}

	private static <B extends Block> B add(String name, B block) {
		ForgeRegistries.BLOCKS.register(Identifier.of(Traverse.MOD_ID, name), block);
		BLOCKS.add(block);
		return block;
	}

	public static void register() {
		addCompostables();
		addFlammables();
		addFuels();
		addStrippables();
	}

	private static void addCompostables() {
		float LEAVES_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.OAK_LEAVES);
		float SAPLING_CHANCE = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.getFloat(Items.OAK_SAPLING);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(FIR_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(FIR_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BROWN_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BROWN_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ORANGE_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ORANGE_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(RED_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(RED_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(YELLOW_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(YELLOW_AUTUMNAL_SAPLING, SAPLING_CHANCE);
	}

	private static void addFlammables() {
		FireBlockAccessor block = (FireBlockAccessor) Blocks.FIRE;
		block.invokeRegisterFlammableBlock(FIR_PLANKS, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_SLAB, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_FENCE_GATE, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_FENCE, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_STAIRS, 5, 20);
		block.invokeRegisterFlammableBlock(FIR_LOG, 5, 5);
		block.invokeRegisterFlammableBlock(STRIPPED_FIR_LOG, 5, 5);
		block.invokeRegisterFlammableBlock(STRIPPED_FIR_WOOD, 5, 5);
		block.invokeRegisterFlammableBlock(FIR_WOOD, 5, 5);
		block.invokeRegisterFlammableBlock(FIR_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(RED_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(BROWN_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(ORANGE_AUTUMNAL_LEAVES, 30, 60);
		block.invokeRegisterFlammableBlock(YELLOW_AUTUMNAL_LEAVES, 30, 60);
	}

	private static void addFuels() {
		TerraformFuelRegistry.addFuel(FIR_FENCE, 300);
		TerraformFuelRegistry.addFuel(FIR_FENCE_GATE, 300);
	}

	private static void addStrippables() {
		StrippableBlockRegistry.register(FIR_LOG, STRIPPED_FIR_LOG);
		StrippableBlockRegistry.register(FIR_WOOD, STRIPPED_FIR_WOOD);
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}

	public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
}
