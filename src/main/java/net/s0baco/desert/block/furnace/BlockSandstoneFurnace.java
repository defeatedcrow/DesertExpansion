package net.s0baco.desert.block.furnace;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.s0baco.desert.DesertExpansion;
import net.s0baco.desert.core.DesertBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSandstoneFurnace extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private IIcon furnaceIconTop;
	@SideOnly(Side.CLIENT)
	private IIcon furnaceIconFront;

	private final boolean isActive;
	private static boolean keepFurnaceInventory = false;

	private final Random random = new Random();

	public BlockSandstoneFurnace(boolean isActive)
	{
		super(Material.rock);

		this.isActive = isActive;

		setHardness(2.0F);
		setStepSound(soundTypeStone);

		if(isActive)
		{
			setLightLevel(0.875F);
		}
		else
		{
			setCreativeTab(DesertExpansion.tabDesert);
		}
	}

	@Override
	public Item getItemDropped(int p, Random rand, int q)
	{
		return Item.getItemFromBlock(DesertBlocks.sandstone_furnace);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(DesertBlocks.sandstone_furnace);
	}

	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p, float q, float r, float s)
	{
		if (world.isRemote)
			return true;

		player.openGui(DesertExpansion.instance, 0, world, x, y, z);
		return true;
	}

	public static void updateFurnaceBlockState(boolean isActive, World world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);

		TileEntity tileentity = world.getTileEntity(x, y, z);
		keepFurnaceInventory = true;

		if (isActive)
		{
			world.setBlock(x, y, z, DesertBlocks.sandstone_furnace_burning);
		}
		else
		{
			world.setBlock(x, y, z, DesertBlocks.sandstone_furnace);
		}

		keepFurnaceInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p)
	{
		return new TileEntitySandstoneFurnace();
	}

	protected BlockFurnace delegatee()
	{
		return (BlockFurnace) (isActive ? Blocks.lit_furnace : Blocks.furnace);
	}

	@Override public void onBlockAdded(World world, int x, int y, int z)
	{
		delegatee().onBlockAdded(world, x, y, z);
	}

	@Override public boolean hasComparatorInputOverride()
	{
		return delegatee().hasComparatorInputOverride();
	}

	@Override
	public int getComparatorInputOverride(World world, int x, int y, int z, int p)
	{
		return delegatee().getComparatorInputOverride(world, x, y, z, p);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int q)
	{
		if (!keepFurnaceInventory)
		{
			delegatee().breakBlock(world, x, y, z, block, q);
		}
		else
		{
			super.breakBlock(world, x, y, z, block, q);
		}
	}
	@Override public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item)
	{
		delegatee().onBlockPlacedBy(world, x, y, z, entity, item);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick( World world, int x, int y, int z, Random rand)
	{
		delegatee().randomDisplayTick(world, x, y, z, rand);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
		blockIcon = ir.registerIcon("desertexpansion:" + "furnace_side");

		furnaceIconFront = ir.registerIcon("desertexpansion:" + (isActive ? "furnace_front_on" : "furnace_front_off"));

		furnaceIconTop = ir.registerIcon("desertexpansion:" + "furnace_top");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p, int q)
	{
		return p == 1 || p == 0 ? furnaceIconTop : ( q == 0 || q == 1 ? (p == 3 ? furnaceIconFront : blockIcon) : (p != q ? blockIcon : furnaceIconFront));
	}
}
