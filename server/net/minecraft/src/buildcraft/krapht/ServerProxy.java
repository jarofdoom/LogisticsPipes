package net.minecraft.src.buildcraft.krapht;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.buildcraft.krapht.network.NetworkConstants;
import net.minecraft.src.buildcraft.krapht.network.PacketPipeInteger;
import net.minecraft.src.buildcraft.logisticspipes.modules.ModuleItemSink;

public class ServerProxy {
	public static void sendToPlayer_ITEM_SINK_STATUS(EntityPlayer entityplayer,int xCoord, int yCoord, int zCoord, boolean isDefaultRoute) {
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.ITEM_SINK_STATUS, xCoord, yCoord, zCoord, isDefaultRoute ? 1 : 0).getPacket());
	}
}
