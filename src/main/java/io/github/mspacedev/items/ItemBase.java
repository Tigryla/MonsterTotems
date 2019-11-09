/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.items;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.utils.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBase extends Item
{
	private String tooltipText;

	public ItemBase(String name, String tooltip)
	{
		this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		this.setUnlocalizedName(name);
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
