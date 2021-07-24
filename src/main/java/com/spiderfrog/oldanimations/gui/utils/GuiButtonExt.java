package com.spiderfrog.oldanimations.gui.utils;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class GuiButtonExt extends GuiButton
{
    public int packedFGColour;
    
    public GuiButtonExt(final int id, final int xPos, final int yPos, final String displayString) {
        super(id, xPos, yPos, displayString);
    }
    
    public GuiButtonExt(final int id, final int xPos, final int yPos, final int width, final int height, final String displayString) {
        super(id, xPos, yPos, width, height, displayString);
    }
    
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            final int k = this.getHoverState(this.hovered);
            this.mouseDragged(mc, mouseX, mouseY);
            int color = 14737632;
            if (this.packedFGColour != 0) {
                color = this.packedFGColour;
            }
            else if (!this.enabled) {
                color = 10526880;
            }
            else if (this.hovered) {
                color = 16777120;
            }
            String buttonText = this.displayString;
            final int strWidth = mc.fontRendererObj.getStringWidth(buttonText);
            final int ellipsisWidth = mc.fontRendererObj.getStringWidth("...");
            if (strWidth > this.width - 6 && strWidth > ellipsisWidth) {
                buttonText = mc.fontRendererObj.trimStringToWidth(buttonText, this.width - 6 - ellipsisWidth).trim() + "...";
            }
        }
    }
}
