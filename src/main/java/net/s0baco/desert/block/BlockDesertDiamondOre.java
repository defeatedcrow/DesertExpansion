package net.s0baco.desert.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.s0baco.desert.DesertExpansion;
import net.s0baco.desert.core.DesertItems;

public class BlockDesertDiamondOre extends Block
{
	private Random random = new Random();

	public BlockDesertDiamondOre(Material par1)
	{
		super(par1);
		setCreativeTab(DesertExpansion.tabDesert);

		setStepSound(Block.soundTypeStone);

		setHardness(3.0F);
		setResistance(5.0F);

		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return DesertItems.desert_diamond;
	}

	@Override
	public int getExpDrop(IBlockAccess iBlockAccess, int meta, int fortune)
	{
		return MathHelper.getRandomIntegerInRange(random, 3, 7);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune))
		{
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return this.quantityDropped(random) * (j + 1);
		}
		else
		{
			return this.quantityDropped(random);
		}
	}
}
