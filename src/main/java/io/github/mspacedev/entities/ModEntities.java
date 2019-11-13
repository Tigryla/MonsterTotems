/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.entities;

import io.github.mspacedev.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class ModEntities
{
	private static int id = 1500;

	public static final EntityEntry[] ENTITIES = {
			getEntityEntry("spirit_blaze", "spirit_blaze", EntitySpiritBlaze.class, 16167425, 16775294),
			getEntityEntry("spirit_cave_spider", "spirit_cave_spider", EntitySpiritCaveSpider.class, 803406, 11013646),
			getEntityEntry("spirit_creeper", "spirit_creeper", EntitySpiritCreeper.class, 894731, 0),
			getEntityEntry("spirit_enderman", "spirit_enderman", EntitySpiritEnderman.class, 1447446, 0),
			getEntityEntry("spirit_ghast", "spirit_ghast", EntitySpiritGhast.class, 16382457, 12369084),
			getEntityEntry("spirit_husk", "spirit_husk", EntitySpiritHusk.class, 7958625, 15125652),
			getEntityEntry("spirit_magma_cube", "spirit_magma_cube", EntitySpiritMagmaCube.class, 3407872, 16579584),
			getEntityEntry("spirit_silverfish", "spirit_silverfish", EntitySpiritSilverfish.class, 7237230, 3158064),
			getEntityEntry("spirit_skeleton", "spirit_skeleton", EntitySpiritSkeleton.class, 12698049, 4802889),
			getEntityEntry("spirit_slime", "spirit_slime", EntitySpiritSlime.class, 5349438, 8306542),
			getEntityEntry("spirit_spider", "spirit_spider", EntitySpiritSpider.class, 3419431, 11013646),
			getEntityEntry("spirit_stray", "spirit_stray", EntitySpiritStray.class, 6387319, 14543594),
			getEntityEntry("spirit_witch", "spirit_witch", EntitySpiritWitch.class, 3407872, 5349438),
			getEntityEntry("spirit_wither_skeleton", "spirit_wither_skeleton", EntitySpiritWitherSkeleton.class, 1315860, 4672845),
			getEntityEntry("spirit_zombie", "spirit_zombie", EntitySpiritZombie.class, 44975, 7969893),
			getEntityEntry("spirit_zombie_pigman", "spirit_zombie_pigman", EntitySpiritPigZombie.class, 15373203, 5009705),
			getEntityEntry("spirit_zombie_villager", "spirit_zombie_villager", EntitySpiritZombieVillager.class, 5651507, 7969893)
	};

	private static EntityEntry getEntityEntry(String nameId, String entityName, Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
	{
		return EntityEntryBuilder.create()
				.entity(entityClass)
				.id(new ResourceLocation(Reference.MODID, nameId), ++id)
				.name(entityName)
				.tracker(64, 1, false)
				.egg(eggPrimary, eggSecondary)
				.spawn(EnumCreatureType.MONSTER, 0, 0, 0, Biomes.VOID)
				.build();
	}
}
