package io.github.mspacedev.blocks.infusedlogs;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityInfusedLog;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockInfusedLog extends BlockWoodBase implements ITileEntityProvider{
    private boolean hasSpawned;

    public BlockInfusedLog(String name, Material materialIn) {
        super(name, materialIn);
        this.setLightLevel(0.5f);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        MonsterTotems.proxy.genMagicParticle(this, pos);
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        hasSpawned = false;
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityInfusedLog();
    }
}
