package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockBase;
import io.github.mspacedev.tiles.TileEntityTotemBaseI;
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

public class BlockTotemBaseI extends BlockTotemBase implements ITileEntityProvider{
    public BlockTotemBaseI(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add("§bRadius: 64 blocks");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTotemBaseI();
    }
}
