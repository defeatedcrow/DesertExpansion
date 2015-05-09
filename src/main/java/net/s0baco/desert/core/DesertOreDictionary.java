package net.s0baco.desert.core;

import net.minecraft.init.Blocks;
import net.s0baco.desert.core.DesertUtil.RegisterUtil;

public class DesertOreDictionary
{
	public static void init()
	{
		RegisterUtil.registerOre("cactusRod", DesertItems.cactus_stick);
		RegisterUtil.registerOre("stickCactus", DesertItems.cactus_stick);
		RegisterUtil.registerOre("stickWood", DesertItems.cactus_stick);

		RegisterUtil.registerOre("gemCoal", DesertItems.cactus_coal);

		RegisterUtil.registerOre("ingotCeramic", DesertItems.ceramic_ingot);
		RegisterUtil.registerOre("ingotReceramic", DesertItems.advceramic_ingot);

		RegisterUtil.registerOre("oreDiamond", DesertBlocks.desert_diamond_ore);
		RegisterUtil.registerOre("gemDiamond", DesertItems.desert_diamond);

		RegisterUtil.registerOre("craftingFurnace", Blocks.furnace);
		RegisterUtil.registerOre("craftingFurnace", DesertBlocks.sandstone_furnace);
	}
}
