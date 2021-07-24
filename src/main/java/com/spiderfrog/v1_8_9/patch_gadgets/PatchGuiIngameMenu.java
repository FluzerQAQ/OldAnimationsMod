package com.spiderfrog.v1_8_9.patch_gadgets;

import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;
import com.spiderfrog.v1_8_9.*;

public class PatchGuiIngameMenu extends ClassVisitor implements Opcodes
{
    public PatchGuiIngameMenu(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu/initGui")) && desc.equals("()V")) {
            return (MethodVisitor)new InitGui(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu/actionPerformed")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton") + ";)V")) {
            return (MethodVisitor)new ActionPerformed(mv, access, name, desc);
        }
        return mv;
    }
    
    public class InitGui extends GeneratorAdapter
    {
        public InitGui(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);
            if (opcode == 181 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton/enabled")) && desc.equals("Z")) {
                final Label l16 = new Label();
                this.mv.visitLabel(l16);
                this.mv.visitLineNumber(41, l16);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu"), VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/buttonList"), "Ljava/util/List;");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "addOAMButton", "(Ljava/util/List;)V", false);
            }
        }
    }
    
    public class ActionPerformed extends GeneratorAdapter
    {
        public ActionPerformed(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitCode() {
            super.visitCode();
            final Label l0 = new Label();
            this.mv.visitLabel(l0);
            this.mv.visitLineNumber(44, l0);
            this.mv.visitVarInsn(25, 1);
            this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "performOAMButton", "(L" + VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton") + ";)V", false);
        }
    }
}
