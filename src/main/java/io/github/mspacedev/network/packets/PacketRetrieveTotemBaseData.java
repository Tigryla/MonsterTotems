/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.network.packets;

import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.utils.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRetrieveTotemBaseData implements IMessage
{
	private TileEntityTotemBase tile;

	// Default constructor to prevent crash when new packet is instantiated
	public PacketRetrieveTotemBaseData() {}

	public PacketRetrieveTotemBaseData(TileEntityTotemBase tile)
	{
		this.tile = tile;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		NBTTagCompound nbt = ByteBufUtils.readTag(buf);

		this.tile = new TileEntityTotemBase();
		this.tile.readFromNBT(nbt);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		// Uses tile's writeToNBT() method to build NBT to write.
		NBTTagCompound nbt = tile.writeToNBT(new NBTTagCompound());

		ByteBufUtils.writeTag(buf, nbt);
	}

	public static class Handler implements IMessageHandler<PacketRetrieveTotemBaseData, IMessage>
	{


		@Override
		public IMessage onMessage(PacketRetrieveTotemBaseData message, MessageContext ctx) {
			TileEntityTotemBase tile = message.tile;

			ITextComponent component = new TextComponentString("");

			if (tile.hasActiveTotemHeads())
			{
				component.appendText(I18n.format("base.prevent"));
				if (tile.isMaster)
					component.appendText("\n" + I18n.format("base.master"));
				else
				{
					if (tile.hasZombie)
						component.appendText("\n" + I18n.format("base.zombies"));
					if (tile.hasCreeper)
						component.appendText("\n" + I18n.format("base.creepers"));
					if (tile.hasSkeleton)
						component.appendText("\n" + I18n.format("base.skeletons"));
					if (tile.hasSpider)
						component.appendText("\n" + I18n.format("base.spiders"));
					if (tile.hasEnderman)
						component.appendText("\n" + I18n.format("base.endermen"));
					if (tile.hasWitch)
						component.appendText("\n" + I18n.format("base.witches"));
					if (tile.hasSilverfish)
						component.appendText("\n" + I18n.format("base.silverfish"));
					if (tile.hasSlime)
						component.appendText("\n" + I18n.format("base.slimes"));
					if (tile.hasBlaze)
						component.appendText("\n" + I18n.format("base.blazes"));
					if (tile.hasZombiePigman)
						component.appendText("\n" + I18n.format("base.zombie_pigmen"));
					if (tile.hasGhast)
						component.appendText("\n" + I18n.format("base.ghasts"));
					if (tile.hasMagmaCube)
						component.appendText("\n" + I18n.format("base.magma_cubes"));
				}
			} else
			{
				component.appendText(I18n.format("base.no_active_heads"));
			}

			PacketDispatcher.sendTotemBaseTextToPlayer(component);

			return null;
		}
	}
}
