package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;


public class CommandTime extends BukkitCommand {
    public CommandTime(String name) {
        super(name);
        this.description = "This will set the world that the sender is in's time.";
        this.usageMessage = "Usage: /time <time>";
        this.setPermission("basics.time");
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
        if(args[0] == null || args[0] == ""){
            sender.sendMessage(ChatColor.RED + this.getUsage());
        }
        String arguments = args[0];
        Player senderPlayer = (Player) sender;
        String worldName = senderPlayer.getWorld().getName();
        long value = Long.parseLong(args[0]);
        Bukkit.getWorld(worldName).setTime(value);
        sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully set the time.");
    return true;
}
}
