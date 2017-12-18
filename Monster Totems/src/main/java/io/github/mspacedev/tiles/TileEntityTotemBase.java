package io.github.mspacedev.tiles;

import com.sun.istack.internal.NotNull;
import io.github.mspacedev.TotemBaseEventHandler;
import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class TileEntityTotemBase extends TileEntity {
    public boolean hasZombie;
    public boolean hasSkeleton;
    public boolean hasCreeper;
    public boolean hasSpider;
    public boolean hasEnderman;
    public boolean hasWitch;
    public boolean hasSilverfish;
    public boolean hasSlime;
    public boolean hasBlaze;
    public boolean hasZombiePigman;
    public boolean hasGhast;
    public boolean hasMagmaCube;
    
    public TileEntityTotemBase() {

    }

    // Sets totem properties based on what block was placed above the totem base
    public void setTotemProperties() {
        resetTotemProperties();
        Iterable<BlockPos> totemBaseRange = BlockPos.getAllInBox(pos, pos.add(0.0D, 12.0D, 0.0D));

        for (BlockPos posRange : totemBaseRange) {
            Block current = getWorld().getBlockState(posRange).getBlock();

            if(current == Blocks.AIR) {
                break;
            }

            if (current == ModBlocks.zombie_totem) {
                hasZombie = true;
            } else if (current == ModBlocks.skeleton_totem) {
                hasSkeleton = true;
            } else if (current == ModBlocks.creeper_totem) {
                hasCreeper = true;
            } else if (current == ModBlocks.spider_totem) {
                hasSpider = true;
            } else if (current == ModBlocks.enderman_totem) {
                hasEnderman = true;
            } else if (current == ModBlocks.witch_totem) {
                hasWitch = true;
            } else if (current == ModBlocks.silverfish_totem) {
                hasSilverfish = true;
            } else if (current == ModBlocks.slime_totem) {
                hasSlime = true;
            } else if (current == ModBlocks.blaze_totem) {
                hasBlaze = true;
            } else if (current == ModBlocks.zombie_pigman_totem) {
                hasZombiePigman = true;
            } else if (current == ModBlocks.ghast_totem) {
                hasGhast = true;
            } else if (current == ModBlocks.magma_cube_totem) {
                hasMagmaCube = true;
            } else if(current == new Block(Material.WOOD)) {
                hasBlaze = true;
                hasGhast = true;
                hasMagmaCube = true;
                hasZombiePigman = true;
            }
        }
    }

    private void resetTotemProperties() {
        hasZombie = false;
        hasSkeleton = false;
        hasCreeper = false;
        hasSpider = false;
        hasEnderman = false;
        hasWitch = false;
        hasSilverfish = false;
        hasSlime = false;
        hasBlaze = false;
        hasGhast = false;
        hasZombiePigman = false;
        hasMagmaCube = false;
    }
}
