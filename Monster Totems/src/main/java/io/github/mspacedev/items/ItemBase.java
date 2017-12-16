package io.github.mspacedev.items;

import io.github.mspacedev.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemBase extends Item{
    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(Reference.MODID, name));
    }
}
