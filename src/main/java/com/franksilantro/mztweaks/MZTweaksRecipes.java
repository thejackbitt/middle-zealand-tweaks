package com.franksilantro.mztweaks;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.battlegear2.items.ItemShield;
import mods.battlegear2.api.shield.ShieldType;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mods.battlegear2.Battlegear;
import mods.battlegear2.utils.BattlegearConfig;
import lotr.common.LOTRConfig;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockFallenLeaves;
import lotr.common.block.LOTRBlockLeavesBase;
import lotr.common.block.LOTRBlockTreasurePile;
import lotr.common.item.LOTRItemBanner;
import lotr.common.recipe.LOTRRecipes;
import mods.battlegear2.Battlegear;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

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

        // For reference, here are the Battlegear 2 Shield indices :
        // 0 = Wood
        // 1 = Hide
        // 2 = Iron
        // 3 = Diamond
        // 4 = Gold

        // Additionally, here are the LOTR Banner codes:
        // Mordor = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.MORDOR.bannerID)
        // Minas Morgul = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.MINAS_MORGUL.bannerID)
        // Black Uruk = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACK_URUK.bannerID)
        // Nan Ungol = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.NAN_UNGOL.bannerID)
        // Galadhrim = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.GALADHRIM.bannerID)
        // Dwarf = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DWARF.bannerID)
        // Isengard = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.ISENGARD.bannerID)
        // Wood Elf = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.WOOD_ELF.bannerID)
        // Gondor = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR.bannerID)
        // Anorien = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.ANORIEN.bannerID)
        // Lossarnach = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.LOSSARNACH.bannerID)
        // Pinnath Gelin = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.PINNATH_GELIN.bannerID)
        // Lebennin = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.LEBENNIN.bannerID)
        // Pelargir = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.PELARGIR.bannerID)
        // Blackroot Vale = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACKROOT_VALE.bannerID)
        // Lamedon = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.LAMEDON.bannerID)
        // Gondor Steward = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR_STEWARD.bannerID)
        // Rohan = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.ROHAN.bannerID)
        // Dunland = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DUNLAND.bannerID)
        // Angmar = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.ANGMAR.bannerID)
        // Rhudar = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUDAUR.bannerID)
        // Near Harad = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.NEAR_HARAD.bannerID)
        // Harad Nomad = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_NOMAD.bannerID)
        // High Elf = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.HIGH_ELF.bannerID)
        // Blue Mountains = (new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLUE_MOUNTAINS.bannerID)
        // Rangers of the North = (new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RANGER_NORTH.bannerID)
        // Dol Guldur = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_GULDUR.bannerID)
        // Gundabad = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.GUNDABAD.bannerID)
        // Half Troll = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.HALF_TROLL.bannerID)
        // Dol Amroth = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_AMROTH.bannerID)
        // Moredain = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.MOREDAIN.bannerID)
        // Tauredain = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.TAUREDAIN.bannerID)
        // Dale = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DALE.bannerID)
        // Esgaroth = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.ESGAROTH.bannerID)
        // Dorwinion = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.DORWINION.bannerID)
        // Hobbit = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.HOBBIT.bannerID)
        // Rhun = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUN.bannerID)
        // Rivendell = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.RIVENDELL.bannerID)
        // Umbar = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.UMBAR.bannerID)
        // Harad Gulf = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_GULF.bannerID)
        // Bree = (LOTRMod.banner, 1, LOTRItemBanner.BannerType.BREE.bannerID)

        // Okay, my CTRL, C and V keys are destroyed now... thanks, Mevans...

        LOTRRecipes.urukRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.blackurukShield),
            new Object[] {
                " X ", "XSX", "X X",
                Character.valueOf('X'), LOTRMod.blackUrukSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.blackrootvaleShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACKROOT_VALE.bannerID),
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.gondorShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR.bannerID),
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.pelargirShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.PELARGIR.bannerID),
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.nearharadShield),
            new Object[] {
                " B ", "XSX", " X ",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.NEAR_HARAD.bannerID),
                Character.valueOf('X'), new ItemStack(Items.dye, 1, 11),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.tauredainRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.tauredainShield),
            new Object[] {
                " X ", "XSX", "FFF",
                Character.valueOf('X'), Items.gold_ingot,
                Character.valueOf('F'), Items.feather,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[0])
            }
        ));

        LOTRRecipes.blueMountainsRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.bluemountainsShield),
            new Object[] {
                "XXX", "XSX", "XXX",
                Character.valueOf('X'), LOTRMod.blueDwarfSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.umbarRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.umbarShield),
            new Object[] {
                "XBX", "XSX", "XIX",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.UMBAR.bannerID),
                Character.valueOf('X'), Items.gold_nugget,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2]),
                Character.valueOf('I'), Items.iron_ingot
            }
        ));

        LOTRRecipes.dolGuldurRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dolguldurShield),
            new Object[] {
                "XBX", "XSX", " X ",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_GULDUR.bannerID),
                Character.valueOf('X'), LOTRMod.orcSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.rhunShield),
            new Object[] {
                "X X", "XSX", "X X",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUN.bannerID),
                Character.valueOf('X'), Items.leather,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.minasmorgulShield),
            new Object[] {
                "X X", "XSX", "X X",
                Character.valueOf('X'), LOTRMod.morgulSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.umbarRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.corsairShield),
            new Object[] {
                " X ", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.bronze,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.rangerRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.rangerShield),
            new Object[] {
                "XLX", "XSX", "XLX",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('L'), Items.leather,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.halfTrollRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.halftrollShield),
            new Object[] {
                " X ", "LSL", " L ",
                Character.valueOf('X'), LOTRMod.bodyHalfTroll,
                Character.valueOf('L'), Items.leather,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.highelvesShield),
            new Object[] {
                "XBX", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.elfSteel,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HIGH_ELF.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.lebeninShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.LEBENNIN.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.lossarnachShield),
            new Object[] {
                "GRW", "GSW", "WGW",
                Character.valueOf('G'), "dyeGreen",
                Character.valueOf('W'), "dyeWhite",
                Character.valueOf('R'), new ItemStack(Items.dye, 1, 1),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.pinnathShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.PINNATH_GELIN.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.daleRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.esgarothShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.gold_nugget,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ESGAROTH.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.dorwinionRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dorwinionShield),
            new Object[] {
                "XBX", "XSX", "XIX",
                Character.valueOf('X'), Items.gold_nugget,
                Character.valueOf('I'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(Items.dye, 1, 5),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.gulfRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.gulfShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), LOTRMod.bronze,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_GULF.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.rohirricRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.rohanShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.gold_nugget,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.ROHAN.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.woodElvenRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.woodelfShield),
            new Object[] {
                "XXX", "XSX", " W ",
                Character.valueOf('X'), LOTRMod.elfSteel,
                Character.valueOf('W'), new ItemStack(LOTRMod.wood, 1, 2),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.breeRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.breeShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.gold_nugget,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BREE.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[0])
            }
        ));

        LOTRRecipes.gundabadRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.gundabadShield),
            new Object[] {
                " B ", " S ", "   ",
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GUNDABAD.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[0])
            }
        ));

        LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.lamendonShield),
            new Object[] {
                "DBX", " S ", "X D",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.LAMEDON.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1]),
                Character.valueOf('D'), "dyeBlue"
            }
        ));

        LOTRRecipes.dorwinionRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dorwinionelfShield),
            new Object[] {
                "XXX", "NSN", "NXN",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('N'), Items.gold_nugget,
                Character.valueOf('S'), MZTweaksMod.dorwinionShield
            }
        ));

        LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.mordorShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), LOTRMod.orcSteel,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MORDOR.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.harnedorShield),
            new Object[] {
                "NXN", "NSN", "NXN",
                Character.valueOf('N'), Items.gold_nugget,
                Character.valueOf('X'), Items.gold_ingot,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dwarfShield),
            new Object[] {
                " X ", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.dwarfSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.daleRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.daleShield),
            new Object[] {
                "XBX", "NSN", "XNX",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('N'), Items.gold_nugget,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DALE.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.rivendellRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.rivendellShield),
            new Object[] {
                "XBX", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.elfSteel,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RIVENDELL.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.urukRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.urukShield),
            new Object[] {
                "XXX", "XSX", "X X",
                Character.valueOf('X'), LOTRMod.urukSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.angmarRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.angmarShield),
            new Object[] {
                "XXX", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.orcSteel,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.moredainRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.moredainShield),
            new Object[] {
                " L ", " S ", " L ",
                Character.valueOf('L'), Items.leather,
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[1])
            }
        ));

        LOTRRecipes.elvenRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.galadhrimShield),
            new Object[] {
                "XBX", "XSX", " X ",
                Character.valueOf('X'), LOTRMod.elfSteel,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GALADHRIM.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.dolAmrothRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dolamrothShield),
            new Object[] {
                "XBX", "XSX", " X ",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DOL_AMROTH.bannerID),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[2])
            }
        ));

        LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(
            new ItemStack(MZTweaksMod.dunlandShield),
            new Object[] {
                "XBX", "XSX", "XXX",
                Character.valueOf('X'), Items.iron_ingot,
                Character.valueOf('B'), new ItemStack(Blocks.planks, 1, 0),
                Character.valueOf('S'), new ItemStack((Item) BattlegearConfig.shield[0])
            }
        ));

        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.braveheart), 
           "  I", 
            " L ",
            "S  ",
            'I', Items.iron_ingot,
            'L', Items.leather,
            'S', LOTRMod.swordGondor
        );

        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.bardsbane), 
        " GI", 
         "GIG",
         "SG ",
         'I', Items.string,
         'G', LOTRMod.galvorn,
         'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.warhammer40k), 
        " DD", 
         " HD",
         "S  ",
         'D', LOTRMod.dwarfSteel,
         'H', LOTRMod.hammerDwarven,
         'S', Items.stick
        );

        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.crucible), 
        "DPD", 
         " G ",
         " B ",
         'P', LOTRMod.balrogFire,
         'D', LOTRMod.nauriteGem,
         'G', LOTRMod.galvorn,
         'B', Items.lava_bucket
        );

        GameRegistry.addRecipe(new ItemStack(MZTweaksMod.mastersword), 
        "  M", 
         "XE ",
         "SX ",
         'M', LOTRMod.mithril,
         'E', LOTRMod.quenditeCrystal,
         'X', LOTRMod.elfSteel,
         'S', LOTRMod.swordDorwinionElf
        );
    }

    
}
