package com.spiderfrog.gadgets.utils;

import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import java.awt.image.*;
import org.lwjgl.*;
import java.nio.*;

public class RenderUtils
{
    static Minecraft mc;
    protected static float zLevel;
    
    public RenderUtils(final Minecraft mc) {
        RenderUtils.mc = mc;
    }
    
    public void drawCoolLines(final AxisAlignedBB mask) {
        GL11.glPushMatrix();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.minX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.maxZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.minZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public void drawBorderedRect(final float x, final float y, final float x2, final float y2, final float l1, final int col1, final int col2) {
        this.drawRect(x, y, x2, y2, col2);
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glLineWidth(l1);
        GL11.glBegin(1);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)x, (double)y2);
        GL11.glVertex2d((double)x2, (double)y2);
        GL11.glVertex2d((double)x2, (double)y);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)x2, (double)y);
        GL11.glVertex2d((double)x, (double)y2);
        GL11.glVertex2d((double)x2, (double)y2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public void glColor(final Color color) {
        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
    }
    
    public void glColor(final int hex) {
        final float alpha = (hex >> 24 & 0xFF) / 255.0f;
        final float red = (hex >> 16 & 0xFF) / 255.0f;
        final float green = (hex >> 8 & 0xFF) / 255.0f;
        final float blue = (hex & 0xFF) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha);
    }
    
    public void drawLine(final float x, final float y, final float x1, final float y1, final float width) {
        GL11.glDisable(3553);
        GL11.glLineWidth(width);
        GL11.glBegin(1);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x1, y1);
        GL11.glEnd();
        GL11.glEnable(3553);
    }
    
    public void drawGradientRect(final float x, final float y, final float x1, final float y1, final int topColor, final int bottomColor) {
        GL11.glEnable(1536);
        GL11.glShadeModel(7424);
        GL11.glBegin(7);
        this.glColor(topColor);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        this.glColor(bottomColor);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
        GL11.glShadeModel(7424);
        GL11.glDisable(1536);
    }
    
    public void drawLines(final AxisAlignedBB mask) {
        GL11.glPushMatrix();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.minX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.maxZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.maxZ);
        GL11.glVertex3d(mask.minX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.minZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.minY, mask.minZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.maxY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.maxY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.minX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glBegin(2);
        GL11.glVertex3d(mask.maxX, mask.minY, mask.minZ);
        GL11.glVertex3d(mask.minX, mask.minY, mask.maxZ);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public void drawRect(final float g, final float h, final float i, final float j, final int col1) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glBegin(7);
        GL11.glVertex2d((double)i, (double)h);
        GL11.glVertex2d((double)g, (double)h);
        GL11.glVertex2d((double)g, (double)j);
        GL11.glVertex2d((double)i, (double)j);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public void drawRectSkew(final float left, final float top, final float right, final float bottom, final int col1) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glBegin(7);
        GL11.glVertex2d((double)(right - 10.0f), (double)top);
        GL11.glVertex2d((double)(left + 10.0f), (double)top);
        GL11.glVertex2d((double)left, (double)bottom);
        GL11.glVertex2d((double)right, (double)bottom);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public void drawRectDragon1(final float left, final float top, final float right, final float bottom, final int col1) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glBegin(7);
        GL11.glVertex2d((double)(right - 7.0f), (double)top);
        GL11.glVertex2d((double)(left + 7.0f), (double)top);
        GL11.glVertex2d((double)left, (double)bottom);
        GL11.glVertex2d((double)right, (double)bottom);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public void drawRectDragon2(final float left, final float top, final float right, final float bottom, final int col1) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glBegin(7);
        GL11.glVertex2d((double)right, (double)top);
        GL11.glVertex2d((double)left, (double)top);
        GL11.glVertex2d((double)(left + 7.0f), (double)bottom);
        GL11.glVertex2d((double)(right - 7.0f), (double)bottom);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public int applyTexture(final int texId, final BufferedImage image, final boolean linear, final boolean repeat) {
        final int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        final ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                final int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte)(pixel >> 16 & 0xFF));
                buffer.put((byte)(pixel >> 8 & 0xFF));
                buffer.put((byte)(pixel & 0xFF));
                buffer.put((byte)(pixel >> 24 & 0xFF));
            }
        }
        buffer.flip();
        this.applyTexture(texId, image.getWidth(), image.getHeight(), buffer, linear, repeat);
        return texId;
    }
    
    public int applyTexture(final int texId, final int width, final int height, final ByteBuffer pixels, final boolean linear, final boolean repeat) {
        GL11.glBindTexture(3553, texId);
        GL11.glTexParameteri(3553, 10241, linear ? 9729 : 9728);
        GL11.glTexParameteri(3553, 10240, linear ? 9729 : 9728);
        GL11.glTexParameteri(3553, 10242, repeat ? 10497 : 10496);
        GL11.glTexParameteri(3553, 10243, repeat ? 10497 : 10496);
        GL11.glPixelStorei(3317, 1);
        GL11.glTexImage2D(3553, 0, 32856, width, height, 0, 6408, 5121, pixels);
        return texId;
    }
}
