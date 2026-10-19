package com.enderdevelopment.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OrderCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if (args.length != 3) {
            player.sendMessage("Usage: /order <item> <amount> <price>");
            return true;
        }

        String item = args[0];
        try {
            int amount = Integer.parseInt(args[1]);
            double price = Double.parseDouble(args[2]);
            if (amount <= 0 || price <= 0) {
                player.sendMessage("Amount and price must be positive.");
                return true;
            }

            // Implement order logic here
            player.sendMessage("Order created: " + amount + " " + item + " for " + price + " each.");
        } catch (NumberFormatException e) {
            player.sendMessage("Invalid amount or price.");
        }

        return true;
    }
}