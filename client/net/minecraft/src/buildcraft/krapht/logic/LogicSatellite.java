/**
 * Copyright (c) Krapht, 2011
 * 
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src.buildcraft.krapht.logic;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_LogisticsPipes;
import net.minecraft.src.buildcraft.api.APIProxy;
import net.minecraft.src.buildcraft.core.CoreProxy;
import net.minecraft.src.buildcraft.krapht.GuiIDs;
import net.minecraft.src.buildcraft.krapht.network.NetworkConstants;
import net.minecraft.src.buildcraft.krapht.network.PacketCoordinates;

public class LogicSatellite extends BaseLogicSatellite {

	/* ** NETWORK FUNCTIONS ** */

	@Override
	public void setNextId() {
		super.setNextId();

		if (APIProxy.isClient(this.worldObj)) {
			// Using existing BuildCraft packet system
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.SATELLITE_PIPE_NEXT, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
	}

	@Override
	public void setPrevId() {
		super.setPrevId();

		if (APIProxy.isClient(this.worldObj)) {
			// Using existing BuildCraft packet system
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.SATELLITE_PIPE_PREV, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
	}

	public void setSatelliteId(int satelliteId) {
		this.satelliteId = satelliteId;
	}

	@Override
	public void onWrenchClicked(EntityPlayer entityplayer) {
		if (!APIProxy.isClient(this.worldObj)) {
			entityplayer.openGui(mod_LogisticsPipes.instance, GuiIDs.GUI_SatelitePipe_ID, worldObj, xCoord, yCoord, zCoord);
		}
	}
}
