package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;


public class CommandWorkbench extends BukkitCommand {
    public CommandWorkbench(String name) {
        super(name);
        this.description = "This will open the workbench gui to the specified player.";
        this.usageMessage = "Usage: /workbench <player>";
        this.setPermission("basics.workbench");
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
        chosenPlayer.openWorkbench(chosenPlayerLocation, true);
        sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully opened workbench to: " + chosenPlayer.getPlayerListName());
    return true;
}
}
