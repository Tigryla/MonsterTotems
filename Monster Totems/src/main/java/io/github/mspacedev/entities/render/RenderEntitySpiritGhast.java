package io.github.mspacedev.entities.render;

import io.github.mspacedev.utils.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.4F);

        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}