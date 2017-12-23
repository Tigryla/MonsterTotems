package io.github.mspacedev.items.tools;

import io.github.mspacedev.MonsterTotems;
import io.github.mspacedev.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
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

public class ItemAxeBase extends ItemAxe {
    protected ArrayList<String> tooltipText = new ArrayList<>();

    public ItemAxeBase(String name, ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.setUnlocalizedName(name);
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
