package com.spiderfrog.oldanimations.utils;

import net.minecraft.client.*;
import com.spiderfrog.oldanimations.*;
import org.lwjgl.opengl.*;

public class InfoBar
{
    int PosX;
    int PosY;
    String message1;
    String message2;
    Minecraft mc;
    OldAnimationsMod oam;
    RenderUtils draw;
    long time;
    boolean drawing;
    
    public InfoBar(final Minecraft mc, final OldAnimationsMod oam, final int PosX, final int PosY) {
        this.oam = oam;
        this.mc = mc;
        this.PosX = PosX;
        this.PosY = PosY;
        this.draw = oam.renderUtils;
    }
    
    public void displayInfo(final String message1, final String message2) {
        this.message1 = message1;
        this.message2 = message2;
        this.time = 0L;
        this.drawing = true;
    }
    
    public void draw() {
        if (this.time == 2000L | this.time > 2000L) {
            this.drawing = false;
        }
        if (this.drawing) {
            ++this.time;
        }
        if (this.time < 2000L && this.time > 200L) {
            GL11.glPushMatrix();
            this.draw.drawRectDragon1((float)this.PosX, (float)this.PosY, (float)(this.PosX + 350), (float)(this.PosY + 25), Integer.MIN_VALUE);
            this.draw.drawRectDragon2((float)this.PosX, (float)(this.PosY + 25), (float)(this.PosX + 350), (float)(this.PosY + 50), Integer.MIN_VALUE);
            this.mc.fontRendererObj.drawStringWithShadow(this.message1, (float)(this.PosX - this.mc.fontRendererObj.getStringWidth(this.message1) / 2 + 175), (float)(this.PosY + 9), 16777215);
            this.mc.fontRendererObj.drawStringWithShadow(this.message2, (float)(this.PosX - this.mc.fontRendererObj.getStringWidth(this.message2) / 2 + 175), (float)(this.PosY + 30), 16777215);
            GL11.glPopMatrix();
        }
    }
}
