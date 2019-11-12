/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.init;

import io.github.mspacedev.entities.*;
import io.github.mspacedev.utils.Reference;
import io.github.mspacedev.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntities
{

	private static int id = 1500;

	public static void register()
	{
		registerEntity("spirit_blaze", "spirit_blaze", EntitySpiritBlaze.class, 16167425, 16775294);
		registerEntity("spirit_cave_spider", "spirit_cave_spider", EntitySpiritCaveSpider.class, 803406, 11013646);
		registerEntity("spirit_creeper", "", EntitySpiritCreeper.class, 894731, 0);
		registerEntity("spirit_enderman", "spirit_enderman", EntitySpiritEnderman.class, 1447446, 0);
		registerEntity("spirit_ghast", "spirit_ghast", EntitySpiritGhast.class, 16382457, 12369084);
		registerEntity("spirit_husk", "spirit_husk", EntitySpiritHusk.class, 7958625, 15125652);
		registerEntity("spirit_magma_cube", "spirit_magma_cube", EntitySpiritMagmaCube.class, 3407872, 16579584);
		registerEntity("spirit_silverfish", "spirit_silverfish", EntitySpiritSilverfish.class, 7237230, 3158064);
		registerEntity("spirit_skeleton", "spirit_skeleton", EntitySpiritSkeleton.class, 12698049, 4802889);
		registerEntity("spirit_slime", "spirit_slime", EntitySpiritSlime.class, 5349438, 8306542);
		registerEntity("spirit_spider", "spirit_spider", EntitySpiritSpider.class, 3419431, 11013646);
		registerEntity("spirit_stray", "spirit_stray", EntitySpiritStray.class, 6387319, 14543594);
		registerEntity("spirit_witch", "spirit_witch", EntitySpiritWitch.class, 3407872, 5349438);
		registerEntity("spirit_wither_skeleton", "spirit_wither_skeleton", EntitySpiritWitherSkeleton.class, 1315860, 4672845);
		registerEntity("spirit_zombie", "spirit_zombie", EntitySpiritZombie.class, 44975, 7969893);
		registerEntity("spirit_zombie_pigman", "spirit_zombie_pigman", EntitySpiritPigZombie.class, 15373203, 5009705);
		registerEntity("spirit_zombie_villager", "spirit_zombie_villager", EntitySpiritZombieVillager.class, 5651507, 7969893);

		Utils.getLogger().info("Monster Totems Entities Registered");
	}

	private static void registerEntity(String nameId, String entityName, Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, nameId), entityClass, entityName, ++id, Reference.MODID, 64, 1, false, eggPrimary, eggSecondary);
	}
}
