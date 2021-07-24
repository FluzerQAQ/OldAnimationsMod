package com.spiderfrog.v1_8_9;

import net.minecraft.client.*;
import net.minecraftforge.fml.common.*;
//import com.spiderfrog.gadgets.gui.gadgets.*;
import com.spiderfrog.oldanimations.gui.animations.*;
import com.spiderfrog.oldanimations.animations.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.network.*;
import net.minecraft.scoreboard.*;
import com.spiderfrog.v1_8_9.patch_animations.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.world.*;

public class OAMInjection
{
    private static Minecraft mc;
    private static final Ordering field_175252_a;
    public static final ResourceLocation icons;
    protected static float zLevel;
    
    public static void addOAMButton(final List<GuiButton> buttonList) {
        //buttonList.add(new GuiButton(80, 3, 3 + (Loader.isModLoaded("labymod") ? 25 : 0), 90, 20, "Cosmetics"));
        buttonList.add(new GuiButton(21, 3, 3 + (Loader.isModLoaded("labymod") ? 25 : 0), 90, 20, "OldAnimationsMod"));
    }
    
    public static void performOAMButton(final GuiButton button) {
        /*if (button.enabled && button.id == 80) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiGadgets(null));
        }*/
        if (button.enabled && button.id == 21) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new OldAnimationsSettings1());
        }
    }
    
    public static void blockbuild() {
        try {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDBLOCKBUILD) && OAMInjection.mc.thePlayer.getItemInUseCount() != 0 && OAMInjection.mc.gameSettings.keyBindAttack.isKeyDown() && OAMInjection.mc.gameSettings.keyBindUseItem.isKeyDown() && OAMInjection.mc.objectMouseOver != null && OAMInjection.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                swingItem((EntityLivingBase)OAMInjection.mc.thePlayer);
            }
        }
        catch (Exception ex) {}
    }
    
    private static void swingItem(final EntityLivingBase e) {
        if (!e.isSwingInProgress || e.swingProgressInt >= getArmSwingAnimationEnd(e) / 2 || e.swingProgressInt < 0) {
            e.swingProgressInt = -1;
            e.isSwingInProgress = true;
        }
    }
    
    private static int getArmSwingAnimationEnd(final EntityLivingBase e) {
        return e.isPotionActive(Potion.digSpeed) ? (6 - (1 + e.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1) : (e.isPotionActive(Potion.digSlowdown) ? (6 + (1 + e.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2) : 6);
    }
    
    public static void transformHeldItem(final EntityLivingBase entitylivingbaseIn, final RendererLivingEntity livingEntityRenderer) {
        if (entitylivingbaseIn instanceof EntityPlayer) {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDSWORD)) {
                if (((EntityPlayer)entitylivingbaseIn).isBlocking()) {
                    if (entitylivingbaseIn.isSneaking()) {
                        ((ModelBiped)livingEntityRenderer.getMainModel()).postRenderArm(0.0325f);
                        GlStateManager.scale(1.05f, 1.05f, 1.05f);
                        GlStateManager.translate(-0.58f, 0.32f, -0.07f);
                        GlStateManager.rotate(-24405.0f, 137290.0f, -2009900.0f, -2654900.0f);
                    }
                    else {
                        ((ModelBiped)livingEntityRenderer.getMainModel()).postRenderArm(0.0325f);
                        GlStateManager.scale(1.05f, 1.05f, 1.05f);
                        GlStateManager.translate(-0.45f, 0.25f, -0.07f);
                        GlStateManager.rotate(-24405.0f, 137290.0f, -2009900.0f, -2654900.0f);
                    }
                }
                else {
                    ((ModelBiped)livingEntityRenderer.getMainModel()).postRenderArm(0.0625f);
                }
            }
            else {
                ((ModelBiped)livingEntityRenderer.getMainModel()).postRenderArm(0.0625f);
            }
            if (!AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD)) {
                GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
            }
            else if (!((EntityPlayer)entitylivingbaseIn).isBlocking() && AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD) && !entitylivingbaseIn.isSneaking()) {
                GlStateManager.translate(-0.0855f, 0.4775f, 0.1585f);
                GlStateManager.rotate(-19.0f, 20.0f, 0.0f, -6.0f);
            }
            else if (entitylivingbaseIn.isSneaking() && !((EntityPlayer)entitylivingbaseIn).isBlocking() && AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD)) {
                GlStateManager.translate(-0.0525f, 0.5375f, 0.0725f);
                GlStateManager.rotate(16.0f, -8.0f, 0.0f, 5.0f);
                GlStateManager.translate(0.0f, 0.1f, 0.09523f);
            }
            else if (((EntityPlayer)entitylivingbaseIn).isBlocking()) {
                GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
            }
        }
        else {
            ((ModelBiped)livingEntityRenderer.getMainModel()).postRenderArm(0.0625f);
            GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
        }
    }
    
    public static void performOldAnimations(final Minecraft mc, final ItemStack itemToRender, final float swingProgress) {
        if (itemToRender != null) {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDROD) && itemToRender.getItem() instanceof ItemCarrotOnAStick) {
                GlStateManager.translate(0.08f, -0.027f, -0.33f);
                GlStateManager.scale(0.93f, 1.0f, 1.0f);
            }
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDROD) && itemToRender.getItem() instanceof ItemFishingRod) {
                GlStateManager.translate(0.08f, -0.027f, -0.33f);
                GlStateManager.scale(0.93f, 1.0f, 1.0f);
            }
            try {
                if (AnimationManager.getOldAnimationState(EnumAnimation.OLDBOW) && mc.thePlayer.getItemInUse().getItem() instanceof ItemBow) {
                    GlStateManager.translate(-0.01f, 0.05f, -0.06f);
                }
            }
            catch (Exception ex) {}
        }
        if (AnimationManager.getOldAnimationState(EnumAnimation.OLDSWING) && swingProgress != 0.0f && !mc.thePlayer.isBlocking() && !mc.thePlayer.isEating() && !mc.thePlayer.isUsingItem()) {
            GlStateManager.scale(0.85f, 0.85f, 0.85f);
            GlStateManager.translate(-0.06f, 0.003f, 0.05f);
        }
    }
    
    public static void renderPlayerlistOld(final int width, final Scoreboard scoreboardIn, final ScoreObjective scoreObjectiveIn) {
        try {
            final NetHandlerPlayClient var4 = OAMInjection.mc.thePlayer.sendQueue;
            final List var5 = OAMInjection.field_175252_a.sortedCopy((Iterable)var4.getPlayerInfoMap());
            int var7;
            final int var6 = var7 = OAMInjection.mc.thePlayer.sendQueue.currentServerMaxPlayers;
            final ScaledResolution var8 = new ScaledResolution(OAMInjection.mc);
            int var9 = 0;
            final int var10 = var8.getScaledWidth();
            int var11 = 0;
            int var12 = 0;
            int var13 = 0;
            for (var9 = 1; var7 > 20; var7 = (var6 + var9 - 1) / var9) {
                ++var9;
            }
            int var14 = 300 / var9;
            if (var14 > 150) {
                var14 = 150;
            }
            final int var15 = (var10 - var9 * var14) / 2;
            final byte var16 = 10;
            Gui.drawRect(var15 - 1, var16 - 1, var15 + var14 * var9, var16 + 9 * var7, Integer.MIN_VALUE);
            for (var11 = 0; var11 < var6; ++var11) {
                var12 = var15 + var11 % var9 * var14;
                var13 = var16 + var11 / var9 * 9;
                Gui.drawRect(var12, var13, var12 + var14 - 1, var13 + 8, 553648127);
                GlStateManager.enableAlpha();
                if (var11 < var5.size()) {
                    final NetworkPlayerInfo var17 = (NetworkPlayerInfo) var5.get(var11);
                    final String name = var17.getGameProfile().getName();
                    final ScorePlayerTeam var18 = OAMInjection.mc.theWorld.getScoreboard().getPlayersTeam(name);
                    final String var19 = getPlayerName(var17);
                    GlStateManager.color(1.0f, 1.0f, 1.0f);
                    OAMInjection.mc.fontRendererObj.drawStringWithShadow(var19, (float)var12, (float)var13, -1);
                    if (scoreObjectiveIn != null) {
                        final int var20 = var12 + OAMInjection.mc.fontRendererObj.getStringWidth(var19) + 5;
                        final int var21 = var12 + var14 - 12 - 5;
                        if (var21 - var20 > 5) {
                            final Score var22 = scoreboardIn.getValueFromObjective(name, scoreObjectiveIn);
                            final String var23 = EnumChatFormatting.YELLOW + "" + var22.getScorePoints();
                            OAMInjection.mc.fontRendererObj.drawStringWithShadow(var23, (float)(var21 - OAMInjection.mc.fontRendererObj.getStringWidth(var23)), (float)var13, 16777215);
                        }
                    }
                    drawPing(50, var12 + var14 - 52, var13, var17);
                }
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.enableAlpha();
        }
        catch (Exception ex) {}
    }
    
    private static String getPlayerName(final NetworkPlayerInfo p_175243_1_) {
        return (p_175243_1_.getDisplayName() != null) ? p_175243_1_.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team)p_175243_1_.getPlayerTeam(), p_175243_1_.getGameProfile().getName());
    }
    
    protected static void drawPing(final int p_175245_1_, final int p_175245_2_, final int p_175245_3_, final NetworkPlayerInfo p_175245_4_) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        OAMInjection.mc.getTextureManager().bindTexture(OAMInjection.icons);
        final byte b0 = 0;
        final boolean flag = false;
        byte b2;
        if (p_175245_4_.getResponseTime() < 0) {
            b2 = 5;
        }
        else if (p_175245_4_.getResponseTime() < 150) {
            b2 = 0;
        }
        else if (p_175245_4_.getResponseTime() < 300) {
            b2 = 1;
        }
        else if (p_175245_4_.getResponseTime() < 600) {
            b2 = 2;
        }
        else if (p_175245_4_.getResponseTime() < 1000) {
            b2 = 3;
        }
        else {
            b2 = 4;
        }
        drawTexturedModalRect(p_175245_2_ + p_175245_1_ - 11, p_175245_3_, 0 + b0 * 10, 176 + b2 * 8, 10, 8, OAMInjection.zLevel += 100.0f);
        OAMInjection.zLevel -= 100.0f;
    }
    
    public static void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height, final float zLevel) {
        Methods.getInstance().drawTexturedModalRect(x, y, textureX, textureY, width, height, zLevel);
    }
    
    static {
        OAMInjection.mc = Minecraft.getMinecraft();
        field_175252_a = Ordering.from((Comparator)new PlayerComparator(null));
        icons = new ResourceLocation("textures/gui/icons.png");
    }
    
    static class PlayerComparator implements Comparator
    {
        private static final String __OBFID = "CL_00001941";
        
        private PlayerComparator() {
        }
        
        public int func_178952_a(final NetworkPlayerInfo p_178952_1_, final NetworkPlayerInfo p_178952_2_) {
            final ScorePlayerTeam scoreplayerteam = p_178952_1_.getPlayerTeam();
            final ScorePlayerTeam scoreplayerteam2 = p_178952_2_.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(p_178952_1_.getGameType() != WorldSettings.GameType.SPECTATOR, p_178952_2_.getGameType() != WorldSettings.GameType.SPECTATOR).compare((Comparable)((scoreplayerteam != null) ? scoreplayerteam.getRegisteredName() : ""), (Comparable)((scoreplayerteam2 != null) ? scoreplayerteam2.getRegisteredName() : "")).compare((Comparable)p_178952_1_.getGameProfile().getName(), (Comparable)p_178952_2_.getGameProfile().getName()).result();
        }
        
        @Override
        public int compare(final Object p_compare_1_, final Object p_compare_2_) {
            return this.func_178952_a((NetworkPlayerInfo)p_compare_1_, (NetworkPlayerInfo)p_compare_2_);
        }
        
        PlayerComparator(final Object p_i45528_1_) {
            this();
        }
    }
}
