package net.s0baco.desert.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.s0baco.desert.block.furnace.TileEntitySandstoneFurnace;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public int chestType;

	/* Methods */

	public void setCustomRenderers(){}
	public void setCustomClientRenderers(){}

	/* IGuiHandler */

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity machine = world.getTileEntity(x, y, z);

		if(machine instanceof TileEntitySandstoneFurnace)
		{
			return new ContainerFurnace(player.inventory, (TileEntitySandstoneFurnace) machine);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}
