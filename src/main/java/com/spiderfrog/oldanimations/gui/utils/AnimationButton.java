package com.spiderfrog.oldanimations.gui.utils;

import com.spiderfrog.oldanimations.animations.*;
import net.minecraft.util.*;
import com.spiderfrog.oldanimations.gui.animations.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.audio.*;

public class AnimationButton extends GuiButton
{
    protected static final ResourceLocation buttonTextures;
    protected int width;
    protected int height;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled;
    public boolean visible;
    protected boolean hovered;
    
    public AnimationButton(final int buttonId, final int x, final int y, final EnumAnimation animation) {
        super(buttonId, x, y, 98, 20, ((animation == EnumAnimation.OLDCOMMINGSOON) ? (EnumChatFormatting.GRAY + "") : ((animation == EnumAnimation.OTHERCOMMINGSOON) ? (EnumChatFormatting.GRAY + "") : "")) + ((animation.getType() == EnumAnimation.AnimationType.OLD) ? OldAnimationsSettingsBase.animationButton(animation) : OtherAnimationsSettingsBase.animationButton(animation)));
        this.width = 98;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.displayString = ((animation == EnumAnimation.OLDCOMMINGSOON) ? (EnumChatFormatting.GRAY + "") : ((animation == EnumAnimation.OTHERCOMMINGSOON) ? (EnumChatFormatting.GRAY + "") : "")) + ((animation.getType() == EnumAnimation.AnimationType.OLD) ? OldAnimationsSettingsBase.animationButton(animation) : OtherAnimationsSettingsBase.animationButton(animation));
    }
    
    protected int getHoverState(final boolean mouseOver) {
        int i = 1;
        if (!this.enabled) {
            i = 0;
        }
        else if (mouseOver) {
            i = 2;
        }
        return i;
    }
    
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            final FontRenderer fontrenderer = Minecraft.getMinecraft().fontRendererObj;
            mc.getTextureManager().bindTexture(AnimationButton.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            final int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;
            if (!this.enabled) {
                j = 10526880;
            }
            else if (this.hovered) {
                j = 16777120;
            }
            fontrenderer.drawStringWithShadow(this.displayString, (float)(this.xPosition + this.width / 2 - fontrenderer.getStringWidth(this.displayString) / 2), (float)(this.yPosition + (this.height - 8) / 2), j);
        }
    }
    
    protected void mouseDragged(final Minecraft mc, final int mouseX, final int mouseY) {
    }
    
    public void mouseReleased(final int mouseX, final int mouseY) {
    }
    
    public boolean mousePressed(final Minecraft mc, final int mouseX, final int mouseY) {
        return this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
    }
    
    public boolean isMouseOver() {
        return this.hovered;
    }
    
    public void drawButtonForegroundLayer(final int mouseX, final int mouseY) {
    }
    
    public void playPressSound(final SoundHandler soundHandlerIn) {
        soundHandlerIn.playSound((ISound)PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0f));
    }
    
    public int getButtonWidth() {
        return this.width;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
    
    static {
        buttonTextures = new ResourceLocation("textures/gui/widgets.png");
    }
}
