package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandLightning extends BukkitCommand {
    public CommandLightning(String name) {
        super(name);
        this.description = "This will freeze the specified player.";
        this.usageMessage = "Usage: /lightning <player>";
        this.setPermission("basics.lightning");
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
        Player chosenPlayer = Bukkit.getPlayer(args[0]);
        if(chosenPlayer == null){
            sender.sendMessage(ChatColor.RED + "[Basics] The player specified cannot be found.");
            return true;
        }
        Location chosenPlayerLocation = chosenPlayer.getLocation();
        String chosenPlayerWorld = chosenPlayer.getWorld().getName();
        Bukkit.getServer().getWorld(chosenPlayerWorld).spawnEntity(chosenPlayerLocation, EntityType.LIGHTNING);
        sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully sent a lightning strike to: " + chosenPlayer.getPlayerListName());
    return true;
}
}
