package io.github.mspacedev.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ModBlocks {
    public static Block infused_log = new BlockInfusedLog("infused_log", Material.WOOD);

    public static final Block[] BLOCKS = {
        infused_log
    };
}
