package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;

public class PatchRenderItem extends ClassVisitor implements Opcodes
{
    public PatchRenderItem(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderItem")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V")) {
            return (MethodVisitor)new RenderItem(mv, access, name, desc);
        }
        return mv;
    }
    
    public void visitEnd() {
        final MethodVisitor mv = this.cv.visitMethod(1, "renderEffectOld", "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(233, l0);
        mv.visitFieldInsn(178, "com/spiderfrog/oldanimations/animations/EnumAnimation", "OLDENCHGLINT", "Lcom/spiderfrog/oldanimations/animations/EnumAnimation;");
        mv.visitMethodInsn(184, "com/spiderfrog/oldanimations/animations/AnimationManager", "getOldAnimationState", "(Lcom/spiderfrog/oldanimations/animations/EnumAnimation;)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(154, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(234, l3);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderEffect"), "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V", false);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(235, l4);
        mv.visitInsn(177);
        mv.visitLabel(l2);
        mv.visitLineNumber(237, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(3);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthMask"), "(Z)V", false);
        final Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLineNumber(238, l5);
        mv.visitIntInsn(17, 514);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthFunc"), "(I)V", false);
        final Label l6 = new Label();
        mv.visitLabel(l6);
        mv.visitLineNumber(239, l6);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/disableLighting"), "()V", false);
        final Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(240, l7);
        mv.visitIntInsn(17, 768);
        mv.visitInsn(4);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/blendFunc"), "(II)V", false);
        final Label l8 = new Label();
        mv.visitLabel(l8);
        mv.visitLineNumber(241, l8);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/textureManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager") + ";");
        mv.visitFieldInsn(178, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/RES_ITEM_GLINT"), "L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager/bindTexture"), "(L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";)V", false);
        final Label l9 = new Label();
        mv.visitLabel(l9);
        mv.visitLineNumber(243, l9);
        mv.visitIntInsn(17, 5890);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/matrixMode"), "(I)V", false);
        final Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(244, l10);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/pushMatrix"), "()V", false);
        final Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLineNumber(245, l11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableAlpha"), "()V", false);
        final Label l12 = new Label();
        mv.visitLabel(l12);
        mv.visitLineNumber(246, l12);
        mv.visitLdcInsn((Object)new Float("6.0"));
        mv.visitLdcInsn((Object)new Float("6.0"));
        mv.visitLdcInsn((Object)new Float("6.0"));
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        final Label l13 = new Label();
        mv.visitLabel(l13);
        mv.visitLineNumber(247, l13);
        mv.visitInsn(3);
        mv.visitVarInsn(54, 2);
        final Label l14 = new Label();
        mv.visitLabel(l14);
        final Label l15 = new Label();
        mv.visitJumpInsn(167, l15);
        final Label l16 = new Label();
        mv.visitLabel(l16);
        mv.visitLineNumber(248, l16);
        mv.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, (Object[])null);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/getSystemTime"), "()J", false);
        mv.visitIntInsn(17, 3000);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(17, 1873);
        mv.visitInsn(104);
        mv.visitInsn(96);
        mv.visitInsn(133);
        mv.visitInsn(113);
        mv.visitInsn(137);
        mv.visitLdcInsn((Object)new Float("2000.0"));
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(17, 1873);
        mv.visitInsn(104);
        mv.visitInsn(134);
        mv.visitInsn(98);
        mv.visitInsn(110);
        mv.visitLdcInsn((Object)new Float("8.0"));
        mv.visitInsn(110);
        mv.visitVarInsn(56, 3);
        final Label l17 = new Label();
        mv.visitLabel(l17);
        mv.visitLineNumber(249, l17);
        mv.visitVarInsn(23, 3);
        mv.visitInsn(118);
        mv.visitInsn(11);
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        final Label l18 = new Label();
        mv.visitLabel(l18);
        mv.visitLineNumber(250, l18);
        mv.visitLdcInsn((Object)new Float("40.0"));
        mv.visitInsn(11);
        mv.visitInsn(11);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/rotate"), "(FFFF)V", false);
        final Label l19 = new Label();
        mv.visitLabel(l19);
        mv.visitLineNumber(251, l19);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitLdcInsn((Object)new Integer(-8372020));
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderModel"), "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";I)V", false);
        final Label l20 = new Label();
        mv.visitLabel(l20);
        mv.visitLineNumber(252, l20);
        mv.visitLdcInsn((Object)new Float("-1.0"));
        mv.visitInsn(12);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        final Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(247, l21);
        mv.visitIincInsn(2, 1);
        mv.visitLabel(l15);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(5);
        mv.visitJumpInsn(161, l16);
        final Label l22 = new Label();
        mv.visitLabel(l22);
        mv.visitLineNumber(254, l22);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/popMatrix"), "()V", false);
        final Label l23 = new Label();
        mv.visitLabel(l23);
        mv.visitLineNumber(255, l23);
        mv.visitIntInsn(17, 5888);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/matrixMode"), "(I)V", false);
        final Label l24 = new Label();
        mv.visitLabel(l24);
        mv.visitLineNumber(256, l24);
        mv.visitIntInsn(17, 770);
        mv.visitIntInsn(17, 771);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/blendFunc"), "(II)V", false);
        final Label l25 = new Label();
        mv.visitLabel(l25);
        mv.visitLineNumber(257, l25);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableLighting"), "()V", false);
        final Label l26 = new Label();
        mv.visitLabel(l26);
        mv.visitLineNumber(258, l26);
        mv.visitIntInsn(17, 515);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthFunc"), "(I)V", false);
        final Label l27 = new Label();
        mv.visitLabel(l27);
        mv.visitLineNumber(259, l27);
        mv.visitInsn(4);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthMask"), "(Z)V", false);
        final Label l28 = new Label();
        mv.visitLabel(l28);
        mv.visitLineNumber(260, l28);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/textureManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager") + ";");
        mv.visitFieldInsn(178, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureMap"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureMap/locationBlocksTexture"), "L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager/bindTexture"), "(L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";)V", false);
        final Label l29 = new Label();
        mv.visitLabel(l29);
        mv.visitLineNumber(261, l29);
        mv.visitInsn(177);
        final Label l30 = new Label();
        mv.visitLabel(l30);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem") + ";", (String)null, l0, l30, 0);
        mv.visitLocalVariable("model", "L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";", (String)null, l0, l30, 1);
        mv.visitLocalVariable("var6", "I", (String)null, l14, l22, 2);
        mv.visitLocalVariable("var3", "F", (String)null, l17, l21, 3);
        mv.visitMaxs(5, 4);
        mv.visitEnd();
        super.visitEnd();
    }
    
    public class RenderItem extends GeneratorAdapter
    {
        public RenderItem(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderEffect")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V")) {
                super.visitMethodInsn(opcode, owner, "renderEffectOld", desc);
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}
