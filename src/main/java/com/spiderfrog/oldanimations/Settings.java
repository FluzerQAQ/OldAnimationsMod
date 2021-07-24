package com.spiderfrog.oldanimations;

import com.spiderfrog.gadgets.utils.config.*;
import java.io.*;
import com.spiderfrog.oldanimations.animations.*;

public class Settings implements ConfigFile
{
    @Override
    public File configFile() {
        return new File("OldAnimationsMod.json");
    }
    
    @Override
    public void init() {
        this.createConfigFile();
        this.loadConfigFile();
    }
    
    @Override
    public void loadConfigFile() {
        try {
            for (final EnumAnimation animation : EnumAnimation.values()) {
                switch (animation.getType()) {
                    case OLD: {
                        AnimationManager.loadOldAnimationState(animation);
                        break;
                    }
                    case OTHER: {
                        AnimationManager.loadOtherAnimationState(animation);
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            this.configFile().delete();
            this.createConfigFile();
            e.printStackTrace();
        }
    }
    
    @Override
    public void saveConfigFile() {
        for (final EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD: {
                    AnimationManager.saveOldAnimationState(animation);
                    break;
                }
                case OTHER: {
                    AnimationManager.saveOtherAnimationState(animation);
                    break;
                }
            }
        }
    }
    
    @Override
    public void createConfigFile() {
        for (final EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD: {
                    AnimationManager.createOldAnimationState(animation);
                    break;
                }
                case OTHER: {
                    AnimationManager.createOtherAnimationState(animation);
                    break;
                }
            }
        }
    }
}
