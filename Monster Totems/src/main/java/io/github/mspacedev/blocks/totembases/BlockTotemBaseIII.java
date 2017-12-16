package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockTotemBaseIII extends BlockWoodBase implements ITileEntityProvider {
    public BlockTotemBaseIII(String name, Material materialIn) {
        super(name, materialIn);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        tooltip.add("Totem Effects apply in a 256 block radius");
        super.addInformation(stack, player, tooltip, advanced);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTotemBaseIII();
    }
}
