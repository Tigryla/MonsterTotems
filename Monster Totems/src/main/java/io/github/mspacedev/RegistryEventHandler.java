package io.github.mspacedev;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.items.ModItems;
import io.github.mspacedev.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod.EventBusSubscriber
public class RegistryEventHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(ModBlocks.BLOCKS);

        Utils.getLogger().info("Monster Totems Blocks Registered");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEMS);

        for(Block block : ModBlocks.BLOCKS){
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
        }

        Utils.getLogger().info("Monster Totems Items Registered");
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        for(Block block : ModBlocks.BLOCKS){
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }

        for(Item item : ModItems.ITEMS){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }

        Utils.getLogger().info("Monster Totems Models Registered");
    }
}
