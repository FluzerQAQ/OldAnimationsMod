package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;

public class PatchFontRenderer extends ClassVisitor
{
    public PatchFontRenderer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(1, "drawStringDebug", "(Ljava/lang/String;III)I", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(273, l0);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(134);
        mv.visitVarInsn(21, 3);
        mv.visitInsn(134);
        mv.visitVarInsn(21, 4);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer/drawString"), "(Ljava/lang/String;FFIZ)I", false);
        mv.visitInsn(172);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer") + ";", (String)null, l0, l2, 0);
        mv.visitLocalVariable("text", "Ljava/lang/String;", (String)null, l0, l2, 1);
        mv.visitLocalVariable("x", "I", (String)null, l0, l2, 2);
        mv.visitLocalVariable("y", "I", (String)null, l0, l2, 3);
        mv.visitLocalVariable("color", "I", (String)null, l0, l2, 4);
        mv.visitMaxs(6, 5);
        mv.visitEnd();
        super.visitEnd();
    }
}
