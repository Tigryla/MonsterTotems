package io.github.mspacedev.blocks;

import io.github.mspacedev.blocks.infusedlogs.BlockZombieInfusedLog;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseI;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseII;
import io.github.mspacedev.blocks.totembases.BlockTotemBaseIII;
import io.github.mspacedev.blocks.totemheads.BlockZombieTotem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ModBlocks {
    public static Block zombie_infused_log = new BlockZombieInfusedLog("infused_log", Material.WOOD);
    public static Block zombie_totem = new BlockZombieTotem("zombie_totem", Material.WOOD);
    public static Block totem_base_i = new BlockTotemBaseI("totem_base_i", Material.WOOD);
    public static Block totem_base_ii = new BlockTotemBaseII("totem_base_ii", Material.WOOD);
    public static Block totem_base_iii = new BlockTotemBaseIII("totem_base_iii", Material.WOOD);

    public static final Block[] BLOCKS = {
            zombie_infused_log,
            zombie_totem,
            totem_base_i,
            totem_base_ii,
            totem_base_iii,
    };
}
