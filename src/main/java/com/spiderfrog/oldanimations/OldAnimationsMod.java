package com.spiderfrog.oldanimations;

import net.minecraft.client.*;
import com.spiderfrog.oldanimations.animations.*;
import com.spiderfrog.oldanimations.utils.*;
import org.apache.logging.log4j.*;

public class OldAnimationsMod
{
    private boolean loaded;
    private static OldAnimationsMod instance;
    private Logger logger;
    public Minecraft mc;
    public RenderUtils renderUtils;
    public AnimationManager animationManager;
    public Settings settings;
    public BlockAndBuild blockbuild;
    
    public void initTweak() {
        this.runMod();
    }
    
    public void runMod() {
        if (this.loaded) {
            return;
        }
        this.loaded = true;
        new Thread("OldAnimationsMod thread") {
            @Override
            public void run() {
                OldAnimationsMod.this.logger = LogManager.getLogger("OAM");
                OldAnimationsMod.this.logger.info("[OldAnimationsMod] Start initialize OldAnimationsMod");
                final OldAnimationsMod this$0 = OldAnimationsMod.this;
                OldAnimationsMod.instance = OldAnimationsMod.this;
                OldAnimationsMod.this.mc = Minecraft.getMinecraft();
                OldAnimationsMod.this.animationManager = new AnimationManager();
                OldAnimationsMod.this.settings = new Settings();
                OldAnimationsMod.this.renderUtils = new RenderUtils(OldAnimationsMod.this.mc);
                OldAnimationsMod.this.animationManager.initAnimations();
                OldAnimationsMod.this.settings.init();
                OldAnimationsMod.this.logger.info("[OldAnimationsMod] Successfully initialized OldAnimationsMod");
            }
        }.start();
    }
    
    public static OldAnimationsMod getInstance() {
        if (OldAnimationsMod.instance == null) {
            OldAnimationsMod.instance = new OldAnimationsMod();
        }
        return OldAnimationsMod.instance;
    }
    
    public void sendMessage(final String message) {
        this.logger.info("[OldAnimationsMod] " + message);
    }
    
    public void sendError(final String error) {
        this.logger.error("[OldAnimationsMod] " + error);
    }
    
    private void runTick() {
    }
}
