package io.github.mspacedev.tiles;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ModTileEntities {
    public static void init(){
        GameRegistry.registerTileEntity(TileEntityTotemBaseI.class, "totem_base_i");
        GameRegistry.registerTileEntity(TileEntityTotemBaseII.class, "totem_base_ii");
        GameRegistry.registerTileEntity(TileEntityTotemBaseIII.class, "totem_base_iii");
    }
}
