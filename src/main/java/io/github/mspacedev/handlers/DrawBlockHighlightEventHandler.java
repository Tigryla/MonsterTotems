/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class DrawBlockHighlightEventHandler
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onDrawBlockHighlight(DrawBlockHighlightEvent event)
	{
		BlockPos pos = event.getTarget().getBlockPos();
		World world = event.getPlayer().world;

		if (event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK)
		{
			if (world.getTileEntity(pos) instanceof TileEntityTotemBase)
			{
				event.setCanceled(true);

				for (AxisAlignedBB axisAlignedBB : Reference.TOTEM_BASE_BOUNDING_BOXES)
				{
					drawSelectionBox(event, axisAlignedBB);
				}
			}
		}
	}

	private static void drawSelectionBox(DrawBlockHighlightEvent event, AxisAlignedBB axisAlignedBB)
	{
		RayTraceResult movingObjectPositionIn = event.getTarget();
		double partialTicks = (double) event.getPartialTicks();
		EntityPlayer player = event.getPlayer();

		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.glLineWidth(2.0F);
		GlStateManager.disableTexture2D();
		GlStateManager.depthMask(false);

		double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
		double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
		double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
		RenderGlobal.drawSelectionBoundingBox(axisAlignedBB.offset(-d0, -d1, -d2).offset(movingObjectPositionIn.getBlockPos()), 0.0F, 0.0F, 0.0F, 0.4F);

		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
}
