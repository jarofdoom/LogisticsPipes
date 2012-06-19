/** 
 * Copyright (c) Krapht, 2011
 * 
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public 
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src.buildcraft.logisticspipes;

import java.util.List;

import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryHolder;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.buildcraft.api.Orientations;
import net.minecraft.src.forge.ISidedInventory;

/**
 * This class is responsible for abstracting an ISidedInventory as a normal IInventory
 * @author Krapht
 *
 */
public class SidedInventoryAdapter implements IInventory {

	private final ISidedInventory _sidedInventory;
	private final Orientations _side;
	private final int _slotOffset;
	
	public SidedInventoryAdapter(ISidedInventory sidedInventory, Orientations side){
		_sidedInventory = sidedInventory;
		_side = side;
		_slotOffset = _sidedInventory.getStartInventorySide(side.ordinal());
	}


	@Override
	public int getSizeInventory() {
		return _sidedInventory.getSizeInventorySide(_side.ordinal());
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return _sidedInventory.getStackInSlot(i + _slotOffset);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return _sidedInventory.decrStackSize(i + _slotOffset, j);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		_sidedInventory.setInventorySlotContents(i + _slotOffset, itemstack);
	}

	@Override
	public String getInvName() {
		return _sidedInventory.getInvName();
	}

	@Override
	public int getInventoryStackLimit() {
		return _sidedInventory.getInventoryStackLimit();
	}

	@Override
	public void onInventoryChanged() {
		_sidedInventory.onInventoryChanged();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return _sidedInventory.isUseableByPlayer(entityplayer);
	}

	@Override
	public void openChest() {
		_sidedInventory.openChest();
	}

	@Override
	public void closeChest() {
		_sidedInventory.closeChest();
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return _sidedInventory.getStackInSlotOnClosing(slot + _slotOffset);
	}


	@Override
	public ItemStack[] getContents() {
		return _sidedInventory.getContents();
	}


	@Override
	public InventoryHolder getOwner() {
		return _sidedInventory.getOwner();
	}


	@Override
	public List<HumanEntity> getViewers() {
		return _sidedInventory.getViewers();
	}


	@Override
	public void onClose(CraftHumanEntity arg0) {
		_sidedInventory.onClose(arg0);
	}


	@Override
	public void onOpen(CraftHumanEntity arg0) {
		_sidedInventory.onOpen(arg0);
	}


	@Override
	public void setMaxStackSize(int arg0) {
		_sidedInventory.setMaxStackSize(arg0);
	}
}
