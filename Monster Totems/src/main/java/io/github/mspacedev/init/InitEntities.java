package io.github.mspacedev.init;

import io.github.mspacedev.entities.EntitySpiritCreeper;
import io.github.mspacedev.utils.Reference;
import io.github.mspacedev.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntities
{

    private static int id = 1500;

    public static void registerEntities()
    {
        registerEntity("spirit_creeper","Spirit Creeper", EntitySpiritCreeper.class, 894731, 0);

        Utils.getLogger().info("Monster Totems Entities Registered");
    }

    private static void registerEntity(String nameId, String entityName, Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, nameId), entityClass, entityName, ++id, Reference.MODID, 64, 1, false, eggPrimary, eggSecondary);
    }
}
