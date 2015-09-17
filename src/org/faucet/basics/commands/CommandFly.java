package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class CommandFly extends BukkitCommand {
    public CommandFly(String name) {
        super(name);
        this.description = "This will set if the specified player is flying.";
        this.usageMessage = "Usage: /fly <flyvalue> <player>";
        this.setPermission("basics.fly");
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }
        if (args.length > 2) {
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        if(args.length < 2){
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        Player chosenPlayer = Bukkit.getPlayer(args[1]);
        if(chosenPlayer == null){
            sender.sendMessage(ChatColor.RED + "[Basics] The player specified cannot be found.");
            return true;
        }
        String mode1 = "TRUE";
        String mode3 = "FALSE";
        if(args[0].equalsIgnoreCase(mode1)){
            chosenPlayer.setAllowFlight(true);
            chosenPlayer.setFlying(true);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s fly mode to TRUE.");
            return true;
        }
        if(args[0].equalsIgnoreCase(mode3)){
            chosenPlayer.setAllowFlight(false);
            chosenPlayer.setFlying(false);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s fly mode to FALSE.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "[Basics] Basics couldn't recongize that. Please try again.");
        sender.sendMessage(ChatColor.GREEN + "[Basics] Only TRUE mode or FALSE mode is implemented.");
    return true;
}
}
