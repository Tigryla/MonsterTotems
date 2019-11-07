package io.github.mspacedev.blocks;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockBase extends Block
{
	private String tooltipText;

	public BlockBase(String name, Material materialIn)
	{
		super(materialIn);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(MonsterTotems.creativeTab);
	}

	public BlockBase(String name, Material materialIn, String tooltip)
	{
		super(materialIn);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(MonsterTotems.creativeTab);
		this.tooltipText = tooltip;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (tooltipText == null)
		{
			tooltip.add(I18n.format("tooltip.missing"));
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			tooltip.add(I18n.format(tooltipText));
		} else
		{
			tooltip.add(I18n.format("tooltip.shift"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
