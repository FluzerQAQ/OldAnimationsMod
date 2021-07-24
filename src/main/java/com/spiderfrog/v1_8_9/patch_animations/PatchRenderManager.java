package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;
import com.spiderfrog.oldanimations.animations.*;

public class PatchRenderManager extends ClassVisitor
{
    public PatchRenderManager(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager/renderDebugBoundingBox")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/entity/Entity") + ";DDDFF)V")) {
            return (MethodVisitor)new renderDebugBoundingBox(mv, access, name, desc);
        }
        return mv;
    }
    
    public class renderDebugBoundingBox extends GeneratorAdapter implements Opcodes
    {
        boolean patched;
        int aload;
        
        public renderDebugBoundingBox(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, desc, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            super.visitMethodInsn(opcode, owner, name, desc);
            if (!this.patched && opcode == 184 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/RenderGlobal")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/RenderGlobal/drawOutlinedBoundingBox")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/util/AxisAlignedBB") + ";IIII)V")) {
                this.patched = true;
                final Label l9 = new Label();
                this.mv.visitLabel(l9);
                this.mv.visitLineNumber(452, l9);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDHITBOX", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l10 = new Label();
                this.mv.visitJumpInsn(153, l10);
                final Label l11 = new Label();
                this.mv.visitLabel(l11);
                this.mv.visitLineNumber(453, l11);
                this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableTexture2D"), "()V", false);
                final Label l12 = new Label();
                this.mv.visitLabel(l12);
                this.mv.visitLineNumber(454, l12);
                this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableLighting"), "()V", false);
                final Label l13 = new Label();
                this.mv.visitLabel(l13);
                this.mv.visitLineNumber(455, l13);
                this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableCull"), "()V", false);
                final Label l14 = new Label();
                this.mv.visitLabel(l14);
                this.mv.visitLineNumber(456, l14);
                this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/disableBlend"), "()V", false);
                final Label l15 = new Label();
                this.mv.visitLabel(l15);
                this.mv.visitLineNumber(457, l15);
                this.mv.visitInsn(4);
                this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthMask"), "(Z)V", false);
                final Label l16 = new Label();
                this.mv.visitLabel(l16);
                this.mv.visitLineNumber(458, l16);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l10);
                this.mv.visitLineNumber(461, l10);
                this.mv.visitFrame(1, 3, new Object[] { Opcodes.FLOAT, VersionTranslation.getDeobf("net/minecraft/util/AxisAlignedBB"), VersionTranslation.getDeobf("net/minecraft/util/AxisAlignedBB") }, 0, (Object[])null);
                this.mv.visitVarInsn(25, 1);
                this.mv.visitTypeInsn(193, VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase"));
            }
        }
    }
}
