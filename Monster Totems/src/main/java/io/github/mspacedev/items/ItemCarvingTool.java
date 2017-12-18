package io.github.mspacedev.items;

import io.github.mspacedev.Reference;
import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.blocks.infusedlogs.BlockZombieInfusedLog;
import io.github.mspacedev.tiles.TileEntityInfusedLog;
import io.github.mspacedev.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemCarvingTool extends ItemBase {
    public ItemCarvingTool(String name) {
        super(name);
        setMaxStackSize(1);
        setMaxDamage(15);
        tooltipText.add("Use on infused logs to carve them into totem heads");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityInfusedLog infusedLog = null;

        // Increase carve amount and create totems
        if(!worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityInfusedLog) {
                    infusedLog = (TileEntityInfusedLog) worldIn.getTileEntity(pos);
                    infusedLog.convertToTotemHead();
                }
            }
        }

        // Display block break particles and play sound
        if(worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityInfusedLog) {
                    worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1000.0f, 1.0f, false);
                    worldIn.playEvent(2001, pos, Block.getStateId(worldIn.getBlockState(pos)));
                }
            }
        }
        
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
