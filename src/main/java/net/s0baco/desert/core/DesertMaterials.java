package net.s0baco.desert.core;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DesertMaterials
{
	public static ToolMaterial cactus = EnumHelper.addToolMaterial("CACTUS", 1, 59, 2.0F, 4, 10);
	public static ToolMaterial ceramic = EnumHelper.addToolMaterial("CERAMIC", 1, 131, 4.0F, 1, 12);
	public static ToolMaterial advceramic = EnumHelper.addToolMaterial("ADVCERAMIC", 2, 201, 6.0F, 2, 15);
	public static ToolMaterial diamond = EnumHelper.addToolMaterial("DESERT_DIAMOND", 3, 1951, 7.0F, 3, 20);

	public static ArmorMaterial cactus_armor = EnumHelper.addArmorMaterial("cactus", 9, new int[] { 2, 5, 3, 2 }, 10);
}
