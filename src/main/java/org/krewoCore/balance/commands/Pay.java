package org.krewoCore.balance.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.krewoCore.KrewoCore;

public class Pay implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    try {
                        double amount = Double.parseDouble(args[1]);
                        if (amount > 0) {
                            if (KrewoCore.econ.has(player, amount)) {
                                KrewoCore.econ.withdrawPlayer(player, amount);
                                KrewoCore.econ.depositPlayer(target, amount);

                                player.sendMessage("§aYou sent §6" + amount + "§a to §e" + target.getName() + "§a!");
                                target.sendMessage("§aYou received §6" + amount + "§a from §e" + player.getName() + "§a!");
                            } else {
                                player.sendMessage("§cYou don't have enough money!");
                            }
                        } else {
                            player.sendMessage("§cAmount must be greater than 0.");
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage("§cThe amount must be a number.");
                    }
                } else {
                    player.sendMessage("§cPlayer not found!");
                }
            } else {
                player.sendMessage("§cUsage: /pay <player> <amount>");
            }
        } else {
            sender.sendMessage("§cOnly players can use this command.");
        }

        return true;
    }
}
