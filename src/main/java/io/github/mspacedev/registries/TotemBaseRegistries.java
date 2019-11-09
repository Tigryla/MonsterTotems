/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.registries;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.HashMap;

public class TotemBaseRegistries
{
	private static HashMap<Integer, TotemBaseRegistry> totemBaseRegistries = new HashMap<>();

	public static TotemBaseRegistry getTotemBaseRegistryFromDimension(int dimID)
	{
		return totemBaseRegistries.computeIfAbsent(dimID, s -> new TotemBaseRegistry(new ArrayList<>()));
	}

	public static void addTotemBaseRegistryWithPositions(int dimID, ArrayList<BlockPos> positions)
	{
		if (!totemBaseRegistries.containsKey(dimID))
			totemBaseRegistries.put(dimID, new TotemBaseRegistry(positions));
	}
}
