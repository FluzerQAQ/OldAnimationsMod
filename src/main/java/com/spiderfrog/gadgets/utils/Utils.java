package com.spiderfrog.gadgets.utils;

import java.io.*;
import java.util.*;
import java.net.*;
import com.spiderfrog.gadgets.*;

public class Utils
{
    public static String getText(final String url) throws Exception {
        final URL website = new URL(url);
        final URLConnection connection = website.openConnection();
        final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    
    public static List<String> getWebsite(final String url) throws Exception {
        final List<String> lines = new ArrayList<String>();
        final URL website = new URL(url);
        final URLConnection connection = website.openConnection();
        final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            lines.add(inputLine);
        }
        in.close();
        return lines;
    }
    
    public static void openWebsite(final String url) {
        try {
            final Class var3 = Class.forName("java.awt.Desktop");
            final Object var4 = var3.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
            var3.getMethod("browse", URI.class).invoke(var4, new URI(url));
        }
        catch (Throwable var5) {
            Gadgets.getInstance().sendError("Couldn't open link");
        }
    }
    
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
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
