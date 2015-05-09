package net.s0baco.desert.integration;

import net.s0baco.desert.integration.plugin.PluginAppleMilkTea;
import net.s0baco.desert.integration.plugin.PluginDesertcraft;
import net.s0baco.desert.integration.plugin.PluginHarvestcraft;
import net.s0baco.desert.integration.plugin.PluginSextiarySector;
import net.s0baco.desert.integration.plugin.PluginThaumcraft;
import cpw.mods.fml.common.Loader;

public class DesertPlugins
{
	public static void preLoad()
	{
	}

	public static void load()
	{
		if(Loader.isModLoaded("desertcraft"))
		{
			PluginDesertcraft.init();
		}

		if(Loader.isModLoaded("harvestcraft"))
		{
			PluginHarvestcraft.init();
		}

		if(Loader.isModLoaded("SextiarySector"))
		{
			PluginSextiarySector.init();
		}

		if(Loader.isModLoaded("DCsAppleMilk"))
		{
			PluginAppleMilkTea.init();
		}

		if(Loader.isModLoaded("Thaumcraft"))
		{
			PluginThaumcraft.init();
		}
	}
}
