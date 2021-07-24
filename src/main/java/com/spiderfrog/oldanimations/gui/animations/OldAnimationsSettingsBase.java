package com.spiderfrog.oldanimations.gui.animations;

import net.minecraft.client.gui.*;
import com.spiderfrog.oldanimations.*;
import java.io.*;
import com.spiderfrog.gadgets.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import com.spiderfrog.oldanimations.animations.*;

public class OldAnimationsSettingsBase extends GuiScreen
{
    public GuiButton nextPage;
    public GuiButton previousPage;
    public GuiButton mods;
    public static GuiScreen modGUI;
    
    public void initGui() {
        this.buttonList.add(new GuiButton(4000, 4, 4, 70, 20, "Others"));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Save"));
        this.buttonList.add(this.nextPage = new GuiButton(1000, this.width / 2 + 110, this.height / 4 + 72 + 48, 40, 20, "->"));
        this.buttonList.add(this.previousPage = new GuiButton(2000, this.width / 2 - 150, this.height / 4 + 72 + 48, 40, 20, "<-"));
        super.initGui();
    }
    
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 4000: {
                    this.mc.displayGuiScreen((GuiScreen)new OtherAnimationsSettings1(this));
                    break;
                }
                case 1000: {
                    this.mc.displayGuiScreen((GuiScreen)new OldAnimationsSettings2());
                    break;
                }
                case 2000: {
                    this.mc.displayGuiScreen((GuiScreen)new OldAnimationsSettings1());
                    break;
                }
                case 0: {
                    OldAnimationsMod.getInstance().settings.saveConfigFile();
                    this.mc.setIngameFocus();
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
        final String oldanimations = "Old Animations";
        GL11.glScaled((double)scale, (double)scale, (double)scale);
        this.fontRendererObj.drawStringWithShadow(oldanimations, (float)(this.width / 2 / scale - this.fontRendererObj.getStringWidth(oldanimations) / 2), (float)(this.height / 11 / scale), 4648180);
        GL11.glScaled((double)(1.0f / scale), (double)(1.0f / scale), (double)(1.0f / scale));
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public String animationButton(final String name, final boolean value) {
        return name + ": " + (value ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }
    
    public static String animationButton(final EnumAnimation animation) {
        return animation.getLangCode() + ": " + (AnimationManager.getOldAnimationState(animation) ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }
    
    public void processAnimationsButton(final EnumAnimation animation, final GuiScreen gui) {
        OldAnimationsMod.getInstance().sendMessage(animation.getLangCode() + " Toggled!");
        AnimationManager.toggleOldAnimation(animation);
        this.mc.displayGuiScreen(gui);
    }
}
