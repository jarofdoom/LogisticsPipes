/** 
 * Copyright (c) Krapht, 2011
 * 
 * "LogisticsPipes" is distributed under the terms of the Minecraft Mod Public 
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */


package net.minecraft.src.krapht.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiButton;

import org.lwjgl.opengl.GL11;

public class SmallGuiButton extends GuiButton {

	public SmallGuiButton(int buttonId, int x, int y, int width, int height, String label) {
		super(buttonId, x, y, width, height, label);
	}

	public SmallGuiButton(int i, int j, int k, String s) {
		super(i, j, k, s);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void drawButton(Minecraft minecraft, int i, int j)
    {
        if(!drawButton)
        {
            return;
        }
        FontRenderer fontrenderer = minecraft.fontRenderer;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, minecraft.renderEngine.getTexture("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;
        int k = getHoverState(flag);
        
        drawTexturedModalRect(xPosition  			, yPosition				, 0			    , 46 + k * 20, width / 2 ,height / 2);
        drawTexturedModalRect(xPosition + width / 2	, yPosition				, 200 - width / 2, 46 + k * 20, width / 2, height / 2);
        
        drawTexturedModalRect(xPosition  			, yPosition + height / 2, 0			    , 46 + 25 - height  +  k * 20, width / 2 ,height / 2);
        drawTexturedModalRect(xPosition + width / 2	, yPosition + height / 2, 200 - width / 2, 46 + 25 - height +  k * 20, width / 2, height / 2);

        mouseDragged(minecraft, i, j);
        if(!enabled)
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffa0a0a0);
        } else
        if(flag)
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xffffa0);
        } else
        {
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xe0e0e0);
        }
    }

}
