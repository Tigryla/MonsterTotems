/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.init;

import io.github.mspacedev.tiles.TileEntityInfusedLog;
import io.github.mspacedev.tiles.TileEntityTotemBaseI;
import io.github.mspacedev.tiles.TileEntityTotemBaseII;
import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitTileEntities
{
	public static void register()
	{
		registerTileEntity(TileEntityTotemBaseI.class, "totem_base_i");
		registerTileEntity(TileEntityTotemBaseII.class, "totem_base_ii");
		registerTileEntity(TileEntityTotemBaseIII.class, "totem_base_iii");
		registerTileEntity(TileEntityInfusedLog.class, "infused_log");
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key)
	{
		GameRegistry.registerTileEntity(tileEntityClass, "monstertotems:" + key);
	}
}
