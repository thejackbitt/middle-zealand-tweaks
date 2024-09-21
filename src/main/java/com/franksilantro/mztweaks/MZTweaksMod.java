package com.franksilantro.mztweaks;

import com.franksilantro.mztweaks.shield.MZShield;
import com.franksilantro.mztweaks.shield.MZShieldItems;
import com.franksilantro.mztweaks.weapon.MZSwordType;
import com.franksilantro.mztweaks.client.renderer.MZShieldRenderer;
import com.franksilantro.mztweaks.client.renderer.MZSwordRenderer;
import com.franksilantro.mztweaks.events.KillstreakEventHandler;
import lotr.client.render.item.LOTRRenderLargeItem;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.Minecraft;

@Mod(modid = MZTweaksMod.MODID, version = MZTweaksMod.VERSION)
public class MZTweaksMod {
    public static final String MODID = "mztweaks";
    public static final String VERSION = "1.0";
    public static Item edibleTreat;
    public static Item angmarShield;
    public static Item blackrootvaleShield;
    public static Item blackurukShield;
    public static Item bluemountainsShield;
    // NEW!
    public static Item breeShield;
    public static Item corsairShield;
    public static Item daleShield;
    public static Item dolamrothShield;
    public static Item dolguldurShield;
    public static Item dorwinionShield;
    public static Item dorwinionelfShield;
    public static Item dunlandShield;
    public static Item dwarfShield;
    public static Item esgarothShield;
    public static Item galadhrimShield;
    public static Item gondorShield;
    public static Item gulfShield;
    public static Item gundabadShield;
    public static Item halftrollShield;
    public static Item harnedorShield;
    public static Item highelvesShield;
    public static Item lamendonShield;
    public static Item lebeninShield;
    public static Item lossarnachShield;
    public static Item minasmorgulShield;
    public static Item mordorShield;
    public static Item moredainShield;
    public static Item nearharadShield;
    public static Item pelargirShield;
    public static Item pinnathShield;
    public static Item rangerShield;
    public static Item rhunShield;
    public static Item rivendellShield;
    public static Item rohanShield;
    public static Item tauredainShield;
    public static Item umbarShield;
    public static Item urukShield;
    public static Item woodelfShield;
    // Swords
    public static Item bardsbane;
    public static Item braveheart;
    public static Item crucible;
    public static Item mastersword;
    public static Item warhammer40k;

    @EventHandler
public void preInit(FMLPreInitializationEvent event) {
    edibleTreat = new ItemEdibleFood().setCreativeTab(CreativeTabs.tabFood);
    GameRegistry.registerItem(edibleTreat, MODID + "_edibleTreat");

    // Initialize shield items but do NOT manually register them since Battlegear 2 may handle it
    angmarShield = new MZShieldItems(MZShield.ANGMAR).setUnlocalizedName("angmar_shield");
    blackrootvaleShield = new MZShieldItems(MZShield.BLACKROOTVALE).setUnlocalizedName("blackrootvale_shield");
    blackurukShield = new MZShieldItems(MZShield.BLACKURUK).setUnlocalizedName("blackuruk_shield");
    bluemountainsShield = new MZShieldItems(MZShield.BLUEMOUNTAINS).setUnlocalizedName("bluemountains_shield");

    // NEW!
    breeShield = new MZShieldItems(MZShield.BREE).setUnlocalizedName("bree_shield");
    corsairShield = new MZShieldItems(MZShield.CORSAIR).setUnlocalizedName("corsair_shield");
    daleShield = new MZShieldItems(MZShield.DALE).setUnlocalizedName("dale_shield");
    dolamrothShield = new MZShieldItems(MZShield.DOLAMROTH).setUnlocalizedName("dolamroth_shield");
    dolguldurShield = new MZShieldItems(MZShield.DOLGULDUR).setUnlocalizedName("dolguldur_shield");
    dorwinionShield = new MZShieldItems(MZShield.DORWINION).setUnlocalizedName("dorwinion_shield");
    dorwinionelfShield = new MZShieldItems(MZShield.DORWINIONELF).setUnlocalizedName("dorwinionelf_shield");
    dunlandShield = new MZShieldItems(MZShield.DUNLAND).setUnlocalizedName("dunland_shield");
    dwarfShield = new MZShieldItems(MZShield.DWARF).setUnlocalizedName("dwarf_shield");
    esgarothShield = new MZShieldItems(MZShield.ESGAROTH).setUnlocalizedName("esgaroth_shield");
    galadhrimShield = new MZShieldItems(MZShield.GALADHRIM).setUnlocalizedName("galadhrim_shield");
    gondorShield = new MZShieldItems(MZShield.GONDOR).setUnlocalizedName("gondor_shield");
    gulfShield = new MZShieldItems(MZShield.GULF).setUnlocalizedName("gulf_shield");
    gundabadShield = new MZShieldItems(MZShield.GUNDABAD).setUnlocalizedName("gundabad_shield");
    halftrollShield = new MZShieldItems(MZShield.HALFTROLL).setUnlocalizedName("halftroll_shield");
    harnedorShield = new MZShieldItems(MZShield.HARNEDOR).setUnlocalizedName("harnedor_shield");
    highelvesShield = new MZShieldItems(MZShield.HIGHELVES).setUnlocalizedName("highelves_shield");
    lamendonShield = new MZShieldItems(MZShield.LAMENDON).setUnlocalizedName("lamendon_shield");
    lebeninShield = new MZShieldItems(MZShield.LEBENIN).setUnlocalizedName("lebenin_shield");
    lossarnachShield = new MZShieldItems(MZShield.LOSSARNACH).setUnlocalizedName("lossarnach_shield");
    minasmorgulShield = new MZShieldItems(MZShield.MINASMORGUL).setUnlocalizedName("minasmorgul_shield");
    mordorShield = new MZShieldItems(MZShield.MORDOR).setUnlocalizedName("mordor_shield");
    moredainShield = new MZShieldItems(MZShield.MOREDAIN).setUnlocalizedName("moredain_shield");
    nearharadShield = new MZShieldItems(MZShield.NEARHARAD).setUnlocalizedName("nearharad_shield");
    pelargirShield = new MZShieldItems(MZShield.PELARGIR).setUnlocalizedName("pelargir_shield");
    pinnathShield = new MZShieldItems(MZShield.PINNATH).setUnlocalizedName("pinnath_shield");
    rangerShield = new MZShieldItems(MZShield.RANGER).setUnlocalizedName("ranger_shield");
    rhunShield = new MZShieldItems(MZShield.RHUN).setUnlocalizedName("rhun_shield");
    rivendellShield = new MZShieldItems(MZShield.RIVENDELL).setUnlocalizedName("rivendell_shield");
    rohanShield = new MZShieldItems(MZShield.ROHAN).setUnlocalizedName("rohan_shield");
    tauredainShield = new MZShieldItems(MZShield.TAUREDAIN).setUnlocalizedName("tauredain_shield");
    umbarShield = new MZShieldItems(MZShield.UMBAR).setUnlocalizedName("umbar_shield");
    urukShield = new MZShieldItems(MZShield.URUK).setUnlocalizedName("uruk_shield");
    woodelfShield = new MZShieldItems(MZShield.WOODELF).setUnlocalizedName("woodelf_shield");

    // Swords!!!!
    bardsbane = new MZSwordType().setUnlocalizedName("bardsbane").setFull3D().setTextureName("mztweaks:bardsbane");
    GameRegistry.registerItem(bardsbane, MODID + "_bardsbane");
    braveheart = new MZSwordType().setUnlocalizedName("braveheart").setFull3D().setTextureName("mztweaks:braveheart");
    GameRegistry.registerItem(braveheart, MODID + "_braveheart");
    crucible = new MZSwordType().setUnlocalizedName("crucible").setFull3D().setTextureName("mztweaks:crucible");
    GameRegistry.registerItem(crucible, MODID + "_crucible");
    mastersword = new MZSwordType().setUnlocalizedName("mastersword").setFull3D().setTextureName("mztweaks:mastersword");
    GameRegistry.registerItem(mastersword, MODID + "_mastersword");
    warhammer40k = new MZSwordType().setUnlocalizedName("warhammer40k").setFull3D().setTextureName("mztweaks:warhammer40k");
    GameRegistry.registerItem(warhammer40k, MODID + "_warhammer40k");

}


    @EventHandler
    public void init(FMLInitializationEvent event) {
    MZTweaksRecipes.registerRecipes();

    // Register custom shield renderer for all MZ shields
    MinecraftForgeClient.registerItemRenderer((MZShieldItems) angmarShield, new MZShieldRenderer());
    MinecraftForgeClient.registerItemRenderer((MZShieldItems) blackrootvaleShield, new MZShieldRenderer());
    MinecraftForgeClient.registerItemRenderer((MZShieldItems) blackurukShield, new MZShieldRenderer());
    MinecraftForgeClient.registerItemRenderer((MZShieldItems) bluemountainsShield, new MZShieldRenderer());

    // New...
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

    MinecraftForgeClient.registerItemRenderer(bardsbane, new MZSwordRenderer());
    MinecraftForgeClient.registerItemRenderer(braveheart, new MZSwordRenderer());
    MinecraftForgeClient.registerItemRenderer(crucible, new MZSwordRenderer());
    MinecraftForgeClient.registerItemRenderer(mastersword, new MZSwordRenderer());
    MinecraftForgeClient.registerItemRenderer(warhammer40k, new MZSwordRenderer());

    MinecraftForge.EVENT_BUS.register(new KillstreakEventHandler(new MZSwordType()));

    SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
    }
}