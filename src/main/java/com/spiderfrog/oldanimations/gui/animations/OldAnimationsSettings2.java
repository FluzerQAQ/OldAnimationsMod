package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.animations.*;
import com.spiderfrog.oldanimations.gui.utils.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class OldAnimationsSettings2 extends OldAnimationsSettingsBase
{
    @Override
    public void initGui() {
        super.initGui();
        this.nextPage.enabled = false;
        this.buttonList.add(new AnimationButton(1, this.width / 2 - 100, this.height / 4, EnumAnimation.OLDSWORD));
        this.buttonList.add(new AnimationButton(2, this.width / 2 + 2, this.height / 4, EnumAnimation.OLDITEMHELD));
        this.buttonList.add(new AnimationButton(3, this.width / 2 - 100, this.height / 4 + 24, EnumAnimation.OLDHITBOX));
        this.buttonList.add(new AnimationButton(4, this.width / 2 + 2, this.height / 4 + 24, EnumAnimation.OLDSWING));
        this.buttonList.add(new AnimationButton(5, this.width / 2 - 100, this.height / 4 + 48, EnumAnimation.OLDITEMUPDATE));
        this.buttonList.add(new AnimationButton(6, this.width / 2 + 2, this.height / 4 + 48, EnumAnimation.OLDFASTITEMS));
        this.buttonList.add(new AnimationButton(7, this.width / 2 - 100, this.height / 4 + 72, EnumAnimation.OLDCROSSHAIR));
        this.buttonList.add(new AnimationButton(8, this.width / 2 + 2, this.height / 4 + 72, EnumAnimation.OLDENCHGLINT));
        /*this.buttonList.add(new AnimationButton(9, this.width / 2 - 100, this.height / 4 + 96, EnumAnimation.OLDCOMMINGSOON));
        this.buttonList.add(new AnimationButton(10, this.width / 2 + 2, this.height / 4 + 96, EnumAnimation.OLDCOMMINGSOON));*/
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        super.actionPerformed(button);
        if (button.enabled) {
            switch (button.id) {
                case 1: {
                    this.processAnimationsButton(EnumAnimation.OLDSWORD, this);
                    break;
                }
                case 2: {
                    this.processAnimationsButton(EnumAnimation.OLDITEMHELD, this);
                    break;
                }
                case 3: {
                    this.processAnimationsButton(EnumAnimation.OLDHITBOX, this);
                    break;
                }
                case 4: {
                    this.processAnimationsButton(EnumAnimation.OLDSWING, this);
                    break;
                }
                case 5: {
                    this.processAnimationsButton(EnumAnimation.OLDITEMUPDATE, this);
                    break;
                }
                case 6: {
                    this.processAnimationsButton(EnumAnimation.OLDFASTITEMS, this);
                    break;
                }
                case 7: {
                    this.processAnimationsButton(EnumAnimation.OLDCROSSHAIR, this);
                    break;
                }
                case 8: {
                    this.processAnimationsButton(EnumAnimation.OLDENCHGLINT, this);
                    break;
                }
                /*case 9: {
                    this.processAnimationsButton(EnumAnimation.OLDCOMMINGSOON, this);
                    break;
                }
                case 10: {
                    this.processAnimationsButton(EnumAnimation.OLDCOMMINGSOON, this);
                    break;
                }*/
            }
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
