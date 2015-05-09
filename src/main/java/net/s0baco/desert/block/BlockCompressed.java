package net.s0baco.desert.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.s0baco.desert.DesertExpansion;

public class BlockCompressed extends Block
{
	public BlockCompressed()
	{
		super(Material.iron);
		setCreativeTab(DesertExpansion.tabDesert);
	}
}
