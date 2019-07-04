package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.*;
import io.github.mspacedev.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod.EventBusSubscriber
public class LootDropsEventHandler {
    @SubscribeEvent
    public void interceptMobDeath(LivingDropsEvent event) {
        Entity killerEntity = event.getSource().getTrueSource();

        if(killerEntity instanceof EntityLivingBase) {
            EntityLivingBase killer = (EntityLivingBase) killerEntity;
            if (killer.getHeldItemMainhand().getItem() == ModItems.spirit_knife) {
                checkMob(event);
            }
        }
    }

    private void checkMob(LivingDropsEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof EntitySpiritPigZombie) {
            dropSpirit(ModItems.zombie_pigman_spirit, event);
        } else if(entity instanceof EntitySpiritZombie || entity instanceof EntitySpiritHusk || entity instanceof EntitySpiritZombieVillager) {
            dropSpirit(ModItems.zombie_spirit, event);
        } else if (entity instanceof EntitySpiritSkeleton || entity instanceof EntitySpiritStray || entity instanceof EntitySpiritWitherSkeleton) {
            dropSpirit(ModItems.skeleton_spirit, event);
        } else if (entity instanceof EntitySpiritCreeper) {
            dropSpirit(ModItems.creeper_spirit, event);
        } else if (entity instanceof EntitySpiritSpider || entity instanceof EntitySpiritCaveSpider) {
            dropSpirit(ModItems.spider_spirit, event);
        } else if (entity instanceof EntitySpiritEnderman) {
            dropSpirit(ModItems.enderman_spirit, event);
        } else if (entity instanceof EntitySpiritWitch) {
            dropSpirit(ModItems.witch_spirit, event);
        } else if (entity instanceof EntitySpiritSilverfish) {
            dropSpirit(ModItems.silverfish_spirit, event);
        } else if (entity instanceof EntitySpiritMagmaCube) {
            dropSpirit(ModItems.magma_cube_spirit, event);
        } else if (entity instanceof EntitySpiritSlime) {
            dropSpirit(ModItems.slime_spirit, event);
        } else if (entity instanceof EntitySpiritBlaze) {
            dropSpirit(ModItems.blaze_spirit, event);
        } else if (entity instanceof EntitySpiritGhast) {
            dropSpirit(ModItems.ghast_spirit, event);
        }
    }

    private void dropSpirit(Item item, LivingDropsEvent event) {
        BlockPos pos = event.getEntity().getPosition();
        event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item, 1)));
    }
}
