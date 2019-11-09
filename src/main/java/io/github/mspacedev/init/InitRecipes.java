/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.init;

import io.github.mspacedev.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
