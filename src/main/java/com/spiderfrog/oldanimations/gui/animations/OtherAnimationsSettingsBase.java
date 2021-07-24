package com.spiderfrog.oldanimations.gui.animations;

import net.minecraft.client.gui.*;
import com.spiderfrog.oldanimations.*;
import java.io.*;
import com.spiderfrog.gadgets.*;
import org.lwjgl.opengl.*;
import com.spiderfrog.oldanimations.animations.*;
import net.minecraft.util.*;

public class OtherAnimationsSettingsBase extends GuiScreen
{
    GuiScreen parentScreen;
    
    public OtherAnimationsSettingsBase(final GuiScreen parent) {
        this.parentScreen = parent;
    }
    
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Save"));
        super.initGui();
    }
    
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 0: {
                    OldAnimationsMod.getInstance().settings.saveConfigFile();
                    this.mc.displayGuiScreen(this.parentScreen);
                    break;
                }
            }
        }
        super.actionPerformed(button);
    }
    
    public void onGuiClosed() {
        OldAnimationsMod.getInstance().settings.saveConfigFile();
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        final StringBuilder append = new StringBuilder().append("Version ");
        Gadgets.getInstance();
        final String version = append.append("2.6.5").toString();
        this.drawString(this.fontRendererObj, version, 2, this.height - 10, 1962542);
        final String author = "Mod by spiderfrog";
        this.drawString(this.fontRendererObj, author, this.width - this.fontRendererObj.getStringWidth(author) - 2, this.height - 20, 1962542);
        final String fucker = "Cosmetics fucked by FluzerQAQ LOL";
        this.drawString(this.fontRendererObj, fucker, this.width - this.fontRendererObj.getStringWidth(fucker) - 2, this.height - 10, 4286945);
        /*final String website = "http://OldAnimationsMod.net";
        this.drawString(this.fontRendererObj, website, this.width / 2 - this.fontRendererObj.getStringWidth(website) / 2, this.height - 10, 15898686);*/
        final int scale = 3;
        final String oldanimations = "Other Animations";
        GL11.glScaled((double)scale, (double)scale, (double)scale);
        this.drawString(this.fontRendererObj, oldanimations, this.width / 2 / scale - this.fontRendererObj.getStringWidth(oldanimations) / 2, this.height / 11 / scale, 4648180);
        GL11.glScaled((double)(1.0f / scale), (double)(1.0f / scale), (double)(1.0f / scale));
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void processAnimationsButton(final EnumAnimation animation, final GuiScreen gui) {
        OldAnimationsMod.getInstance().sendMessage(animation.getLangCode() + " Toggled!");
        AnimationManager.toggleOtherAnimation(animation);
        this.mc.displayGuiScreen(gui);
    }
    
    public static String animationButton(final EnumAnimation animation) {
        return animation.getLangCode() + ": " + (AnimationManager.getOtherAnimationState(animation) ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }
}
