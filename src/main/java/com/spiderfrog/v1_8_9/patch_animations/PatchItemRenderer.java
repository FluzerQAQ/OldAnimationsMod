package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import com.spiderfrog.v1_8_9.*;

public class PatchItemRenderer extends ClassVisitor implements Opcodes
{
    boolean patchItemScales;
    
    public PatchItemRenderer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public void visitEnd() {
        this.appendUpdateEquippedItemOld();
        this.appendOldBlockhit();
        this.appendEatMethod();
        this.appendClearMethod();
        this.appendPerformBlockhit();
        super.visitEnd();
    }
    
    private void appendPerformBlockhit() {
        final MethodVisitor mv = this.cv.visitMethod(2, "performBlockhit", "()V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKHIT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(153, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(308, l3);
        mv.visitLdcInsn((Object)new Float("0.83"));
        mv.visitLdcInsn((Object)new Float("0.88"));
        mv.visitLdcInsn((Object)new Float("0.85"));
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(309, l4);
        mv.visitLdcInsn((Object)new Float("-0.3"));
        mv.visitLdcInsn((Object)new Float("0.1"));
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        mv.visitLabel(l2);
        mv.visitLineNumber(311, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", (String)null, l0, l5, 0);
        mv.visitMaxs(3, 1);
        mv.visitEnd();
    }
    
    private void appendClearMethod() {
        final MethodVisitor mv = this.cv.visitMethod(2, "transformFirstPersonItemClear", "(FF)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitInsn(177);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", (String)null, l0, l2, 0);
        mv.visitLocalVariable("equipProgress", "F", (String)null, l0, l2, 1);
        mv.visitLocalVariable("swingProgress", "F", (String)null, l0, l2, 2);
        mv.visitMaxs(0, 3);
        mv.visitEnd();
    }
    
    private void appendEatMethod() {
        final MethodVisitor mv = this.cv.visitMethod(2, "transformFirstPersonItemEat", "(FF)V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDEAT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(153, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(308, l3);
        mv.visitLdcInsn((Object)new Float("0.8"));
        mv.visitInsn(12);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(309, l4);
        mv.visitLdcInsn((Object)new Float("-0.2"));
        mv.visitLdcInsn((Object)new Float("-0.1"));
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        mv.visitLabel(l2);
        mv.visitLineNumber(311, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", (String)null, l0, l5, 0);
        mv.visitLocalVariable("equipProgress", "F", (String)null, l0, l5, 1);
        mv.visitLocalVariable("swingProgress", "F", (String)null, l0, l5, 2);
        mv.visitMaxs(3, 3);
        mv.visitEnd();
    }
    
    private void appendOldBlockhit() {
        final MethodVisitor mv = this.cv.visitMethod(2, "oldBlockhit", "(F)F", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKHIT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        final Label l2 = new Label();
        mv.visitJumpInsn(153, l2);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(308, l3);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/thePlayer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";");
        mv.visitVarInsn(23, 1);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase/getSwingProgress"), "(F)F", false);
        mv.visitInsn(174);
        mv.visitLabel(l2);
        mv.visitLineNumber(310, l2);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(11);
        mv.visitInsn(174);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", (String)null, l0, l4, 0);
        mv.visitLocalVariable("partialTicks", "F", (String)null, l0, l4, 1);
        mv.visitMaxs(2, 2);
        mv.visitEnd();
    }
    
    private void appendUpdateEquippedItemOld() {
        final MethodVisitor mv = this.cv.visitMethod(1, "updateEquippedItemOld", "()V", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(519, l0);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/prevEquippedProgress"), "F");
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(520, l2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/thePlayer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";");
        mv.visitVarInsn(58, 1);
        final Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(521, l3);
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/getCurrentItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";", false);
        mv.visitVarInsn(58, 2);
        final Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(522, l4);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedItemSlot"), "I");
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/currentItem"), "I");
        final Label l5 = new Label();
        mv.visitJumpInsn(160, l5);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(166, l5);
        mv.visitInsn(4);
        final Label l6 = new Label();
        mv.visitJumpInsn(167, l6);
        mv.visitLabel(l5);
        mv.visitFrame(1, 2, new Object[] { VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack") }, 0, (Object[])null);
        mv.visitInsn(3);
        mv.visitLabel(l6);
        mv.visitFrame(4, 0, (Object[])null, 1, new Object[] { Opcodes.INTEGER });
        mv.visitVarInsn(54, 3);
        final Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(523, l7);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        final Label l8 = new Label();
        mv.visitJumpInsn(199, l8);
        mv.visitVarInsn(25, 2);
        mv.visitJumpInsn(199, l8);
        final Label l9 = new Label();
        mv.visitLabel(l9);
        mv.visitLineNumber(524, l9);
        mv.visitInsn(4);
        mv.visitVarInsn(54, 3);
        mv.visitLabel(l8);
        mv.visitLineNumber(526, l8);
        mv.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, (Object[])null);
        mv.visitVarInsn(25, 2);
        final Label l10 = new Label();
        mv.visitJumpInsn(198, l10);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(198, l10);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(165, l10);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/Item") + ";", false);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/Item") + ";", false);
        mv.visitJumpInsn(166, l10);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItemDamage"), "()I", false);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItemDamage"), "()I", false);
        mv.visitJumpInsn(160, l10);
        final Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLineNumber(528, l11);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 2);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        final Label l12 = new Label();
        mv.visitLabel(l12);
        mv.visitLineNumber(529, l12);
        mv.visitInsn(4);
        mv.visitVarInsn(54, 3);
        mv.visitLabel(l10);
        mv.visitLineNumber(531, l10);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitLdcInsn((Object)new Float("0.4"));
        mv.visitVarInsn(56, 4);
        final Label l13 = new Label();
        mv.visitLabel(l13);
        mv.visitLineNumber(532, l13);
        mv.visitVarInsn(21, 3);
        final Label l14 = new Label();
        mv.visitJumpInsn(153, l14);
        mv.visitInsn(12);
        final Label l15 = new Label();
        mv.visitJumpInsn(167, l15);
        mv.visitLabel(l14);
        mv.visitFrame(1, 1, new Object[] { Opcodes.FLOAT }, 0, (Object[])null);
        mv.visitInsn(11);
        mv.visitLabel(l15);
        mv.visitFrame(4, 0, (Object[])null, 1, new Object[] { Opcodes.FLOAT });
        mv.visitVarInsn(56, 5);
        final Label l16 = new Label();
        mv.visitLabel(l16);
        mv.visitLineNumber(533, l16);
        mv.visitVarInsn(23, 5);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitInsn(102);
        mv.visitVarInsn(56, 6);
        final Label l17 = new Label();
        mv.visitLabel(l17);
        mv.visitLineNumber(534, l17);
        mv.visitVarInsn(23, 6);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(118);
        mv.visitInsn(150);
        final Label l18 = new Label();
        mv.visitJumpInsn(156, l18);
        final Label l19 = new Label();
        mv.visitLabel(l19);
        mv.visitLineNumber(535, l19);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(118);
        mv.visitVarInsn(56, 6);
        mv.visitLabel(l18);
        mv.visitLineNumber(537, l18);
        mv.visitFrame(1, 2, new Object[] { Opcodes.FLOAT, Opcodes.FLOAT }, 0, (Object[])null);
        mv.visitVarInsn(23, 6);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(149);
        final Label l20 = new Label();
        mv.visitJumpInsn(158, l20);
        final Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(538, l21);
        mv.visitVarInsn(23, 4);
        mv.visitVarInsn(56, 6);
        mv.visitLabel(l20);
        mv.visitLineNumber(540, l20);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitInsn(89);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitVarInsn(23, 6);
        mv.visitInsn(98);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        final Label l22 = new Label();
        mv.visitLabel(l22);
        mv.visitLineNumber(541, l22);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitLdcInsn((Object)new Float("0.1"));
        mv.visitInsn(150);
        final Label l23 = new Label();
        mv.visitJumpInsn(156, l23);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 2);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        final Label l24 = new Label();
        mv.visitLabel(l24);
        mv.visitLineNumber(548, l24);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/currentItem"), "I");
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedItemSlot"), "I");
        mv.visitLabel(l23);
        mv.visitLineNumber(550, l23);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitInsn(177);
        final Label l25 = new Label();
        mv.visitLabel(l25);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", (String)null, l0, l25, 0);
        mv.visitLocalVariable("var1", "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";", (String)null, l3, l25, 1);
        mv.visitLocalVariable("var2", "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";", (String)null, l4, l25, 2);
        mv.visitLocalVariable("var3", "Z", (String)null, l7, l25, 3);
        mv.visitLocalVariable("var4", "F", (String)null, l13, l25, 4);
        mv.visitLocalVariable("var5", "F", (String)null, l16, l25, 5);
        mv.visitLocalVariable("var6", "F", (String)null, l17, l25, 6);
        mv.visitMaxs(3, 7);
        mv.visitEnd();
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem")) && desc.equals("(FF)V")) {
            return (MethodVisitor)new TransformFirstPersonItem(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/updateEquippedItem")) && desc.equals("()V")) {
            return (MethodVisitor)new UpdateEquippedItem(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/renderItemInFirstPerson")) && desc.equals("(F)V")) {
            return (MethodVisitor)new RenderItemInFirstPerson(mv, access, name, desc);
        }
        return mv;
    }
    
    public class UpdateEquippedItem extends GeneratorAdapter implements Opcodes
    {
        boolean patched;
        
        public UpdateEquippedItem(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitVarInsn(final int opcode, final int var) {
            super.visitVarInsn(opcode, var);
            if (!this.patched) {
                this.patched = true;
                final Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(501, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDITEMUPDATE", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l2 = new Label();
                this.mv.visitJumpInsn(153, l2);
                final Label l3 = new Label();
                this.mv.visitLabel(l3);
                this.mv.visitLineNumber(502, l3);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "updateEquippedItemOld", "()V", false);
                final Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(503, l4);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(506, l2);
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
            }
        }
    }
    
    public class TransformFirstPersonItem extends GeneratorAdapter implements Opcodes
    {
        boolean patched;
        
        TransformFirstPersonItem(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (!this.patched && opcode == 184 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate")) && desc.equals("(FFF)V")) {
                this.patched = true;
                final Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(239, l0);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
                this.mv.visitVarInsn(23, 2);
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "performOldAnimations", "(L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";F)V", false);
            }
            super.visitMethodInsn(opcode, owner, name, desc);
        }
    }
    
    public class RenderItemInFirstPerson extends GeneratorAdapter implements Opcodes
    {
        boolean patchedresource;
        int transFirstPerItem;
        
        public RenderItemInFirstPerson(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
            this.transFirstPerItem = 0;
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem")) && desc.equals("(FF)V")) {
                ++this.transFirstPerItem;
                if (this.transFirstPerItem == 1 || this.transFirstPerItem == 5) {
                    super.visitMethodInsn(opcode, owner, name, desc);
                }
                else if (this.transFirstPerItem == 2) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemEat", desc);
                }
                else if (this.transFirstPerItem == 3) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemClear", desc);
                    final Label l25 = new Label();
                    this.mv.visitLabel(l25);
                    this.mv.visitLineNumber(333, l25);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 2);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 1);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
                }
                else if (this.transFirstPerItem == 4) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemClear", desc);
                    final Label l25 = new Label();
                    this.mv.visitLabel(l25);
                    this.mv.visitLineNumber(333, l25);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 2);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 1);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
                }
            }
            else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/func_178104_a")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/entity/AbstractClientPlayer") + ";F)V")) {
                final Label l25 = new Label();
                this.mv.visitLabel(l25);
                this.mv.visitLineNumber(333, l25);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(23, 2);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(23, 1);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
            }
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/func_178103_d")) && desc.equals("()V")) {
                final Label l26 = new Label();
                this.mv.visitLabel(l26);
                this.mv.visitLineNumber(362, l26);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "performBlockhit", "()V", false);
            }
        }
    }
}
