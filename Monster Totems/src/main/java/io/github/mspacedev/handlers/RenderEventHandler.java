package io.github.mspacedev.handlers;

import io.github.mspacedev.entities.EntitySpiritCreeper;
import io.github.mspacedev.entities.render.RenderEntitySpiritCreeper;
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
	}
}
