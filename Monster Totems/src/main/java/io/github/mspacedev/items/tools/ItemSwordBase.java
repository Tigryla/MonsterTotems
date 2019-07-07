package io.github.mspacedev.items.tools;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.utils.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemSwordBase extends ItemSword
{
	private String tooltipText;

	public ItemSwordBase(String name, ToolMaterial material, String tooltip)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setCreativeTab(MonsterTotems.creativeTab);
		this.tooltipText = tooltip;
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
		} else
		{
			tooltip.add(I18n.format("tooltip.shift"));
		}
		super.addInformation(stack, player, tooltip, advanced);
	}
}
