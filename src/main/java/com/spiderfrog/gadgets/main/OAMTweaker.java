package com.spiderfrog.gadgets.main;

import java.util.*;
import java.io.*;
import net.minecraft.launchwrapper.*;
import net.minecraftforge.fml.relauncher.*;

public class OAMTweaker implements ITweaker
{
    public static boolean RUNTIME_DEOBF;
    
    public void acceptOptions(final List<String> args, final File gameDir, final File assetsDir, final String profile) {
    }
    
    public void injectIntoClassLoader(final LaunchClassLoader classLoader) {
        if (FMLInjectionData.data()[4].equals("1.8.9")) {
            classLoader.registerTransformer("com.spiderfrog.gadgets.main.ClassTransformer");
        }
        else {
            ClassTransformer.logger.error("Wrong Minecraft (" + FMLInjectionData.data()[4] + ") Version, could't tweak OAM " + "2.6.5" + " for Minecraft " + "1.8.9");
        }
    }
    
    public String getLaunchTarget() {
        return null;
    }
    
    public String[] getLaunchArguments() {
        return new String[0];
    }
    
    static {
        OAMTweaker.RUNTIME_DEOBF = false;
    }
}
