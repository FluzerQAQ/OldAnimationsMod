package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;

public class PatchLayerBipedArmor extends ClassVisitor
{
    public PatchLayerBipedArmor(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(1, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerArmorBase/shouldCombineTextures"), "()Z", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(61, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDMG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        mv.visitInsn(172);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerBipedArmor") + ";", (String)null, l0, l2, 0);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }
}
