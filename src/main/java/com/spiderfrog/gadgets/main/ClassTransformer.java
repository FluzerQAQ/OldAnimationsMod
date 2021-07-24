package com.spiderfrog.gadgets.main;

import net.minecraft.launchwrapper.*;
import org.objectweb.asm.*;
import com.spiderfrog.v1_8_9.patch_gadgets.*;
import com.spiderfrog.v1_8_9.patch_animations.*;
import org.apache.logging.log4j.*;

public class ClassTransformer implements IClassTransformer
{
    public static Logger logger;
    
    public byte[] transform(final String name, final String transformedName, final byte[] bytes) {
        if (transformedName.equals("net.minecraft.client.Minecraft") && !name.equals("net.minecraft.client.Minecraft")) {
            OAMTweaker.RUNTIME_DEOBF = true;
        }
        if (transformedName.equals("net.minecraft.client.Minecraft")) {
            ClassTransformer.logger.info("Found Minecraft Class to inject");
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchMinecraft(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        /*if (transformedName.equals("net.minecraft.client.renderer.entity.RenderPlayer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRenderPlayer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.model.ModelPlayer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchModelPlayer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RendererLivingEntity")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRendererLivingEntity(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.Render")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRender(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.entity.Entity")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchEntity(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }*/
        if (transformedName.equals("net.minecraft.client.gui.GuiIngameMenu")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGuiIngameMenu(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.ItemRenderer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchItemRenderer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.GuiPlayerTabOverlay")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGuiPlayerTabOverlay(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.entity.player.EntityPlayer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchEntityPlayer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderItem")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRenderItem(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.EntityRenderer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchEntityRenderer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.layers.LayerBipedArmor")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchLayerBipedArmor(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.GuiIngame")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGuiIngame(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraftforge.client.GuiIngameForge")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGuiIngameForge(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.FontRenderer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchFontRenderer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.layers.LayerHeldItem")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchLayerHeldItem(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.model.ModelBiped")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchModelBiped(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderManager")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRenderManager(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderEntityItem")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRenderEntityItem(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.GlStateManager")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGlStateManager(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.InventoryEffectRenderer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchInventoryEffectRenderer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.inventory.GuiContainer")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchGuiContainer(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.multiplayer.PlayerControllerMP")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchPlayerControllerMP(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderFish")) {
            final ClassReader classReader = new ClassReader(bytes);
            final ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor)new PatchRenderFish(262144, (ClassVisitor)cw), 8);
            return cw.toByteArray();
        }
        return bytes;
    }
    
    static {
        ClassTransformer.logger = LogManager.getLogger("OAM");
    }
}
