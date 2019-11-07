package io.github.mspacedev.init;

import io.github.mspacedev.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Copyright © MSpaceDev 2019
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class InitRecipes
{
	public static void register()
	{
		registerSmelting();
	}

	private static void registerSmelting()
	{
		GameRegistry.addSmelting(ModItems.spirit_powder, new ItemStack(ModItems.spirit_ingot, 1), 0.0f);
	}
}
