package net.s0baco.desert;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.s0baco.desert.core.DesertBlocks;
import net.s0baco.desert.core.DesertItems;
import net.s0baco.desert.core.DesertOreDictionary;
import net.s0baco.desert.core.DesertRecipes;
import net.s0baco.desert.integration.DesertPlugins;
import net.s0baco.desert.proxy.CommonProxy;
import net.s0baco.desert.world.DesertVillageHandler;
import net.s0baco.desert.world.DesertWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod
(
	modid        = "s0baco.desertexpansion",
	name         = "Desert Expansion",
	version      = "1.0.4",
	dependencies = "required-after:Forge@[10.13.0.1291,);after:desertcraft;after:harvestcraft;after:Thaumcraft;after:MoreInventoryMod;after:DCsAppleMilk;after:SextiarySector"
)
public class DesertExpansion
{
	@Mod.Instance("s0baco.desertexpansion")
	public static DesertExpansion instance;

//	public static final CreativeTabs tabDesert = instance.new CreativeTab("desertexpansion");
	public static final CreativeTabs tabDesert = new CreativeTab("desertexpansion");

	@SidedProxy(clientSide = "net.s0baco.desert.proxy.ClientProxy", serverSide = "net.s0baco.desert.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configurations.load(event);

		DesertExpansion.instance.proxy.setCustomRenderers();

		DesertItems.init();
		DesertBlocks.init();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		DesertOreDictionary.init();
		DesertRecipes.init();

		DesertWorldGenerator.initPyramid();

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);

//		MinecraftForge.EVENT_BUS.register(new CultivateEventHandler());

		MinecraftForge.TERRAIN_GEN_BUS.register(new DesertVillageHandler());

		GameRegistry.registerWorldGenerator(new DesertWorldGenerator(), 1);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		DesertPlugins.load();
	}

	/* subclass */

	public static class Configurations
	{
		public static void initialize(Configuration cfg)
		{
//			useDesertcraft = cfg.getBoolean("Pam's Mods", "general", true, "");
		}

		public static void load(FMLPreInitializationEvent event)
		{
			Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

			try
			{
				cfg.load();

				initialize(cfg);
			}
			catch(Exception e)
			{
			}
			finally
			{
				cfg.save();
			}
		}
	}

	public static class CreativeTab extends CreativeTabs
	{
		public CreativeTab(String label)
		{
			super(label);
		}

		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.cactus);
		}
	}
}
