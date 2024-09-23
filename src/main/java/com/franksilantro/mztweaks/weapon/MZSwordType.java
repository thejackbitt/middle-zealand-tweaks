package com.franksilantro.mztweaks.weapon;

import lotr.common.LOTRCreativeTabs;
import lotr.common.item.LOTRItemSword;
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
        this.setMaxDamage(1500);
        this.lotrWeaponDamage = 12.0f; 
        this.setCreativeTab(LOTRCreativeTabs.tabStory); 
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);  // Call the parent class's registerIcons method
        String iconPath = "mztweaks:" + this.getUnlocalizedName().substring(5) + ".big";  // Ensure it uses your mod domain
        this.bigIcon = iconRegister.registerIcon(iconPath);
    }


    public void onEntityKill(EntityPlayer player) {
        UUID playerID = player.getUniqueID();
        int streak = killstreaks.getOrDefault(playerID, 0) + 1;
        killstreaks.put(playerID, streak);

        // Inform player about their killstreak
        // player.addChatMessage(new ChatComponentText("Killstreak: " + streak));
        MZOverlay.triggerKillsteak(streak);

        // Play a random sound
        playRandomKillstreakSound(player);
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
