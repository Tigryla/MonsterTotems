package io.github.mspacedev.blocks.infusedlogs;

import io.github.mspacedev.MonsterTotems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockZombieInfusedLog extends BlockInfusedLog
{
	public BlockZombieInfusedLog(String name, Material materialIn)
	{
		super(name, materialIn, "tooltip.zombie_infused_log");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		MonsterTotems.proxy.genMagicParticle(this, pos, 50, 255, 50);
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
	}
}
