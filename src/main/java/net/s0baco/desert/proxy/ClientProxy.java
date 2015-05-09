package net.s0baco.desert.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.s0baco.desert.block.chest.TileEntitySandstoneChest;
import net.s0baco.desert.block.furnace.GuiSandstoneFurnace;
import net.s0baco.desert.block.furnace.TileEntitySandstoneFurnace;
import net.s0baco.desert.renderer.RendererChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@Override
	public void setCustomRenderers()
	{
		this.chestType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RendererChest());

		this.setCustomClientRenderers();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setCustomClientRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySandstoneChest.class, new RendererChest());
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity machine = world.getTileEntity(x, y, z);

		if(machine instanceof TileEntitySandstoneFurnace)
		{
			TileEntitySandstoneFurnace f = (TileEntitySandstoneFurnace) machine;

			return new GuiSandstoneFurnace(player.inventory, f);
		}

		return null;
	}
}
