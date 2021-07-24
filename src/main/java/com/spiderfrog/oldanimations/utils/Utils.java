package com.spiderfrog.oldanimations.utils;

public class Utils
{
    public static String getMinecraftVersion() {
        return "1.8.9";
    }
    
    public static String getFullMinecraftVersion() {
        return (isForgeActive() ? "Forge" : "") + getMinecraftVersion();
    }
    
    public static boolean isForgeActive() {
        try {
            final Class clazz = Class.forName("net.minecraftforge.fml.client.FMLClientHandler");
            return true;
        }
        catch (Exception err) {
            return false;
        }
    }
    
    public static boolean isOptifineActive() {
        try {
            final Class optifineConfig = Class.forName("Config");
            final String optifineVersion = (String)optifineConfig.getField("VERSION").get(null);
            if (optifineVersion.startsWith("Optifine_")) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
