package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class CommandBroadcast extends BukkitCommand {
    public CommandBroadcast(String name) {
        super(name);
        this.description = "This will send a public broadcast to the whole serve.r";
        this.usageMessage = "Usage: /broadcast <message>";
        this.setPermission("basics.broadcast");
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
        if(args[0] == null){
            sender.sendMessage(ChatColor.RED + "[Basics] Basics couldn't process that. Please try again.");
            return true;
        }else{
            Bukkit.broadcastMessage(ChatColor.GREEN + "[BasicsBroadcast] " + args[0]);
            return true;
        }
}
}
