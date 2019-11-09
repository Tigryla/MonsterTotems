/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.tiles.TileEntityTotemBaseIII;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTotemBaseIII extends BlockTotemBase
{
	public BlockTotemBaseIII(String name, Material materialIn)
	{
		super(name, materialIn, "tooltip.totem_base_iii");
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityTotemBaseIII();
	}

	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
}
