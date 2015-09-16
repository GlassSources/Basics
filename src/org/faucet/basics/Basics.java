package org.faucet.basics;

import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.faucet.basics.commands.CommandWindowsUpgrade;

public class Basics extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Basics " + DataResources.VERSION + " is ready to be coded!");
        ((CraftServer) this.getServer()).getCommandMap().register("windows10upgrade", new CommandWindowsUpgrade("windows10upgrade"));
    }
    @Override
    public void onDisable(){
        getLogger().info("Basics " + DataResources.VERSION + " is shutting down.");
    }
}
