package io.github.mspacedev.entities.layers;

import io.github.mspacedev.entities.EntitySpiritSlime;
import io.github.mspacedev.entities.render.RenderEntitySpiritSlime;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerSpiritSlimeGel implements LayerRenderer<EntitySpiritSlime>
{
	private final RenderEntitySpiritSlime slimeRenderer;
	private final ModelBase slimeModel = new ModelSlime(0);

	public LayerSpiritSlimeGel(RenderEntitySpiritSlime slimeRenderer)
	{
		this.slimeRenderer = slimeRenderer;
	}

	@Override
	public void doRenderLayer(EntitySpiritSlime entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		if (!entitylivingbaseIn.isInvisible())
		{
			GlStateManager.pushMatrix();
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);

			GlStateManager.enableNormalize();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
			this.slimeModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableNormalize();

			GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
			GlStateManager.disableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return true;
	}
}

