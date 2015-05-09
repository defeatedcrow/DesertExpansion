package net.s0baco.desert.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.s0baco.desert.DesertExpansion;

public class BlockWetSand extends Block
{
	public BlockWetSand()
	{
		super(Material.sand);
		setCreativeTab(DesertExpansion.tabDesert);

		setHarvestLevel("shovel", 0);

		setHardness(0.5F);
		setStepSound(Block.soundTypeSand);
	}
}
