package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.*;
import com.spiderfrog.oldanimations.animations.*;
import com.spiderfrog.v1_8_9.*;

public class PatchGuiPlayerTabOverlay extends ClassVisitor
{
    public PatchGuiPlayerTabOverlay(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiPlayerTabOverlay/renderPlayerlist")) && desc.equals("(IL" + VersionTranslation.getDeobf("net/minecraft/scoreboard/Scoreboard") + ";L" + VersionTranslation.getDeobf("net/minecraft/scoreboard/ScoreObjective") + ";)V")) {
            return new Func_175249_a(mv);
        }
        return mv;
    }
    
    public class Func_175249_a extends MethodVisitor
    {
        private final MethodVisitor target;
        boolean patchedOldtablist;
        
        public Func_175249_a(final MethodVisitor mv) {
            super(262144, mv);
            this.target = mv;
        }
        
        public void visitInsn(final int opcode) {
            if (!this.patchedOldtablist) {
                this.patchedOldtablist = true;
                final Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(59, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDPLAYERLIST", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                final Label l2 = new Label();
                this.mv.visitJumpInsn(153, l2);
                final Label l3 = new Label();
                this.mv.visitLabel(l3);
                this.mv.visitLineNumber(60, l3);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(21, 1);
                this.mv.visitVarInsn(25, 2);
                this.mv.visitVarInsn(25, 3);
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "renderPlayerlistOld", "(IL" + VersionTranslation.getDeobf("net/minecraft/scoreboard/Scoreboard") + ";L" + VersionTranslation.getDeobf("net/minecraft/scoreboard/ScoreObjective") + ";)V", false);
                final Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(61, l4);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(64, l2);
                this.mv.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
            }
            super.visitInsn(opcode);
        }
        
        public void visitCode() {
            super.visitCode();
        }
    }
}
