/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.handlers;

import io.github.mspacedev.registries.TotemBaseRegistries;
import io.github.mspacedev.registries.TotemBaseRegistry;
import io.github.mspacedev.utils.Utils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class TotemBaseRegistryEventHandler
{
	// Load totem base positional data into registries
	@SubscribeEvent
	public void OnWorldLoad(WorldEvent.Load event)
	{
		World world = event.getWorld();
		TotemBaseData.load(world);
	}

	// Save totem base positional data from registries
	@SubscribeEvent
	public void OnWorldUnload(WorldEvent.Unload event)
	{
		World world = event.getWorld();
		int dimID = world.provider.getDimension();
		ArrayList<BlockPos> positions = getPositionsFromRegistry(dimID);

		if (!positions.isEmpty())
		{
			TotemBaseData.save(world, dimID, positions);
			Utils.getLogger().info("Positional data saved.");
		} else
			Utils.getLogger().info("Positional data empty!");
	}

	private ArrayList<BlockPos> getPositionsFromRegistry(int dimID)
	{
		TotemBaseRegistry registry = TotemBaseRegistries.getTotemBaseRegistryFromDimension(dimID);

		return registry.getPositions();
	}

	public static class TotemBaseData extends WorldSavedData
	{
		private static final String DATA_NAME = "totembaseregistries";

		private int dimID;
		private ArrayList<BlockPos> positions;

		// Default constructor to prevent runtime exception from MapStorage#getOrLoadData
		public TotemBaseData(String name)
		{
			super(name);
		}

		TotemBaseData(int dimID, ArrayList<BlockPos> positions)
		{
			super(DATA_NAME);

			this.dimID = dimID;
			this.positions = positions;
		}

		public static TotemBaseData load(World world)
		{
			MapStorage storage = world.getMapStorage();
			TotemBaseData data = (TotemBaseData) storage.getOrLoadData(TotemBaseData.class, DATA_NAME);

			// Create empty data if world does not have existing data
			if (data == null)
			{
				data = new TotemBaseData(DATA_NAME);
				storage.setData(DATA_NAME, data);
			}

			return data;
		}

		public static void save(World world, int dimID, ArrayList<BlockPos> positions)
		{
			MapStorage storage = world.getMapStorage();

			TotemBaseData data = new TotemBaseData(dimID, positions);
			storage.setData(DATA_NAME, data);

			data.markDirty();
			world.getMapStorage().saveAllData();
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt)
		{
			Integer[] dimIDs = DimensionManager.getIDs();

			// Reads NBT for each dimension and adds them to each registry.
			for (Integer dimID : dimIDs)
			{
				if (nbt.hasKey(dimID.toString()))
				{
					ArrayList<BlockPos> positions = new ArrayList<>();

					NBTTagIntArray coordsNBT = (NBTTagIntArray) nbt.getTag(dimID.toString());
					int[] coords = coordsNBT.getIntArray();

					for (int i = 0; i < coords.length; i += 3)
					{
						positions.add(
								new BlockPos(
										coords[i],
										coords[i + 1],
										coords[i + 2]
								)
						);
					}

					TotemBaseRegistries.addTotemBaseRegistryWithPositions(dimID, positions);
				}
			}
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound)
		{
			NBTTagIntArray coords = new NBTTagIntArray(getCoordsFromBlockPositions(positions));

			compound.setTag(Integer.toString(dimID), coords);

			return compound;
		}

		private ArrayList<Integer> getCoordsFromBlockPositions(ArrayList<BlockPos> positions)
		{
			ArrayList<Integer> coords = new ArrayList<>();

			for (BlockPos pos : positions)
			{
				coords.add(pos.getX());
				coords.add(pos.getY());
				coords.add(pos.getZ());
			}

			return coords;
		}
	}
}
