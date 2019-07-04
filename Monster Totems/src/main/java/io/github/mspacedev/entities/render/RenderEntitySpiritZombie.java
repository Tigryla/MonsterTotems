package io.github.mspacedev.entities.render;

import io.github.mspacedev.utils.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySpiritZombie extends RenderZombie
{
    private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/zombie/spirit_zombie.png");

    public RenderEntitySpiritZombie(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityZombie entity)
    {
        return texture;
    }

    @Override
    public void doRender(EntityZombie entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
//        GlStateManager.pushMatrix();
//        GlStateManager.enableAlpha();
//        GlStateManager.enableBlend();
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.4F);

        super.doRender(entity, x, y, z, entityYaw, partialTicks);

//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
//        GlStateManager.disableAlpha();
//        GlStateManager.disableBlend();
//        GlStateManager.popMatrix();
    }

    @Override
    public void doRenderShadowAndFire(Entity entityIn, double x, double y, double z, float yaw, float partialTicks)
    {
        super.doRenderShadowAndFire(entityIn, x, y, z, yaw, partialTicks);
    }
}