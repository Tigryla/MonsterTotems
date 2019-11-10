/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.blocks.totembases;

import io.github.mspacedev.blocks.BlockWoodBase;
import io.github.mspacedev.registries.TotemBaseRegistries;
import io.github.mspacedev.registries.TotemBaseRegistry;
import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.utils.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class BlockTotemBase extends BlockWoodBase
{
	private String radiusText;
	private String tooltipText;

	public BlockTotemBase(String name, Material materialIn, String radiusText)
	{
		super(name, materialIn);
		this.tooltipText = "tooltip.totem_base";
		this.radiusText = radiusText;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	{
		for (AxisAlignedBB axisAlignedBB : Reference.TOTEM_BASE_BOUNDING_BOXES)
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisAlignedBB);
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if (!worldIn.isRemote)
		{
			if (worldIn.getTileEntity(pos) != null)
			{
				if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase)
				{
					TileEntityTotemBase totemBase = (TileEntityTotemBase) worldIn.getTileEntity(pos);

					// Add totem to registry for this dimension
					TotemBaseRegistry registry = TotemBaseRegistries.getTotemBaseRegistryFromDimension(worldIn.provider.getDimension());
					registry.addTotem(pos);

					totemBase.setTotemProperties();
					totemBase.sendUpdates();
				}
			}
		}

		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!worldIn.isRemote)
		{
			if (worldIn.getTileEntity(pos) != null)
			{
				if (worldIn.getTileEntity(pos) instanceof TileEntityTotemBase)
				{
					TileEntityTotemBase totemBase = (TileEntityTotemBase) worldIn.getTileEntity(pos);

					// Remove totem from registry for this dimension
					TotemBaseRegistry registry = TotemBaseRegistries.getTotemBaseRegistryFromDimension(worldIn.provider.getDimension());
					registry.removeTotem(pos);

					totemBase.setTotemProperties();
					totemBase.sendUpdates();
				}
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		if (tooltipText == null)
		{
			tooltip.add(I18n.format("tooltip.missing"));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			tooltip.add(I18n.format(tooltipText));
			tooltip.add(I18n.format(radiusText));
		} else
		{
			tooltip.add(I18n.format("tooltip.shift"));
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{

		if (!world.isRemote)
		{
			TileEntity base = world.getTileEntity(pos);

			if (base instanceof TileEntityTotemBase)
			{
				TileEntityTotemBase tile = (TileEntityTotemBase) base;

				if (tile.isCooldownOver())
				{
					ITextComponent component = new TextComponentString("");

					if (tile.hasActiveTotemHeads())
					{
						component.appendSibling(new TextComponentTranslation("base.prevent"));

						if (tile.isMaster)
							component = appendText("base.master", component);
						else
						{
							if (tile.hasZombie)
								component = appendText("base.zombies", component);
							if (tile.hasCreeper)
								component = appendText("base.creepers", component);
							if (tile.hasSkeleton)
								component = appendText("base.skeletons", component);
							if (tile.hasSpider)
								component = appendText("base.spiders", component);
							if (tile.hasEnderman)
								component = appendText("base.endermen", component);
							if (tile.hasWitch)
								component = appendText("base.witches", component);
							if (tile.hasSilverfish)
								component = appendText("base.silverfish", component);
							if (tile.hasSlime)
								component = appendText("base.slimes", component);
							if (tile.hasBlaze)
								component = appendText("base.blazes", component);
							if (tile.hasZombiePigman)
								component = appendText("base.zombie_pigmen", component);
							if (tile.hasGhast)
								component = appendText("base.ghasts", component);
							if (tile.hasMagmaCube)
								component = appendText("base.magma_cubes", component);
						}
					} else
					{
						component.appendSibling(new TextComponentTranslation("base.no_active_heads"));
					}

					player.sendMessage(component);
				}
			}
		}

		return true;
	}

	private ITextComponent appendText(String translationKey, ITextComponent component)
	{
		component.appendText("\n");
		component.appendSibling(new TextComponentTranslation(translationKey));

		return component;
	}
}
