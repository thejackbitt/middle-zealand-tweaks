package com.franksilantro.mztweaks.client.renderer;

import mods.battlegear2.client.utils.BattlegearRenderHelper;
import com.franksilantro.mztweaks.weapon.MZSwordType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class MZSwordRenderer implements IItemRenderer {
    private final RenderItem itemRenderer = new RenderItem();

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return item != null && item.getItem() instanceof MZSwordType &&  // Updated type check
               (type == IItemRenderer.ItemRenderType.INVENTORY || 
                type == IItemRenderer.ItemRenderType.EQUIPPED || 
                type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
    }

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        IIcon icon = item.getIconIndex();  // Retrieve the icon of the sword
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.instance;

        // Handle EQUIPPED or FIRST_PERSON rendering types with translations and scaling
        if (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
                GL11.glTranslatef(1.4F, -0.35F, 0.0F);
                // GL11.glTranslatef(0.0F, 0.0F, 0.0F);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                GL11.glScalef(2.0F, 2.0F, 1.0F);  // Adjust the scaling for the equipped view
                icon = ((MZSwordType) item.getItem()).bigIcon;

            // Render the item using the ItemRenderer method
            ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

            if (item.hasEffect(0)) {
                BattlegearRenderHelper.renderEnchantmentEffects(tessellator);
            }
        }

        // Handle INVENTORY rendering
        else if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            this.itemRenderer.renderIcon(0, 0, icon, 16, 16);  // Render the icon in the inventory

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDisable(GL11.GL_BLEND);

            if (item.hasEffect(0)) {
                this.itemRenderer.renderEffect(Minecraft.getMinecraft().getTextureManager(), 0, 0);
            }
        }

        GL11.glPopMatrix();
    }
}
