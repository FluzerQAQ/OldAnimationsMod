package com.spiderfrog.gadgets.utils.config;

import com.google.gson.*;
import java.io.*;

public class JsonConfigCreate extends JsonConfig
{
    static JsonConfigCreate instance;
    
    public static JsonConfigCreate getInstance() {
        if (JsonConfigCreate.instance == null) {
            JsonConfigCreate.instance = new JsonConfigCreate();
        }
        return JsonConfigCreate.instance;
    }
    
    public void addProperty(final File file, final String valueName, final boolean value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        try {
            if (!createfile.exists()) {
                this.path.mkdirs();
                createfile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + file.getName() + " Created!");
            }
            final String fileContent = this.getFileContent(createfile);
            if (fileContent.contains(valueName)) {
                return;
            }
            JsonObject json = new JsonObject();
            if (!fileContent.equals("")) {
                try {
                    json = new JsonParser().parse(fileContent).getAsJsonObject();
                }
                catch (JsonParseException err) {
                    err.printStackTrace();
                    this.logger.error("[OldAnimationsMod] Can't parse Config file.");
                    createfile.delete();
                    this.logger.info("[OldAnimationsMod] Deleted Config File.");
                }
            }
            json.addProperty(valueName, Boolean.valueOf(value));
            try {
                final FileWriter write = new FileWriter(createfile);
                final String text = this.prettyGson.toJson((JsonElement)json);
                write.write(text);
                write.close();
            }
            catch (IOException err2) {
                err2.printStackTrace();
            }
        }
        catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't create Config file: " + file.getName());
            e.printStackTrace();
        }
    }
    
    public void addProperty(final File file, final String valueName, final int value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        try {
            if (!createfile.exists()) {
                this.path.mkdirs();
                createfile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + file.getName() + "Created!");
            }
            final String fileContent = this.getFileContent(createfile);
            if (fileContent.contains(valueName)) {
                return;
            }
            JsonObject json = new JsonObject();
            if (!fileContent.equals("")) {
                try {
                    json = new JsonParser().parse(fileContent).getAsJsonObject();
                }
                catch (JsonParseException err) {
                    err.printStackTrace();
                    this.logger.error("[OldAnimationsMod] Can't parse Config file.");
                    createfile.delete();
                    this.logger.info("[OldAnimationsMod] Deleted Config File.");
                }
            }
            json.addProperty(valueName, (Number)value);
            try {
                final FileWriter write = new FileWriter(createfile);
                final String text = this.prettyGson.toJson((JsonElement)json);
                write.write(text);
                write.close();
            }
            catch (IOException err2) {
                err2.printStackTrace();
            }
        }
        catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't create Config file: " + file.getName());
            e.printStackTrace();
        }
    }
    
    public void addProperty(final File file, final String valueName, final float value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        try {
            if (!createfile.exists()) {
                this.path.mkdirs();
                createfile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + file.getName() + "Created!");
            }
            final String fileContent = this.getFileContent(createfile);
            if (fileContent.contains(valueName)) {
                return;
            }
            JsonObject json = new JsonObject();
            if (!fileContent.equals("")) {
                try {
                    json = new JsonParser().parse(fileContent).getAsJsonObject();
                }
                catch (JsonParseException err) {
                    err.printStackTrace();
                    this.logger.error("[OldAnimationsMod] Can't parse Config file.");
                    createfile.delete();
                    this.logger.info("[OldAnimationsMod] Deleted Config File.");
                }
            }
            json.addProperty(valueName, (Number)value);
            try {
                final FileWriter write = new FileWriter(createfile);
                final String text = this.prettyGson.toJson((JsonElement)json);
                write.write(text);
                write.close();
            }
            catch (IOException err2) {
                err2.printStackTrace();
            }
        }
        catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't create Config file: " + file.getName());
            e.printStackTrace();
        }
    }
    
    public void addProperty(final File file, final String valueName, final double value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        try {
            if (!createfile.exists()) {
                this.path.mkdirs();
                createfile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + file.getName() + "Created!");
            }
            final String fileContent = this.getFileContent(createfile);
            if (fileContent.contains(valueName)) {
                return;
            }
            JsonObject json = new JsonObject();
            if (!fileContent.equals("")) {
                try {
                    json = new JsonParser().parse(fileContent).getAsJsonObject();
                }
                catch (JsonParseException err) {
                    err.printStackTrace();
                    this.logger.error("[OldAnimationsMod] Can't parse Config file.");
                    createfile.delete();
                    this.logger.info("[OldAnimationsMod] Deleted Config File.");
                }
            }
            json.addProperty(valueName, (Number)value);
            try {
                final FileWriter write = new FileWriter(createfile);
                final String text = this.prettyGson.toJson((JsonElement)json);
                write.write(text);
                write.close();
            }
            catch (IOException err2) {
                err2.printStackTrace();
            }
        }
        catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't create Config file: " + file.getName());
            e.printStackTrace();
        }
    }
    
    public void addProperty(final File file, final String valueName, final String value) {
        final File createfile = new File(this.path.getAbsolutePath(), file.getName());
        try {
            if (!createfile.exists()) {
                this.path.mkdirs();
                createfile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + file.getName() + "Created!");
            }
            final String fileContent = this.getFileContent(createfile);
            if (fileContent.contains(valueName)) {
                return;
            }
            JsonObject json = new JsonObject();
            if (!fileContent.equals("")) {
                try {
                    json = new JsonParser().parse(fileContent).getAsJsonObject();
                }
                catch (JsonParseException err) {
                    err.printStackTrace();
                    this.logger.error("[OldAnimationsMod] Can't parse Config file.");
                    createfile.delete();
                    this.logger.info("[OldAnimationsMod] Deleted Config File.");
                }
            }
            json.addProperty(valueName, value);
            try {
                final FileWriter write = new FileWriter(createfile);
                final String text = this.prettyGson.toJson((JsonElement)json);
                write.write(text);
                write.close();
            }
            catch (IOException err2) {
                err2.printStackTrace();
            }
        }
        catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't create Config file: " + file.getName());
            e.printStackTrace();
        }
    }
}
