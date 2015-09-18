package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.Collection;

public class
        CommandFreeze extends BukkitCommand {
    public CommandFreeze(String name) {
        super(name);
        this.description = "This will freeze the specified player.";
        this.usageMessage = "Usage: /freeze <player>";
        this.setPermission("basics.freeze");
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
        float speed = (float) 0;
        chosenPlayer.setWalkSpeed(speed);
        chosenPlayer.setFlySpeed(speed);
        sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has successfully frozen: " + chosenPlayer.getPlayerListName());
    return true;
}
}
