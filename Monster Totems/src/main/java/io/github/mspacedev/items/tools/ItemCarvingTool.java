package io.github.mspacedev.items.tools;

import io.github.mspacedev.tiles.TileEntityInfusedLog;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemCarvingTool extends ItemAxeBase {
    public ItemCarvingTool(String name, ToolMaterial material, float damage, float speed) {
        super(name, material, damage, speed);
        this.setMaxDamage(160);
        this.setMaxStackSize(1);
        tooltipText.add("Use on infused logs to carve them into totem heads");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        // Increase carve amount and create totems
        if(!worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityInfusedLog) {
                    TileEntityInfusedLog infusedLog = (TileEntityInfusedLog) worldIn.getTileEntity(pos);
                    player.getHeldItem(hand).damageItem(1, player);
                    infusedLog.convertToTotemHead();
                }
            }
        }

        // Display block break particles and play sound
        if(worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityInfusedLog) {
                    worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    worldIn.playEvent(2001, pos, Block.getStateId(worldIn.getBlockState(pos)));
                }
            }
        }
        
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        stack.damageItem(1, entityLiving);
        return false;
    }
}
