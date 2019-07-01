package io.github.mspacedev.blocks.totemheads;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockBlazeTotem extends BlockTotemHeadBase {
    public BlockBlazeTotem(String name, Material materialIn) {
        super(name, materialIn);
        tooltipText.add(I18n.format("tooltip.blaze_totem"));
    }
}