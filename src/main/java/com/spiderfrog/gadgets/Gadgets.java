package com.spiderfrog.gadgets;

import net.minecraft.client.*;
/*import org.java_websocket.client.*;
import com.spiderfrog.gadgets.connection.utils.*;
import com.spiderfrog.gadgets.emote.*;*/
import com.spiderfrog.oldanimations.*;
import org.apache.logging.log4j.*;
//import java.util.*;
import net.minecraft.util.*;
/*import com.spiderfrog.gadgets.cosmetic.*;
import com.spiderfrog.gadgets.connection.*;*/
import java.net.*;
import com.spiderfrog.gadgets.utils.*;

public class Gadgets
{
    public static final String MODVERSION = "2.6.5";
    public static final String MODID = "oldanimationsgadgets";
    public static final String MCVERSION = "1.8.9";
    private boolean loaded;
    private static Gadgets instance;
    private Logger logger;
    public Minecraft mc;
    public RenderUtils renderUtils;
    /*public UpdateChecker updateChecker;
    public WebSocketClient client;
    public SessionNetworkManager sessionNetworkManager;
    public ConnectionPackets.DatabaseConnectionState connectionState;
    public CosmeticDownloader cosmeticDownloader;
    public EmoteManager emoteManager;
    private AutoReconnecter autoReconnecter;
    public GadgetsConfig config;*/
    boolean orange;
    
    public Gadgets() {
        this.orange = false;
    }
    
    public void initTweak() {
        this.runMod();
    }
    
    public void runMod() {
        OldAnimationsMod.getInstance().runMod();
        if (this.loaded) {
            return;
        }
        this.loaded = true;
        //this.cosmeticDownloader = new CosmeticDownloader();
        new Thread("Cosmetic thread") {
            @Override
            public void run() {
                Gadgets.this.logger = LogManager.getLogger("OAM");
                Gadgets.this.logger.info("[Cosmetics] Start initialize OldAnimationsMod Cosmetics");
                /*Gadgets.this.connectionState = ConnectionPackets.DatabaseConnectionState.OFFLINE;
                final Gadgets this$0 = Gadgets.this;
                Gadgets.instance = Gadgets.this;
                Gadgets.this.mc = Minecraft.getMinecraft();
                Gadgets.this.updateChecker = new UpdateChecker(Gadgets.this, false);
                Gadgets.this.renderUtils = new RenderUtils(Gadgets.this.mc);
                Gadgets.this.emoteManager = new EmoteManager();
                (Gadgets.this.config = new GadgetsConfig()).init();
                Gadgets.this.sessionNetworkManager = new SessionNetworkManager(Gadgets.this.mc, "host.oldanimationsmod.net", 25564, Gadgets.this);
                final java.util.Timer t = new java.util.Timer("OldAnimationsMod");
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Gadgets.this.runSecondLoop();
                    }
                }, 0L, 1000L);
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Gadgets.this.runTick();
                    }
                }, 0L, 20L);*/
                Gadgets.this.logger.info("[Cosmetics] Initialization has been fucked by FluzerQAQ");
                Gadgets.this.logger.info("[Cosmetics] Successfully initialized OldAnimationsMod Cosmetics");
            }
        }.start();
    }
    
    public static Gadgets getInstance() {
        if (Gadgets.instance == null) {
            Gadgets.instance = new Gadgets();
        }
        return Gadgets.instance;
    }
    
    public void reconnectToDatabase() {
        new Thread("OAM Database Connector") {
            /*@Override
            public void run() {
                if (Gadgets.this.mc.thePlayer != null && Gadgets.this.mc.theWorld != null) {
                    Gadgets.this.mc.thePlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_GRAY + "" + EnumChatFormatting.BOLD + "[" + EnumChatFormatting.GOLD + EnumChatFormatting.BOLD + "OldAnimationsMod" + EnumChatFormatting.DARK_GRAY + EnumChatFormatting.BOLD + "] " + EnumChatFormatting.RESET + EnumChatFormatting.GREEN + "Reconnecting to Database..."));
                }
                Gadgets.this.connectionState = ConnectionPackets.DatabaseConnectionState.OFFLINE;
                int connects = 1;
                if (Gadgets.this.sessionNetworkManager != null) {
                    connects = Gadgets.this.sessionNetworkManager.reconnects;
                }
                Gadgets.this.sessionNetworkManager = null;
                try {
                    Gadgets.this.sessionNetworkManager = new SessionNetworkManager(Gadgets.this.mc, "host.oldanimationsmod.net", 25564, Gadgets.this);
                    Gadgets.this.sessionNetworkManager.reconnects = connects;
                    Gadgets.this.client.closeConnection(0, "CLOSED_BY_CLIENT");
                    Gadgets.this.client = null;
                }
                catch (Exception err) {
                    err.printStackTrace();
                }
                CosmeticManager.reloadCosmetics();
                super.run();
            }*/
        }.start();
    }
    
    public void sendMessage(final String message) {
        this.logger.info("[Cosmetics] " + message);
    }
    
    public void sendError(final String error) {
        this.logger.error("[Cosmetics] " + error);
    }
    
    private void runSecondLoop() {
        /*if (this.sessionNetworkManager != null) {
            this.sessionNetworkManager.checkServerInfo(this.client, this.connectionState);
        }
        if (this.client == null && this.sessionNetworkManager != null && !this.sessionNetworkManager.getSessionID().equals("EXCEPTION")) {
            try {
                (this.client = new Client(new URI("ws://host.oldanimationsmod.net:8886"), this.mc, this, this.sessionNetworkManager, "2.6.5", Utils.getMinecraftVersion())).connect();
            }
            catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        try {
            if (this.sessionNetworkManager != null) {
                this.sessionNetworkManager.autoReconnect(this);
            }
        }
        catch (Exception err) {
            err.printStackTrace();
        }*/
        if (this.mc.theWorld != null && this.mc.thePlayer != null && !this.orange) {
            try {
                final Class clazz = Class.forName("com.orangemarshall.animations.Animations");
                this.mc.thePlayer.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_GRAY + "" + EnumChatFormatting.BOLD + "[" + EnumChatFormatting.GOLD + EnumChatFormatting.BOLD + "OldAnimationsMod" + EnumChatFormatting.DARK_GRAY + EnumChatFormatting.BOLD + "] " + EnumChatFormatting.RESET + EnumChatFormatting.RED + "Orange's 1.7 Animations Detected. The Cosmetics may not work, please uninstall Orange's 1.7 Animations."));
                this.orange = true;
            }
            catch (Exception ex) {}
        }
        this.processAutoReconnect();
    }
    
    private void processAutoReconnect() {
        /*if (this.connectionState == ConnectionPackets.DatabaseConnectionState.REFUSED) {
            if (this.autoReconnecter == null) {
                this.autoReconnecter = new AutoReconnecter(this);
            }
            else {
                this.autoReconnecter.runAutoReconnect();
            }
        }
        if (this.autoReconnecter != null) {
            this.autoReconnecter.updateReconnectStatus();
        }*/
    }
    
    private void runTick() {
        /*if (this.client == null && this.sessionNetworkManager != null) {
            this.sessionNetworkManager.updatePackets();
        }
        EmoteManager.runEssentials();
        UpdateChecker.sendMessage();*/
        LSD.runTick();
    }
}
