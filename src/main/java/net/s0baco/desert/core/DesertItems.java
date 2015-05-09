package net.s0baco.desert.core;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.oredict.OreDictionary;
import net.s0baco.desert.DesertExpansion;
import net.s0baco.desert.item.ItemDesertArmor;
import net.s0baco.desert.item.ItemDesertAxe;
import net.s0baco.desert.item.ItemDesertPickaxe;
import net.s0baco.desert.item.ItemDesertShears;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;

public class DesertItems
{
	/* Desert Expansion 	-start- */

	// Material
	public static Item cactus_stick;
	public static Item cactus_gel;
	public static Item cactus_straw;
	public static Item cactus_skin;

	public static Item cactus_coal;

	public static Item ceramic_material;
	public static Item ceramic_ingot;
	public static Item advceramic_ingot;

	public static Item desert_diamond;

	// Food
	public static Item cactus_flesh;
	public static Item cactus_steak;
	public static Item cactus_jelly;

	// Tool
	public static Item desert_shears;

	public static Item cactus_sword;
	public static Item cactus_shovel;
	public static Item cactus_pickaxe;
	public static Item cactus_axe;
	public static Item cactus_hoe;

	public static Item ceramic_sword;
	public static Item ceramic_shovel;
	public static Item ceramic_pickaxe;
	public static Item ceramic_axe;
	public static Item ceramic_hoe;

	public static Item advceramic_sword;
	public static Item advceramic_shovel;
	public static Item advceramic_pickaxe;
	public static Item advceramic_axe;
	public static Item advceramic_hoe;

	public static Item desert_diamond_sword;
	public static Item desert_diamond_shovel;
	public static Item desert_diamond_pickaxe;
	public static Item desert_diamond_axe;
	public static Item desert_diamond_hoe;

	// Armor
	public static Item cactus_helmet;
	public static Item cactus_chestplate;
	public static Item cactus_leggings;
	public static Item cactus_boots;

	// Crops
	public static Item desert_leaf;
	public static Item leaf_seeds;

	/* Desert Expansion 	- end - */

	/* Pam's Desert craft 	-start- */

	@ObjectHolder("desertcraft:Desert Plants")
	public static final Item desert_plants = null;

	/* Pam's Desert craft 	- end - */

	public static void init()
	{
		cactus_stick = new Item().setCreativeTab(DesertExpansion.tabDesert);
		cactus_stick.setUnlocalizedName("cactus_stick");
		cactus_stick.setTextureName("desertexpansion:material/" + "cactus_stick");
		GameRegistry.registerItem(cactus_stick, "cactus_stick");

		cactus_gel = new Item().setCreativeTab(DesertExpansion.tabDesert);
		cactus_gel.setUnlocalizedName("cactus_gel");
		cactus_gel.setTextureName("desertexpansion:material/" + "cactus_gel");
		GameRegistry.registerItem(cactus_gel, "cactus_gel");

		cactus_straw = new Item().setCreativeTab(DesertExpansion.tabDesert);
		cactus_straw.setUnlocalizedName("cactus_straw");
		cactus_straw.setTextureName("desertexpansion:material/" + "cactus_straw");
		GameRegistry.registerItem(cactus_straw, "cactus_straw");

		cactus_skin = new Item().setCreativeTab(DesertExpansion.tabDesert);
		cactus_skin.setUnlocalizedName("cactus_skin");
		cactus_skin.setTextureName("desertexpansion:material/" + "cactus_skin");
		GameRegistry.registerItem(cactus_skin, "cactus_skin");

		cactus_coal = new Item().setCreativeTab(DesertExpansion.tabDesert);
		cactus_coal.setUnlocalizedName("cactus_coal");
		cactus_coal.setTextureName("desertexpansion:material/" + "cactus_coal");
		GameRegistry.registerItem(cactus_coal, "cactus_coal");

		ceramic_material = new Item().setCreativeTab(DesertExpansion.tabDesert);
		ceramic_material.setUnlocalizedName("ceramic_material");
		ceramic_material.setTextureName("desertexpansion:material/" + "ceramic_material");
		GameRegistry.registerItem(ceramic_material, "ceramic_material");

		ceramic_ingot = new Item().setCreativeTab(DesertExpansion.tabDesert);
		ceramic_ingot.setUnlocalizedName("ceramic_ingot");
		ceramic_ingot.setTextureName("desertexpansion:material/" + "ceramic_ingot");
		GameRegistry.registerItem(ceramic_ingot, "ceramic_ingot");

		advceramic_ingot = new Item().setCreativeTab(DesertExpansion.tabDesert);
		advceramic_ingot.setUnlocalizedName("advceramic_ingot");
		advceramic_ingot.setTextureName("desertexpansion:material/" + "advceramic_ingot");
		GameRegistry.registerItem(advceramic_ingot, "advceramic_ingot");

		desert_diamond = new Item().setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond.setUnlocalizedName("desert_diamond");
		desert_diamond.setTextureName("desertexpansion:material/" + "desert_diamond");
		GameRegistry.registerItem(desert_diamond, "desert_diamond");

		cactus_flesh = new ItemFood(3, 0.3F, false).setCreativeTab(DesertExpansion.tabDesert);
		cactus_flesh.setUnlocalizedName("cactus_flesh");
		cactus_flesh.setTextureName("desertexpansion:food/" + "cactus_flesh");
		GameRegistry.registerItem(cactus_flesh, "cactus_flesh");

		cactus_steak = new ItemFood(6, 0.8F, false).setCreativeTab(DesertExpansion.tabDesert);
		cactus_steak.setUnlocalizedName("cactus_steak");
		cactus_steak.setTextureName("desertexpansion:food/" + "cactus_steak");
		GameRegistry.registerItem(cactus_steak, "cactus_steak");

		cactus_jelly = new ItemFood(2, 0.1F, false).setCreativeTab(DesertExpansion.tabDesert);
		cactus_jelly.setUnlocalizedName("cactus_jelly");
		cactus_jelly.setTextureName("desertexpansion:food/" + "cactus_jelly");
		GameRegistry.registerItem(cactus_jelly, "cactus_jelly");

		cactus_sword = new ItemSword(DesertMaterials.cactus).setCreativeTab(DesertExpansion.tabDesert);
		cactus_sword.setUnlocalizedName("cactus_sword");
		cactus_sword.setTextureName("desertexpansion:tool/" + "cactus_sword");
		GameRegistry.registerItem(cactus_sword, "cactus_sword");

		cactus_shovel = new ItemSpade(DesertMaterials.cactus).setCreativeTab(DesertExpansion.tabDesert);
		cactus_shovel.setUnlocalizedName("cactus_shovel");
		cactus_shovel.setTextureName("desertexpansion:tool/" + "cactus_shovel");
		GameRegistry.registerItem(cactus_shovel, "cactus_shovel");

		cactus_pickaxe = new ItemDesertPickaxe(DesertMaterials.cactus).setCreativeTab(DesertExpansion.tabDesert);
		cactus_pickaxe.setUnlocalizedName("cactus_pickaxe");
		cactus_pickaxe.setTextureName("desertexpansion:tool/" + "cactus_pickaxe");
		GameRegistry.registerItem(cactus_pickaxe, "cactus_pickaxe");

		cactus_axe = new ItemDesertAxe(DesertMaterials.cactus).setCreativeTab(DesertExpansion.tabDesert);
		cactus_axe.setUnlocalizedName("cactus_axe");
		cactus_axe.setTextureName("desertexpansion:tool/" + "cactus_axe");
		GameRegistry.registerItem(cactus_axe, "cactus_axe");

		cactus_hoe = new ItemHoe(DesertMaterials.cactus).setCreativeTab(DesertExpansion.tabDesert);
		cactus_hoe.setUnlocalizedName("cactus_hoe");
		cactus_hoe.setTextureName("desertexpansion:tool/" + "cactus_hoe");
		GameRegistry.registerItem(cactus_hoe, "cactus_hoe");

		ceramic_sword = new ItemSword(DesertMaterials.ceramic).setCreativeTab(DesertExpansion.tabDesert);
		ceramic_sword.setUnlocalizedName("ceramic_sword");
		ceramic_sword.setTextureName("desertexpansion:tool/" + "ceramic_sword");
		GameRegistry.registerItem(ceramic_sword, "ceramic_sword");

		ceramic_shovel = new ItemSpade(DesertMaterials.ceramic).setCreativeTab(DesertExpansion.tabDesert);
		ceramic_shovel.setUnlocalizedName("cactus_shovel");
		ceramic_shovel.setTextureName("desertexpansion:tool/" + "cactus_shovel");
		GameRegistry.registerItem(ceramic_shovel, "ceramic_shovel");

		ceramic_pickaxe = new ItemDesertPickaxe(DesertMaterials.ceramic).setCreativeTab(DesertExpansion.tabDesert);
		ceramic_pickaxe.setUnlocalizedName("ceramic_pickaxe");
		ceramic_pickaxe.setTextureName("desertexpansion:tool/" + "ceramic_pickaxe");
		GameRegistry.registerItem(ceramic_pickaxe, "ceramic_pickaxe");

		ceramic_axe = new ItemDesertAxe(DesertMaterials.ceramic).setCreativeTab(DesertExpansion.tabDesert);
		ceramic_axe.setUnlocalizedName("ceramic_axe");
		ceramic_axe.setTextureName("desertexpansion:tool/" + "ceramic_axe");
		GameRegistry.registerItem(ceramic_axe, "ceramic_axe");

		ceramic_hoe = new ItemHoe(DesertMaterials.ceramic).setCreativeTab(DesertExpansion.tabDesert);
		ceramic_hoe.setUnlocalizedName("ceramic_hoe");
		ceramic_hoe.setTextureName("desertexpansion:tool/" + "ceramic_hoe");
		GameRegistry.registerItem(ceramic_hoe, "ceramic_hoe");

		advceramic_sword = new ItemSword(DesertMaterials.advceramic).setCreativeTab(DesertExpansion.tabDesert);
		advceramic_sword.setUnlocalizedName("advceramic_sword");
		advceramic_sword.setTextureName("desertexpansion:tool/" + "advceramic_sword");
		GameRegistry.registerItem(advceramic_sword, "advceramic_sword");

		advceramic_shovel = new ItemSpade(DesertMaterials.advceramic).setCreativeTab(DesertExpansion.tabDesert);
		advceramic_shovel.setUnlocalizedName("advceramic_shovel");
		advceramic_shovel.setTextureName("desertexpansion:tool/" + "advceramic_shovel");
		GameRegistry.registerItem(advceramic_shovel, "advceramic_shovel");

		advceramic_pickaxe = new ItemDesertPickaxe(DesertMaterials.advceramic).setCreativeTab(DesertExpansion.tabDesert);
		advceramic_pickaxe.setUnlocalizedName("advceramic_pickaxe");
		advceramic_pickaxe.setTextureName("desertexpansion:tool/" + "advceramic_pickaxe");
		GameRegistry.registerItem(advceramic_pickaxe, "advceramic_pickaxe");

		advceramic_axe = new ItemDesertAxe(DesertMaterials.advceramic).setCreativeTab(DesertExpansion.tabDesert);
		advceramic_axe.setUnlocalizedName("advceramic_axe");
		advceramic_axe.setTextureName("desertexpansion:tool/" + "advceramic_axe");
		GameRegistry.registerItem(advceramic_axe, "advceramic_axe");

		advceramic_hoe = new ItemHoe(DesertMaterials.advceramic).setCreativeTab(DesertExpansion.tabDesert);
		advceramic_hoe.setUnlocalizedName("advceramic_hoe");
		advceramic_hoe.setTextureName("desertexpansion:tool/" + "advceramic_hoe");
		GameRegistry.registerItem(advceramic_hoe, "advceramic_hoe");

		desert_diamond_sword = new ItemSword(DesertMaterials.diamond).setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond_sword.setUnlocalizedName("desert_diamond_sword");
		desert_diamond_sword.setTextureName("desertexpansion:tool/" + "desert_diamond_sword");
		GameRegistry.registerItem(desert_diamond_sword, "desert_diamond_sword");

		desert_diamond_shovel = new ItemSpade(DesertMaterials.diamond).setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond_shovel.setUnlocalizedName("desert_diamond_shovel");
		desert_diamond_shovel.setTextureName("desertexpansion:tool/" + "desert_diamond_shovel");
		GameRegistry.registerItem(desert_diamond_shovel, "desert_diamond_shovel");

		desert_diamond_pickaxe = new ItemDesertPickaxe(DesertMaterials.diamond).setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond_pickaxe.setUnlocalizedName("desert_diamond_pickaxe");
		desert_diamond_pickaxe.setTextureName("desertexpansion:tool/" + "desert_diamond_pickaxe");
		GameRegistry.registerItem(desert_diamond_pickaxe, "desert_diamond_pickaxe");

		desert_diamond_axe = new ItemDesertAxe(DesertMaterials.diamond).setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond_axe.setUnlocalizedName("desert_diamond_axe");
		desert_diamond_axe.setTextureName("desertexpansion:tool/" + "desert_diamond_axe");
		GameRegistry.registerItem(desert_diamond_axe, "desert_diamond_axe");

		desert_diamond_hoe = new ItemHoe(DesertMaterials.diamond).setCreativeTab(DesertExpansion.tabDesert);
		desert_diamond_hoe.setUnlocalizedName("desert_diamond_hoe");
		desert_diamond_hoe.setTextureName("desertexpansion:tool/" + "desert_diamond_hoe");
		GameRegistry.registerItem(desert_diamond_hoe, "desert_diamond_hoe");

		desert_shears = new ItemDesertShears().setUnlocalizedName("desert_shears").setTextureName("desertexpansion:tool/desert_shears");
		GameRegistry.registerItem(desert_shears, "desert_shears");

		// Armor
		cactus_helmet = new ItemDesertArmor(DesertMaterials.cactus_armor, 0, 0).setUnlocalizedName("cactus_helmet").setTextureName("desertexpansion:armor/cactus_helmet");
		GameRegistry.registerItem(cactus_helmet, "cactus_helmet");

		cactus_chestplate = new ItemDesertArmor(DesertMaterials.cactus_armor, 0, 1).setUnlocalizedName("cactus_chestplate").setTextureName("desertexpansion:armor/cactus_chestplate");
		GameRegistry.registerItem(cactus_chestplate, "cactus_chestplate");

		cactus_leggings = new ItemDesertArmor(DesertMaterials.cactus_armor, 0, 2).setUnlocalizedName("cactus_leggings").setTextureName("desertexpansion:armor/cactus_leggings");
		GameRegistry.registerItem(cactus_leggings, "cactus_leggings");

		cactus_boots = new ItemDesertArmor(DesertMaterials.cactus_armor, 0, 3).setUnlocalizedName("cactus_boots").setTextureName("desertexpansion:armor/cactus_boots");
		GameRegistry.registerItem(cactus_boots, "cactus_boots");

//		// Crops has gone...
//		BlockDesertGrass.addDrops(new ItemStack(DesertItems.leaf_seeds, 1));
//		leaf_seeds = new ItemDesertSeeds(DesertBlocks.leaf_crop, DesertBlocks.sand_farmland).setUnlocalizedName("leaf_seeds").setTextureName("desertexpansion:material/" + "leaf_seeds");
//		GameRegistry.registerItem(leaf_seeds, "leaf_seeds");

		/* Fuel Handler */
		GameRegistry.registerFuelHandler(new FuelHandler());
	}

	public static class FuelHandler implements IFuelHandler
	{
		private int WILDCARD = OreDictionary.WILDCARD_VALUE;

		@Override
		public int getBurnTime(ItemStack fuel)
		{
			if(fuel.getItem() == new ItemStack(DesertItems.cactus_coal).getItem())
			{
				return (200 * 8) / 4;
			}
			if(fuel.getItem() == new ItemStack(Blocks.cactus).getItem())
			{
				return 200 / 2;
			}
			if(fuel.getItem() == new ItemStack(DesertBlocks.cactus_block).getItem())
			{
				return (200 / 2) * 9;
			}
			if(fuel.getItem() == new ItemStack(DesertItems.cactus_skin).getItem())
			{
				return (200 / 2) / 4;
			}
			if(fuel.getItem() == new ItemStack(DesertItems.cactus_skin).getItem())
			{
				return (200 / 2) / 2;
			}
			return 0;
		}
	}
}
