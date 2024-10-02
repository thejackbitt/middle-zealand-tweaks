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

        // Clamp alpha between 0.0f and 1.0f
        alpha = Math.max(0.0f, Math.min(1.0f, alpha));

        if (shadow) {
            // Calculate shadow color as a darker version of the original color
            int shadowRed = (int) ((color >> 16 & 0xFF) * 0.44f);
            int shadowGreen = (int) ((color >> 8 & 0xFF) * 0.44f);
            int shadowBlue = (int) ((color & 0xFF) * 0.44f);
            int shadowColor = (0xFF << 24) | (shadowRed << 16) | (shadowGreen << 8) | shadowBlue;

            drawStringInternal(text, x + 1, y + 1, shadowColor, alpha * 0.5f); // Draw shadow with half the alpha value
        }

        drawStringInternal(text, x, y, color, alpha); // Draw the text with the provided alpha value

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
                offsetX += 2; // Adjusted space width to 2 pixels
                continue;
            }

            int charIndex = c - 32; // Calculate character index (assuming ASCII starting from 32)
            if (charIndex < 0 || charIndex >= 256) {
                // Skip non-printable or out-of-range characters
                continue;
            }

            int texX = (charIndex % 16) * 8; // Column position in the texture
            int texY = ((charIndex / 16) * 8) + 16; // Correct row position in the texture with a two-row offset down (16 pixels)

            // Set color for each character to maintain the correct color value
            GL11.glColor4f(r, g, b, alpha);

            drawChar(x + offsetX, y, texX, texY);
            offsetX += 6; // Adjusted character spacing to 2 pixels (8px character width + 2px spacing)
        }
    }

    private void drawChar(int x, int y, int texX, int texY) {
        float textureSize = 128.0F; // The size of the texture (128x128 pixels)
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
        return text.length() * 6; // Updated to reflect new character width (8 pixels wide + 2 pixels spacing)
    }
}
