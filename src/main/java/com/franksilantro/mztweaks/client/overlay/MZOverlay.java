package com.franksilantro.mztweaks.client.overlay;

import com.franksilantro.mztweaks.client.renderer.MZFontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
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
    private static int fscale = 5; // Font size

    private static final int frameDuration = 1000 / 12; // 1000 milliseconds divided by 12 FPS
    private static long lastFrameTime = 0;
    private static int framesIndex = 0;

    private static final MZFontRenderer customFontRenderer = new MZFontRenderer(Minecraft.getMinecraft());

    public static void triggerKillsteak(int streek) {
        canKillsteak = true;
        streakNum = streek;
        fscale = 7;
        framesIndex = 0;
        lastFrameTime = System.currentTimeMillis();
    }

    public static void renderKillsteak(Minecraft mc) {
        if (!canKillsteak || framesIndex >= frames) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFrameTime >= frameDuration) {
            framesIndex++;
            lastFrameTime = currentTime;
        }

        if (framesIndex >= frames) {
            canKillsteak = false;
            return;
        }

        ResourceLocation currentTexture = new ResourceLocation("mztweaks", "textures/gui/frame" + framesIndex + ".png");
        ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();

        // Save the current OpenGL state
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glPushMatrix();

        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);

        mc.renderEngine.bindTexture(currentTexture);

        float textureWidth = 311F;
        float textureHeight = 128F;
        float x = (width + textureWidth * scalef - 30) / 2;
        float y = (height - 270) / 2;
        GL11.glScalef(scalef, scalef, 1);
        drawTexturedModalRect(x, y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);

        // Render the streak number
        String streakText = "" + streakNum;
        int textWidth = customFontRenderer.getStringWidth(streakText);
        int textX = (width - textWidth + 375) / 2;
        int textY = (height - 80) / 2;

        if (framesIndex < 2 || framesIndex > 22) {
            fscale = Math.max(1, fscale - (int) (framesIndex * 0.5));
        } else if (framesIndex > 2 && framesIndex < 22) {
            fscale = 5;
        }

        int maxStreak = 25;
        float ratio = Math.min((float) streakNum / maxStreak, 1.0f);

        int startColor = 0xFFFF55;
        int endColor = 0xFF5555;

        int startR = (startColor >> 16) & 0xFF;
        int startG = (startColor >> 8) & 0xFF;
        int startB = startColor & 0xFF;

        int endR = (endColor >> 16) & 0xFF;
        int endG = (endColor >> 8) & 0xFF;
        int endB = endColor & 0xFF;

        int r = (int) (startR + (endR - startR) * ratio);
        int g = (int) (startG + (endG - startG) * ratio);
        int b = (int) (startB + (endB - startB) * ratio);

        int color = (0xFF << 24) | (r << 16) | (g << 8) | b;

        float alpha = 1.0f; 
        if (framesIndex >= 16) {
            alpha = Math.max(0.0f, 1.0f - ((framesIndex - 16) / 6.0f));
        }

        GL11.glPushMatrix();
        GL11.glScalef(fscale, fscale, fscale);
        customFontRenderer.drawString(streakText, textX / fscale, textY / fscale, color, true, alpha);
        GL11.glPopMatrix();

        GL11.glPopAttrib();
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
