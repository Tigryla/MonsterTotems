package io.github.mspacedev.init;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

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
		registerOreDictRecipe(new ItemStack(ModItems.carving_tool, 1),
				"  I", " I ", "S  ", 'S', "stickWood", 'I', "ingotIron"
		);

		// Spirit Powder
		registerOreDictRecipe(new ItemStack(ModItems.spirit_powder, 1),
				"GDG", "DSD", "GDG", 'G', "ingotGold", 'S', "dustGlowstone", 'D', "gemDiamond"
		);

		// Totem bases
		// I
		registerOreDictRecipe(new ItemStack(ModBlocks.totem_base_i, 1),
				"LCL", "LPL", "LIL", 'L', "logWood", 'I', ModItems.spirit_ingot, 'P', ModItems.spirit_powder, 'C', new ItemStack(Blocks.CARPET, 1, 14));
		// II
		registerOreDictRecipe(new ItemStack(ModBlocks.totem_base_ii, 1),
				"QPQ", "PTP", "QPQ", 'T', ModBlocks.totem_base_i, 'P', ModItems.spirit_powder, 'Q', "gemQuartz");
		// III
		registerOreDictRecipe(new ItemStack(ModBlocks.totem_base_iii, 1),
				"PIP", "ITI", "PIP", 'P', "gemPrismarine", 'I', ModItems.spirit_ingot, 'T', ModBlocks.totem_base_ii);

		// Compressed Totem Heads
		// Overworld
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.overworld_totem, 1),
				ModBlocks.zombie_totem, ModBlocks.skeleton_totem, ModBlocks.creeper_totem, ModBlocks.spider_totem);
		// Nether
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.nether_totem, 1),
				ModBlocks.blaze_totem, ModBlocks.ghast_totem, ModBlocks.zombie_pigman_totem, ModBlocks.magma_cube_totem);
		// Unnatural
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.unnatural_totem, 1),
				ModBlocks.enderman_totem, ModBlocks.witch_totem, ModBlocks.silverfish_totem, ModBlocks.slime_totem);
		// Master
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.master_totem, 1),
				ModBlocks.overworld_totem, ModBlocks.nether_totem, ModBlocks.unnatural_totem);

		// Spirit Knife
		registerOreDictRecipe(new ItemStack(ModItems.spirit_knife, 1),
				" I ", " I ", " S ", 'S', "stickWood", 'I', ModItems.spirit_ingot
		);
	}

	private static void registerOreDictRecipe(ItemStack output, Object... recipe)
	{
		IRecipe craftingRecipe = new ShapedOreRecipe(output, recipe);
		CraftingManager.getInstance().addRecipe(craftingRecipe);
	}

	private static void registerSmelting()
	{
		GameRegistry.addSmelting(ModItems.spirit_powder, new ItemStack(ModItems.spirit_ingot, 1), 0.0f);
	}
}
