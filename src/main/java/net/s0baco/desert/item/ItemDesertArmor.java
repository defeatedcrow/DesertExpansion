package net.s0baco.desert.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.s0baco.desert.DesertExpansion;

public class ItemDesertArmor extends ItemArmor
{
	private static String modelRoot = "desertexpansion:textures/models/armor/";

	public ItemDesertArmor(ArmorMaterial par1, int par2, int par3)
	{
		super(par1, par2, par3);
		setCreativeTab(DesertExpansion.tabDesert);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String s1 = String.format(modelRoot + "%s_layer_%d%s.png", this.getArmorMaterial().name(), (slot == 2 ? 2 : 1), type == null ? "" : String.format("_%s", type));

		return s1;
	}
}
