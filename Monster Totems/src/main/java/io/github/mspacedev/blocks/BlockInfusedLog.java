package io.github.mspacedev.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockInfusedLog extends BlockBase {
    public BlockInfusedLog(String name, Material materialIn) {
        super(name, materialIn);
        setSoundType(SoundType.WOOD);
        setHardness(2.0f);
        setHarvestLevel("axe", 0);
    }
}
