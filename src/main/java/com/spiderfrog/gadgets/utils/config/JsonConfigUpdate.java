package com.spiderfrog.gadgets.utils.config;

import java.io.*;
import com.google.gson.*;

public class JsonConfigUpdate extends JsonConfig
{
    static JsonConfigUpdate instance;
    
    public static JsonConfigUpdate getInstance() {
        if (JsonConfigUpdate.instance == null) {
            JsonConfigUpdate.instance = new JsonConfigUpdate();
        }
        return JsonConfigUpdate.instance;
    }
    
    public boolean updatePropertyBoolean(final File file, final String ValueName) throws Exception {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return false;
        }
        final String fileContent = this.getFileContent(createfile);
        final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
        try {
            return json.get(ValueName).getAsBoolean();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return false;
        }
    }
    
    public int updatePropertyInteger(final File file, final String ValueName) throws Exception {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return 0;
        }
        final String fileContent = this.getFileContent(createfile);
        final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
        try {
            return json.get(ValueName).getAsInt();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return 0;
        }
    }
    
    public float updatePropertyFloat(final File file, final String ValueName) throws Exception {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return 0.0f;
        }
        final String fileContent = this.getFileContent(createfile);
        final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
        try {
            return json.get(ValueName).getAsFloat();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return 0.0f;
        }
    }
    
    public double updatePropertyDouble(final File file, final String ValueName) throws Exception {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return 0.0;
        }
        final String fileContent = this.getFileContent(createfile);
        final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
        try {
            return json.get(ValueName).getAsDouble();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return 0.0;
        }
    }
    
    public String updatePropertyString(final File file, final String ValueName) throws Exception {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        if (!createfile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return "";
        }
        final String fileContent = this.getFileContent(createfile);
        final JsonObject json = new JsonParser().parse(fileContent).getAsJsonObject();
        try {
            return json.get(ValueName).getAsString();
        }
        catch (Exception err) {
            this.logger.error("[OldAnimationsMod] Can't find: " + ValueName + " in " + file.getName());
            createfile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return "";
        }
    }
}
