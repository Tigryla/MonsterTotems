package io.github.mspacedev.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

import java.util.Set;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemToolBase extends ItemTool {
    public ItemToolBase(String name, float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
        this.setUnlocalizedName(name);

    }
}
