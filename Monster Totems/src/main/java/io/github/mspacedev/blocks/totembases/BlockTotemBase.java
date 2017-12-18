package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityTotemBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockTotemBase extends BlockWoodBase {
    public BlockTotemBase(String name, Material materialIn) {
        super(name, materialIn);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(!worldIn.isRemote) {
            if(worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase) {
                    TileEntityTotemBase totem_base = (TileEntityTotemBase) worldIn.getTileEntity(pos);
                    totem_base.setTotemProperties();
                }
            }
        }

        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            if(worldIn.getTileEntity(pos) != null) {
                if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase) {
                    TileEntityTotemBase totem_base = (TileEntityTotemBase) worldIn.getTileEntity(pos);
                    totem_base.setTotemProperties();
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }
}
