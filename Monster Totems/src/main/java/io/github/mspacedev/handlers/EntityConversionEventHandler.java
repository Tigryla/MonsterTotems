package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.EntitySpiritCreeper;
import io.github.mspacedev.entities.EntitySpiritSpider;
import io.github.mspacedev.items.ItemSpiritPowder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
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
				if (target.getClass().equals(EntityCreeper.class))
					spawnEntity(new EntitySpiritCreeper(worldObj), target, worldObj);
				if (target.getClass().equals(EntitySpider.class))
					spawnEntity(new EntitySpiritSpider(worldObj), target, worldObj);
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
