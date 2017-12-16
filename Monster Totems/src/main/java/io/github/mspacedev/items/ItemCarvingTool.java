package io.github.mspacedev.items;

import io.github.mspacedev.blocks.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemCarvingTool extends ItemBase {
    public ItemCarvingTool(String name) {
        super(name);
        setMaxStackSize(1);
        setMaxDamage(15);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("Use on infused logs to carve totems");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            if(worldIn.getBlockState(pos) == ModBlocks.zombie_infused_log.getDefaultState()){
                worldIn.destroyBlock(pos, false);
                worldIn.setBlockState(pos, ModBlocks.zombie_infused_log.getDefaultState());
            }
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
