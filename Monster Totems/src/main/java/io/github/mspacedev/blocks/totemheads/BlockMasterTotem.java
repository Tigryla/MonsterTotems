package io.github.mspacedev.blocks.totemheads;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockMasterTotem extends BlockTotemHeadBase
{
	public static final PropertyEnum<EnumTotemPos> TOTEM_POS = PropertyEnum.create("totem_pos", EnumTotemPos.class);

	public BlockMasterTotem(String name, Material materialIn)
	{
		super(name, materialIn, "tooltip.master_totem");
		this.setDefaultState(this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.BOTTOM));
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		switch (meta)
		{
			case 0:
				return this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.BOTTOM);
			case 1:
				return this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.MIDDLE);
			case 2:
				return this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.TOP);
		}

		return super.getStateFromMeta(meta);
	}

	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.MIDDLE), 2);
		worldIn.setBlockState(pos.up(2), this.getDefaultState().withProperty(TOTEM_POS, EnumTotemPos.TOP), 2);
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		switch (state.getValue(TOTEM_POS))
		{
			case BOTTOM:
				return 0;
			case MIDDLE:
				return 1;
			case TOP:
				return 2;
		}

		return super.getMetaFromState(state);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		return pos.getY() < world.getHeight() - 2 && (world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP) && super.canPlaceBlockAt(world, pos) && super.canPlaceBlockAt(world, pos.up()) && super.canPlaceBlockAt(world, pos.up(2)));
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		if (state.getValue(TOTEM_POS) == EnumTotemPos.BOTTOM)
		{
			BlockPos posMid = pos.up();
			BlockPos posTop = pos.up(2);

			worldIn.setBlockToAir(posMid);
			worldIn.setBlockToAir(posTop);
		} else if (state.getValue(TOTEM_POS) == EnumTotemPos.MIDDLE)
		{
			BlockPos posBot = pos.up();
			BlockPos posTop = pos.down();

			worldIn.setBlockToAir(posBot);
			worldIn.setBlockToAir(posTop);
		} else if (state.getValue(TOTEM_POS) == EnumTotemPos.TOP)
		{
			BlockPos posMid = pos.down();
			BlockPos posBot = pos.down(2);

			worldIn.setBlockToAir(posMid);
			worldIn.setBlockToAir(posBot);
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[]{TOTEM_POS});
	}

	public enum EnumTotemPos implements IStringSerializable
	{
		TOP,
		MIDDLE,
		BOTTOM;

		@Override
		public String getName()
		{
			switch (this)
			{
				case TOP:
					return "top";
				case MIDDLE:
					return "middle";
				case BOTTOM:
					return "bottom";
				default:
					return "";
			}
		}
	}
}
