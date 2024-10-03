package com.franksilantro.mztweaks.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class MZFontRenderer {
    private final Minecraft mc;
    private final ResourceLocation fontTexture;

    public MZFontRenderer(Minecraft mc) {
        this.mc = mc;
        this.fontTexture = new ResourceLocation("mztweaks", "textures/font/ascii.png");
    }

    public void drawString(String text, int x, int y, int color, boolean shadow, float alpha) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        mc.getTextureManager().bindTexture(fontTexture);

        alpha = Math.max(0.0f, Math.min(1.0f, alpha));

        if (shadow) {
            int shadowRed = (int) ((color >> 16 & 0xFF) * 0.44f);
            int shadowGreen = (int) ((color >> 8 & 0xFF) * 0.44f);
            int shadowBlue = (int) ((color & 0xFF) * 0.44f);
            int shadowColor = (0xFF << 24) | (shadowRed << 16) | (shadowGreen << 8) | shadowBlue;

            drawStringInternal(text, x + 1, y + 1, shadowColor, alpha * 0.5f); 
        }

        drawStringInternal(text, x, y, color, alpha); 

        GL11.glDisable(GL11.GL_BLEND);
    }

    private void drawStringInternal(String text, int x, int y, int color, float alpha) {
        int offsetX = 0;

        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;

        float r = red / 255.0F;
        float g = green / 255.0F;
        float b = blue / 255.0F;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                offsetX += 2;
                continue;
            }

            int charIndex = c - 32; 
            if (charIndex < 0 || charIndex >= 256) {
                
                continue;
            }

            int texX = (charIndex % 16) * 8;
            int texY = ((charIndex / 16) * 8) + 16;

            GL11.glColor4f(r, g, b, alpha);

            drawChar(x + offsetX, y, texX, texY);
            offsetX += 6; 
        }
    }

    private void drawChar(int x, int y, int texX, int texY) {
        float textureSize = 128.0F; 
        float u = texX / textureSize;
        float v = texY / textureSize;
        float uMax = (texX + 8) / textureSize;
        float vMax = (texY + 8) / textureSize;

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0);

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0, 8, 0, u, vMax);
        tessellator.addVertexWithUV(8, 8, 0, uMax, vMax);
        tessellator.addVertexWithUV(8, 0, 0, uMax, v);
        tessellator.addVertexWithUV(0, 0, 0, u, v);
        tessellator.draw();

        GL11.glPopMatrix();
    }

    public int getStringWidth(String text) {
        return text.length() * 6;
    }
}
