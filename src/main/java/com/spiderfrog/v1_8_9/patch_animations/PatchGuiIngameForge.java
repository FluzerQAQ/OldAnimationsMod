package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;
import net.minecraft.client.gui.*;
import org.objectweb.asm.commons.*;

public class PatchGuiIngameForge extends ClassVisitor implements Opcodes
{
    public PatchGuiIngameForge(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals("renderHUDText") && desc.equals("(II)V")) {
            return new RenderDebugInfoLeft(mv, access, name, desc);
        }
        if (name.equals("renderHealth") && desc.equals("(II)V")) {
            return (MethodVisitor)new RenderHealth(mv, access, name, desc);
        }
        return mv;
    }
    
    public void visitEnd() {
        final FieldVisitor fv = this.cv.visitField(4, "hightlight", "J", (String)null, (Object)null);
        fv.visitEnd();
        final MethodVisitor mv = this.cv.visitMethod(9, "drawRectDebug", "(IIIII)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(45, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(154, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(46, l3);
        mv.visitVarInsn(21, 0);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitMethodInsn(184, "net/minecraftforge/client/GuiIngameForge", VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawRect"), "(IIIII)V", false);
        mv.visitLabel(l2);
        mv.visitLineNumber(48, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("left", "I", (String)null, l0, l4, 0);
        mv.visitLocalVariable("top", "I", (String)null, l0, l4, 1);
        mv.visitLocalVariable("right", "I", (String)null, l0, l4, 2);
        mv.visitLocalVariable("bottom", "I", (String)null, l0, l4, 3);
        mv.visitLocalVariable("color", "I", (String)null, l0, l4, 4);
        mv.visitMaxs(5, 5);
        mv.visitEnd();
        this.oldHighlight();
        super.visitEnd();
    }
    
    private void oldHighlight() {
        final MethodVisitor mv = this.cv.visitMethod(2, "drawTexturedModalRectOAM", "(IIIIII)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(272, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDHEARTS", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(154, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(273, l3);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitVarInsn(21, 5);
        mv.visitVarInsn(21, 6);
        mv.visitMethodInsn(182, "net/minecraftforge/client/GuiIngameForge", VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect"), "(IIIIII)V", false);
        mv.visitLabel(l2);
        mv.visitLineNumber(275, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "Lnet/minecraftforge/client/GuiIngameForge;", (String)null, l0, l4, 0);
        mv.visitLocalVariable("x", "I", (String)null, l0, l4, 1);
        mv.visitLocalVariable("y", "I", (String)null, l0, l4, 2);
        mv.visitLocalVariable("textureX", "I", (String)null, l0, l4, 3);
        mv.visitLocalVariable("textureY", "I", (String)null, l0, l4, 4);
        mv.visitLocalVariable("width", "I", (String)null, l0, l4, 5);
        mv.visitLocalVariable("height", "I", (String)null, l0, l4, 6);
        mv.visitMaxs(7, 7);
        mv.visitEnd();
    }
    
    public static void drawRectDebug(final int left, final int top, final int right, final int bottom, final int color) {
        if (!AnimationManager.getOldAnimationState(EnumAnimation.OLDDEBUG)) {
            Gui.drawRect(left, top, right, bottom, color);
        }
    }
    
    public class RenderDebugInfoLeft extends MethodVisitor implements Opcodes
    {
        public RenderDebugInfoLeft(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (opcode == 184 && owner.equals("net/minecraftforge/client/GuiIngameForge") && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawRect")) && desc.equals("(IIIII)V")) {
                super.visitMethodInsn(opcode, owner, "drawRectDebug", desc);
            }
            else if (opcode == 182 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer/drawString")) && desc.equals("(Ljava/lang/String;III)I")) {
                super.visitMethodInsn(opcode, owner, "drawStringDebug", desc);
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
    
    public class RenderHealth extends GeneratorAdapter implements Opcodes
    {
        int time;
        
        public RenderHealth(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc, final boolean itf) {
            if (owner.equals("net/minecraftforge/client/GuiIngameForge") && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect")) && desc.equals("(IIIIII)V")) {
                ++this.time;
                if (this.time == 2 || this.time == 3) {
                    super.visitMethodInsn(183, "net/minecraftforge/client/GuiIngameForge", "drawTexturedModalRectOAM", desc, itf);
                }
                else {
                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                }
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
            }
        }
    }
}
