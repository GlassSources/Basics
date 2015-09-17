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
        Player chosenPlayer = null;
        try{
            chosenPlayer = Bukkit.getPlayer(args[3]);
        }catch(NullPointerException e){
            sender.sendMessage(ChatColor.RED + "[Basics] Player specified was not found.");
            return true;
        }
        String mode1 = "WALK";
        String mode3 = "FLY";
        if(args[2].equalsIgnoreCase(mode1)){
            int speed = Integer.parseInt(args[3]);
            chosenPlayer.setWalkSpeed(speed);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just attempted to set the specified player's walkspeed.");
            return true;
        }
        if(args[2].equalsIgnoreCase(mode3)){
            int speed = Integer.parseInt(args[3]);
            chosenPlayer.setFlySpeed(speed);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just attempted to set the specified player's walkspeed.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "[Basics] Basics couldn't recongize that. Please try again.");
        sender.sendMessage(ChatColor.GREEN + "[Basics] Only WALK mode or FLY mode is implemented.");
    return true;
}
}
