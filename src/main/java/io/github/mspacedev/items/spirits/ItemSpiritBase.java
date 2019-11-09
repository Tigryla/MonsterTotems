/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.items.spirits;

import io.github.mspacedev.handlers.RegistryEventHandler;
import io.github.mspacedev.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSpiritBase extends ItemBase
{
	private Block infusedLog;

	public ItemSpiritBase(String name, Block infusedLog)
	{
		super(name, "tooltip.spirit");
		this.infusedLog = infusedLog;
	}

	protected void conversion(World world, BlockPos pos)
	{
		if (world.isRemote)
		{
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), RegistryEventHandler.convert_log, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (worldIn.getBlockState(pos).getBlock().equals(Blocks.LOG) || worldIn.getBlockState(pos).getBlock().equals(Blocks.LOG2))
		{
			conversion(worldIn, pos);
			worldIn.setBlockState(pos, infusedLog.getDefaultState());
			player.getHeldItem(hand).shrink(1);
		}

		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
}
