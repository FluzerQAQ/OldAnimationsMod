package com.spiderfrog.v1_8_9;

import java.util.*;
import com.spiderfrog.gadgets.main.*;
import java.io.*;

public class VersionTranslation
{
    private static boolean initialized;
    private static HashMap<String, String> classTranslations;
    private static HashMap<String, String> srgMethodTranslations;
    private static HashMap<String, String> srgFieldTranslations;
    private static HashMap<String, String> methodTranslations;
    private static HashMap<String, String> fieldTranslations;
    
    public static String getDeobf(final String name) {
        if (!VersionTranslation.initialized) {
            joined();
        }
        if (VersionTranslation.classTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? VersionTranslation.classTranslations.get(name) : name;
        }
        if (VersionTranslation.srgMethodTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? VersionTranslation.srgMethodTranslations.get(name) : name.substring(name.lastIndexOf(47) + 1);
        }
        if (VersionTranslation.srgFieldTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? VersionTranslation.srgFieldTranslations.get(name) : name.substring(name.lastIndexOf(47) + 1);
        }
        if (VersionTranslation.methodTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? VersionTranslation.methodTranslations.get(name) : name.substring(name.lastIndexOf(47) + 1);
        }
        if (VersionTranslation.fieldTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? VersionTranslation.fieldTranslations.get(name) : name.substring(name.lastIndexOf(47) + 1);
        }
        System.out.println("[OldAnimationsMod] Unknown Translation: " + name);
        return name;
    }
    
    public static String getPath(final Class clazz) {
        final String name = clazz.getName();
        if (name.startsWith("com.spiderfrog")) {
            return name.replace(".", "/");
        }
        return name;
    }
    
    private static void joined() {
        VersionTranslation.initialized = true;
        BufferedReader fileReader = null;
        VersionTranslation.classTranslations = new HashMap<String, String>();
        VersionTranslation.methodTranslations = new HashMap<String, String>();
        VersionTranslation.fieldTranslations = new HashMap<String, String>();
        VersionTranslation.srgFieldTranslations = new HashMap<String, String>();
        VersionTranslation.srgMethodTranslations = new HashMap<String, String>();
        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/methods.csv")));
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                VersionTranslation.methodTranslations.put(line.split(",")[0], line.split(",")[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                }
                catch (IOException ex) {}
            }
        }
        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/fields.csv")));
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                VersionTranslation.fieldTranslations.put(line.split(",")[0], line.split(",")[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                }
                catch (IOException ex2) {}
            }
        }
        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/joined.srg")));
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                if (line.startsWith("CL:")) {
                    VersionTranslation.classTranslations.put(line.split(" ")[2], line.split(" ")[1]);
                }
                if (line.startsWith("MD:")) {
                    final String methoddeobf = line.split(" ")[3];
                    final String methodobf = line.split(" ")[1].split("/")[1];
                    VersionTranslation.srgMethodTranslations.put(methoddeobf, methodobf);
                    final String srgName = methoddeobf.substring(methoddeobf.lastIndexOf(47) + 1);
                    if (VersionTranslation.methodTranslations.containsKey(srgName)) {
                        VersionTranslation.methodTranslations.put(methoddeobf.replace(srgName, "") + VersionTranslation.methodTranslations.get(srgName), methodobf);
                    }
                }
                if (line.startsWith("FD:")) {
                    final String fielddeobf = line.split(" ")[2];
                    final String fieldobf = line.split(" ")[1].split("/")[1];
                    VersionTranslation.srgFieldTranslations.put(fielddeobf, fieldobf);
                    final String srgName = fielddeobf.substring(fielddeobf.lastIndexOf(47) + 1);
                    if (!VersionTranslation.fieldTranslations.containsKey(srgName)) {
                        continue;
                    }
                    VersionTranslation.fieldTranslations.put(fielddeobf.replace(srgName, "") + VersionTranslation.fieldTranslations.get(srgName), fieldobf);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                }
                catch (IOException ex3) {}
            }
        }
    }
}
