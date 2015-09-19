package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandSpawn extends BukkitCommand {
    public CommandSpawn(String name) {
        super(name);
        this.description = "This will spawn the specified mob to the sender of the command.";
        this.usageMessage = "Usage: /spawnmob <mob>";
        this.setPermission("basics.spawnmob");
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        if(args.length < 1){
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        Player chosenPlayer = (Player) sender;
        String chosenPlayerWorld = chosenPlayer.getWorld().getName();
        String mobParameters =  args[0];
        Location chosenPlayerLocation = chosenPlayer.getLocation();
        if(mobParameters.equalsIgnoreCase("ZOMBIE")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.ZOMBIE);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: ZOMBIE to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("SKELETON")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.SKELETON);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: SKELETON to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("WITHER")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.WITHER);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: WITHER to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("BLAZE")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.BLAZE);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: BLAZE to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("ENDER DRAGON")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.ENDER_DRAGON);
            String entityName = "ENDER DRAGON";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("PIG_ZOMBIE")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.PIG_ZOMBIE);
            String entityName = "PIG ZOMBIE";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("GHAST")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.GHAST);
            String entityName = "GHAST";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("ARMOR_STAND")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.ARMOR_STAND);
            String entityName = "ARMOR STAND";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("CREEPER")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.CREEPER);
            String entityName = "CREEPER";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("CHICKEN")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.CHICKEN);
            String entityName = "CHICKEN";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("COW")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.COW);
            String entityName = "COW";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("CAVE_SPIDER")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.CAVE_SPIDER);
            String entityName = "CAVE SPIDER";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        if(mobParameters.equalsIgnoreCase("SPIDER")){
            Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.SPIDER);
            String entityName = "SPIDER";
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully spawned a: " + entityName + "to the world!");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "[Basics] Sorry, that wasn't recongized. Try again.");
    return true;
}
}
