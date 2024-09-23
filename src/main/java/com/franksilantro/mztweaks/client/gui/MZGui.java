package com.franksilantro.mztweaks.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent.OverlayType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import com.franksilantro.mztweaks.client.overlay.MZOverlay;

public class MZGui extends Gui {
    private Minecraft mc;

    public MZGui(Minecraft mc) {
        super();
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
            MZOverlay.renderKillsteak(this.mc);
    }
}
