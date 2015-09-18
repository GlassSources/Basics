package org.faucet.basics;

import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.faucet.basics.api.SpigotUpdater;
import org.faucet.basics.commands.*;

import java.io.IOException;

public class Basics extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Basics " + DataResources.VERSION + " is loaded!");
        ((CraftServer) this.getServer()).getCommandMap().register("windows10upgrade", new CommandWindowsUpgrade("windows10upgrade"));
        ((CraftServer) this.getServer()).getCommandMap().register("speed", new CommandSpeed("speed"));
        ((CraftServer) this.getServer()).getCommandMap().register("fly", new CommandFly("fly"));
        ((CraftServer) this.getServer()).getCommandMap().register("gamemode", new CommandGamemode("gamemode"));
        ((CraftServer) this.getServer()).getCommandMap().register("gm", new CommandGM("gm"));
        ((CraftServer) this.getServer()).getCommandMap().register("broadcast", new CommandBroadcast("broadcast"));
        ((CraftServer) this.getServer()).getCommandMap().register("freeze", new CommandFreeze("freeze"));
        ((CraftServer) this.getServer()).getCommandMap().register("unfreeze", new CommandUnFreeze("unfreeze"));
        try {
            SpigotUpdater spigotUpdater = new SpigotUpdater(this, 12359);
        }catch(IOException e){
            getLogger().info("Basics couldn't find any updates due to a error.");
        }
    }
    @Override
    public void onDisable(){
        getLogger().info("Basics " + DataResources.VERSION + " is shutting down.");
    }
}
