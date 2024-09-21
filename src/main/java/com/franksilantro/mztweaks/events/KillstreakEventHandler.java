package com.franksilantro.mztweaks.events;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import com.franksilantro.mztweaks.weapon.MZSwordType;

public class KillstreakEventHandler {
    
    private MZSwordType customWeapon;

    public KillstreakEventHandler(MZSwordType weapon) {
        this.customWeapon = weapon;
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent event) {
        if (event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getEntity();
            if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof MZSwordType) {
                customWeapon.onEntityKill(player);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        // Check if the entity that died is a player
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            // Reset the player's killstreak upon death
            customWeapon.onPlayerDeath(player);
        }
    }
}
