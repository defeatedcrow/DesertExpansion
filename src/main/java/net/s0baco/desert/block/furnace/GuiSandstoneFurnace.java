package net.s0baco.desert.block.furnace;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.s0baco.desert.core.DesertBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSandstoneFurnace extends GuiFurnace
{
	private TileEntitySandstoneFurnace furnaceInventory;

	public GuiSandstoneFurnace(InventoryPlayer player, TileEntitySandstoneFurnace furnace)
	{
		super(player, furnace);
		this.furnaceInventory = furnace;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = DesertBlocks.sandstone_furnace.getLocalizedName();

		fontRendererObj.drawString(s, this.xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	}
}
