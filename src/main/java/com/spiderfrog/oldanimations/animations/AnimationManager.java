package com.spiderfrog.oldanimations.animations;

import java.util.*;
import com.spiderfrog.oldanimations.*;
import com.spiderfrog.gadgets.utils.config.*;

public class AnimationManager
{
    private static HashMap<EnumAnimation, Boolean> oldAnimations;
    private static HashMap<EnumAnimation, Boolean> otherAnimations;
    
    public void initAnimations() {
        AnimationManager.oldAnimations.clear();
        for (final EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD: {
                    AnimationManager.oldAnimations.put(animation, true);
                    break;
                }
                case OTHER: {
                    AnimationManager.otherAnimations.put(animation, false);
                    break;
                }
            }
        }
    }
    
    public static void toggleOldAnimation(final EnumAnimation animation) {
        boolean value = AnimationManager.oldAnimations.get(animation);
        value = !value;
        AnimationManager.oldAnimations.replace(animation, value);
    }
    
    public static void toggleOtherAnimation(final EnumAnimation animation) {
        boolean value = AnimationManager.otherAnimations.get(animation);
        value = !value;
        AnimationManager.otherAnimations.replace(animation, value);
    }
    
    public static boolean getOldAnimationState(final EnumAnimation animation) {
        return AnimationManager.oldAnimations.get(animation);
    }
    
    public static boolean getOtherAnimationState(final EnumAnimation animation) {
        return AnimationManager.otherAnimations.get(animation);
    }
    
    public static void loadOldAnimationState(final EnumAnimation animation) throws Exception {
        final boolean state = JsonConfigUpdate.getInstance().updatePropertyBoolean(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName());
        AnimationManager.oldAnimations.replace(animation, state);
    }
    
    public static void loadOtherAnimationState(final EnumAnimation animation) throws Exception {
        final boolean state = JsonConfigUpdate.getInstance().updatePropertyBoolean(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName());
        AnimationManager.otherAnimations.replace(animation, state);
    }
    
    public static void saveOldAnimationState(final EnumAnimation animation) {
        JsonConfigSave.getInstance().saveProperty(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName(), getOldAnimationState(animation));
    }
    
    public static void saveOtherAnimationState(final EnumAnimation animation) {
        JsonConfigSave.getInstance().saveProperty(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName(), getOtherAnimationState(animation));
    }
    
    public static void createOldAnimationState(final EnumAnimation animation) {
        JsonConfigCreate.getInstance().addProperty(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName(), getOldAnimationState(animation));
    }
    
    public static void createOtherAnimationState(final EnumAnimation animation) {
        JsonConfigCreate.getInstance().addProperty(OldAnimationsMod.getInstance().settings.configFile(), animation.getVarName(), getOtherAnimationState(animation));
    }
    
    static {
        AnimationManager.oldAnimations = new HashMap<EnumAnimation, Boolean>();
        AnimationManager.otherAnimations = new HashMap<EnumAnimation, Boolean>();
    }
}
