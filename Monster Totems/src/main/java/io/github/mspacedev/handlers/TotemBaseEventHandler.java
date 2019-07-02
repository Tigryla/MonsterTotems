package io.github.mspacedev.handlers;

import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.tiles.TileEntityTotemBaseI;
import io.github.mspacedev.tiles.TileEntityTotemBaseII;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod.EventBusSubscriber
public class TotemBaseEventHandler {
    @SubscribeEvent
    public static void totemBase(LivingSpawnEvent.CheckSpawn event)
    {
        findTotemBase(event, 4);
        findTotemBase(event, 8);
        findTotemBase(event, 12);
    }

    private static void findTotemBase(LivingSpawnEvent.CheckSpawn event, int radius)
    {
        BlockPos pos = event.getEntity().getPosition();

        int chunkPosX = pos.getX() >> 4;
        int chunkPosZ = pos.getZ() >> 4;

        if (!event.getWorld().isRemote) {
            for (int x = chunkPosX - radius; x < chunkPosX + radius; x++) {
                for (int z = chunkPosZ - radius; z < chunkPosZ + radius; z++) {
                    Map<BlockPos, TileEntity> currentChunkTE = event.getWorld().getChunkFromChunkCoords(x, z).getTileEntityMap();
                    for (TileEntity te : currentChunkTE.values()) {
                        if (te != null) {
                            if (te instanceof TileEntityTotemBaseI && radius == 4) {
                                denySpawning(event, (TileEntityTotemBaseI) te);
                            } else if (te instanceof TileEntityTotemBaseII && radius == 8) {
                                denySpawning(event, (TileEntityTotemBaseII) te);
                            } else if (te instanceof TileEntityTotemBaseIII && radius == 12) {
                                denySpawning(event, (TileEntityTotemBaseIII) te);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void denySpawning(LivingSpawnEvent.CheckSpawn event, TileEntityTotemBase totemBase) {
        Entity entity = event.getEntity();

        if(entity instanceof EntityZombie && totemBase.hasZombie) {
            if(!(entity instanceof EntityPigZombie)) {
                event.setResult(Event.Result.DENY);
            }
        } else if (entity instanceof AbstractSkeleton && totemBase.hasSkeleton) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityCreeper && totemBase.hasCreeper) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntitySpider && totemBase.hasSpider) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityEnderman && totemBase.hasEnderman) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityWitch && totemBase.hasWitch) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntitySilverfish && totemBase.hasSilverfish) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityMagmaCube && totemBase.hasMagmaCube) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntitySlime && totemBase.hasSlime) {
            if(!(entity instanceof EntityMagmaCube)) {
                event.setResult(Event.Result.DENY);
            }
        } else if (entity instanceof EntityBlaze && totemBase.hasBlaze) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityGhast && totemBase.hasGhast) {
            event.setResult(Event.Result.DENY);
        } else if (entity instanceof EntityPigZombie && totemBase.hasZombiePigman) {
            event.setResult(Event.Result.DENY);
        }
    }
}
