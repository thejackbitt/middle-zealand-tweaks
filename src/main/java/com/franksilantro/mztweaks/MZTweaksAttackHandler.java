package com.franksilantro.mztweaks;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.battlegear2.api.PlayerEventChild;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class MZTweaksAttackHandler {

    public MZTweaksAttackHandler() {}

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onOffhandAttack(PlayerEventChild.OffhandAttackEvent event) {
        // Cancel the event to prevent offhand attacks
        event.setCanceled(true);
    }
}
