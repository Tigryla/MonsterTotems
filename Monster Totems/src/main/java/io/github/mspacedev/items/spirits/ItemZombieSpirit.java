package io.github.mspacedev.items.spirits;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.blocks.infusedlogs.BlockZombieInfusedLog;
import io.github.mspacedev.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemZombieSpirit extends ItemSpiritBase {
    public ItemZombieSpirit(String name) {
        super(name);
        tooltipText.add("Right Click on a log to infuse");
        tooltipText.add("the spirit into it");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.getBlockState(pos) == Blocks.LOG.getDefaultState() || worldIn.getBlockState(pos) == Blocks.LOG2.getDefaultState()) {
            conversionDisplay(worldIn, pos);
            worldIn.setBlockState(pos, ModBlocks.zombie_infused_log.getDefaultState());
        }

        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
