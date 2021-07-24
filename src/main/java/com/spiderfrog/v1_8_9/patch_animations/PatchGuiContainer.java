package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.*;
import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.oldanimations.animations.*;
import net.minecraft.client.*;
import org.objectweb.asm.commons.*;

public class PatchGuiContainer extends ClassVisitor implements Opcodes
{
    public PatchGuiContainer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/drawScreen")) && desc.equalsIgnoreCase("(IIF)V")) {
            return (MethodVisitor)new DrawScreen(mv, access, name, desc);
        }
        return mv;
    }
    
    public static void drawBackgroundOAM() {
        if (!AnimationManager.getOtherAnimationState(EnumAnimation.NOINVBACKGROUND)) {
            drawGradientRect(0, 0, Minecraft.getMinecraft().currentScreen.width, Minecraft.getMinecraft().currentScreen.height, -1072689136, -804253680);
        }
    }
    
    private static void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor) {
        Methods.getInstance().drawGradientRect(left, top, right, bottom, startColor, endColor);
    }
    
    public class DrawScreen extends GeneratorAdapter
    {
        public DrawScreen(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (opcode == 182 && owner.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/inventory/GuiContainer")) && name.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/drawDefaultBackground")) && desc.equalsIgnoreCase("()V")) {
                super.visitMethodInsn(184, VersionTranslation.getPath(PatchGuiContainer.class), "drawBackgroundOAM", desc);
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}
