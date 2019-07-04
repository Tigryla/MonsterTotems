package io.github.mspacedev.entities.render;

import io.github.mspacedev.entities.EntitySpiritSlime;
import io.github.mspacedev.entities.layers.LayerSpiritSlimeGel;
import io.github.mspacedev.utils.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.renderer.entity.layers.LayerSlimeGel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderEntitySpiritSlime extends RenderLiving<EntitySpiritSlime>
{
    private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/slime/spirit_slime.png");

    public RenderEntitySpiritSlime(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerSpiritSlimeGel(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpiritSlime entity)
    {
        return texture;
    }

    @Override
    public void doRender(EntitySpiritSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);

        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    protected void applyRotations(EntitySpiritSlime entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntitySpiritSlime entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
}