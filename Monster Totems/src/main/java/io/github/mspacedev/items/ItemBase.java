package io.github.mspacedev.items;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ItemBase extends Item {
    protected ArrayList<String> tooltipText = new ArrayList<>();

    public ItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.setCreativeTab(MonsterTotems.creativeTab);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        if (tooltipText == null) {
            tooltipText.add("No information provided! Please post on the issue tracker!");
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.addAll(tooltipText);
        } else {
            tooltip.add("Press SHIFT for information");
        }
        super.addInformation(stack, player, tooltip, advanced);
    }
}
