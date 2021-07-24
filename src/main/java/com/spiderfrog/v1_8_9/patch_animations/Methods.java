package com.spiderfrog.v1_8_9.patch_animations;

import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Methods
{
    static Methods instance;
    
    public static Methods getInstance() {
        if (Methods.instance == null) {
            return Methods.instance = new Methods();
        }
        return Methods.instance;
    }
    
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor) {
        final float f = (startColor >> 24 & 0xFF) / 255.0f;
        final float f2 = (startColor >> 16 & 0xFF) / 255.0f;
        final float f3 = (startColor >> 8 & 0xFF) / 255.0f;
        final float f4 = (startColor & 0xFF) / 255.0f;
        final float f5 = (endColor >> 24 & 0xFF) / 255.0f;
        final float f6 = (endColor >> 16 & 0xFF) / 255.0f;
        final float f7 = (endColor >> 8 & 0xFF) / 255.0f;
        final float f8 = (endColor & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos((double)right, (double)top, 0.0).color(f2, f3, f4, f).endVertex();
        worldrenderer.pos((double)left, (double)top, 0.0).color(f2, f3, f4, f).endVertex();
        worldrenderer.pos((double)left, (double)bottom, 0.0).color(f6, f7, f8, f5).endVertex();
        worldrenderer.pos((double)right, (double)bottom, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height, final float zLevel) {
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(x + 0), (double)(y + height), (double)zLevel).tex((double)((textureX + 0) * f), (double)((textureY + height) * f2)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), (double)zLevel).tex((double)((textureX + width) * f), (double)((textureY + height) * f2)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + 0), (double)zLevel).tex((double)((textureX + width) * f), (double)((textureY + 0) * f2)).endVertex();
        worldrenderer.pos((double)(x + 0), (double)(y + 0), (double)zLevel).tex((double)((textureX + 0) * f), (double)((textureY + 0) * f2)).endVertex();
        tessellator.draw();
    }
    
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height) {
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(x + 0), (double)(y + height), 0.0).tex((double)((textureX + 0) * f), (double)((textureY + height) * f2)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), 0.0).tex((double)((textureX + width) * f), (double)((textureY + height) * f2)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + 0), 0.0).tex((double)((textureX + width) * f), (double)((textureY + 0) * f2)).endVertex();
        worldrenderer.pos((double)(x + 0), (double)(y + 0), 0.0).tex((double)((textureX + 0) * f), (double)((textureY + 0) * f2)).endVertex();
        tessellator.draw();
    }
}
