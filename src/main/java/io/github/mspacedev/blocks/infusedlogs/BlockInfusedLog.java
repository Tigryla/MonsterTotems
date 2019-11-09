/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.blocks.infusedlogs;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.tiles.TileEntityInfusedLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockInfusedLog extends BlockWoodBase
{
	public BlockInfusedLog(String name, Material materialIn)
	{
		super(name, materialIn);
		this.setLightLevel(0.5f);
	}

	public BlockInfusedLog(String name, Material materialIn, String tooltip)
	{
		super(name, materialIn, tooltip);
		this.setLightLevel(0.5f);
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityInfusedLog();
	}

	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
}
