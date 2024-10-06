package com.franksilantro.mztweaks.client;

import com.franksilantro.mztweaks.client.gui.MZGui;
import com.franksilantro.mztweaks.client.renderer.MZShieldRenderer;
import com.franksilantro.mztweaks.client.renderer.MZSwordRenderer;
import com.franksilantro.mztweaks.events.KillstreakEventHandler;
import com.franksilantro.mztweaks.proxy.CommonProxy;
import com.franksilantro.mztweaks.shield.MZShieldItems;
import com.franksilantro.mztweaks.weapon.MZSwordType;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;

import static com.franksilantro.mztweaks.MZTweaksMod.*;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        // Register custom shield renderer for all MZ shields
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) angmarShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) blackrootvaleShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) blackurukShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) bluemountainsShield, new MZShieldRenderer());

        // Register other shields (newly added)
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) breeShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) corsairShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) daleShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dolamrothShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dolguldurShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dorwinionShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dorwinionelfShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dunlandShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) dwarfShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) esgarothShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) galadhrimShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) gondorShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) gulfShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) gundabadShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) halftrollShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) harnedorShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) highelvesShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) lamendonShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) lebeninShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) lossarnachShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) minasmorgulShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) mordorShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) moredainShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) nearharadShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) pelargirShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) pinnathShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) rangerShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) rhunShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) rivendellShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) rohanShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) tauredainShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) umbarShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) urukShield, new MZShieldRenderer());
        MinecraftForgeClient.registerItemRenderer((MZShieldItems) woodelfShield, new MZShieldRenderer());

        // Register swords
        MinecraftForgeClient.registerItemRenderer(bardsbane, new MZSwordRenderer());
        MinecraftForgeClient.registerItemRenderer(braveheart, new MZSwordRenderer());
        MinecraftForgeClient.registerItemRenderer(crucible, new MZSwordRenderer());
        MinecraftForgeClient.registerItemRenderer(mastersword, new MZSwordRenderer());
        MinecraftForgeClient.registerItemRenderer(warhammer40k, new MZSwordRenderer());

        // Register GUI and other client-side event handlers
        MinecraftForge.EVENT_BUS.register(new MZGui(Minecraft.getMinecraft()));
        MinecraftForge.EVENT_BUS.register(new KillstreakEventHandler(new MZSwordType()));
        SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
    }
}
