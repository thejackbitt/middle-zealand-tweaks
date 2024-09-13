package com.franksilantro.mztweaks.client.renderer;

import mods.battlegear2.client.utils.BattlegearRenderHelper;
import mods.battlegear2.items.ItemShield;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class MZShieldRenderer implements IItemRenderer {
    private final RenderItem itemRenderer = new RenderItem();

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return item != null && item.getItem() instanceof ItemShield && type != IItemRenderer.ItemRenderType.FIRST_PERSON_MAP;
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return type == IItemRenderer.ItemRenderType.ENTITY && 
               (helper == IItemRenderer.ItemRendererHelper.ENTITY_BOBBING || helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION);
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        ItemShield shield = (ItemShield) item.getItem();
        IIcon icon = item.getIconIndex();
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.instance;

        // Apply scaling based on the render type (only in third-person view)
        if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            GL11.glScalef(1.5F, 1.5F, 1.5F);  // Scale the shield by 2.0x only in third-person
        }

        // Shift the shield down in all cases except first-person and inventory
        if (type != IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON && type != IItemRenderer.ItemRenderType.INVENTORY) {
            GL11.glTranslatef(-0.15F, -0.25F, 0.0F);  // Shift the shield down slightly
        }

        // Render the shield with its icons
        switch (type) {
            case ENTITY: {
                GL11.glTranslatef(-0.5f, -0.25f, 0.0f);
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

                GL11.glTranslatef(0.0F, 0.0F, -0.0625F);
                icon = shield.getBackIcon();
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.00390625F);

                if (!item.hasEffect(0)) break;
                BattlegearRenderHelper.renderEnchantmentEffects(tessellator);
                break;
            }
            case EQUIPPED: {
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

                GL11.glTranslatef(0.0F, 0.0F, 0.00390625F);
                icon = shield.getBackIcon();
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.00390625F);

                if (!item.hasEffect(0)) break;
                BattlegearRenderHelper.renderEnchantmentEffects(tessellator);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

                GL11.glTranslatef(0.0F, 0.0F, 0.00390625F);
                icon = shield.getBackIcon();
                ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.00390625F);

                if (!item.hasEffect(0)) break;
                BattlegearRenderHelper.renderEnchantmentEffects(tessellator);
                break;
            }
            case INVENTORY: {
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                itemRenderer.renderIcon(0, 0, icon, 16, 16);  // Render the front side of the shield

                GL11.glDisable(GL11.GL_ALPHA_TEST);
                GL11.glDisable(GL11.GL_BLEND);

                if (!item.hasEffect(0)) break;
                itemRenderer.renderEffect(Minecraft.getMinecraft().getTextureManager(), 0, 0);
                break;
            }
        }

        GL11.glPopMatrix();
    }
}
