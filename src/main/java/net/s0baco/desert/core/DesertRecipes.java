package net.s0baco.desert.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.s0baco.desert.core.DesertUtil.RegisterUtil;
import cpw.mods.fml.common.registry.GameRegistry;

public class DesertRecipes
{
	public static void init()
	{
		/* Block Recipe */
		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.cactus_block),
				new Object[]
						{
							"XXX",
							"XXX",
							"XXX",

							'X', Blocks.cactus
						});

		RegisterUtil.addShapelessRecipe(new ItemStack(Blocks.cactus, 9), DesertBlocks.cactus_block);

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.ceramic_block),
				new Object[]
						{
							"XXX",
							"XXX",
							"XXX",

							'X', DesertItems.ceramic_ingot
						});

		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.ceramic_ingot, 9), DesertBlocks.ceramic_block);

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.advceramic_block),
				new Object[]
						{
							"XXX",
							"XXX",
							"XXX",

							'X', DesertItems.advceramic_ingot
						});

		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.advceramic_ingot, 9), DesertBlocks.advceramic_block);

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.desert_diamond_block),
				new Object[]
						{
							"XXX",
							"XXX",
							"XXX",

							'X', DesertItems.desert_diamond
						});

		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.desert_diamond, 9), DesertBlocks.desert_diamond_block);

		/* Material Recipe */
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 4), Blocks.cactus);


		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_stick, 4),
				new Object[]
						{
							"X",
							"X",

							'X', Blocks.cactus
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_straw, 1),
				new Object[]
						{
							"X",
							"X",

							'X', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_gel),
				new Object[]
						{
							"X",
							"Y",

							'X', DesertItems.cactus_straw,
							'Y', Blocks.cactus
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_material),
				new Object[]
						{
							" X ",
							"XYX",
							" X ",

							'X', Blocks.sand,
							'Y', DesertItems.cactus_gel
						});

		// Food

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_jelly),
				new Object[]
						{
							"X",
							"Y",

							'X', DesertItems.cactus_gel,
							'Y', Items.sugar
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_jelly),
				new Object[]
						{
							"X",
							"Y",

							'X', Items.sugar,
							'Y', DesertItems.cactus_gel
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_flesh, 3),
				new Object[]
						{
							"XXX",

							'X', Blocks.cactus
						});

		// Tool - Desert Shears
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_shears),
				new Object[]
						{
							"X ",
							" X",

							'X', DesertItems.advceramic_ingot
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_shears),
				new Object[]
						{
							" X",
							"X ",

							'X', DesertItems.advceramic_ingot
						});

		// Vanilla - Bucket
		RegisterUtil.addShapedRecipe(new ItemStack(Items.bucket),
				new Object[]
						{
							"X X",
							" X ",

							'X', DesertItems.advceramic_ingot
						});

		// Tool - Cactus
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_pickaxe),
				new Object[]
						{
							"XXX",
							" Y ",
							" Y ",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_axe),
				new Object[]
						{
							"XX",
							"YX",
							"Y ",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_axe),
				new Object[]
						{
							"XX",
							"XY",
							" Y",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_shovel),
				new Object[]
						{
							"X",
							"Y",
							"Y",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_hoe),
				new Object[]
						{
							"XX",
							"Y ",
							"Y ",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_hoe),
				new Object[]
						{
							"XX",
							" Y",
							" Y",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_sword),
				new Object[]
						{
							"X",
							"X",
							"Y",

							'X', Blocks.cactus,
							'Y', DesertItems.cactus_stick
						});

		// Tool - Ceramic
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_pickaxe),
				new Object[]
						{
							"XXX",
							" Y ",
							" Y ",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_axe),
				new Object[]
						{
							"XX",
							"YX",
							"Y ",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_axe),
				new Object[]
						{
							"XX",
							"XY",
							" Y",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_shovel),
				new Object[]
						{
							"X",
							"Y",
							"Y",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_hoe),
				new Object[]
						{
							"XX",
							"Y ",
							"Y ",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_hoe),
				new Object[]
						{
							"XX",
							" Y",
							" Y",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.ceramic_sword),
				new Object[]
						{
							"X",
							"X",
							"Y",

							'X', DesertItems.ceramic_ingot,
							'Y', "stickWood"
						});
		// Tool - advceramic
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_pickaxe),
				new Object[]
						{
							"XXX",
							" Y ",
							" Y ",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_axe),
				new Object[]
						{
							"XX",
							"YX",
							"Y ",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_axe),
				new Object[]
						{
							"XX",
							"XY",
							" Y",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_shovel),
				new Object[]
						{
							"X",
							"Y",
							"Y",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_hoe),
				new Object[]
						{
							"XX",
							"Y ",
							"Y ",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_hoe),
				new Object[]
						{
							"XX",
							" Y",
							" Y",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.advceramic_sword),
				new Object[]
						{
							"X",
							"X",
							"Y",

							'X', DesertItems.advceramic_ingot,
							'Y', "stickWood"
						});

		// Tool - desert diamond
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_pickaxe),
				new Object[]
						{
							"XXX",
							" Y ",
							" Y ",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_axe),
				new Object[]
						{
							"XX",
							"YX",
							"Y ",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_axe),
				new Object[]
						{
							"XX",
							"XY",
							" Y",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_shovel),
				new Object[]
						{
							"X",
							"Y",
							"Y",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_hoe),
				new Object[]
						{
							"XX",
							"Y ",
							"Y ",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_hoe),
				new Object[]
						{
							"XX",
							" Y",
							" Y",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.desert_diamond_sword),
				new Object[]
						{
							"X",
							"X",
							"Y",

							'X', DesertItems.desert_diamond,
							'Y', "stickWood"
						});

		// Armor
		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_helmet),
				new Object[]
						{
							"XXX",
							"X X",

							'X', DesertBlocks.cactus_block
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_chestplate),
				new Object[]
						{
							"X X",
							"XXX",
							"XXX",

							'X', DesertBlocks.cactus_block
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_leggings),
				new Object[]
						{
							"XXX",
							"X X",
							"X X",

							'X', DesertBlocks.cactus_block
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertItems.cactus_boots),
				new Object[]
						{
							"X X",
							"X X",

							'X', DesertBlocks.cactus_block
						});

		// Others
		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.wet_sand, 4),
				new Object[]
						{
							" X ",
							"XYX",
							" X ",

							'X', Blocks.sand,
							'Y', Items.water_bucket,
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.wet_sand, 4),
				new Object[]
						{
							" X ",
							"XYX",
							" X ",

							'X', Blocks.sand,
							'Y', "bucketWater",
						});

		RegisterUtil.addShapedRecipe(new ItemStack(Blocks.dirt),
				new Object[]
						{
							"XYX",

							'X', DesertItems.cactus_gel,
							'Y', Blocks.sand
						});

		RegisterUtil.addShapedRecipe(new ItemStack(Blocks.grass),
				new Object[]
						{
							"XXX",
							"XYX",
							"XXX",

							'X', DesertItems.cactus_gel,
							'Y', Blocks.dirt
						});

		RegisterUtil.addShapedRecipe(new ItemStack(Blocks.crafting_table),
				new Object[]
						{
							"XX",
							"YY",

							'X', DesertItems.cactus_skin,
							'Y', Blocks.cactus
						});

		RegisterUtil.addShapedRecipe(new ItemStack(Blocks.chest),
				new Object[]
						{
							"XXX",
							"Y Y",
							"YYY",

							'X', DesertItems.cactus_skin,
							'Y', Blocks.cactus
						});

		RegisterUtil.addShapedRecipe(new ItemStack(Blocks.torch, 4),
				new Object[]
						{
							"X",
							"Y",

							'X', DesertItems.cactus_coal,
							'Y', "stickWood"
						});

		RegisterUtil.addShapelessRecipe(new ItemStack(Items.book), Items.paper, Items.paper, Items.paper, DesertItems.cactus_skin);

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.sandstone_chest),
				new Object[]
						{
							"XXX",
							"X X",
							"XXX",

							'X', new ItemStack(Blocks.sandstone, 1, 0)
						});

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.sandstone_chest),
				new Object[]
						{
							"XXX",
							"X X",
							"XXX",

							'X', new ItemStack(Blocks.sandstone, 1, 2)
						});

		/* Furnace Recipes */

		RegisterUtil.addShapedRecipe(new ItemStack(DesertBlocks.sandstone_furnace),
				new Object[]
						{
							"XXX",
							"X X",
							"XXX",

							'X', new ItemStack(Blocks.sandstone, 1, 1)
						});

		// Cactus Stick -> Stick
		GameRegistry.addSmelting(DesertItems.cactus_stick, new ItemStack(Items.stick), 0.1F);

//		// Cactus Flesh -> Cactus Steak
		GameRegistry.addSmelting(DesertItems.cactus_flesh, new ItemStack(DesertItems.cactus_steak), 0.1F);

		// Cactus Charcoal
		GameRegistry.addSmelting(DesertItems.cactus_skin, new ItemStack(DesertItems.cactus_coal), 0.2F);

		// Ceramics
		GameRegistry.addSmelting(DesertItems.ceramic_material, new ItemStack(DesertItems.ceramic_ingot), 0.3F);
		GameRegistry.addSmelting(DesertItems.ceramic_ingot, new ItemStack(DesertItems.advceramic_ingot), 0.5F);
		GameRegistry.addSmelting(DesertBlocks.ceramic_block, new ItemStack(DesertBlocks.advceramic_block), 2.0F);
	}
}
