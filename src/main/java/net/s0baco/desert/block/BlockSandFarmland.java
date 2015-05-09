package net.s0baco.desert.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.s0baco.desert.core.DesertBlocks;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSandFarmland extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon wetIcon;
	@SideOnly(Side.CLIENT)
	private IIcon dryIcon;

	public BlockSandFarmland()
	{
		super(Material.sand);

		this.setStepSound(soundTypeSand);
		this.setHarvestLevel("shovel", 0);

		this.setTickRandomly(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
//		this.setLightOpacity(255);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4)
	{
		return AxisAlignedBB.getBoundingBox((double)(par2 + 0), (double)(par3 + 0), (double)(par4 + 0), (double)(par2 + 1), (double)(par3 + 1), (double)(par4 + 1));
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!this.checkWater(world, x, y, z) && !world.canLightningStrikeAt(x, y + 1, z))
		{
			 int l = world.getBlockMetadata(x, y, z);

			 if (l > 0)
			 {
				 world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
			 }
			 else if (!this.checkPlant(world, x, y, z))
			 {
				 world.setBlock(x, y, z, Blocks.sand);
			 }
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y, z, 7, 2);
		}
	}

//	@Override - BlockFarmland.class
	private boolean checkPlant(World world, int x, int y, int z)
	{
		byte b0 = 0;

		for (int l = x - b0; l <= x + b0; ++l)
		{
			 for (int i1 = z - b0; i1 <= z + b0; ++i1)
			 {
				 Block block = world.getBlock(l, y + 1, i1);

				 if (block instanceof IPlantable && canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable)block))
				 {
					 return true;
				 }
			 }
		}

		return false;
	}

//	@Override - BlockFarmland.class
	private boolean checkWater(World world, int x, int y, int z)
	{
		for (int l = x - 4; l <= x + 4; ++l)
		{
			for (int i1 = y; i1 <= y + 1; ++i1)
			{
				for (int j1 = z - 4; j1 <= z + 4; ++j1)
				{
					if (world.getBlock(l, i1, j1).getMaterial() == Material.water)
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float par1)
	{
		if (!world.isRemote && world.rand.nextFloat() < par1 - 0.5F)
		{
			if (!(entity instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
			{
				return;
			}

			world.setBlock(x, y, z, Blocks.sand);
		}
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int par1, int par2, int par3, Block block)
	{
		super.onNeighborBlockChange(world, par1, par2, par3, block);
		Material material = world.getBlock(par1, par2 + 1, par3).getMaterial();

		if (material.isSolid())
		{
			world.setBlock(par1, par2, par3, Blocks.sand);
		}
	}

	@Override
	public Item getItemDropped(int par1, Random random, int par3)
	{
		return Blocks.sand.getItemDropped(0, random, par3);
	}

	/* Client Side Methods */

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? (par2 > 0 ? this.wetIcon : this.dryIcon) : (par2 > 0 ? DesertBlocks.wet_sand.getBlockTextureFromSide(par1) : Blocks.sand.getBlockTextureFromSide(par1));
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int par1, int par2, int par3)
	{
		return Item.getItemFromBlock(DesertBlocks.wet_sand);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1)
	{
		this.wetIcon = par1.registerIcon(this.getTextureName() + "_wet");
		this.dryIcon = par1.registerIcon(this.getTextureName() + "_dry");
	}



	/* Hoe Event */

	public static class CultivateEventHandler
	{
		@SubscribeEvent
		public void doSandCultivate(UseHoeEvent event)
		{
			EntityPlayer player = event.entityPlayer;
			World world = player.worldObj;

			int x = event.x;
			int y = event.y;
			int z = event.z;

			if(world.getBlock(x, y, z) == DesertBlocks.wet_sand)
			{
				world.setBlock(x, y, z, DesertBlocks.sand_farmland);

				event.setResult(Result.ALLOW);
			}
		}
	}
}
