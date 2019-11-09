/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.entities.render;

import io.github.mspacedev.utils.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySpiritGhast extends RenderGhast
{
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/ghast/spirit_ghast.png");
	private static final ResourceLocation texture_shooting = new ResourceLocation(Reference.MODID, "textures/entity/ghast/spirit_ghast_shooting.png");

	public RenderEntitySpiritGhast(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGhast entity)
	{
		return entity.isAttacking() ? texture_shooting : texture;
	}

	@Override
	public void doRender(EntityGhast entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.6F);

		super.doRender(entity, x, y, z, entityYaw, partialTicks);

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	}

	@Override
	protected void applyRotations(EntityGhast entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	protected void preRenderCallback(EntityGhast entitylivingbaseIn, float partialTickTime)
	{
		GlStateManager.scale(4.5F, 4.5F, 4.5F);
	}
}