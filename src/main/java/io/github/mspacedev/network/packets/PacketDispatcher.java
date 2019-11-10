/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.network.packets;

import io.github.mspacedev.tiles.TileEntityTotemBase;
import io.github.mspacedev.utils.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketDispatcher
{
	private static byte packetId = 0;
	private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

	public static void registerPackets() {
		registerMessage(PacketRetrieveTotemBaseData.Handler.class, PacketRetrieveTotemBaseData.class, Side.CLIENT);
		registerMessage(PacketRetrieveTotemBaseData.Handler.class, PacketRetrieveTotemBaseData.class, Side.SERVER);
	}

	private static void registerMessage(Class handlerClass, Class messageClass, Side side) {
		PacketDispatcher.dispatcher.registerMessage(handlerClass, messageClass, packetId++, side);
	}

	public static void sendTotemBaseDataToPlayer(TileEntityTotemBase tile, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(new PacketRetrieveTotemBaseData(tile), player);
	}

	public static void sendTotemBaseTextToPlayer(ITextComponent text) {
		PacketDispatcher.dispatcher.sendToServer(new PacketSendTextComponent(text));
	}
}
