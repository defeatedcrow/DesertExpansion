package net.s0baco.desert.world;

import static net.minecraftforge.common.ChestGenHooks.*;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ChestGenHooks;
import net.s0baco.desert.block.chest.TileEntitySandstoneChest;
import net.s0baco.desert.core.DesertBlocks;
import net.s0baco.desert.core.DesertItems;
import net.s0baco.desert.core.DesertUtil;
import cpw.mods.fml.common.IWorldGenerator;

public class DesertWorldGenerator implements IWorldGenerator
{
	public static void initPyramid()
	{
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.cactus), 0, 5, 20, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.cactus), 0, 5, 20, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.cactus), 0, 5, 20, 10));

		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(DesertItems.advceramic_ingot), 1, 4, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(DesertItems.advceramic_ingot), 1, 4, 10));

		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(DesertItems.desert_diamond), 1, 2, 3));

		/* Crops */
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider instanceof WorldProviderSurface)
		{
			this.generateSurface(world, random, chunkX << 4, chunkZ << 4);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 1 + random.nextInt(3); i++)
		{
			int randomPosX = chunkX + random.nextInt(16);
			int randomPosY = 5 + random.nextInt(14);
			int randomPosZ = chunkZ + random.nextInt(16);

			BiomeGenBase biome = world.getBiomeGenForCoords(randomPosX, randomPosZ);

			if(DesertUtil.isSandy(biome))
			{
				(new WorldGenMinable(DesertBlocks.desert_diamond_ore, random.nextInt(7) + 1)).generate(world, random, randomPosX, randomPosY, randomPosZ);
			}
		}

		if(BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(chunkX, chunkZ), BiomeDictionary.Type.DESERT) || BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(chunkX, chunkZ), BiomeDictionary.Type.SANDY))
		{
			for (int i = 0; i < 10; i++)
			{
				int randPosX = chunkX + random.nextInt(16) + 8;
				int randPosY = random.nextInt(128);
				int randPosZ = chunkZ + random.nextInt(16) + 8;

				new DesertGrassGenerator().generate(world, random, randPosX, randPosY, randPosZ);
			}
		}

		// Chest
		for (int i = 0; i < 1 + random.nextInt(7); i++)
		{
			int x = chunkX + random.nextInt(16);
			int y = 0;
			int z = chunkZ + random.nextInt(16);

			BiomeGenBase biome = world.getBiomeGenForCoords(x, z);

			y = world.getHeightValue(x, z);

			if(world.isAirBlock(x, y, z))
			{
				return;
			}

			if(DesertUtil.isSandy(biome))
			{
				Block topBlock = world.getBiomeGenForCoords(x, z).topBlock;

				if(topBlock.getMaterial().isLiquid())
				{
					topBlock = Blocks.air;
				}

				if ((world.getBlock(x, y - 1, z) == Blocks.sand || world.getBlock(x, y - 1, z) == Blocks.hardened_clay || world.getBlock(x, y - 1, z) == Blocks.stained_hardened_clay) || (topBlock != Blocks.air && world.getBlock(x, y - 1, z) == topBlock))
				{
					System.out.println("[LOOT CHEST POS] " + x + "," + y + "," + z);

					int rare = random.nextInt(12);

					if(rare > 7)
					{
						world.setBlock(x, y - 2, z, Blocks.chest);
						TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y - 2, z);

						if (tileentitychest != null && tileentitychest != null)
							WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(PYRAMID_JUNGLE_CHEST, random), tileentitychest, ChestGenHooks.getCount(PYRAMID_JUNGLE_CHEST, random));
					}
					else if(rare >= 3)
					{
//						world.setBlock(x, y - 2, z, Blocks.chest);
						world.setBlock(x, y - 2, z, DesertBlocks.sandstone_chest);
//						TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y - 2, z);
						TileEntitySandstoneChest tileentitychest = (TileEntitySandstoneChest)world.getTileEntity(x, y - 2, z);

						if (tileentitychest != null && tileentitychest != null)
							WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(PYRAMID_DESERT_CHEST, random), tileentitychest, ChestGenHooks.getCount(PYRAMID_DESERT_CHEST, random));
					}
					else
					{
						world.setBlock(x, y - 2, z, Blocks.chest);
						TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y - 2, z);

						if (tileentitychest != null && tileentitychest != null)
							WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(DUNGEON_CHEST, random), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
					}
				}
			}
		}
	}

	public class DesertGrassGenerator extends WorldGenerator
	{
		@Override
		public boolean generate(World world, Random random, int i, int j, int k)
		{
			for (int l = 0; l < 64; l++)
			{
				int i1 = i + random.nextInt(8) - random.nextInt(8);
				int j1 = j + random.nextInt(4) - random.nextInt(4);
				int k1 = k + random.nextInt(8) - random.nextInt(8);

				if ((world.isAirBlock(i1, j1, k1)) && (DesertBlocks.desert_grass.canBlockStay(world, i1, j1, k1)))
				{
					world.setBlock(i1, j1, k1, DesertBlocks.desert_grass);
				}
			}

			return true;
		}
	}
}
