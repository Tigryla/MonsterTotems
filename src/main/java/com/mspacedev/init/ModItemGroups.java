package com.mspacedev.init;

import com.mspacedev.Main;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups
{
	public static final ModItemGroup MOD_ITEM_GROUP = new ModItemGroup(Main.MODID, () -> new ItemStack(ModBlocks.TOTEM_BASE_I));

	private static class ModItemGroup extends ItemGroup
	{
		Supplier<ItemStack> iconSupplier;

		public ModItemGroup(String name, Supplier<ItemStack> iconSupplier)
		{
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		public ItemStack createIcon()
		{
			return iconSupplier.get();
		}
	}
}
