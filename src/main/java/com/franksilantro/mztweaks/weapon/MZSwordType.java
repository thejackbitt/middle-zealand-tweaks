package com.franksilantro.mztweaks.weapon;

import lotr.common.LOTRCreativeTabs;
import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.IIconRegister;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;     
import net.minecraft.util.ChatComponentText;
import com.franksilantro.mztweaks.client.overlay.MZOverlay;    
import net.minecraft.util.ChatComponentText;    
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import java.util.Random;

public class MZSwordType extends LOTRItemSword {
    public IIcon bigIcon;
    private Map<UUID, Integer> killstreaks = new HashMap<>();


    private static final ResourceLocation[] killstreakSounds = new ResourceLocation[]{
        new ResourceLocation("mztweaks:killstreaksound1"),
        new ResourceLocation("mztweaks:killstreaksound2"),
        new ResourceLocation("mztweaks:killstreaksound3"),
        new ResourceLocation("mztweaks:killstreaksound4"),
        new ResourceLocation("mztweaks:killstreaksound5")
    };

    public MZSwordType() {
        super(Item.ToolMaterial.IRON);
        this.setMaxDamage(1000);
        this.lotrWeaponDamage = 6.0f;
        this.setCreativeTab(LOTRCreativeTabs.tabStory);
    }

    public MZSwordType(LOTRMaterial repairItem, int maxDamage, float weaponDamage) {
        super(repairItem);
        this.setMaxDamage(maxDamage);
        this.lotrWeaponDamage = weaponDamage; 
        this.setCreativeTab(LOTRCreativeTabs.tabStory); 
    }

    public MZSwordType(Item.ToolMaterial repairItem, int maxDamage, float weaponDamage) {
        super(repairItem);
        this.setMaxDamage(maxDamage);
        this.lotrWeaponDamage = weaponDamage; 
        this.setCreativeTab(LOTRCreativeTabs.tabStory); 
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister); 
        String iconPath = "mztweaks:" + this.getUnlocalizedName().substring(5) + ".big"; 
        this.bigIcon = iconRegister.registerIcon(iconPath);
    }


    public void onEntityKill(EntityPlayer player) {
        UUID playerID = player.getUniqueID();
        int streak = killstreaks.getOrDefault(playerID, 0) + 1;
        killstreaks.put(playerID, streak);

        // If kill is a multiple of 5 then do this:
        if (streak % 5 == 0) {
        MZOverlay.triggerKillsteak(streak);
        // player.addChatMessage(new ChatComponentText("Killstreak: " + streak));

        playRandomKillstreakSound(player);
        }
    }

    private void playRandomKillstreakSound(EntityPlayer player) {
        Random rand = new Random();
        ResourceLocation sound = killstreakSounds[rand.nextInt(killstreakSounds.length)];

        // Play sound at player's location
        player.worldObj.playSoundAtEntity(player, sound.toString(), 1.0F, 1.0F);
    }

    public void onPlayerDeath(EntityPlayer player) {
        UUID playerID = player.getUniqueID();
        killstreaks.remove(playerID);
    }

}
