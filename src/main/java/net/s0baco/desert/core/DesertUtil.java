package net.s0baco.desert.core;

import static cpw.mods.fml.common.ObfuscationReflectionHelper.*;
import static cpw.mods.fml.relauncher.ReflectionHelper.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException;

public class DesertUtil
{
	/* Biome Check */

	public static boolean isInDesert(BiomeGenBase biome)
	{
		return biome == BiomeGenBase.desert || biome == BiomeGenBase.desertHills;
//		return BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY);
	}

	public static boolean isSandy(BiomeGenBase biome)
	{
		return BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY);
	}

	public static class RegisterUtil
	{
		public static void addShapedRecipe(ItemStack is, Object... recipe)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(is, recipe));
		}

		public static void addShapelessRecipe(ItemStack is, Object... recipe)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(is, recipe));
		}

		/* Ore Dictionary */

		public static void registerOre(String name, ItemStack ore)
		{
			int[] ids = OreDictionary.getOreIDs(ore);

			for (int id : ids) {
				if (OreDictionary.getOreName(id).equals(name)) return;
			}
			OreDictionary.registerOre(name, ore);
		}

		public static void registerOre(String name, Item ore)
		{
			registerOre(name, new ItemStack(ore));
		}

		public static void registerOre(String name, Block ore)
		{
			registerOre(name, new ItemStack(ore));
		}

		public static boolean isRegistered(String name)
		{
			if (OreDictionary.getOres(name).isEmpty()) return false;
			else return true;
		}
	}

	public static class RecipeUtil
	{
		private static final RecipeUtil INSTANCE = new RecipeUtil();

		public void deleteRecipes(ItemStack targetOutput)
		{
			this.deleteRecipes(targetOutput, null);
		}

		public void deleteRecipes(ItemStack[] targetParams)
		{
			this.deleteRecipes(null, targetParams);
		}

		public void deleteRecipes(ItemStack targetOutput, ItemStack[] targetParams)
		{
			this.changeRecipes(targetOutput, targetParams, null, null, null);
		}

		public void changeRecipes(ItemStack targetOutput, ItemStack[] targetParams, ItemStack newOutput)
		{
			this.changeRecipes(targetOutput, targetParams, null, newOutput, null);
		}

		public void changeRecipes(ItemStack targetOutput, ItemStack[] targetParams, ItemStack targetParam, ItemStack newParam)
		{
			this.changeRecipes(targetOutput, targetParams, targetParam, null, newParam);
		}

		public void changeRecipes(ItemStack targetOutput, ItemStack[] targetParams, ItemStack targetParam, ItemStack newOutput, ItemStack newParam)
		{
			List<IRecipe> newRecipes = new ArrayList<IRecipe>();

			List<IRecipe> listRecipes = CraftingManager.getInstance().getRecipeList();

			for (int i = 0; i < listRecipes.size(); i++)
			{
				IRecipe irecipe = listRecipes.get(i);
				ItemStack oldOutput = irecipe.getRecipeOutput();

				if (oldOutput != null)
				{
					boolean flag = false;

					if (targetOutput != null && this.equalItemStackAndStackSize(oldOutput, targetOutput))
					{
						flag = true;
					}

					IRecipe newRecipe = null;

					if (irecipe instanceof ShapedRecipes)
					{
						ShapedRecipes recipe = (ShapedRecipes) irecipe;
						ItemStack[] oldParams = recipe.recipeItems;
						ItemStack[] newParams = new ItemStack[oldParams.length];

						if (this.equalItemStackArray(oldParams, targetParams))
						{
							if (targetParam == null && newOutput == null && newParam == null)
							{
								flag = true;
							}
							else
							{
								for (int j = 0; j < newParams.length; j++)
								{
									ItemStack oldParam = oldParams[j];

									if (this.equalItemStack(oldParam, targetParam))
									{
										newParams[j] = newParam;
									}
									else
									{
										newParams[j] = oldParam;
									}
								}
								newRecipe = new ShapedRecipes(recipe.recipeWidth, recipe.recipeHeight, newParams, (newOutput == null ? oldOutput : newOutput));
							}
						}
					}

					if (newRecipe != null)
					{
						flag = true;
						newRecipes.add(newRecipe);
					}

					if (flag)
					{
						listRecipes.remove(i--);
					}
				}
			}

			for (IRecipe newRecipe : newRecipes)
			{
				GameRegistry.addRecipe(newRecipe);
			}
		}

		public boolean equalItemStack(ItemStack a, ItemStack b)
		{
			if (a == null && b == null) return true;
			if (a == null || b == null) return false;

			return a.getItem() == b.getItem() && (a.getItemDamage() == b.getItemDamage() || b.getItemDamage() == 32767);
		}

		public boolean equalItemStackAndStackSize(ItemStack a, ItemStack b)
		{
			return this.equalItemStack(a, b) && a.stackSize == b.stackSize;
		}

		public boolean equalItemStackArray(ItemStack[] a, ItemStack[] b)
		{
			if (a.length != b.length) return false;

			for (int i = 0; i < a.length; i++)
			{
				if (!this.equalItemStack(a[i], b[i])) return false;
			}

			return true;
		}

		public static final RecipeUtil instance()
		{
			return INSTANCE;
		}
	}

	public static enum Fields
	{
		FURNACE_ITEM_STACKS (TileEntityFurnace.class, true, "furnaceItemStacks", "field_145957_n");

		private final Field field;
		private Fields(Class<?> clz, boolean isObfuscated, String... names)
		{
			if (isObfuscated)
				names = remapFieldNames(clz.getName(), names);

			field = findField(clz, names);
			field.setAccessible(true);
		}

		@SuppressWarnings("unchecked")
		public <V> V get(Object instance)
		{
			try
			{
				return (V) field.get(instance);
			}
			catch (Exception e)
			{
				throw new UnableToAccessFieldException(new String[0], e);
			}
		}

		public <V> void set(Object instance, V value)
		{
			try
			{
				field.set(instance, value);
			}
			catch (Exception e)
			{
				throw new UnableToAccessFieldException(new String[0], e);
			}
		}

		public <V> void copyValue(Object sourceInstance, Object targetInstance)
		{
			try
			{
				field.set(targetInstance, field.get(sourceInstance));
			}
			catch (Exception e)
			{
				throw new UnableToAccessFieldException(new String[0], e);
			}
		}
	}
}
