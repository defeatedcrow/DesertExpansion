package net.s0baco.desert.item;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.s0baco.desert.DesertExpansion;

public class ItemDesertShears extends ItemShears
{
	public ItemDesertShears()
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(201);
		this.setCreativeTab(DesertExpansion.tabDesert);
	}

	@Override
	public boolean func_150897_b(Block par1)
	{
		return par1 == Blocks.web || par1 == Blocks.redstone_wire || par1 == Blocks.tripwire;
	}

	@Override
	public float func_150893_a(ItemStack par1, Block par2)
	{
		return par2 != Blocks.web && par2.getMaterial() != Material.leaves ? ((par2 == Blocks.wool || par2 == Blocks.cactus) ? 5.0F : super.func_150893_a(par1, par2)) : 15.0F;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1, World par2, Block par3, int x, int y, int z, EntityLivingBase par7)
	{
		if (par3.getMaterial() != Material.leaves && par3 != Blocks.web && par3 != Blocks.tallgrass && par3 != Blocks.vine && par3 != Blocks.tripwire && !(par3 instanceof IShearable))
		{
			return super.onBlockDestroyed(par1, par2, par3, x, y, z, par7);
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	{
		if (entity.worldObj.isRemote)
		{
			return false;
		}
		if (entity instanceof IShearable)
		{
			IShearable target = (IShearable) entity;

			if (target.isShearable(itemstack, entity.worldObj, (int) entity.posX, (int) entity.posY, (int) entity.posZ))
			{
				ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int) entity.posX, (int) entity.posY, (int) entity.posZ,
				EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));

				Random rand = new Random();

				for (ItemStack stack : drops) {
					EntityItem ent = entity.entityDropItem(stack, 1.0F);
					ent.motionY += rand.nextFloat() * 0.05F;
					ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
				}

				itemstack.damageItem(1, entity);
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
	{
		if (player.worldObj.isRemote)
		{
			return false;
		}

		Block block = player.worldObj.getBlock(x, y, z);

		if (block instanceof IShearable)
		{
			IShearable target = (IShearable)block;
			if (target.isShearable(itemstack, player.worldObj, x, y, z))
			{
				ArrayList<ItemStack> drops = target.onSheared(itemstack, player.worldObj, x, y, z,
				EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
				Random rand = new Random();

				for(ItemStack stack : drops)
				{
					float f = 0.7F;
					double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
					double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
					double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
					EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
					entityitem.delayBeforeCanPickup = 10;
					player.worldObj.spawnEntityInWorld(entityitem);
				}

				itemstack.damageItem(1, player);
				player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(block)], 1);
			}
		}

		return false;
	}
}
