package io.github.mspacedev.tiles;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class TileEntityInfusedLog extends TileEntity {
    private int carveAmount = 0;

    public void convertToTotemHead() {
        Block infusedLog = getWorld().getBlockState(pos).getBlock();
        carveAmount++;
        Utils.getLogger().info("Carved on server?");
        if(carveAmount >= 3) {
            createTotem(infusedLog);
        }
    }

    private void createTotem(Block infusedLog) {
        if (infusedLog == ModBlocks.zombie_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.zombie_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.skeleton_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.skeleton_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.creeper_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.creeper_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.spider_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.spider_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.enderman_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.enderman_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.witch_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.witch_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.silverfish_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.silverfish_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.slime_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.slime_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.blaze_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.blaze_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.zombie_pigman_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.zombie_pigman_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.ghast_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.ghast_totem.getDefaultState());
        } else if (infusedLog == ModBlocks.magma_cube_infused_log) {
            getWorld().setBlockState(pos, ModBlocks.magma_cube_totem.getDefaultState());
        }
        Utils.getLogger().info("Totem created on server?");
    }
}
