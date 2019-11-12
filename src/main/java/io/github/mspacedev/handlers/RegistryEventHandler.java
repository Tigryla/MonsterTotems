/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.handlers;

import io.github.mspacedev.blocks.ModBlocks;
import io.github.mspacedev.items.ModItems;
import io.github.mspacedev.utils.Reference;
import io.github.mspacedev.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistryEventHandler
{
	private static final ResourceLocation convertLogRL = new ResourceLocation(Reference.MODID, "blocks.convert_log");
	public static TextureAtlasSprite textureAtlasSprite;
	public static SoundEvent convert_log;

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		convert_log = new SoundEvent(convertLogRL).setRegistryName(convertLogRL);
		registerSound(convert_log, event);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerParticleMap(TextureStitchEvent.Pre event)
	{
		TextureMap map = event.getMap();
		textureAtlasSprite = map.registerSprite(new ResourceLocation(Reference.MODID, "particle/particles"));
	}

	private static void registerSound(SoundEvent soundID, RegistryEvent.Register<SoundEvent> event)
	{
		Utils.getLogger().info(soundID + " loaded");
		event.getRegistry().register(soundID);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS);
		Utils.getLogger().info("Monster Totems Blocks Registered");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS);

		for (Block block : ModBlocks.BLOCKS)
		{
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
		}

		Utils.getLogger().info("Monster Totems Items Registered");
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for (Block block : ModBlocks.BLOCKS)
		{
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		for (Item item : ModItems.ITEMS)
		{
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		Utils.getLogger().info("Monster Totems Models Registered");
	}
}
