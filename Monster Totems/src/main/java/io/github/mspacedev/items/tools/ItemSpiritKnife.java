package io.github.mspacedev.items.tools;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemSpiritKnife extends ItemSwordBase {
    public ItemSpiritKnife(String name, ToolMaterial material) {
        super(name, material);
        tooltipText.add("A mysterious blade that seems to retrieve");
        tooltipText.add("monster spirits upon their death");
    }
}
