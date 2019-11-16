/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.handlers;

import io.github.mspacedev.Configs;
import io.github.mspacedev.registries.TotemBaseRegistries;
import io.github.mspacedev.registries.TotemBaseRegistry;
import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.tiles.TileEntityTotemBaseI;
import io.github.mspacedev.tiles.TileEntityTotemBaseII;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import io.github.mspacedev.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class TotemBaseEventHandler
{
	@SubscribeEvent
	public static void onLivingEntitySpawn(LivingSpawnEvent.CheckSpawn event)
	{
		checkTotemBaseDistance(event);
	}

	private static void checkTotemBaseDistance(LivingSpawnEvent.CheckSpawn event)
	{
		World world = event.getWorld();

		int dimID = world.provider.getDimension();
		TotemBaseRegistry totemBaseRegistry = TotemBaseRegistries.getTotemBaseRegistryFromDimension(dimID);
		BlockPos entityPos = event.getEntity().getPosition();

		if (!world.isRemote)
		{
			for (BlockPos pos : totemBaseRegistry.getPositions())
			{
				TileEntity te = world.getTileEntity(pos);
				if (te != null)
				{
					if (te instanceof TileEntityTotemBaseI && Utils.canSpawnWithinRange(Configs.totemBaseIRange, pos, entityPos, Configs.isCubicRange))
					{
						denySpawning(event, (TileEntityTotemBase) te);
						break;
					} else if (te instanceof TileEntityTotemBaseII && Utils.canSpawnWithinRange(Configs.totemBaseIIRange, pos, entityPos, Configs.isCubicRange))
					{
						denySpawning(event, (TileEntityTotemBase) te);
						break;
					} else if (te instanceof TileEntityTotemBaseIII && Utils.canSpawnWithinRange(Configs.totemBaseIIIRange, pos, entityPos, Configs.isCubicRange))
					{
						denySpawning(event, (TileEntityTotemBase) te);
						break;
					}
				}
			}
		}
	}

	private static void denySpawning(LivingSpawnEvent.CheckSpawn event, TileEntityTotemBase totemBase)
	{
		Entity entity = event.getEntity();

		if ((entity instanceof EntityZombie && totemBase.hasZombie) && !entity.getClass().equals(EntityPigZombie.class))
			event.setResult(Event.Result.DENY);
		else if (entity instanceof AbstractSkeleton && totemBase.hasSkeleton)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityCreeper && totemBase.hasCreeper)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntitySpider && totemBase.hasSpider)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityEnderman && totemBase.hasEnderman)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityWitch && totemBase.hasWitch)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntitySilverfish && totemBase.hasSilverfish)
			event.setResult(Event.Result.DENY);
		else if (entity.getClass().equals(EntityMagmaCube.class) && totemBase.hasMagmaCube)
			event.setResult(Event.Result.DENY);
		else if (entity.getClass().equals(EntitySlime.class) && totemBase.hasSlime)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityBlaze && totemBase.hasBlaze)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityGhast && totemBase.hasGhast)
			event.setResult(Event.Result.DENY);
		else if (entity instanceof EntityPigZombie && totemBase.hasZombiePigman)
			event.setResult(Event.Result.DENY);
		else if (entity.isCreatureType(EnumCreatureType.MONSTER, false) && totemBase.isMaster)
			event.setResult(Event.Result.DENY);
	}
}
