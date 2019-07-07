package io.github.mspacedev.handlers;

import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.utils.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DrawBlockHighlightEventHandler
{
	@SubscribeEvent
	public static void onDrawBlockHighlight(DrawBlockHighlightEvent event)
	{
		BlockPos pos = event.getTarget().getBlockPos();
		World world = event.getPlayer().world;

		if (event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK)
		{
			if (world.getTileEntity(pos) instanceof TileEntityTotemBase)
			{
				event.setCanceled(true);
				TileEntityTotemBase tile = (TileEntityTotemBase) world.getTileEntity(pos);

				for (AxisAlignedBB axisAlignedBB : Reference.TOTEM_BASE_BOUNDING_BOXES)
				{
					drawSelectionBox(event.getPlayer(), axisAlignedBB, (double) event.getPartialTicks(), event.getTarget(), tile);
				}
			}
		}
	}

	private static void drawSelectionBox(EntityPlayer player, AxisAlignedBB axisAlignedBB, double partialTicks, RayTraceResult movingObjectPositionIn, TileEntityTotemBase tile)
	{
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.glLineWidth(1.0F);
		GlStateManager.disableTexture2D();
		GlStateManager.depthMask(false);

		double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
		double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
		double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
		RenderGlobal.drawSelectionBoundingBox(axisAlignedBB.offset(-d0, -d1, -d2).offset(movingObjectPositionIn.getBlockPos()), tile.hasActiveTotemHeads() ? 0.0F : 1.0F, tile.hasActiveTotemHeads() ? 1.0F : 0.0F, 0.0F, 0.4F);

		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
}
