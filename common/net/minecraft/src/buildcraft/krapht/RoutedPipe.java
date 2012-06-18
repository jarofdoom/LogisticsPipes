/**
 * Copyright (c) Krapht, 2011
 *
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src.buildcraft.krapht;

import net.minecraft.src.buildcraft.krapht.logic.BaseRoutingLogic;
import net.minecraft.src.buildcraft.transport.Pipe;

public abstract class RoutedPipe extends CoreRoutedPipe
{
    public RoutedPipe(BaseRoutingLogic logic, int itemID)
    {
        super(logic, itemID);
    }

    @Override
    public int getBlockTexture()
    {
        return _nextTexture;
    }

    @Override
    public void onNeighborBlockChange()
    {
        super.onNeighborBlockChange();
        onNeighborBlockChange_Logistics();
    }
}
