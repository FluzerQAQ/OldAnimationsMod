package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.animations.*;
import com.spiderfrog.oldanimations.gui.utils.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class OtherAnimationsSettings1 extends OtherAnimationsSettingsBase
{
    public OtherAnimationsSettings1(final GuiScreen parent) {
        super(parent);
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new AnimationButton(1, this.width / 2 - 100, this.height / 4, EnumAnimation.NOINVBACKGROUND));
        this.buttonList.add(new AnimationButton(2, this.width / 2 + 2, this.height / 4, EnumAnimation.NOINVMOVE));
        this.buttonList.add(new AnimationButton(3, this.width / 2 - 100, this.height / 4 + 24, EnumAnimation.NOBOSSBAR));
        /*this.buttonList.add(new AnimationButton(4, this.width / 2 + 2, this.height / 4 + 24, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(5, this.width / 2 - 100, this.height / 4 + 48, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(6, this.width / 2 + 2, this.height / 4 + 48, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(7, this.width / 2 - 100, this.height / 4 + 72, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(8, this.width / 2 + 2, this.height / 4 + 72, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(9, this.width / 2 - 100, this.height / 4 + 96, EnumAnimation.OTHERCOMMINGSOON));
        this.buttonList.add(new AnimationButton(10, this.width / 2 + 2, this.height / 4 + 96, EnumAnimation.OTHERCOMMINGSOON));*/
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 1: {
                    this.processAnimationsButton(EnumAnimation.NOINVBACKGROUND, this);
                    break;
                }
                case 2: {
                    this.processAnimationsButton(EnumAnimation.NOINVMOVE, this);
                    break;
                }
                case 3: {
                    this.processAnimationsButton(EnumAnimation.NOBOSSBAR, this);
                    break;
                }
                /*case 4: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 5: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 6: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 7: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 8: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 9: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }
                case 10: {
                    this.processAnimationsButton(EnumAnimation.OTHERCOMMINGSOON, this);
                    break;
                }*/
            }
        }
        super.actionPerformed(button);
    }
}
