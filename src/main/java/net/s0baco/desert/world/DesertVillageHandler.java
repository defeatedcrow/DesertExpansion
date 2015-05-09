package net.s0baco.desert.world;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.BiomeEvent.GetVillageBlockID;
import net.s0baco.desert.core.DesertBlocks;
import net.s0baco.desert.core.DesertUtil;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DesertVillageHandler
{
	@SubscribeEvent
	public void getVillageBlockID(GetVillageBlockID event)
	{
		// BiomeDictionary.isBiomeOfType(event.biome, Type.SANDY)
		if (DesertUtil.isInDesert(event.biome) && event.original == Blocks.furnace)
		{
			event.replacement = DesertBlocks.sandstone_furnace;
			event.setResult(Result.DENY);
		}
	}
}
