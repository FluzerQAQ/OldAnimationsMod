package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.*;

public class PatchGlStateManager extends ClassVisitor implements Opcodes
{
    public PatchGlStateManager(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(9, "translateClear", "(FFF)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(430, l0);
        mv.visitInsn(177);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLocalVariable("x", "F", (String)null, l0, l2, 0);
        mv.visitLocalVariable("y", "F", (String)null, l0, l2, 1);
        mv.visitLocalVariable("z", "F", (String)null, l0, l2, 2);
        mv.visitMaxs(0, 3);
        mv.visitEnd();
        super.visitEnd();
    }
}
