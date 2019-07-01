package io.github.mspacedev;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.handlers.EntityConversionEventHandler;
import io.github.mspacedev.handlers.LootDropsEventHandler;
import io.github.mspacedev.handlers.RenderEventHandler;
import io.github.mspacedev.init.InitEntities;
import io.github.mspacedev.init.InitRecipes;
import io.github.mspacedev.handlers.TotemBaseEventHandler;
import io.github.mspacedev.proxies.CommonProxy;
import io.github.mspacedev.tiles.ModTileEntities;
import io.github.mspacedev.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static net.minecraftforge.common.ForgeVersion.MOD_ID;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION )
public class MonsterTotems {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY, modId = Reference.MODID)
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static MonsterTotems instance;

    public static final CreativeTabs creativeTab = new CreativeTabs(CreativeTabs.getNextID(), "monstertotems") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.totem_base_iii);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        InitEntities.registerEntities();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
        ModTileEntities.init();
        InitRecipes.register();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
        MinecraftForge.EVENT_BUS.register(new TotemBaseEventHandler());
        MinecraftForge.EVENT_BUS.register(new LootDropsEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityConversionEventHandler());
    }
}
