package com.enderdevelopment.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if (args.length != 2) {
            player.sendMessage("Usage: /pay <player> <amount>");
            return true;
        }

        Player target = player.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage("Player not found.");
            return true;
        }

        try {
            double amount = Double.parseDouble(args[1]);
            if (amount <= 0) {
                player.sendMessage("Amount must be positive.");
                return true;
            }

            // Implement payment logic here
            player.sendMessage("Paid " + amount + " to " + target.getName());
            target.sendMessage("Received " + amount + " from " + player.getName());
        } catch (NumberFormatException e) {
            player.sendMessage("Invalid amount.");
        }

        return true;
    }
}