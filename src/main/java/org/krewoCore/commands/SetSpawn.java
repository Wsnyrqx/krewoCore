package org.krewoCore.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.krewoCore.KrewoCore;
import org.krewoCore.utils.Utils;

public class SetSpawn implements CommandExecutor {
    public KrewoCore plugin;

    public SetSpawn(KrewoCore plugin) {
        this.plugin = plugin;
        plugin.getCommand("setspawn").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("setspawn.use")){
            if(strings.length == 0){
                commandSender.sendMessage(Utils.chat("&cUsage: /setspawn"));
            }
            else{
                Player player = (Player) commandSender;
                Location loc = player.getLocation();
                plugin.getConfig().set("spawn.world", loc.getWorld().getName());
                plugin.getConfig().set("spawn.x", loc.getX());
                plugin.getConfig().set("spawn.y", loc.getY());
                plugin.getConfig().set("spawn.z", loc.getZ());
                plugin.getConfig().set("spawn.yaw", loc.getYaw());
                plugin.getConfig().set("spawn.pitch", loc.getPitch());
                plugin.saveConfig();
                commandSender.sendMessage(Utils.chat("&aSpawn set!"));
            }
        }
        else{
            commandSender.sendMessage(Utils.chat("&cYou do not have permission to use this command!"));
        }
        return false;
    }
}
