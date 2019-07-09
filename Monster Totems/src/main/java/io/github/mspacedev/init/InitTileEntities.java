package io.github.mspacedev.init;

import io.github.mspacedev.tiles.TileEntityInfusedLog;
import io.github.mspacedev.tiles.TileEntityTotemBaseI;
import io.github.mspacedev.tiles.TileEntityTotemBaseII;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class InitTileEntities
{
	public static void register()
	{
		GameRegistry.registerTileEntity(TileEntityTotemBaseI.class, "totem_base_i");
		GameRegistry.registerTileEntity(TileEntityTotemBaseII.class, "totem_base_ii");
		GameRegistry.registerTileEntity(TileEntityTotemBaseIII.class, "totem_base_iii");
		GameRegistry.registerTileEntity(TileEntityInfusedLog.class, "infused_log");
	}
}
