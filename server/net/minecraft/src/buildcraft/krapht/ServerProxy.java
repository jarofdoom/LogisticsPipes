package net.minecraft.src.buildcraft.krapht;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.buildcraft.core.CoreProxy;
import net.minecraft.src.buildcraft.krapht.logic.LogicProvider;
import net.minecraft.src.buildcraft.krapht.logic.LogicSupplier;
import net.minecraft.src.buildcraft.krapht.network.NetworkConstants;
import net.minecraft.src.buildcraft.krapht.network.PacketPipeInteger;
import net.minecraft.src.buildcraft.logisticspipes.modules.ModuleExtractor;
import net.minecraft.src.buildcraft.logisticspipes.modules.ModuleItemSink;

public class ServerProxy {
	public static void sendToPlayer_ITEM_SINK_STATUS(EntityPlayer entityplayer,int xCoord, int yCoord, int zCoord, boolean isDefaultRoute) {
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.ITEM_SINK_STATUS, xCoord, yCoord, zCoord, isDefaultRoute ? 1 : 0).getPacket());
	}
	
	public static void sendToPlayer_EXTRACTOR_MODULE_RESPONSE(EntityPlayer entityplayer,int xCoord, int yCoord, int zCoord, int status) {
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.EXTRACTOR_MODULE_RESPONSE, xCoord, yCoord, zCoord, status).getPacket());
	}
	
	public static void sendToPlayer_GUI_INFORMATION(EntityPlayer entityplayer,int xCoord, int yCoord, int zCoord, LogicProvider logic) {
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.PROVIDER_PIPE_MODE_CONTENT, xCoord, yCoord, zCoord, logic.getExtractionMode().ordinal()).getPacket());
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.PROVIDER_PIPE_INCLUDE_CONTENT, xCoord, yCoord, zCoord, logic.isExcludeFilter() ? 1 : 0).getPacket());
	}
	
	public static void sendToPlayer_GUI_INFORMATION(EntityPlayer entityplayer,int xCoord, int yCoord, int zCoord, LogicSupplier logic) {
		((EntityPlayerMP)entityplayer).playerNetServerHandler.sendPacket(new PacketPipeInteger(NetworkConstants.SUPPLIER_PIPE_MODE_RESPONSE, xCoord, yCoord, zCoord, logic.isRequestingPartials() ? 1 : 0).getPacket());
	}
}
