package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.*;
import io.github.mspacedev.items.ItemSpiritPowder;
import io.github.mspacedev.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityConversionEventHandler
{
	@SubscribeEvent
	public void stopSpritEntityBurning(LivingEvent.LivingUpdateEvent event)
	{
		Entity entity = event.getEntity();

		for (Class spiritEntityClass : Reference.ENTITIES)
		{
			if (entity.getClass().equals(spiritEntityClass))
			{
				if (entity.isBurning())
					entity.extinguish();
			}
		}
	}

	@SubscribeEvent
	public void interactEntity(PlayerInteractEvent.EntityInteract event)
	{
		Entity target = event.getTarget();
		World worldObj = event.getWorld();
		EntityPlayer player = event.getEntityPlayer();

		if (player.getHeldItem(event.getHand()).getItem() instanceof ItemSpiritPowder)
		{
			boolean playsound = true;

			if (worldObj.isRemote)
			{
				for (Class spiritEntityClass : Reference.ENTITIES)
				{
					if (target.getClass().equals(spiritEntityClass))
						playsound = false;
				}
			}

			if (playsound)
				worldObj.playSound(target.posX, target.posY, target.posZ, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.AMBIENT, 0.25F, 2.0F, false);

			if (!worldObj.isRemote)
			{
				if (target.getClass().equals(EntityZombie.class))
					spawnEntity(new EntitySpiritZombie(worldObj), event);
				else if (target.getClass().equals(EntitySkeleton.class))
					spawnEntity(new EntitySpiritSkeleton(worldObj), event);
				else if (target.getClass().equals(EntityCreeper.class))
					spawnEntity(new EntitySpiritCreeper(worldObj), event);
				else if (target.getClass().equals(EntitySpider.class))
					spawnEntity(new EntitySpiritSpider(worldObj), event);
				else if (target.getClass().equals(EntityEnderman.class))
					spawnEntity(new EntitySpiritEnderman(worldObj), event);
				else if (target.getClass().equals(EntityWitch.class))
					spawnEntity(new EntitySpiritWitch(worldObj), event);
				else if (target.getClass().equals(EntitySilverfish.class))
					spawnEntity(new EntitySpiritSilverfish(worldObj), event);
				else if (target.getClass().equals(EntityBlaze.class))
					spawnEntity(new EntitySpiritBlaze(worldObj), event);
				else if (target.getClass().equals(EntityPigZombie.class))
					spawnEntity(new EntitySpiritPigZombie(worldObj), event);
				else if (target.getClass().equals(EntityGhast.class))
					spawnEntity(new EntitySpiritGhast(worldObj), event);
				else if (target.getClass().equals(EntityHusk.class))
					spawnEntity(new EntitySpiritHusk(worldObj), event);
				else if (target.getClass().equals(EntityZombieVillager.class))
					spawnEntity(new EntitySpiritZombieVillager(worldObj), event);
				else if (target.getClass().equals(EntityCaveSpider.class))
					spawnEntity(new EntitySpiritCaveSpider(worldObj), event);
				else if (target.getClass().equals(EntityStray.class))
					spawnEntity(new EntitySpiritStray(worldObj), event);
				else if (target.getClass().equals(EntityWitherSkeleton.class))
					spawnEntity(new EntitySpiritWitherSkeleton(worldObj), event);
				else if (target.getClass().equals(EntityMagmaCube.class))
				{
					EntityMagmaCube slime = (EntityMagmaCube) target;
					spawnEntity(new EntitySpiritMagmaCube(worldObj, slime.getSlimeSize()), event);
				} else if (target.getClass().equals(EntitySlime.class))
				{
					EntitySlime slime = (EntitySlime) target;
					spawnEntity(new EntitySpiritSlime(worldObj, slime.getSlimeSize()), event);
				}
			}
		}
	}

	private void spawnEntity(Entity entity, PlayerInteractEvent.EntityInteract event)
	{
		Entity target = event.getTarget();
		World world = event.getWorld();

		entity.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
		world.spawnEntity(entity);
		((WorldServer) world).spawnParticle(EnumParticleTypes.CLOUD, target.posX, target.posY, target.posZ, 100, 0.5F, 1.0F, 0.5F, 0);
		target.setDead();

		// Removes powder from player
		event.getEntityPlayer().getHeldItem(event.getHand()).shrink(1);
	}
}
