package net.s0baco.desert.integration.plugin;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.s0baco.desert.core.DesertItems;
import net.s0baco.desert.core.DesertUtil.RecipeUtil;
import net.s0baco.desert.core.DesertUtil.RegisterUtil;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class PluginDesertcraft
{
	public static void init()
	{
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 2), new ItemStack(DesertItems.desert_plants, 1, 0));
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 2), new ItemStack(DesertItems.desert_plants, 1, 4));
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 1), new ItemStack(DesertItems.desert_plants, 1, 1));
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 1), new ItemStack(DesertItems.desert_plants, 1, 2));
		RegisterUtil.addShapelessRecipe(new ItemStack(DesertItems.cactus_skin, 1), new ItemStack(DesertItems.desert_plants, 1, 3));

		RegisterUtil.addShapelessRecipe(new ItemStack(Items.dye, 1, 11), new ItemStack(DesertItems.desert_plants, 1, 14));

		RegisterUtil.addShapelessRecipe(new ItemStack(Items.stick, 1), new ItemStack(DesertItems.desert_plants, 1, 15));

		GameRegistry.registerFuelHandler(new FuelHandler());

		RecipeUtil.instance().deleteRecipes(new ItemStack(Blocks.planks, 1, 0), new ItemStack[]{new ItemStack(Blocks.cactus)});
//		RecipeDeleter.delete(new ItemStack(Blocks.planks, 1, 0));
	}

	public static class FuelHandler implements IFuelHandler
	{
		private int WILDCARD = OreDictionary.WILDCARD_VALUE;

		@Override
		public int getBurnTime(ItemStack fuel)
		{
			if(fuel.getItem() == new ItemStack(DesertItems.desert_plants, 1, WILDCARD).getItem())
			{
				return 200 / 2;
			}
			return 0;
		}
	}
}
