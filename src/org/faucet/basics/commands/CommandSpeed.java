package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class CommandSpeed extends BukkitCommand {
    public CommandSpeed(String name) {
        super(name);
        this.description = "This will set the specified player's walkspeed.";
        this.usageMessage = "Usage: /speed <type> <speed> <player>";
        this.setPermission("basics.speed");
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }
        if (args.length > 3) {
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        if(args.length < 3){
            sender.sendMessage(ChatColor.RED + this.getUsage());
            return true;
        }
        double compare = Double.parseDouble(args[1]);
        double compare2 =  1.0;
        if(compare > compare2){
            sender.sendMessage(ChatColor.RED + "[Basics] The maximum speed is 1.");
            return true;
        }
        Player chosenPlayer = Bukkit.getPlayer(args[2]);
        if(chosenPlayer == null){
            sender.sendMessage(ChatColor.RED + "[Basics] The player specified cannot be found.");
            return true;
        }
        String mode1 = "WALK";
        String mode3 = "FLY";
        if(args[0].equalsIgnoreCase(mode1)){
            double speed = Double.parseDouble(args[1]);
            float speedFloat = (float) speed;
            chosenPlayer.setWalkSpeed(speedFloat);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s walkspeed.");
            return true;
        }
        if(args[0].equalsIgnoreCase(mode3)){
            double speed = Double.parseDouble(args[1]);
            float speedFloat = (float) speed;
            chosenPlayer.setFlySpeed(speedFloat);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s flyspeed.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "[Basics] Basics couldn't recongize that. Please try again.");
        sender.sendMessage(ChatColor.GREEN + "[Basics] Only WALK mode or FLY mode is implemented.");
    return true;
}
}
