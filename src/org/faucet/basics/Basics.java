package org.faucet.basics;

import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.faucet.basics.api.Updater;
import org.faucet.basics.commands.*;
import org.faucet.drip.plugin.SpigotPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        ((CraftServer) this.getServer()).getCommandMap().register("spawnmob", new CommandSpawn("spawnmob"));
        ((CraftServer) this.getServer()).getCommandMap().register("lightning", new CommandLightning("lightning"));
        ((CraftServer) this.getServer()).getCommandMap().register("teleport", new CommandTeleport("teleport"));
        ((CraftServer) this.getServer()).getCommandMap().register("tp", new CommandTP("tp"));
        ((CraftServer) this.getServer()).getCommandMap().register("heal", new CommandHeal("heal"));
        ((CraftServer) this.getServer()).getCommandMap().register("workbench", new CommandWorkbench("workbench"));
        ((CraftServer) this.getServer()).getCommandMap().register("time", new CommandTime("time"));
        getLogger().info("Checking for updates...");
        Updater updater = new Updater(this, 95176, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false);
        Updater.UpdateResult shouldUpdate = updater.getResult();
        switch(shouldUpdate)
        {
            case SUCCESS:
                break;
            case NO_UPDATE:
                getLogger().info("Basics is at the latest version at: " + this.getDescription().getVersion());
                break;
            case DISABLED:
                getLogger().info("Basics couldn't check for updates due to the configuration disabling it.");
                break;
            case FAIL_DBO:
                getLogger().info("Basics couldn't contact dev.bukkit.org, somehow..");
                break;
            case FAIL_NOVERSION:
                getLogger().info("Please report this error as FAIL_NOVERSION to FaucetTeam immediately.");
                break;
            case FAIL_BADID:
                getLogger().info("Please report this error as FAIL_BADID to FaucetTeam immediately.");
                break;
            case FAIL_APIKEY:
                getLogger().info("Please report this as INVALIDAPIKEY.");
                break;
            case UPDATE_AVAILABLE:
               getLogger().info("Basics found a update! " + updater.getLatestName() + " is now available.");
                break;
        }
    }
    @Override
    public void onDisable(){
        getLogger().info("Basics " + DataResources.VERSION + " is shutting down.");
    }
}
