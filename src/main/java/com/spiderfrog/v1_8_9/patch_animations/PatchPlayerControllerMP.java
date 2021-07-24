package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;
import com.spiderfrog.oldanimations.animations.*;

public class PatchPlayerControllerMP extends ClassVisitor implements Opcodes
{
    public PatchPlayerControllerMP(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/multiplayer/PlayerControllerMP/func_181040_m")) && desc.equals("()Z")) {
            return (MethodVisitor)new getIsHittingBlock(mv, access, name, desc, signature, exceptions);
        }
        return mv;
    }
    
    public class getIsHittingBlock extends GeneratorAdapter implements Opcodes
    {
        boolean patched;
        
        getIsHittingBlock(final MethodVisitor mv, final int access, final String name, final String desc, final String signature, final String[] exceptions) {
            super(262144, mv, access, name, desc);
            this.patched = false;
        }
        
        public void visitVarInsn(final int opcode, final int var) {
            if (!this.patched) {
                this.patched = true;
                final Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(622, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKBUILD", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l2 = new Label();
                this.mv.visitJumpInsn(153, l2);
                this.mv.visitInsn(3);
                this.mv.visitInsn(172);
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(623, l2);
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
            }
            super.visitVarInsn(opcode, var);
        }
    }
}
