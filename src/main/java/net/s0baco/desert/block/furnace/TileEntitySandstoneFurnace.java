package net.s0baco.desert.block.furnace;

import static net.s0baco.desert.core.DesertUtil.Fields.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntitySandstoneFurnace extends TileEntityFurnace
{
	private static final int FURNACE_INTERVAL = 200;
	private static final double MULTIPLIER = 1.5;
	private static final int INTERVAL = (int) (FURNACE_INTERVAL * MULTIPLIER);

//	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	private ItemStack[] furnaceItemStacks = FURNACE_ITEM_STACKS.get(this);

	private boolean noSync;

	private int maxCookTime = Short.MAX_VALUE;
	{
		currentItemBurnTime = -1;
	}

	public int syncMaxCookTime()
	{
		if (maxCookTime == Short.MAX_VALUE || !noSync)
		{
			try
			{
				TileEntitySandstoneFurnace te = (TileEntitySandstoneFurnace) worldObj.getTileEntity(xCoord, yCoord, zCoord);

				if (te != this)
				{
					maxCookTime = te.maxCookTime;
				}
				else
				{
					noSync = true;
				}
			}
			catch(NullPointerException ignored){}
			catch(ClassCastException ignored){}
		}

		return maxCookTime;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tags = new NBTTagCompound();
		this.writeToNBT(tags);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tags);
	}

	@Override
	public void readFromNBT(NBTTagCompound tags)
	{
		super.readFromNBT(tags);
		maxCookTime = tags.getShort("MaxCookTime");

		furnaceItemStacks = FURNACE_ITEM_STACKS.get(this);
	}

	@Override
	public void writeToNBT(NBTTagCompound tags)
	{
		super.writeToNBT(tags);
		tags.setShort("MaxCookTime", (short) maxCookTime);
	}

	private boolean setBurning(int burnTime)
	{
		currentItemBurnTime = furnaceBurnTime = burnTime;

		return burnTime > 0;
	}

	@Override
	public void updateEntity()
	{
		boolean isBurningLastTick = isBurning();
		boolean inventoryChanged = false;

		if (isBurning())
		{
			furnaceBurnTime--;
		}

		if (!worldObj.isRemote)
		{
			if (!isBurning() && canSmelt() && setBurning(calculateBurnTime(furnaceItemStacks[1])))
			{
				inventoryChanged = true;

				if (furnaceItemStacks[1] != null)
				{
					furnaceItemStacks[1].stackSize--;

					if (furnaceItemStacks[1].stackSize == 0)
					{
						furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
					}
				}
			}

			if (isBurning() && canSmelt())
			{
				//===================================================>>
				if (furnaceCookTime++ == 0)
				{
					setMaxCookTime();
				}

				if (furnaceCookTime == maxCookTime)
				{
					furnaceCookTime = 0;
					smeltItem();
					inventoryChanged = true;
				}
				//===================================================>>
			}
			else
			{
				furnaceCookTime = 0;
			}

			if (isBurningLastTick ^ furnaceBurnTime > 0)
			{
				inventoryChanged = true;
				BlockSandstoneFurnace.updateFurnaceBlockState(furnaceBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
			}
		}

		if (inventoryChanged)
		{
			markDirty();
		}
	}

	private void setMaxCookTime()
	{
    	int oldMaxCookTime = maxCookTime;
    	maxCookTime = calculateMaxCookTime(furnaceItemStacks[0]);

    	if (oldMaxCookTime == maxCookTime || worldObj.isRemote)
    		return;

    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public int calculateMaxCookTime(ItemStack i)
	{
		if (i == null)
			return 0;

		ItemStack j = FurnaceRecipes.smelting().getSmeltingResult(i);

		long seed = worldObj.getSeed()
				^ i.getItem().getUnlocalizedName(i).hashCode() * 479001599
				^ j.getItem().getUnlocalizedName(j).hashCode() * 5039;
		int x = (int) (seed % 165 + 165) % 165;


		int r;
		int p = 0;

		if 		(x < (p += 63)) r =  8;	//	 8	 8		 8.00	8 * Math.exp( 0.0)
		else if (x < (p += 40)) r = 12;	//	12	15		13.19	8 * Math.exp(+0.5);
		else if (x < (p += 40)) r =  5;	//	 4	 5		 4.85	8 * Math.exp(-0.5);
		else if (x < (p += 10)) r = 20;	//	20	24		21.75	8 * Math.exp(+1.0);
		else if (x < (p += 10)) r =  3;	//	 2	 3		 2.94	8 * Math.exp(-1.0);
		else if (x < (p +=  1)) r = 40;	//	32	40		35.85	8 * Math.exp(+1.5);
		else					r =  2;	//	 1	 2		 1.79	8 * Math.exp(-1.5);


		return INTERVAL * 8 / r;
	}

	public static int calculateBurnTime(ItemStack item)
	{
		return (int) Math.ceil(TileEntityFurnace.getItemBurnTime(item) * MULTIPLIER);
	}

	private boolean canSmelt()
	{
		if (this.furnaceItemStacks[0] == null)
		{
			return false;
		}

		ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(furnaceItemStacks[0]);
		if (itemstack == null)
		{
			return false;
		}
		if (furnaceItemStacks[2] == null)
		{
			return true;
		}
		if (!furnaceItemStacks[2].isItemEqual(itemstack))
		{
			return false;
		}

		int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;

		return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int p)
	{
		return furnaceCookTime * p / syncMaxCookTime();
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int p)
	{
		return furnaceBurnTime * p / currentItemBurnTime;
	}
}
