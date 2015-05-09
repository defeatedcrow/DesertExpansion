package net.s0baco.desert.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.s0baco.desert.DesertExpansion;

import com.google.common.collect.Lists;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDesertGrass extends BlockTallGrass
{
	public static class ItemDesertGrass extends ItemColored
	{
		public ItemDesertGrass(Block block)
		{
			super(block, false);
		}
	}

	private static ArrayList<ItemStack> dropList = new ArrayList();

	public BlockDesertGrass()
	{
		super();
		setHardness(0.0F).setStepSound(soundTypeGrass);
		setCreativeTab(DesertExpansion.tabDesert);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iba, int x, int y, int z)
	{
		return 0xFAF3A2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return 0xFAF3A2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return 0xFAF3A2;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) { }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int id, int meta)
	{
		return Blocks.tallgrass.getIcon(id, 1);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Desert;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
	{
		if (world.rand.nextInt(16) == 0)
		{
			return super.getDrops(world, x, y, z, meta, fortune);
		}
		else if(world.rand.nextInt(10) > 6)
		{
			return dropList;
		}

		return Lists.newArrayList();
	}

	@Override
	protected boolean canPlaceBlockOn(Block block)
	{
		return block == Blocks.sand || block == Blocks.dirt;
	}

	public static void addDrops(ItemStack ist)
	{
		dropList.add(ist);
	}
}
