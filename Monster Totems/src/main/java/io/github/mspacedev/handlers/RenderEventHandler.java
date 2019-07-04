package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.*;
import io.github.mspacedev.entities.render.*;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderEventHandler
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritZombie.class, new IRenderFactory<EntitySpiritZombie>()
		{
			@Override
			public Render<? super EntitySpiritZombie> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritZombie(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritSkeleton.class, new IRenderFactory<EntitySpiritSkeleton>()
		{
			@Override
			public Render<? super EntitySpiritSkeleton> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritSkeleton(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritCreeper.class, new IRenderFactory<EntitySpiritCreeper>()
		{
			@Override
			public Render<? super EntitySpiritCreeper> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritCreeper(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritSpider.class, new IRenderFactory<EntitySpiritSpider>()
		{
			@Override
			public Render<? super EntitySpiritSpider> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritSpider(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritEnderman.class, new IRenderFactory<EntitySpiritEnderman>()
		{
			@Override
			public Render<? super EntitySpiritEnderman> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritEnderman(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWitch.class, new IRenderFactory<EntitySpiritWitch>()
		{
			@Override
			public Render<? super EntitySpiritWitch> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritWitch(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritSilverfish.class, new IRenderFactory<EntitySpiritSilverfish>()
		{
			@Override
			public Render<? super EntitySpiritSilverfish> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritSilverfish(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritSlime.class, new IRenderFactory<EntitySpiritSlime>()
		{
			@Override
			public Render<? super EntitySpiritSlime> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritSlime(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritBlaze.class, new IRenderFactory<EntitySpiritBlaze>()
		{
			@Override
			public Render<? super EntitySpiritBlaze> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritBlaze(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritPigZombie.class, new IRenderFactory<EntitySpiritPigZombie>()
		{
			@Override
			public Render<? super EntitySpiritPigZombie> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritPigZombie(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritGhast.class, new IRenderFactory<EntitySpiritGhast>()
		{
			@Override
			public Render<? super EntitySpiritGhast> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritGhast(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritMagmaCube.class, new IRenderFactory<EntitySpiritMagmaCube>()
		{
			@Override
			public Render<? super EntitySpiritMagmaCube> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritMagmaCube(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritHusk.class, new IRenderFactory<EntitySpiritHusk>()
		{
			@Override
			public Render<? super EntitySpiritHusk> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritHusk(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritZombieVillager.class, new IRenderFactory<EntitySpiritZombieVillager>()
		{
			@Override
			public Render<? super EntitySpiritZombieVillager> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritZombieVillager(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritCaveSpider.class, new IRenderFactory<EntitySpiritCaveSpider>()
		{
			@Override
			public Render<? super EntitySpiritCaveSpider> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritCaveSpider(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritStray.class, new IRenderFactory<EntitySpiritStray>()
		{
			@Override
			public Render<? super EntitySpiritStray> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritStray(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWitherSkeleton.class, new IRenderFactory<EntitySpiritWitherSkeleton>()
		{
			@Override
			public Render<? super EntitySpiritWitherSkeleton> createRenderFor(RenderManager manager)
			{
				return new RenderEntitySpiritWitherSkeleton(manager);
			}
		});
	}
}
