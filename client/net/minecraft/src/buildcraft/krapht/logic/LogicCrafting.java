/**
 * Copyright (c) Krapht, 2011
 * 
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src.buildcraft.krapht.logic;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_LogisticsPipes;
import net.minecraft.src.buildcraft.api.APIProxy;
import net.minecraft.src.buildcraft.core.CoreProxy;
import net.minecraft.src.buildcraft.krapht.GuiIDs;
import net.minecraft.src.buildcraft.krapht.network.NetworkConstants;
import net.minecraft.src.buildcraft.krapht.network.PacketCoordinates;
import net.minecraft.src.buildcraft.krapht.routing.IRouter;
import net.minecraft.src.krapht.SimpleInventory;

public class LogicCrafting extends BaseLogicCrafting {

	/* ** NETWORK FUNCTIONS ** */

	@Override
	public void setNextSatellite() {
		super.setNextSatellite();

		if (APIProxy.isClient(this.worldObj)) {
			// Using existing BuildCraft packet system
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.CRAFTING_PIPE_NEXT_SATELLITE, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
	}

	@Override
	public void setPrevSatellite() {
		super.setPrevSatellite();

		if (APIProxy.isClient(this.worldObj)) {
			// Using existing BuildCraft packet system
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.CRAFTING_PIPE_PREV_SATELLITE, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
	}

	// This is called by the packet PacketCraftingPipeSatelliteId
	public void setSatelliteId(int satelliteId) {
		this.satelliteId = satelliteId;
	}

	@Override
	public void importFromCraftingTable() {
		super.importFromCraftingTable();

		// Send packet asking for import
		if (APIProxy.isClient(this.worldObj)) {
			// Using existing BuildCraft packet system
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.CRAFTING_PIPE_IMPORT, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
	}

	public void setDummyInventorySlot(int slot, ItemStack itemstack) {
		_dummyInventory.setInventorySlotContents(slot, itemstack);
	}

	/* ** GUI ** */

	@Override
	public SimpleInventory getDummyInventory() {
		return _dummyInventory;
	}

	/* ** NON NETWORKING ** */

	public void paintPathToSatellite() {
		final IRouter satelliteRouter = getSatelliteRouter();
		if (satelliteRouter == null) {
			return;
		}

		getRouter().displayRouteTo(satelliteRouter);
	}

	@Override
	public void openAttachedGui(EntityPlayer player) {
		if (APIProxy.isClient(worldObj)) {
			final PacketCoordinates packet = new PacketCoordinates(NetworkConstants.CRAFTING_PIPE_OPEN_CONNECTED_GUI, xCoord, yCoord, zCoord);
			ModLoader.getMinecraftInstance().getSendQueue().addToSendQueue(packet.getPacket());
		}
		super.openAttachedGui(player);
	}
	
	@Override
	public void onWrenchClicked(EntityPlayer player) {
		// Open the gui, when not multiplayer
		if (!APIProxy.isClient(this.worldObj)) {
			player.openGui(mod_LogisticsPipes.instance, GuiIDs.GUI_CRAFTINGPIPE_ID, worldObj, xCoord, yCoord, zCoord);
		}
	}
}
