package io.github.mspacedev.blocks.totemheads;

import io.github.mspacedev.blocks.BlockWoodBase;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockSpiderTotem extends BlockTotemHeadBase {
    public BlockSpiderTotem(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add("Stops Spiders from spawning when");
        tooltipText.add("placed on a totem base");
    }
}
