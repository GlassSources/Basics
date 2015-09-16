package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

public class CommandWindowsUpgrade extends BukkitCommand {
    public CommandWindowsUpgrade(String name){
        super(name);
        this.description = "Upgrade your PC to Microsoft Windows 10. (joke command)";
        this.usageMessage = "Usage: /windows10upgrade";
        this.setPermission("basics.windowsupdate");
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
        sender.sendMessage(ChatColor.RED + "Sorry, but you cannot upgrade to Windows 10 via Minecraft.");
        sender.sendMessage(ChatColor.GREEN + "Why would you think that anyway?");
        return true;
    }
}
