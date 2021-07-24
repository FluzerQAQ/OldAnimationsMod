package com.spiderfrog.gadgets.utils.config;

import java.io.*;
import com.google.gson.*;
import net.minecraft.client.*;

public class JsonConfigSave extends JsonConfig
{
    static JsonConfigSave instance;
    
    public static JsonConfigSave getInstance() {
        if (JsonConfigSave.instance == null) {
            JsonConfigSave.instance = new JsonConfigSave();
        }
        return JsonConfigSave.instance;
    }
    
    public void saveProperty(final File file, final String ValueName, final boolean value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }
        final String fileContent = this.getFileContent(createfile);
        try {
            final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
            json.remove(ValueName);
            json.addProperty(ValueName, Boolean.valueOf(value));
            final FileWriter write = new FileWriter(createfile);
            final String text = this.prettyGson.toJson((JsonElement)json);
            write.write(text);
            write.close();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find/update: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
        }
    }
    
    public void saveProperty(final File file, final String ValueName, final float value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }
        final String fileContent = this.getFileContent(createfile);
        try {
            final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
            json.remove(ValueName);
            json.addProperty(ValueName, (Number)value);
            final FileWriter write = new FileWriter(createfile);
            final String text = this.prettyGson.toJson((JsonElement)json);
            write.write(text);
            write.close();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find/update: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
        }
    }
    
    public void saveProperty(final File file, final String ValueName, final double value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }
        final String fileContent = this.getFileContent(createfile);
        try {
            final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
            json.remove(ValueName);
            json.addProperty(ValueName, (Number)value);
            final FileWriter write = new FileWriter(createfile);
            final String text = this.prettyGson.toJson((JsonElement)json);
            write.write(text);
            write.close();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find/update: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
        }
    }
    
    public void saveProperty(final File file, final String ValueName, final int value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }
        final String fileContent = this.getFileContent(createfile);
        try {
            final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
            json.remove(ValueName);
            json.addProperty(ValueName, (Number)value);
            final FileWriter write = new FileWriter(createfile);
            final String text = this.prettyGson.toJson((JsonElement)json);
            write.write(text);
            write.close();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find/update: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
        }
    }
    
    public void saveProperty(final File file, final String ValueName, final String value) {
        final File path = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "OldAnimationsMod" + File.separator);
        final File createfile = new File(path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }
        final String fileContent = this.getFileContent(createfile);
        try {
            final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
            json.remove(ValueName);
            json.addProperty(ValueName, value);
            final FileWriter write = new FileWriter(createfile);
            final String text = this.prettyGson.toJson((JsonElement)json);
            write.write(text);
            write.close();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find/update: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
        }
    }
}
