/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.handlers;

import io.github.mspacedev.registries.TotemBaseRegistries;
import io.github.mspacedev.utils.Utils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

@Mod.EventBusSubscriber
public class TotemBaseRegistryEventHandler
{
	// Load totem base positional data into registries
	@SubscribeEvent
	public void OnWorldLoad(WorldEvent.Load event)
	{
		TotemBaseData.load(event.getWorld());
	}

	// Save totem base positional data from registries
	@SubscribeEvent
	public void OnWorldUnload(WorldEvent.Unload event)
	{
		World world = event.getWorld();
		Integer[] dimIDs = getAllDimensionIDs();

		TotemBaseData.save(world, dimIDs);
		Utils.getLogger().info("Positional data saved for dimensions: " + Arrays.toString(dimIDs));
	}

	private Integer[] getAllDimensionIDs()
	{
		DimensionType[] dimTypes = DimensionType.values();

		ArrayList<Integer> dimIDsArray = new ArrayList<>();
		for (DimensionType dimType : dimTypes)
		{
			int[] ids = DimensionManager.getDimensions(dimType);

			for (int i : ids)
				dimIDsArray.add(i);
		}

		Integer[] dimIDs = new Integer[dimIDsArray.size()];
		for (int i = 0; i < dimIDsArray.size(); i++)
		{
			dimIDs[i] = dimIDsArray.get(i);
		}

		return dimIDs;
	}

	public static class TotemBaseData extends WorldSavedData
	{
		private static final String DATA_NAME = "totembaseregistries";

		private Integer[] dimIDs;

		// Default constructor to prevent runtime exception from MapStorage#getOrLoadData
		public TotemBaseData(String name)
		{
			super(name);
		}

		TotemBaseData(Integer[] dimIDs)
		{
			super(DATA_NAME);
			this.dimIDs = dimIDs;
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

		public static void save(World world, Integer[] dimIDs)
		{
			MapStorage storage = world.getMapStorage();

			TotemBaseData data = new TotemBaseData(dimIDs);
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
										coords[i + 0],
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
			for (int dimID : dimIDs)
			{
				ArrayList<BlockPos> positions = TotemBaseRegistries.getTotemBaseRegistryFromDimension(dimID).getPositions();
				NBTTagIntArray coords = new NBTTagIntArray(getCoordsFromBlockPositions(positions));
				compound.setTag(Integer.toString(dimID), coords);
			}

			return compound;
		}

		private int[] getCoordsFromBlockPositions(ArrayList<BlockPos> positions)
		{
			int[] coords = new int[positions.size() * 3];

			int i = 0;
			for (BlockPos pos : positions)
			{
				coords[i + 0] = pos.getX();
				coords[i + 1] = pos.getY();
				coords[i + 2] = pos.getZ();

				i += 3;
			}

			return coords;
		}
	}
}
