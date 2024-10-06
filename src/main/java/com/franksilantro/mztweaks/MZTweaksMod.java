package com.franksilantro.mztweaks;

import com.franksilantro.mztweaks.proxy.CommonProxy;
import com.franksilantro.mztweaks.shield.MZShield;
import com.franksilantro.mztweaks.shield.MZShieldItems;
import com.franksilantro.mztweaks.weapon.MZSwordType;
import lotr.client.render.item.LOTRRenderLargeItem;
import lotr.common.LOTRMod;
import lotr.common.item.LOTRMaterial;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = MZTweaksMod.MODID, version = MZTweaksMod.VERSION)
public class MZTweaksMod {
    public static final String MODID = "mztweaks";
    public static final String VERSION = "1.0";
    public static Item edibleTreat;

    public static Item angmarShield, blackrootvaleShield, blackurukShield, bluemountainsShield;
    public static Item breeShield, corsairShield, daleShield, dolamrothShield, dolguldurShield, dorwinionShield, dorwinionelfShield;
    public static Item dunlandShield, dwarfShield, esgarothShield, galadhrimShield, gondorShield, gulfShield, gundabadShield;
    public static Item halftrollShield, harnedorShield, highelvesShield, lamendonShield, lebeninShield, lossarnachShield;
    public static Item minasmorgulShield, mordorShield, moredainShield, nearharadShield, pelargirShield, pinnathShield;
    public static Item rangerShield, rhunShield, rivendellShield, rohanShield, tauredainShield, umbarShield, urukShield, woodelfShield;

    public static Item bardsbane, braveheart, crucible, mastersword, warhammer40k;

    @SidedProxy(clientSide = "com.franksilantro.mztweaks.client.ClientProxy", serverSide = "com.franksilantro.mztweaks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Register edible treat item
        edibleTreat = new ItemEdibleFood().setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(edibleTreat, MODID + "_edibleTreat");

        // Initialize shields without manual registration
        angmarShield = new MZShieldItems(MZShield.ANGMAR).setUnlocalizedName("angmar_shield");
        blackrootvaleShield = new MZShieldItems(MZShield.BLACKROOTVALE).setUnlocalizedName("blackrootvale_shield");
        blackurukShield = new MZShieldItems(MZShield.BLACKURUK).setUnlocalizedName("blackuruk_shield");
        bluemountainsShield = new MZShieldItems(MZShield.BLUEMOUNTAINS).setUnlocalizedName("bluemountains_shield");

        // Initialize other shields (newly added shields)
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

        // Register swords
        bardsbane = new MZSwordType(LOTRMaterial.GALVORN, 3000, 12.0f).setUnlocalizedName("bardsbane").setFull3D().setTextureName("mztweaks:bardsbane");
        GameRegistry.registerItem(bardsbane, MODID + "_bardsbane");
        braveheart = new MZSwordType(Item.ToolMaterial.IRON, 1500, 7.5f).setUnlocalizedName("braveheart").setFull3D().setTextureName("mztweaks:braveheart");
        GameRegistry.registerItem(braveheart, MODID + "_braveheart");
        crucible = new MZSwordType(LOTRMaterial.GALVORN, 7777, 15.0f).setUnlocalizedName("crucible").setFull3D().setTextureName("mztweaks:crucible");
        GameRegistry.registerItem(crucible, MODID + "_crucible");
        mastersword = new MZSwordType(LOTRMaterial.HIGH_ELVEN, 3000, 10.0f).setUnlocalizedName("mastersword").setFull3D().setTextureName("mztweaks:mastersword");
        GameRegistry.registerItem(mastersword, MODID + "_mastersword");
        warhammer40k = new MZSwordType(LOTRMaterial.DWARVEN, 1500, 8.0f).setUnlocalizedName("warhammer40k").setFull3D().setTextureName("mztweaks:warhammer40k");
        GameRegistry.registerItem(warhammer40k, MODID + "_warhammer40k");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MZTweaksRecipes.registerRecipes();

        proxy.registerRenderers();
    }
}
