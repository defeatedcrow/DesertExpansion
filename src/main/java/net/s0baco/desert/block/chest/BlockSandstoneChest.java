package net.s0baco.desert.block.chest;

import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.s0baco.desert.DesertExpansion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSandstoneChest extends BlockChest
{
	public BlockSandstoneChest(int par1)
	{
		super(par1);

		setCreativeTab(DesertExpansion.tabDesert);
		setHarvestLevel("pickaxe", 0);

		setResistance(8.0F);
	}

	@Override
	public int getRenderType()
	{
		return DesertExpansion.proxy.chestType;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par1)
	{
		return new TileEntitySandstoneChest();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1)
	{
		this.blockIcon = par1.registerIcon("sand");
	}
}
