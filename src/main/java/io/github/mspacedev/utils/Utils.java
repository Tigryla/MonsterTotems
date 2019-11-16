/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.utils;

import io.github.mspacedev.Configs;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils
{

	private static Logger logger;

	public static Logger getLogger()
	{
		if (logger == null)
		{
			logger = LogManager.getFormatterLogger(Reference.MODID);
		}
		return logger;
	}

	public static boolean canSpawnWithinRange(double range, BlockPos totemBasePos, BlockPos entityPos, boolean isCubic)
	{
		if (isCubic)
		{
			double minX = totemBasePos.getX() - range;
			double minY = totemBasePos.getY() - range;
			double minZ = totemBasePos.getZ() - range;
			double maxX = totemBasePos.getX() + range + 1;
			double maxY = totemBasePos.getY() + range + 1;
			double maxZ = totemBasePos.getZ() + range + 1;

			if (Configs.isYAlways256)
				return minX <= entityPos.getX() && maxX >= entityPos.getX() &&
						minZ <= entityPos.getZ() && maxZ >= entityPos.getZ();
			else
				return minX <= entityPos.getX() && maxX >= entityPos.getX() &&
						minY <= entityPos.getY() && maxY >= entityPos.getY() &&
						minZ <= entityPos.getZ() && maxZ >= entityPos.getZ();
		} else
		{
			double distance;

			if (Configs.isYAlways256)
				distance = Math.sqrt(
						Math.pow(totemBasePos.getX() - entityPos.getX(), 2) +
								Math.pow(totemBasePos.getZ() - entityPos.getZ(), 2)
				);
			else
				distance = Math.sqrt(
						Math.pow(totemBasePos.getX() - entityPos.getX(), 2) +
								Math.pow(totemBasePos.getY() - entityPos.getY(), 2) +
								Math.pow(totemBasePos.getZ() - entityPos.getZ(), 2)
				);

			return distance <= range;
		}
	}
}
