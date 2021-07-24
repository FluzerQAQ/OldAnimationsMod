package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;
import com.spiderfrog.oldanimations.animations.*;
import com.spiderfrog.v1_8_9.*;

public class PatchEntityRenderer extends ClassVisitor implements Opcodes
{
    public PatchEntityRenderer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/EntityRenderer/renderWorldPass")) && desc.equals("(IFJ)V")) {
            return (MethodVisitor)new RenderWorldPass(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/EntityRenderer/renderWorldDirections")) && desc.equals("(F)V")) {
            return (MethodVisitor)new RenderWorldDirections(mv, access, name, desc);
        }
        return mv;
    }
    
    public class RenderWorldDirections extends GeneratorAdapter
    {
        boolean patchedDebug;
        
        public RenderWorldDirections(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitInsn(final int opcode) {
            if (!this.patchedDebug) {
                this.patchedDebug = true;
                final Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(1134, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l2 = new Label();
                this.mv.visitJumpInsn(153, l2);
                final Label l3 = new Label();
                this.mv.visitLabel(l3);
                this.mv.visitLineNumber(1135, l3);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(1137, l2);
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
            }
            super.visitInsn(opcode);
        }
    }
    
    public class RenderWorldPass extends GeneratorAdapter
    {
        public RenderWorldPass(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitInsn(final int opcode) {
            if (opcode == 177) {
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "blockbuild", "()V", false);
                final Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(69, l4);
            }
            super.visitInsn(opcode);
        }
    }
}
