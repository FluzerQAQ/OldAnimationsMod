package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import com.spiderfrog.oldanimations.animations.*;

public class PatchEntityPlayer extends ClassVisitor implements Opcodes
{
    public PatchEntityPlayer(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/getEyeHeight")) && desc.equals("()F")) {
            return (MethodVisitor)new GetEyeHeight(mv, access, name, desc);
        }
        return mv;
    }
    
    public void visitEnd() {
        final FieldVisitor fv = this.cv.visitField(0, "sneak", "J", (String)null, (Object)null);
        fv.visitEnd();
        final FieldVisitor fv2 = this.cv.visitField(0, "sneaking", "Z", (String)null, (Object)null);
        fv2.visitEnd();
        this.appendgetOldEyeHeight();
        super.visitEnd();
    }
    
    private void appendgetOldEyeHeight() {
        final MethodVisitor mv = this.cv.visitMethod(1, "getOldEyeHeight", "()F", (String)null, (String[])null);
        mv.visitCode();
        final Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(1582, l0);
        mv.visitLdcInsn((Object)new Float("1.62"));
        mv.visitVarInsn(56, 1);
        final Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(1583, l2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneaking", "Z");
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        final Label l3 = new Label();
        mv.visitJumpInsn(160, l3);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitInsn(9);
        mv.visitInsn(148);
        final Label l4 = new Label();
        mv.visitJumpInsn(157, l4);
        mv.visitLabel(l3);
        mv.visitLineNumber(1584, l3);
        mv.visitFrame(1, 1, new Object[] { Opcodes.FLOAT }, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLabel(l4);
        mv.visitLineNumber(1586, l4);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneaking", "Z");
        final Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLineNumber(1587, l5);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/getMinecraft"), "()L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";", false);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/gameSettings"), "L" + VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings"), VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings/thirdPersonView"), "I");
        final Label l6 = new Label();
        mv.visitJumpInsn(154, l6);
        final Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(1588, l7);
        mv.visitLdcInsn((Object)new Float("1.62"));
        mv.visitVarInsn(56, 1);
        final Label l8 = new Label();
        mv.visitLabel(l8);
        mv.visitLineNumber(1589, l8);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        final Label l9 = new Label();
        mv.visitJumpInsn(153, l9);
        final Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(1590, l10);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLdcInsn((Object)new Long(8L));
        mv.visitInsn(97);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitInsn(101);
        mv.visitInsn(136);
        mv.visitVarInsn(54, 2);
        final Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLineNumber(1591, l11);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(16, -50);
        final Label l12 = new Label();
        mv.visitJumpInsn(164, l12);
        final Label l13 = new Label();
        mv.visitLabel(l13);
        mv.visitLineNumber(1592, l13);
        mv.visitVarInsn(23, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(135);
        mv.visitLdcInsn((Object)new Double("0.0017"));
        mv.visitInsn(107);
        mv.visitInsn(144);
        mv.visitInsn(98);
        mv.visitVarInsn(56, 1);
        final Label l14 = new Label();
        mv.visitLabel(l14);
        mv.visitLineNumber(1593, l14);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(150);
        final Label l15 = new Label();
        mv.visitJumpInsn(155, l15);
        mv.visitVarInsn(23, 1);
        mv.visitLdcInsn((Object)new Float("10.0"));
        mv.visitInsn(149);
        final Label l16 = new Label();
        mv.visitJumpInsn(158, l16);
        mv.visitLabel(l15);
        mv.visitLineNumber(1594, l15);
        mv.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, (Object[])null);
        mv.visitLdcInsn((Object)new Float("1.54"));
        mv.visitVarInsn(56, 1);
        final Label l17 = new Label();
        mv.visitLabel(l17);
        mv.visitLineNumber(1596, l17);
        mv.visitJumpInsn(167, l16);
        mv.visitLabel(l12);
        mv.visitLineNumber(1598, l12);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(141);
        mv.visitLdcInsn((Object)new Double("0.08"));
        mv.visitInsn(103);
        mv.visitInsn(144);
        mv.visitVarInsn(56, 1);
        final Label l18 = new Label();
        mv.visitLabel(l18);
        mv.visitLineNumber(1600, l18);
        mv.visitJumpInsn(167, l16);
        mv.visitLabel(l9);
        mv.visitLineNumber(1603, l9);
        mv.visitFrame(2, 1, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLdcInsn((Object)new Long(8L));
        mv.visitInsn(97);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitInsn(101);
        mv.visitInsn(136);
        mv.visitVarInsn(54, 2);
        final Label l19 = new Label();
        mv.visitLabel(l19);
        mv.visitLineNumber(1604, l19);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(16, -50);
        final Label l20 = new Label();
        mv.visitJumpInsn(164, l20);
        final Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(1605, l21);
        mv.visitVarInsn(23, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(135);
        mv.visitLdcInsn((Object)new Double("0.0017"));
        mv.visitInsn(107);
        mv.visitInsn(144);
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        final Label l22 = new Label();
        mv.visitLabel(l22);
        mv.visitLineNumber(1606, l22);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(141);
        mv.visitLdcInsn((Object)new Double("0.08"));
        mv.visitInsn(103);
        mv.visitInsn(144);
        mv.visitVarInsn(56, 1);
        final Label l23 = new Label();
        mv.visitLabel(l23);
        mv.visitLineNumber(1607, l23);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(150);
        mv.visitJumpInsn(156, l16);
        final Label l24 = new Label();
        mv.visitLabel(l24);
        mv.visitLineNumber(1608, l24);
        mv.visitLdcInsn((Object)new Float("1.62"));
        mv.visitVarInsn(56, 1);
        final Label l25 = new Label();
        mv.visitLabel(l25);
        mv.visitLineNumber(1611, l25);
        mv.visitJumpInsn(167, l16);
        mv.visitLabel(l20);
        mv.visitLineNumber(1613, l20);
        mv.visitFrame(1, 1, new Object[] { Opcodes.INTEGER }, 0, (Object[])null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        final Label l26 = new Label();
        mv.visitLabel(l26);
        mv.visitLineNumber(1616, l26);
        mv.visitJumpInsn(167, l16);
        mv.visitLabel(l6);
        mv.visitFrame(2, 1, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        mv.visitJumpInsn(153, l16);
        final Label l27 = new Label();
        mv.visitLabel(l27);
        mv.visitLineNumber(1618, l27);
        mv.visitVarInsn(23, 1);
        mv.visitLdcInsn((Object)new Float("0.08"));
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        mv.visitLabel(l16);
        mv.visitLineNumber(1620, l16);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/isPlayerSleeping"), "()Z", false);
        final Label l28 = new Label();
        mv.visitJumpInsn(153, l28);
        final Label l29 = new Label();
        mv.visitLabel(l29);
        mv.visitLineNumber(1621, l29);
        mv.visitLdcInsn((Object)new Float("0.2"));
        mv.visitVarInsn(56, 1);
        mv.visitLabel(l28);
        mv.visitLineNumber(1623, l28);
        mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(174);
        final Label l30 = new Label();
        mv.visitLabel(l30);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer") + ";", (String)null, l0, l30, 0);
        mv.visitLocalVariable("f", "F", (String)null, l2, l30, 1);
        mv.visitLocalVariable("a", "I", (String)null, l11, l18, 2);
        mv.visitLocalVariable("a", "I", (String)null, l19, l26, 2);
        mv.visitMaxs(5, 3);
        mv.visitEnd();
    }
    
    public class GetEyeHeight extends GeneratorAdapter
    {
        int timer;
        boolean patched;
        
        public GetEyeHeight(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, desc, desc);
        }
        
        public void visitVarInsn(final int opcode, final int var) {
            super.visitVarInsn(opcode, var);
            if (opcode == 56 && var == 1) {
                ++this.timer;
                if (!this.patched && this.timer == 1) {
                    this.patched = true;
                    final Label l1 = new Label();
                    this.mv.visitLabel(l1);
                    this.mv.visitLineNumber(1623, l1);
                    this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDSNEAK", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                    this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                    final Label l2 = new Label();
                    this.mv.visitJumpInsn(153, l2);
                    final Label l3 = new Label();
                    this.mv.visitLabel(l3);
                    this.mv.visitLineNumber(1624, l3);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "getOldEyeHeight", "()F", false);
                    this.mv.visitInsn(174);
                    this.mv.visitLabel(l2);
                    this.mv.visitLineNumber(1627, l2);
                    this.mv.visitFrame(1, 1, new Object[] { Opcodes.FLOAT }, 0, (Object[])null);
                }
            }
        }
    }
}
