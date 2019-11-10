/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.handlers.*;
import io.github.mspacedev.init.InitEntities;
import io.github.mspacedev.init.InitRecipes;
import io.github.mspacedev.init.InitTileEntities;
import io.github.mspacedev.network.packets.PacketDispatcher;
import io.github.mspacedev.proxies.CommonProxy;
import io.github.mspacedev.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MonsterTotems
{

	public static final CreativeTabs creativeTab = new CreativeTabs(CreativeTabs.getNextID(), "monstertotems")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModBlocks.totem_base_iii);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllRelevantItems(NonNullList<ItemStack> itemList)
		{
			super.displayAllRelevantItems(itemList);
			itemList.add(getSpawnEgg("spirit_zombie"));
			itemList.add(getSpawnEgg("spirit_creeper"));
			itemList.add(getSpawnEgg("spirit_skeleton"));
			itemList.add(getSpawnEgg("spirit_spider"));
			itemList.add(getSpawnEgg("spirit_enderman"));
			itemList.add(getSpawnEgg("spirit_witch"));
			itemList.add(getSpawnEgg("spirit_silverfish"));
			itemList.add(getSpawnEgg("spirit_slime"));
			itemList.add(getSpawnEgg("spirit_ghast"));
			itemList.add(getSpawnEgg("spirit_blaze"));
			itemList.add(getSpawnEgg("spirit_zombie_pigman"));
			itemList.add(getSpawnEgg("spirit_magma_cube"));
		}
	};

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY, modId = Reference.MODID)
	public static CommonProxy proxy;

	@Mod.Instance(Reference.MODID)
	public static MonsterTotems instance;

	private static ItemStack getSpawnEgg(String name)
	{
		ItemStack item = new ItemStack(Items.SPAWN_EGG);
		ItemMonsterPlacer.applyEntityIdToItemStack(item, new ResourceLocation(Reference.MODID, name));
		return item;
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		InitEntities.register();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		InitTileEntities.register();
		InitRecipes.register();

		ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);

		PacketDispatcher.registerPackets();

		MinecraftForge.EVENT_BUS.register(new TotemBaseEventHandler());
		MinecraftForge.EVENT_BUS.register(new LootDropsEventHandler());
		MinecraftForge.EVENT_BUS.register(new EntityConversionEventHandler());
		MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightEventHandler());
		MinecraftForge.EVENT_BUS.register(new TotemBaseRegistryEventHandler());

		// Initialise config event handler to sync config changes
		MinecraftForge.EVENT_BUS.register(new Configs());
	}
}
