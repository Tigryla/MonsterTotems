package io.github.mspacedev;

import io.github.mspacedev.tiles.TileEntityTotemBaseI;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod.EventBusSubscriber
public class TotemBaseEventHandler {
    @SubscribeEvent
    public static void totemBase(LivingSpawnEvent.CheckSpawn event){
        BlockPos eventPos = event.getEntity().getPosition();
        Iterable<BlockPos> totemBaseI = BlockPos.getAllInBox(eventPos.add(64.0f, 64.0f, 64.0f), eventPos.add(-64.0f, -64.0f, -64.0f));
        Iterable<BlockPos> totemBaseII = BlockPos.getAllInBox(eventPos.add(128.0f, 128.0f, 128.0f), eventPos.add(-128.0f, -128.0f, -128.0f));
        Iterable<BlockPos> totemBaseIII = BlockPos.getAllInBox(eventPos.add(256.0f, 256.0f, 256.0f), eventPos.add(-256.0f, -256.0f, -256.0f));

        World world = event.getWorld();

        for(BlockPos pos : totemBaseI){
            if(world.getTileEntity(pos) != null){
                if(world.getTileEntity(pos) instanceof TileEntityTotemBaseI){
                    event.setResult(Event.Result.DENY);
                }
            }
        }

        for(BlockPos pos : totemBaseII){
            if(world.getTileEntity(pos) != null){
                if(world.getTileEntity(pos) instanceof TileEntityTotemBaseI){
                    event.setResult(Event.Result.DENY);
                }
            }
        }

        for(BlockPos pos : totemBaseIII){
            if(world.getTileEntity(pos) != null){
                if(world.getTileEntity(pos) instanceof TileEntityTotemBaseI){
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
