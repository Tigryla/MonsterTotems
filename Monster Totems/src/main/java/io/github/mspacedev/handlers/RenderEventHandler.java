package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.EntitySpiritCreeper;
import io.github.mspacedev.entities.EntitySpiritSpider;
import io.github.mspacedev.entities.render.RenderEntitySpiritCreeper;
import io.github.mspacedev.entities.render.RenderEntitySpiritSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderEventHandler
{
	public static void registerEntityRenders()
	{
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
	}
}
