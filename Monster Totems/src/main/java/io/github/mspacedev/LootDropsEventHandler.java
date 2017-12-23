package io.github.mspacedev;

import io.github.mspacedev.items.ModItems;
import io.github.mspacedev.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

@Mod.EventBusSubscriber
public class LootDropsEventHandler {
    @SubscribeEvent
    public void breakCoalOre(BlockEvent.HarvestDropsEvent event) {
        List<ItemStack> blockDrops = event.getDrops();
        int fortuneLevel = event.getFortuneLevel() + 1;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
        int dropChancePercent = 5 * fortuneLevel;
        int dropAmount = 1;

        // Drops powder from coal ore; more given if fortune is used
        if(!event.getWorld().isRemote) {
            for (ItemStack item : blockDrops) {
                if (item.getItem() == Items.COAL) {
                    if (dropChancePercent > randomNum) {
                        if(fortuneLevel > 1) {
                            dropAmount = ThreadLocalRandom.current().nextInt(1, 3);
                        }

                        event.getWorld().spawnEntity(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.spirit_powder, dropAmount)));
                    }
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void interceptMobDeath(LivingDropsEvent event) {
        List<EntityItem> mobDrops = event.getDrops();
        int lootingLevel = event.getLootingLevel() + 1;
        int dropChance = lootingLevel * 6;
        Entity killerEntity = event.getSource().getSourceOfDamage();

        if(killerEntity instanceof EntityLivingBase) {
            EntityLivingBase killer = (EntityLivingBase) killerEntity;
            if (killer.getHeldItemMainhand().getItem() == ModItems.spirit_knife) {
                dropMobSpirit(event.getEntityLiving(), dropChance);
                Utils.getLogger().info(dropChance);
            }
        }

    }

    private void dropMobSpirit(EntityLivingBase entityKilled, int dropChance) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
        BlockPos entityPos = entityKilled.getPosition();

        if (dropChance > randomNum) {
            World world = entityKilled.getEntityWorld();
            if (!world.isRemote) {
                world.spawnEntity(new EntityItem(world, entityPos.getX(), entityPos.getY(), entityPos.getZ(), new ItemStack(ModItems.spirit_powder, 1)));
            }
        }
    }
}
