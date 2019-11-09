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

public class TotemBaseRegistry
{
	private ArrayList<BlockPos> totemBasePositions;

	public TotemBaseRegistry(ArrayList<BlockPos> totemBasePositions)
	{
		this.totemBasePositions = totemBasePositions;
	}

	public void addTotem(BlockPos pos)
	{
		if (totemBasePositions.contains(pos))
			return;

		totemBasePositions.add(pos);
	}

	public void removeTotem(BlockPos pos)
	{
		if (!totemBasePositions.contains(pos))
			return;

		totemBasePositions.remove(pos);
	}

	public ArrayList<BlockPos> getPositions()
	{
		return totemBasePositions;
	}
}
