package com.franksilantro.mztweaks.shield;

import mods.battlegear2.items.ItemShield;
import mods.battlegear2.api.shield.ShieldType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;

public class MZShieldItems extends ItemShield {
    private IIcon frontIcon;
    private IIcon customBackIcon;
    private IIcon customTrimIcon;

    public MZShieldItems(ShieldType enumShield) {
        super(enumShield);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.frontIcon = iconRegister.registerIcon("mztweaks:shield_" + this.enumShield.getName() + "_front");
        this.customBackIcon = iconRegister.registerIcon("mztweaks:shield_" + this.enumShield.getName() + "_back");
        this.customTrimIcon = iconRegister.registerIcon("mztweaks:shield_" + this.enumShield.getName() + "_trim");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        return (pass == 0) ? this.frontIcon : this.getBackIcon();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int damage) {
        return this.frontIcon;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBackIcon() {
        return this.customBackIcon != null ? this.customBackIcon : this.frontIcon;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getTrimIcon() {
        return this.customTrimIcon != null ? this.customTrimIcon : this.frontIcon;
    }
}
