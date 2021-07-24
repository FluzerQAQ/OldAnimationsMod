package com.spiderfrog.gadgets.utils;

import java.util.*;
import java.awt.*;

public class LSD
{
    public static float colorTicks;
    public static float colorTicks2;
    public static float colorTicks3;
    public static int lsdColor;
    public static boolean changing1;
    public static boolean changing2;
    public static boolean changing3;
    public static boolean down1;
    public static boolean down2;
    public static boolean down3;
    private static TimeHelper h;
    
    public static void runTick() {
        if (!LSD.h.isDelayComplete(5L)) {
            return;
        }
        LSD.h.setLastMS();
        if (LSD.changing1) {
            LSD.colorTicks += (float)0.03;
            if (LSD.colorTicks >= 1.0f) {
                LSD.changing1 = false;
                LSD.changing2 = true;
            }
        }
        if (LSD.down1) {
            LSD.colorTicks -= (float)0.03;
            if (LSD.colorTicks <= 0.2f) {
                LSD.down1 = false;
                LSD.down2 = true;
            }
        }
        if (LSD.changing2) {
            LSD.colorTicks2 += (float)0.03;
            if (LSD.colorTicks2 >= 1.0f) {
                LSD.changing2 = false;
                LSD.changing3 = true;
            }
        }
        if (LSD.down2) {
            LSD.colorTicks2 -= (float)0.03;
            if (LSD.colorTicks2 <= 0.2f) {
                LSD.down2 = false;
                LSD.down3 = true;
            }
        }
        if (LSD.changing3) {
            LSD.colorTicks3 += (float)0.07;
            if (LSD.colorTicks3 >= 1.0f) {
                LSD.changing3 = false;
                LSD.down1 = true;
            }
        }
        if (LSD.down3) {
            LSD.colorTicks3 -= (float)0.07;
            if (LSD.colorTicks3 <= 0.2f) {
                LSD.changing1 = true;
                LSD.down3 = false;
            }
        }
        final int var7 = new Random().nextInt(254);
        int var8 = (int)(var7 * 255.0f / 20.0f);
        if (var8 > 255) {
            var8 = 255;
        }
        final int var9 = Color.HSBtoRGB(var7 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
        LSD.lsdColor = var9 + (var8 << 24 & 0xFF000000);
    }
    
    public static Color rainbow(final long offset, final float fade) {
        final float hue = (System.nanoTime() + offset) / 1.0E10f % 1.0f;
        final long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0f, 1.0f)), 16);
        final Color c = new Color((int)color);
        return new Color(c.getRed() / 255.0f * fade, c.getGreen() / 255.0f * fade, c.getBlue() / 255.0f * fade, c.getAlpha() / 255.0f);
    }
    
    static {
        LSD.colorTicks = 0.0f;
        LSD.colorTicks2 = 0.0f;
        LSD.colorTicks3 = 0.0f;
        LSD.lsdColor = 0;
        LSD.changing1 = true;
        LSD.changing2 = false;
        LSD.changing3 = false;
        LSD.down1 = false;
        LSD.down2 = false;
        LSD.down3 = false;
        LSD.h = new TimeHelper();
    }
}
