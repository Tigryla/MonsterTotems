package io.github.mspacedev;

import io.github.mspacedev.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
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
    private Block blockBroken = null;

    @SubscribeEvent
    public void getBlockBroken(BlockEvent.BreakEvent event) {
        this.blockBroken = event.getWorld().getBlockState(event.getPos()).getBlock();
    }

    @SubscribeEvent
    public void changeBlockDrops(BlockEvent.HarvestDropsEvent event) {
        int fortuneLevel = event.getFortuneLevel() + 1;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
        int dropChancePercent = 10 * fortuneLevel;
        int dropAmount = ThreadLocalRandom.current().nextInt(1, 3);

        // Drops powder from diamond ore; more given if fortune is used
        if(blockBroken == Blocks.DIAMOND_ORE) {
            if(dropChancePercent > randomNum) {
                event.getDrops().add(new ItemStack(ModItems.spirit_powder, dropAmount));
            }
        }
    }

    @SubscribeEvent
    public void interceptMobDeath(LivingDropsEvent event) {
        int lootingLevel = event.getLootingLevel() + 1;
        int dropChance = lootingLevel * 6;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
        Entity killerEntity = event.getSource().getTrueSource();
        BlockPos pos = event.getEntity().getPosition();

        if(killerEntity instanceof EntityLivingBase) {
            EntityLivingBase killer = (EntityLivingBase) killerEntity;
            if (killer.getHeldItemMainhand().getItem() == ModItems.spirit_knife) {
                if (dropChance > randomNum) {
                    checkMob(event);
                }
            }
        }
    }

    private void checkMob(LivingDropsEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof EntityPigZombie) {
            dropSpirit(ModItems.zombie_pigman_spirit, event);
        } else if(entity instanceof EntityZombie) {
            dropSpirit(ModItems.zombie_spirit, event);
        } else if (entity instanceof AbstractSkeleton) {
            dropSpirit(ModItems.skeleton_spirit, event);
        } else if (entity instanceof EntityCreeper) {
            dropSpirit(ModItems.creeper_spirit, event);
        } else if (entity instanceof EntitySpider) {
            dropSpirit(ModItems.spider_spirit, event);
        } else if (entity instanceof EntityEnderman) {
            dropSpirit(ModItems.enderman_spirit, event);
        } else if (entity instanceof EntityWitch) {
            dropSpirit(ModItems.witch_spirit, event);
        } else if (entity instanceof EntitySilverfish) {
            dropSpirit(ModItems.silverfish_spirit, event);
        } else if (entity instanceof EntityMagmaCube) {
            dropSpirit(ModItems.magma_cube_spirit, event);
        } else if (entity instanceof EntitySlime) {
            dropSpirit(ModItems.slime_spirit, event);
        } else if (entity instanceof EntityBlaze) {
            dropSpirit(ModItems.blaze_spirit, event);
        } else if (entity instanceof EntityGhast) {
            dropSpirit(ModItems.ghast_spirit, event);
        }
    }

    private void dropSpirit(Item item, LivingDropsEvent event) {
        BlockPos pos = event.getEntity().getPosition();
        event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item, 1)));
    }
}
