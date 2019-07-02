package io.github.mspacedev.blocks.infusedlogs;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityInfusedLog;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockInfusedLog extends BlockWoodBase {
    public BlockInfusedLog(String name, Material materialIn) {
        super(name, materialIn);
        this.setLightLevel(0.5f);
    }

    public BlockInfusedLog(String name, Material materialIn, String tooltip) {
        super(name, materialIn, tooltip);
        this.setLightLevel(0.5f);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityInfusedLog();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
