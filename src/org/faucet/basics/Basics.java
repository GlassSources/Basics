package org.faucet.basics;

import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.faucet.basics.commands.*;

public class Basics extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Basics " + DataResources.VERSION + " is ready to be coded!");
        ((CraftServer) this.getServer()).getCommandMap().register("windows10upgrade", new CommandWindowsUpgrade("windows10upgrade"));
        ((CraftServer) this.getServer()).getCommandMap().register("speed", new CommandSpeed("speed"));
        ((CraftServer) this.getServer()).getCommandMap().register("fly", new CommandFly("fly"));
        ((CraftServer) this.getServer()).getCommandMap().register("gamemode", new CommandGamemode("gamemode"));
        ((CraftServer) this.getServer()).getCommandMap().register("gm", new CommandGM("gm"));
        ((CraftServer) this.getServer()).getCommandMap().register("broadcast", new CommandBroadcast("broadcast"));
    }
    @Override
    public void onDisable(){
        getLogger().info("Basics " + DataResources.VERSION + " is shutting down.");
    }
}
