package net.s0baco.desert.integration.plugin;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.s0baco.desert.core.DesertBlocks;
import net.s0baco.desert.core.DesertItems;
import net.s0baco.desert.core.DesertUtil.RegisterUtil;

public class PluginAppleMilkTea
{
	public static void init()
	{
//		RegisterUtil.addShapelessRecipe(ItemAPI.getBlock("vegetable bags", 6), DesertBlocks.cactus_block);
		RegisterUtil.addShapelessRecipe(new ItemStack(DCsAppleMilk.vegiBag, 1, 6), DesertBlocks.cactus_block);
//		RegisterUtil.addShapelessRecipe(new ItemStack(DesertBlocks.cactus_block), ItemAPI.getBlock("vegetable bags", 6));
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertBlocks.cactus_block), new ItemStack(DCsAppleMilk.vegiBag, 1, 6));

		RecipeRegisterManager.plateRecipe.register(new ItemStack(DesertItems.cactus_flesh, 1, 0), new ItemStack(DesertItems.cactus_steak), 100, false);
		RecipeRegisterManager.plateRecipe.register(new ItemStack(DesertBlocks.wet_sand, 1, 0), new ItemStack(Blocks.sand), 40, false);
	}
}
