package org.faucet.basics.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class CommandGamemode extends BukkitCommand {
    public CommandGamemode(String name) {
        super(name);
        this.description = "This will set the GameMode of the specified player.";
        this.usageMessage = "Usage: /gamemode <gamemode> <player>";
        this.setPermission("basics.gamemode");
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
        String mode1 = "survival";
        String mode2 = "creative";
        String mode3 = "adventure";
        String mode4 = "spectator";
        String mode5 = "0";
        String mode6 = "1";
        String mode7 = "2";
        String mode8 = "3";
        if(args[0].equalsIgnoreCase(mode1) || (args[0].equalsIgnoreCase(mode5))){
            chosenPlayer.setGameMode(GameMode.SURVIVAL);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s GameMode to SURVIVAL.");
            return true;
        }
        if(args[0].equalsIgnoreCase(mode2) || (args[0].equalsIgnoreCase(mode6))){
            chosenPlayer.setGameMode(GameMode.CREATIVE);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s GameMode to CREATIVE.");
            return true;
        }
        if(args[0].equalsIgnoreCase(mode3) || (args[0].equalsIgnoreCase(mode7))){
            chosenPlayer.setGameMode(GameMode.ADVENTURE);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s GameMode to ADVENTURE.");
            return true;
        }
        if(args[0].equalsIgnoreCase(mode4) || (args[0].equalsIgnoreCase(mode8))){
            chosenPlayer.setGameMode(GameMode.SPECTATOR);
            sender.sendMessage(ChatColor.GREEN + "[Basics] Basics has just successfully attempted to set " + chosenPlayer.getPlayerListName() + "'s GameMode to SPECTATOR.");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "[Basics] Basics couldn't recongize that. Please try again.");
        sender.sendMessage(ChatColor.GREEN + "[Basics] The implemented gamemodes are: survival, creative, adventure, spectator, 0, 1, 2, and .");
    return true;
}
}
