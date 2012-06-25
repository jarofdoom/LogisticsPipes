/**
 * Copyright (c) Krapht, 2011
 *
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src;

import net.minecraft.src.buildcraft.krapht.BuildCraftProxy2;
import net.minecraft.src.buildcraft.krapht.IBuildCraftProxy;
import net.minecraft.src.buildcraft.krapht.SimpleServiceLocator;
import net.minecraft.src.buildcraft.logisticspipes.ItemModule;

public class mod_LogisticsPipes extends core_LogisticsPipes
{
    public mod_LogisticsPipes()
    {
        SimpleServiceLocator.setBuildCraftProxy(new BuildCraftProxy2());
        instance = this;
    }
    public static mod_LogisticsPipes instance;
	
    //Log Requests
    public static boolean DisplayRequests;

	@Override
	public String getVersion(){
		return "0.3.1";
	}
}
