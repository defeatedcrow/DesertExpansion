package net.s0baco.desert.integration.plugin;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.s0baco.desert.DesertExpansion;
import net.s0baco.desert.core.DesertItems;
import net.s0baco.desert.core.DesertMaterials;
import net.s0baco.desert.core.DesertUtil.RegisterUtil;
import shift.sextiarysector.api.SextiarySectorAPI;
import shift.sextiarysector.api.equipment.EquipmentType;
import shift.sextiarysector.api.event.PlayerEatenEvent;
import shift.sextiarysector.item.ItemKnife;
import shift.sextiarysector.item.ItemScoop;
import shift.sextiarysector.item.ItemUnit;
import shift.sextiarysector.player.EntityPlayerManager;
import shift.sextiarysector.player.EquipmentStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class PluginSextiarySector
{
	public static Item cactus_unit;

	public static Item cactus_scoop;
	public static Item ceramic_scoop;
	public static Item advceramic_scoop;
//	public static Item desert_diamond_scoop;

	public static Item cactus_knife;
	public static Item ceramic_knife;
	public static Item advceramic_knife;
//	public static Item desert_diamond_knife;

	public static void init()
	{
		FoodEventHandler.initMap();
		MinecraftForge.EVENT_BUS.register(new FoodEventHandler());
		MinecraftForge.EVENT_BUS.register(new UnitEquipEventHandler());

		Blocks.cactus.setHarvestLevel("knife", 0);

		cactus_unit = new ItemUnit().setCreativeTab(DesertExpansion.tabDesert);
		cactus_unit.setUnlocalizedName("cactus_unit").setTextureName("desertexpansion:ss2/cactus_unit");
		GameRegistry.registerItem(cactus_unit, "cactus_unit");

		cactus_scoop = new ItemDesertScoop(DesertMaterials.cactus).setUnlocalizedName("cactus_scoop").setTextureName("cactus_scoop");
		ceramic_scoop = new ItemDesertScoop(DesertMaterials.ceramic).setUnlocalizedName("ceramic_scoop").setTextureName("ceramic_scoop");
		advceramic_scoop = new ItemDesertScoop(DesertMaterials.advceramic).setUnlocalizedName("advceramic_scoop").setTextureName("advceramic_scoop");
//		desert_diamond_scoop = new ItemDesertScoop(DesertMaterials.diamond).setUnlocalizedName("desert_diamond_scoop").setTextureName("desert_diamond_scoop");

		cactus_knife = new ItemDesertKnife(DesertMaterials.cactus).setUnlocalizedName("cactus_knife").setTextureName("cactus_knife");
		ceramic_knife = new ItemDesertKnife(DesertMaterials.ceramic).setUnlocalizedName("ceramic_knife").setTextureName("ceramic_knife");
		advceramic_knife = new ItemDesertKnife(DesertMaterials.advceramic).setUnlocalizedName("advceramic_knife").setTextureName("advceramic_knife");
//		desert_diamond_knife = new ItemDesertScoop(DesertMaterials.diamond).setUnlocalizedName("desert_diamond_knife").setTextureName("desert_diamond_knife");

		GameRegistry.registerItem(cactus_scoop, "cactus_scoop");
		GameRegistry.registerItem(ceramic_scoop, "ceramic_scoop");
		GameRegistry.registerItem(advceramic_scoop, "advceramic_scoop");
//		GameRegistry.registerItem(desert_diamond_scoop, "desert_diamond_scoop");

		GameRegistry.registerItem(cactus_knife, "cactus_knife");
		GameRegistry.registerItem(ceramic_knife, "ceramic_knife");
		GameRegistry.registerItem(advceramic_knife, "advceramic_knife");
//		GameRegistry.registerItem(desert_diamond_knife, "desert_diamond_knife");

		Item[] material = new Item[] {Item.getItemFromBlock(Blocks.cactus), DesertItems.ceramic_ingot, DesertItems.advceramic_ingot/*, DesertItems.desert_diamond*/};

//		Item[] scoop = new Item[] {cactus_scoop, ceramic_scoop, advceramic_scoop, desert_diamond_scoop};
		Item[] scoop = new Item[] {cactus_scoop, ceramic_scoop, advceramic_scoop};

		for (int i = 0; i < material.length; i++)
		{
			RegisterUtil.addShapedRecipe(new ItemStack(scoop[i], 1),
				new Object[]
					{
						"y",
						"x",

						Character.valueOf('y'), material[i],
						Character.valueOf('x'), "stickWood",
					});
		}

		Item[] knife = new Item[] {cactus_knife, ceramic_knife, advceramic_knife/*, desert_diamond_knife*/};

		for (int i = 0; i < material.length; i++)
		{
			RegisterUtil.addShapedRecipe(new ItemStack(knife[i], 1),
				new Object[]
					{
						" y",
						"x ",

						Character.valueOf('y'), material[i],
						Character.valueOf('x'), "stickWood",
					});
		}

		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(cactus_unit), 1, 3, 3));
	}

	/* Items */
	public static class ItemDesertScoop extends ItemScoop
	{
		public ItemDesertScoop(ToolMaterial par1)
		{
			super(par1);

			int i = par1.getHarvestLevel();
			float d = par1.getMaxUses();

			this.setHarvestLevel("scoop", i);

			if (i == 0)
			{
				this.setHarvestLevel("shovel", 0);
			}
			else
			{
				this.setHarvestLevel("shovel", i - 1);
			}

			this.setMaxDamage((int) (d / 2.0F));

			setCreativeTab(DesertExpansion.tabDesert);
		}

		@Override
		public Item setTextureName(String par1)
		{
			this.iconString = "desertexpansion:ss2/" + par1;
			return this;
		}
	}

	public static class ItemDesertKnife extends ItemKnife
	{
		public ItemDesertKnife(ToolMaterial par1)
		{
			super(par1);

			int i = par1.getHarvestLevel();
			float d = par1.getMaxUses();

			this.setHarvestLevel("knife", i);

			if (i == 0)
			{
				this.setHarvestLevel("axe", 0);
			}
			else
			{
				this.setHarvestLevel("axe", i - 1);
			}

			this.setMaxDamage((int) (d / 2.0F));

			setCreativeTab(DesertExpansion.tabDesert);
		}

		@Override
		public Item setTextureName(String par1)
		{
			this.iconString = "desertexpansion:ss2/" + par1;
			return this;
		}
	}

	public static class UnitEquipEventHandler
	{
		@SubscribeEvent
		public void onHurtEvent(LivingHurtEvent event)
		{
			if(event.source == DamageSource.cactus)
			{
				if (!(event.entity instanceof EntityPlayer)) return;

				EquipmentStats e = EntityPlayerManager.getEquipmentStats((EntityPlayer) event.entity);

				for (int i = 0; i < EquipmentType.Unit.getSlots().length; i++)
				{
					ItemStack item = e.inventory.getStackInSlot(EquipmentType.Unit.getSlots()[i]);

					if (item != null && item.getItem() != null && item.getItem() == cactus_unit)
					{
//						event.ammount = 0;
						event.setCanceled(true);
					}
				}

//				if (event.ammount < 0) {
//					event.ammount = 0;
//				}
			}
		}
	}

	/* EventHandler */
	public static class FoodEventHandler
	{
		private static Map<Item, Object> map;

		@SubscribeEvent
		public void onPlayerEatenEvent(PlayerEatenEvent event)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			Item eatenItem = event.food.getItem();

			Object stats = map.get(eatenItem);

			if(stats != null)
			{
				// 水分ゲージ回復の場合
				if(stats instanceof MoistureStats)
				{
					SextiarySectorAPI.addMoistureStats(player, ((MoistureStats)stats).moisture, ((MoistureStats)stats).hidden);
				}

				// 水分ゲージ消費の場合
				if(stats instanceof MoistureExhaustion)
				{
					SextiarySectorAPI.addMoistureExhaustion(player, ((MoistureExhaustion)stats).var);
				}
			}
		}

		public static void initMap()
		{
			map = new HashMap<Item, Object>();

			map.put(DesertItems.cactus_flesh, new MoistureStats(2, 1));
			map.put(DesertItems.cactus_jelly, new MoistureStats(1, 1));
			map.put(DesertItems.cactus_jelly, new MoistureExhaustion(2.0F));
		}
	}

	/* Store */
	private static class MoistureStats
	{
		public final int moisture;
		public final float hidden;

		public MoistureStats(int par1, float par2)
		{
			moisture = par1;
			hidden = par2;
		}
	}

	private static class MoistureExhaustion
	{
		public final float var;

		public MoistureExhaustion(float par1)
		{
			var = par1;
		}
	}
}
