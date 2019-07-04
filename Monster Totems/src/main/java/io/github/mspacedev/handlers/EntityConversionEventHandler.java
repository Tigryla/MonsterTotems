package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.*;
import io.github.mspacedev.items.ItemSpiritPowder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityConversionEventHandler
{
	@SubscribeEvent
	public void interactEntity(PlayerInteractEvent.EntityInteract event)
	{
		Entity target = event.getTarget();
		World worldObj = event.getWorld();
		EntityPlayer player = event.getEntityPlayer();

		if(player.getHeldItem(event.getHand()).getItem() instanceof ItemSpiritPowder)
		{
			if(worldObj.isRemote)
				worldObj.playSound(target.posX, target.posY, target.posZ, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.AMBIENT, 0.25F, 2.0F, false);

			if(!worldObj.isRemote)
			{
				if (target.getClass().equals(EntityZombie.class))
					spawnEntity(new EntitySpiritZombie(worldObj), target, worldObj);
				else if (target.getClass().equals(EntitySkeleton.class))
					spawnEntity(new EntitySpiritSkeleton(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityCreeper.class))
					spawnEntity(new EntitySpiritCreeper(worldObj), target, worldObj);
				else if (target.getClass().equals(EntitySpider.class))
					spawnEntity(new EntitySpiritSpider(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityEnderman.class))
					spawnEntity(new EntitySpiritEnderman(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityWitch.class))
					spawnEntity(new EntitySpiritWitch(worldObj), target, worldObj);
				else if (target.getClass().equals(EntitySilverfish.class))
					spawnEntity(new EntitySpiritSilverfish(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityBlaze.class))
					spawnEntity(new EntitySpiritBlaze(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityPigZombie.class))
					spawnEntity(new EntitySpiritPigZombie(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityGhast.class))
					spawnEntity(new EntitySpiritGhast(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityHusk.class))
					spawnEntity(new EntitySpiritHusk(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityZombieVillager.class))
					spawnEntity(new EntitySpiritZombieVillager(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityCaveSpider.class))
					spawnEntity(new EntitySpiritCaveSpider(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityStray.class))
					spawnEntity(new EntitySpiritStray(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityWitherSkeleton.class))
					spawnEntity(new EntitySpiritWitherSkeleton(worldObj), target, worldObj);
				else if (target.getClass().equals(EntityMagmaCube.class))
				{
					EntityMagmaCube slime = (EntityMagmaCube) target;
					spawnEntity(new EntitySpiritMagmaCube(worldObj, slime.getSlimeSize()), target, worldObj);
				}
				else if (target.getClass().equals(EntitySlime.class))
				{
					EntitySlime slime = (EntitySlime) target;
					spawnEntity(new EntitySpiritSlime(worldObj, slime.getSlimeSize()), target, worldObj);
				}
			}
		}
	}

	private void spawnEntity(Entity entity, Entity target, World world)
	{
		entity.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
		world.spawnEntity(entity);
		((WorldServer)world).spawnParticle(EnumParticleTypes.CLOUD, target.posX, target.posY, target.posZ, 100, 0.5F, 1.0F, 0.5F, 0);
		target.setDead();
	}
}
