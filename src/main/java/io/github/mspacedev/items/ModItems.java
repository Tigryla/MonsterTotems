/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.items;

import io.github.mspacedev.items.spirits.*;
import io.github.mspacedev.items.tools.ItemCarvingTool;
import io.github.mspacedev.items.tools.ItemSpiritKnife;
import net.minecraft.item.Item;

public class ModItems
{
	// Tools
	public static final Item carving_tool = new ItemCarvingTool("carving_tool", Item.ToolMaterial.IRON, 1.0f, -1.0f);
	public static final Item spirit_knife = new ItemSpiritKnife("spirit_knife", Item.ToolMaterial.DIAMOND);

	// Ingot
	public static final Item spirit_powder = new ItemSpiritPowder("spirit_powder");
	public static final Item spirit_ingot = new ItemSpiritIngot("spirit_ingot");

	// Mob Spirits
	public static final Item zombie_spirit = new ItemZombieSpirit("zombie_spirit");
	public static final Item skeleton_spirit = new ItemSkeletonSpirit("skeleton_spirit");
	public static final Item creeper_spirit = new ItemCreeperSpirit("creeper_spirit");
	public static final Item spider_spirit = new ItemSpiderSpirit("spider_spirit");
	public static final Item enderman_spirit = new ItemEndermanSpirit("enderman_spirit");
	public static final Item witch_spirit = new ItemWitchSpirit("witch_spirit");
	public static final Item silverfish_spirit = new ItemSilverfishSpirit("silverfish_spirit");
	public static final Item slime_spirit = new ItemSlimeSpirit("slime_spirit");
	public static final Item blaze_spirit = new ItemBlazeSpirit("blaze_spirit");
	public static final Item zombie_pigman_spirit = new ItemZombiePigmanSpirit("zombie_pigman_spirit");
	public static final Item ghast_spirit = new ItemGhastSpirit("ghast_spirit");
	public static final Item magma_cube_spirit = new ItemMagmaCubeSpirit("magma_cube_spirit");

	public static Item[] ITEMS = {
			// Tools
			carving_tool,
			spirit_knife,
			// Ingot
			spirit_powder,
			spirit_ingot,
			// Mob Spirits
			zombie_spirit,
			skeleton_spirit,
			creeper_spirit,
			spider_spirit,
			enderman_spirit,
			witch_spirit,
			silverfish_spirit,
			slime_spirit,
			blaze_spirit,
			zombie_pigman_spirit,
			ghast_spirit,
			magma_cube_spirit
	};
}
