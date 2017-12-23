package io.github.mspacedev.items.spirits;

import io.github.mspacedev.RegistryEventHandler;
import io.github.mspacedev.items.ItemBase;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemSpiritBase extends ItemBase {


    public ItemSpiritBase(String name) {
        super(name);
    }

    protected void conversionDisplay(World world, BlockPos pos) {
        if(world.isRemote) {
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), RegistryEventHandler.convert_log, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
        }
    }
}
