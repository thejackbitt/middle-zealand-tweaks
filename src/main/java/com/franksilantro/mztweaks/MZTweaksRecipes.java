package com.franksilantro.mztweaks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MZTweaksRecipes {

    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.edibleTreat), 
           "GE ", 
            "DS ",
            "   ",
            'G', Items.glowstone_dust,
            'E', Items.egg,  
            'D', new ItemStack(Items.dye, 1, 3), 
            'S', Items.sugar
        );
    }
}
