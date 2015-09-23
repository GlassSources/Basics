package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandHeal extends BukkitCommand {
    public CommandHeal(String name) {
        super(name);
        this.description = "This will freeze the specified player.";
        this.usageMessage = "Usage: /heal <player>";
        this.setPermission("basics.heal");
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
        double MaxHealth = chosenPlayer.getMaxHealth();
        chosenPlayer.setHealth(MaxHealth);
        sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully healed: " + chosenPlayer.getPlayerListName());
    return true;
}
}
