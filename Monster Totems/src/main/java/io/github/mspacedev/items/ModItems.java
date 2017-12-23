package io.github.mspacedev.items;

import io.github.mspacedev.items.spirits.ItemZombieSpirit;
import io.github.mspacedev.items.tools.ItemCarvingTool;
import io.github.mspacedev.items.tools.ItemSpiritKnife;
import net.minecraft.item.Item;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ModItems {
    // Tools
    public static final Item carving_tool = new ItemCarvingTool("carving_tool", Item.ToolMaterial.IRON, 1.0f, -1.0f );
    public static final Item spirit_knife = new ItemSpiritKnife("spirit_knife", Item.ToolMaterial.DIAMOND);

    // Ingot
    public static final Item spirit_powder = new ItemSpiritPowder("spirit_powder");
    public static final Item spirit_ingot = new ItemSpiritIngot("spirit_ingot");

    // Mob Spirits
    public static final Item zombie_spirit = new ItemZombieSpirit("zombie_spirit");

    public static Item ITEMS[] = {
            // Tools
            carving_tool,
            spirit_knife,
            // Ingot
            spirit_powder,
            spirit_ingot,
            // Mob Spirits
            zombie_spirit
    };
}
