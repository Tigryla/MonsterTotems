/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev;

import io.github.mspacedev.utils.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Config(modid = Reference.MODID, name = Reference.MODID, type = Config.Type.INSTANCE)
public class Configs
{
	@Config.LangKey("config.isCubicRange")
	@Config.Comment({
			"§eIf true, Totem Bases will prevent spawns within a cubic radius.",
			"§cIf false, Totem Bases will prevent spawns within a cylindrical radius.",
			"§fNOTE: The Y-level of entities are ignored. The Totem Base range is always from bedrock to world height!"
	})
	public static boolean isCubicRange = true;

	@Config.LangKey("config.preventSpawners")
	@Config.Comment({
			"§eIf false, Totem Bases will allow spawns from spawners within range.",
			"§cIf true, Totem Bases will prevent spawns from spawners within range."
	})
	public static boolean preventSpawners = false;

	@Config.LangKey("config.base.i_range")
	@Config.Comment({"The range mobs will not spawn around a Totem Base I (blocks)."})
	public static int totemBaseIRange = 64;

	@Config.LangKey("config.base.ii_range")
	@Config.Comment({"The range mobs will not spawn around a Totem Base II (blocks)."})
	public static int totemBaseIIRange = 96;

	@Config.LangKey("config.base.iii_range")
	@Config.Comment({"The range mobs will not spawn around a Totem Base III (blocks)."})
	public static int totemBaseIIIRange = 128;

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(Reference.MODID))
		{
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
		}
	}
}
