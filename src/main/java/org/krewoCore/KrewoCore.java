package org.krewoCore;

import org.bukkit.plugin.java.JavaPlugin;
import org.krewoCore.commands.Fly;
import org.krewoCore.commands.SetSpawn;
import org.krewoCore.listeners.JoinLeave;
import org.krewoCore.managers.CurrencyManager;

public final class KrewoCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register commands
        registerCommands();

        // Register listeners
        registerListeners();


    }

    @Override
    public void onDisable(){

    }


    public void registerCommands() {
        // Register commands
        getCommand("fly").setExecutor(new Fly());
        getCommand("setspawn").setExecutor(new SetSpawn(this));
    }

    public void registerListeners() {
        // Register listeners
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
    }

    public void registerManagers() {

    }
}
