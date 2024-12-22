package org.krewoCore.commands;

import com.sun.tools.javac.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.krewoCore.KrewoCore;
import org.krewoCore.utils.Utils;

public class CurrencyCommand implements CommandExecutor {
    public KrewoCore plugin;

    public CurrencyCommand(KrewoCore plugin) {
        this.plugin = plugin;
        plugin.getCommand("currency").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // if(commandSender.hasPermission("currencymanager.use")){
        //            if(strings.length == 0){
        //                commandSender.sendMessage(Utils.chat("&cUsage: /currency <add/remove/set> <player> <amount>"));
        //            }
        //            else if(strings.length == 1){
        //                commandSender.sendMessage(Utils.chat("&cUsage: /currency <add/remove/set> <player> <amount>"));
        //            }
        //            else if(strings.length == 2){
        //                commandSender.sendMessage(Utils.chat("&cUsage: /currency <add/remove/set> <player> <amount>"));
        //            }
        //            else{
        //                Player target = plugin.getServer().getPlayer(strings[1]);
        //                if(target == null){
        //                    commandSender.sendMessage(Utils.chat("&cPlayer not found!"));
        //                    return false;
        //                }
        //                if(strings[0].equalsIgnoreCase("add")){
        //                    plugin.currencyManager.addCurrency(target, Integer.parseInt(strings[2]));
        //                    commandSender.sendMessage(Utils.chat("&aAdded " + strings[2] + " to " + target.getName() + "'s balance!"));
        //                }
        //                else if(strings[0].equalsIgnoreCase("remove")){
        //                    plugin.currencyManager.removeCurrency(target, Integer.parseInt(strings[2]));
        //                    commandSender.sendMessage(Utils.chat("&aRemoved " + strings[2] + " from " + target.getName() + "'s balance!"));
        //                }
        //                else if(strings[0].equalsIgnoreCase("set")){
        //                    plugin.currencyManager.setCurrency(target, Integer.parseInt(strings[2]));
        //                    commandSender.sendMessage(Utils.chat("&aSet " + target.getName() + "'s balance to " + strings[2] + "!"));
        //                }
        //                else{
        //                    commandSender.sendMessage(Utils.chat("&cUsage: /currency <add/remove/set> <player> <amount>"));
        //                }
        //            }
        //        }
        //        else{
        //            commandSender.sendMessage(Utils.chat("&cYou do not have permission to use this command!"));
        //        }
        return false;
    }
}
