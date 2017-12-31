package io.github.mspacedev.items;

import net.minecraft.client.resources.I18n;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemSpiritIngot extends ItemBase {
    public ItemSpiritIngot(String name) {
        super(name);
        tooltipText.add(I18n.format("tooltip.spirit_ingot"));
    }

}
