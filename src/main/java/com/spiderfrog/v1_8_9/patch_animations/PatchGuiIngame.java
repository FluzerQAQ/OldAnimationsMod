package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.commons.*;

public class PatchGuiIngame extends ClassVisitor implements Opcodes
{
    public PatchGuiIngame(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame/showCrosshair")) && desc.equals("()Z")) {
            return (MethodVisitor)new ShowCrosshair(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame/renderBossHealth")) && desc.equals("()V")) {
            return (MethodVisitor)new RenderBossHealth(mv, access, name, desc);
        }
        return mv;
    }
    
    public static void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height) {
        Methods.getInstance().drawTexturedModalRect(x, y, textureX, textureY, width, height);
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(1, "drawTexturedModalRectOAM", "(IIIIII)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(35, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "NOBOSSBAR", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOtherAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(154, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(36, l3);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitVarInsn(21, 5);
        mv.visitVarInsn(21, 6);
        mv.visitMethodInsn(184, VersionTranslation.getPath(PatchGuiIngame.class), "drawTexturedModalRect", "(IIIIII)V", false);
        mv.visitLabel(l2);
        mv.visitLineNumber(38, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getPath(PatchGuiIngame.class) + ";", (String)null, l0, l4, 0);
        mv.visitLocalVariable("x", "I", (String)null, l0, l4, 1);
        mv.visitLocalVariable("y", "I", (String)null, l0, l4, 2);
        mv.visitLocalVariable("textureX", "I", (String)null, l0, l4, 3);
        mv.visitLocalVariable("textureY", "I", (String)null, l0, l4, 4);
        mv.visitLocalVariable("width", "I", (String)null, l0, l4, 5);
        mv.visitLocalVariable("height", "I", (String)null, l0, l4, 6);
        mv.visitMaxs(6, 7);
        mv.visitEnd();
        super.visitEnd();
    }
    
    public class ShowCrosshair extends GeneratorAdapter
    {
        boolean patchedDebug;
        
        public ShowCrosshair(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitInsn(final int opcode) {
            if (opcode == 172 && !this.patchedDebug) {
                this.patchedDebug = true;
                final Label l2 = new Label();
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(433, l2);
                this.mv.visitFieldInsn(178, "com/spiderfrog/oldanimations/animations/EnumAnimation", "OLDDEBUG", "Lcom/spiderfrog/oldanimations/animations/EnumAnimation;");
                this.mv.visitMethodInsn(184, "com/spiderfrog/oldanimations/animations/AnimationManager", "getOldAnimationState", "(Lcom/spiderfrog/oldanimations/animations/EnumAnimation;)Z", false);
                final Label l3 = new Label();
                this.mv.visitJumpInsn(153, l3);
                final Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(434, l4);
                this.mv.visitInsn(4);
                this.mv.visitInsn(172);
                this.mv.visitLabel(l3);
            }
            super.visitInsn(opcode);
        }
    }
    
    public class RenderBossHealth extends GeneratorAdapter
    {
        public RenderBossHealth(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (opcode == 182 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect")) && desc.equals("(IIIIII)V")) {
                super.visitMethodInsn(opcode, owner, "drawTexturedModalRectOAM", desc);
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}
