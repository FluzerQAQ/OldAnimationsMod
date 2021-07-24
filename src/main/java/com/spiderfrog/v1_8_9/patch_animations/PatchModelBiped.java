package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;

public class PatchModelBiped extends ClassVisitor implements Opcodes
{
    public PatchModelBiped(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(2, "performOldSword", "()V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(99, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDSWORD", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(153, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(100, l3);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped"), VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped/bipedRightArm"), "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer") + ";");
        mv.visitInsn(11);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer"), VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer/rotateAngleY"), "F");
        mv.visitLabel(l2);
        mv.visitLineNumber(102, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped") + ";", (String)null, l0, l4, 0);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
        this.appendPostRenderArmClear();
        super.visitEnd();
    }
    
    private void appendPostRenderArmClear() {
        final MethodVisitor mv = this.cv.visitMethod(1, "postRenderArmClear", "(F)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(236, l0);
        mv.visitInsn(177);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped") + ";", (String)null, l0, l2, 0);
        mv.visitLocalVariable("scale", "F", (String)null, l0, l2, 1);
        mv.visitMaxs(0, 2);
        mv.visitEnd();
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped/setRotationAngles")) && desc.equals("(FFFFFFL" + VersionTranslation.getDeobf("net/minecraft/entity/Entity") + ";)V")) {
            return (MethodVisitor)new SetRotationAngles(mv, access, name, desc);
        }
        return mv;
    }
    
    public class SetRotationAngles extends GeneratorAdapter implements Opcodes
    {
        int patchi;
        
        public SetRotationAngles(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);
            if (opcode == 181 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer/rotateAngleY"))) {
                ++this.patchi;
                if (this.patchi == 7) {
                    ++this.patchi;
                    final Label l83 = new Label();
                    this.mv.visitLabel(l83);
                    this.mv.visitLineNumber(206, l83);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped"), "performOldSword", "()V", false);
                }
            }
        }
    }
}
