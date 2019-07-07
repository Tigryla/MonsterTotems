package io.github.mspacedev.init;

import io.github.mspacedev.items.ModItems;
import net.minecraft.init.Items;
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
		registerRecipes();
		registerSmelting();
	}

	private static void registerRecipes()
	{
		// Carving Tool
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.carving_tool, 1),
				"I  ", " I ", "  S", 'S', Items.STICK, 'I', ModItems.spirit_ingot
		);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.carving_tool, 1),
				"  I", " I ", "S  ", 'S', Items.STICK, 'I', ModItems.spirit_ingot
		);

		// Spirit Powder
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spirit_powder, 1),
				"GDG", "DSD", "GDG", 'G', Items.GOLD_INGOT, 'S', Items.GLOWSTONE_DUST, 'D', Items.DIAMOND
		);

		// Spirit Knife
	}

	private static void registerSmelting()
	{
		GameRegistry.addSmelting(ModItems.spirit_powder, new ItemStack(ModItems.spirit_ingot, 1), 0.0f);
	}
}
