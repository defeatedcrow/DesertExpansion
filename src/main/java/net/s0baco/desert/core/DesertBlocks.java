package net.s0baco.desert.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.s0baco.desert.block.BlockCompressed;
import net.s0baco.desert.block.BlockDesertDiamondOre;
import net.s0baco.desert.block.BlockDesertGrass;
import net.s0baco.desert.block.BlockDesertGrass.ItemDesertGrass;
import net.s0baco.desert.block.BlockWetSand;
import net.s0baco.desert.block.chest.BlockSandstoneChest;
import net.s0baco.desert.block.chest.TileEntitySandstoneChest;
import net.s0baco.desert.block.furnace.BlockSandstoneFurnace;
import net.s0baco.desert.block.furnace.TileEntitySandstoneFurnace;
import cpw.mods.fml.common.registry.GameRegistry;

public class DesertBlocks
{
	/* Desert Expansion 	-start- */

	public static Block cactus_block;
	public static Block ceramic_block;
	public static Block advceramic_block;
	public static Block desert_diamond_block;

	public static Block wet_sand;
	public static Block sand_farmland;

	public static Block agave_crop;
	public static Block dragon_crop;
	public static Block papyrus_crop;

	public static Block desert_grass;
	public static Block desert_diamond_ore;

	public static Block sandstone_furnace;
	public static Block sandstone_furnace_burning;

	public static Block sandstone_chest;

	/* Desert Expansion 	- end - */

	public static void init()
	{
		sandstone_furnace = GameRegistry.registerBlock(new BlockSandstoneFurnace(false), "sandstone_furnace").setBlockName("sandstone_furnace");
		sandstone_furnace_burning = GameRegistry.registerBlock(new BlockSandstoneFurnace(true), "sandstone_furnace_burning").setBlockName("sandstone_furnace_burning");

		GameRegistry.registerTileEntity(TileEntitySandstoneFurnace.class, "tileEntitySandstoneFurnace");

		sandstone_chest = GameRegistry.registerBlock(new BlockSandstoneChest(6), "sandstone_chest").setBlockName("sandstone_chest").setHardness(2.5F).setStepSound(Block.soundTypeStone);

		GameRegistry.registerTileEntity(TileEntitySandstoneChest.class, "tileEntitySandstoneChest");

		/* World Generation */

		desert_grass = GameRegistry.registerBlock(new BlockDesertGrass(), ItemDesertGrass.class, "desert_grass").setBlockName("desert_grass");

		desert_diamond_ore = GameRegistry.registerBlock(new BlockDesertDiamondOre(Material.rock), "desert_diamond_ore").setBlockName("desert_diamond_ore").setBlockTextureName("desertexpansion:desert_diamond_ore");

		/* Normal Blocks */

		wet_sand = GameRegistry.registerBlock(new BlockWetSand(), "wet_sand").setBlockName("wet_sand").setBlockTextureName("desertexpansion:wet_sand");
//		sand_farmland = GameRegistry.registerBlock(new BlockSandFarmland(), "sand_farmland").setBlockName("sand_farmland").setBlockTextureName("desertexpansion:sand_farmland");

		/* Crops has gone... */



		/* Compressed Blocks */

		cactus_block = new BlockCompressed().setBlockName("cactus_block").setBlockTextureName("desertexpansion:cactus_block");
		cactus_block.setHardness(0.5F).setResistance(10F).setStepSound(Block.soundTypeCloth);
		cactus_block.setHarvestLevel("pickaxe", 1);
		cactus_block.setHarvestLevel("axe", 1);

		GameRegistry.registerBlock(cactus_block, "cactus_block");

		ceramic_block = new BlockCompressed().setBlockName("ceramic_block").setBlockTextureName("desertexpansion:ceramic_block");
		ceramic_block.setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
		ceramic_block.setHarvestLevel("pickaxe", 1);

		GameRegistry.registerBlock(ceramic_block, "ceramic_block");

		advceramic_block = new BlockCompressed().setBlockName("advceramic_block").setBlockTextureName("desertexpansion:advceramic_block");
		advceramic_block.setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
		advceramic_block.setHarvestLevel("pickaxe", 1);

		GameRegistry.registerBlock(advceramic_block, "advceramic_block");

		desert_diamond_block = new BlockCompressed().setBlockName("desert_diamond_block").setBlockTextureName("desertexpansion:desert_diamond_block");
		desert_diamond_block.setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
		desert_diamond_block.setHarvestLevel("pickaxe", 1);

		GameRegistry.registerBlock(desert_diamond_block, "desert_diamond_block");
	}
}
