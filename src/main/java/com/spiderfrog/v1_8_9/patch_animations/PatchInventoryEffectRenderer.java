package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.commons.*;
import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;

public class PatchInventoryEffectRenderer extends ClassVisitor implements Opcodes
{
    public PatchInventoryEffectRenderer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/renderer/InventoryEffectRenderer/updateActivePotionEffects")) && desc.equalsIgnoreCase("()V")) {
            return (MethodVisitor)new UpdateActivePotionEffects(mv, access, name, desc);
        }
        return mv;
    }
    
    public class UpdateActivePotionEffects extends GeneratorAdapter
    {
        public UpdateActivePotionEffects(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitInsn(final int opcode) {
            if (opcode == 177) {
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "NOINVMOVE", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOtherAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l7 = new Label();
                this.mv.visitJumpInsn(153, l7);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/InventoryEffectRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/thePlayer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";");
                this.mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase/getActivePotionEffects"), "()Ljava/util/Collection;", false);
                this.mv.visitMethodInsn(185, "java/util/Collection", "isEmpty", "()Z", true);
                this.mv.visitJumpInsn(154, l7);
                final Label l8 = new Label();
                this.mv.visitLabel(l8);
                this.mv.visitLineNumber(42, l8);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/InventoryEffectRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/width"), "I");
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/InventoryEffectRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/inventory/GuiContainer/xSize"), "I");
                this.mv.visitInsn(100);
                this.mv.visitInsn(5);
                this.mv.visitInsn(108);
                this.mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/InventoryEffectRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/inventory/GuiContainer/guiLeft"), "I");
                this.mv.visitLabel(l7);
                this.mv.visitLineNumber(45, l7);
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
                this.mv.visitInsn(177);
            }
            super.visitInsn(opcode);
        }
    }
}
