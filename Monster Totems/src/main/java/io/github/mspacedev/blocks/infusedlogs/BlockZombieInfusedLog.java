package io.github.mspacedev.blocks.infusedlogs;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityInfusedLog;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockZombieInfusedLog extends BlockWoodBase implements ITileEntityProvider{
    public BlockZombieInfusedLog(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add("Carve with the Carving Tool to create");
        tooltipText.add("a Zombie Totem Head");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityInfusedLog();
    }
}
