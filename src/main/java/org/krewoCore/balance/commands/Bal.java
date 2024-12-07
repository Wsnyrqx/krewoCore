package org.krewoCore.balance.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.krewoCore.KrewoCore;

public class Bal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // If no arguments are provided, show the player's own balance
            if (args.length == 0) {
                double balance = KrewoCore.econ.getBalance(player);
                player.sendMessage("§aYour balance: §6" + balance);
            }
            // If an argument is provided, check the balance of the specified player
            else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    double targetBalance = KrewoCore.econ.getBalance(target);
                    player.sendMessage("§a" + target.getName() + "'s balance: §6" + targetBalance);
                } else {
                    player.sendMessage("§cPlayer not found or is not online.");
                }
            }
            // Handle incorrect usage
            else {
                player.sendMessage("§cUsage: /bal [player]");
            }
        } else {
            sender.sendMessage("§cOnly players can use this command.");
        }
        return true;
    }
}
