package com.spiderfrog.gadgets.utils.config;

import com.google.gson.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import java.io.*;

public class JsonConfig
{
    public final Gson prettyGson;
    Logger logger;
    public final File path;
    
    public JsonConfig() {
        this.prettyGson = new GsonBuilder().setPrettyPrinting().create();
        this.logger = LogManager.getLogger();
        this.path = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "OldAnimationsMod" + File.separator);
    }
    
    public String getFileContent(final File file) {
        final StringBuilder sb = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            final char[] readerContent = { '\0' };
            while (reader.read(readerContent) != -1) {
                sb.append(readerContent[0]);
            }
            reader.close();
        }
        catch (Exception ex) {
            return null;
        }
        return sb.toString();
    }
}
