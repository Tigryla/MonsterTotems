package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.tiles.TileEntityTotemBaseII;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockTotemBaseII extends BlockTotemBase implements ITileEntityProvider {
    public BlockTotemBaseII(String name, Material materialIn) {
        super(name, materialIn, "tooltip.totem_base_ii");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTotemBaseII();
    }
}
