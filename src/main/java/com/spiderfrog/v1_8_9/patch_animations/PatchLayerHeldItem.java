package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;
import com.spiderfrog.v1_8_9.*;

public class PatchLayerHeldItem extends ClassVisitor
{
    public PatchLayerHeldItem(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerHeldItem/doRenderLayer")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase") + ";FFFFFFF)V")) {
            return (MethodVisitor)new DoRenderLayer(mv, access, name, desc);
        }
        return mv;
    }
    
    public class DoRenderLayer extends GeneratorAdapter implements Opcodes
    {
        int patchedSwordAItem;
        
        public DoRenderLayer(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (opcode == 182 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped/postRenderArm")) && desc.equals("(F)V")) {
                super.visitMethodInsn(opcode, owner, "postRenderArmClear", desc);
            }
            else if (opcode == 184 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate")) && desc.equals("(FFF)V")) {
                ++this.patchedSwordAItem;
                if (this.patchedSwordAItem == 2) {
                    super.visitMethodInsn(opcode, owner, "translateClear", desc);
                    final Label l11 = new Label();
                    this.mv.visitLabel(l11);
                    this.mv.visitLineNumber(45, l11);
                    this.mv.visitVarInsn(25, 1);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerHeldItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerHeldItem/livingEntityRenderer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RendererLivingEntity") + ";");
                    this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "transformHeldItem", "(L" + VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase") + ";L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RendererLivingEntity") + ";)V", false);
                }
                else {
                    super.visitMethodInsn(opcode, owner, name, desc);
                }
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}
