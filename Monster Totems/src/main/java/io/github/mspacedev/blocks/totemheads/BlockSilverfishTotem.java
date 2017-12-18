package io.github.mspacedev.blocks.totemheads;

import io.github.mspacedev.blocks.BlockWoodBase;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockSilverfishTotem extends BlockTotemHeadBase {
    public BlockSilverfishTotem(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add("Stops Silverfish from spawning when");
        tooltipText.add("placed on a totem base");
    }
}
