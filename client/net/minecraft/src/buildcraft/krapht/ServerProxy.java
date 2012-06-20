package net.minecraft.src.buildcraft.krapht;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.buildcraft.krapht.logic.LogicProvider;
import net.minecraft.src.buildcraft.krapht.logic.LogicSupplier;

public class ServerProxy {
	public static void sendToPlayer_ITEM_SINK_STATUS(EntityPlayer entityplayer, int xCoord, int yCoord, int zCoord, boolean defaultRoute) {
		//Unused on client
	}

	public static void sendToPlayer_GUI_INFORMATION(EntityPlayer entityplayer, int xCoord, int yCoord, int zCoord, LogicSupplier logicSupplier) {
		//Unused on client
	}

	public static void sendToPlayer_EXTRACTOR_MODULE_RESPONSE(EntityPlayer entityplayer, int xCoord, int yCoord, int zCoord, int ordinal) {
		//Unused on client
	}

	public static void sendToPlayer_GUI_INFORMATION(EntityPlayer entityplayer, int xCoord, int yCoord, int zCoord, LogicProvider logicProvider) {
		//Unused on client
	}
}
