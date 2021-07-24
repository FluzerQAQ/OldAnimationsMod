package com.spiderfrog.v1_8_9.patch_gadgets;

import com.spiderfrog.v1_8_9.*;
import com.spiderfrog.gadgets.main.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.*;

public class PatchMinecraft extends ClassVisitor implements Opcodes
{
    public PatchMinecraft(final int api, final ClassVisitor cv) {
        super(api, cv);
    }
    
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        final MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/Minecraft/startGame")) && desc.equals("()V")) {
            ClassTransformer.logger.info("Found Minecraft Start Method");
            return (MethodVisitor)new StartGame(mv, access, name, desc);
        }
        return mv;
    }
    
    public class StartGame extends GeneratorAdapter
    {
        protected StartGame(final MethodVisitor mv, final int access, final String name, final String desc) {
            super(262144, mv, access, name, desc);
        }
        
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
            super.visitMethodInsn(opcode, owner, name, desc);
            if (opcode == 182 && owner.equals("net/minecraftforge/fml/client/FMLClientHandler") && name.equals("onInitializationComplete") && desc.equals("()V")) {
                ClassTransformer.logger.info("Tweak Gadgets init Method into Minecraft");
                final Label l111 = new Label();
                this.mv.visitLabel(l111);
                this.mv.visitLineNumber(598, l111);
                this.mv.visitMethodInsn(184, "com/spiderfrog/gadgets/Gadgets", "getInstance", "()Lcom/spiderfrog/gadgets/Gadgets;", false);
                this.mv.visitMethodInsn(182, "com/spiderfrog/gadgets/Gadgets", "initTweak", "()V", false);
            }
        }
    }
}
