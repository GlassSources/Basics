package org.faucet.basics;

import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.faucet.basics.commands.*;

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
        getLogger().info("Checking for updates...");
        String latestVersion;
        try {
            int id = 12359;
            HttpURLConnection con = (HttpURLConnection) new URL("http://www.spigotmc.org/api/general.php").openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream().write(
                    ("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + id).getBytes("UTF-8"));
            latestVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
        } catch (Exception e) {
            getLogger().info("Basics encountered a error when searching for updates.");
            latestVersion = "null";
        }
        if(latestVersion.equals(this.getDescription().getVersion())){
            getLogger().info("Basics has successfully checked for updates and is up to date!");
        }
        if(!latestVersion.equals(this.getDescription().getVersion())){
            getLogger().info("Basics isn't up to date! Version " + latestVersion + " is available! Please update!");
        }
    }
    @Override
    public void onDisable(){
        getLogger().info("Basics " + DataResources.VERSION + " is shutting down.");
    }
}
