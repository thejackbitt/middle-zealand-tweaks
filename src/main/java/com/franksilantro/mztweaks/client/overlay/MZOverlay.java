package com.franksilantro.mztweaks.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MZOverlay {

    private static boolean canKillsteak = false;
    private static int displayTime = 0;
    private static int streakNum = 0;

    private static final int frames = 22;
    private static final float scalef = 0.5f;
    private static final int fscale = 5; // Font size

    private static final int frameDuration = 1000 / 12; // 1000 milliseconds divided by 12 FPS
    private static long lastFrameTime = 0;
    private static int framesIndex = 0;

    public static void triggerKillsteak(int streek) {
        canKillsteak = true;
        streakNum = streek;
        framesIndex = 0;
        lastFrameTime = System.currentTimeMillis();
    }

    private static void renderStreakNum(Minecraft mc, int screenWidth, int screenHeight) {
        String streakText = "" + streakNum;
        int textWidth = mc.fontRenderer.getStringWidth(streakText);
        int textX = (screenWidth - textWidth + 400) / 2;
        int textY = (screenHeight - 80) / 2;

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glScalef(fscale, fscale, fscale);
        mc.fontRenderer.drawStringWithShadow(streakText, textX / fscale, textY / fscale, 0xFFFFFF);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void renderKillsteak(Minecraft mc) {
        if (!canKillsteak || framesIndex >= frames) {
            return; // End the animation once all frames have been shown
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFrameTime >= frameDuration) {
            framesIndex++; // Move to the next frame
            lastFrameTime = currentTime; // Reset the timer for the next frame
        }

        if (framesIndex >= frames) {
            canKillsteak = false; // Stop the animation once all frames are displayed
            return;
        }

        ResourceLocation currentTexture = new ResourceLocation("mztweaks", "textures/gui/frame" + framesIndex + ".png");
        ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_ALPHA_TEST);

        mc.renderEngine.bindTexture(currentTexture);

        if (canKillsteak) {
            float textureWidth = 311F;
            float textureHeight = 128F;
            float x = (width + textureWidth * scalef - 30) / 2;
            float y = (height - 270) / 2;
            GL11.glScalef(scalef, scalef, 1);
            drawTexturedModalRect(x, y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
            renderStreakNum(mc, width, height);
        }

        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawTexturedModalRect(float x, float y, float u, float v, float width, float height, float textureWidth, float textureHeight) {
		float zLevel = -90.0F;

		float var7 = 1 / textureWidth;
        float var8 = 1 / textureHeight;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + height), (double) zLevel, (double) ((float) (u + 0) * var7), (double) ((float) (v + height) * var8));
		tessellator.addVertexWithUV((double) (x + width), (double) (y + height), (double) zLevel, (double) ((float) (u + width) * var7), (double) ((float) (v + height) * var8));
		tessellator.addVertexWithUV((double) (x + width), (double) (y + 0), (double) zLevel, (double) ((float) (u + width) * var7), (double) ((float) (v + 0) * var8));
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + 0), (double) zLevel, (double) ((float) (u + 0) * var7), (double) ((float) (v + 0) * var8));
		tessellator.draw();
	}

}