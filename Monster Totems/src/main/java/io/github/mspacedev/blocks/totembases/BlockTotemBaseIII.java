package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
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

public class BlockTotemBaseIII extends BlockTotemBase implements ITileEntityProvider {
    public BlockTotemBaseIII(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add("Required for totems to work and");
        tooltipText.add("determines affected radius");
        tooltipText.add("§bRadius: 192 blocks");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTotemBaseIII();
    }
}
