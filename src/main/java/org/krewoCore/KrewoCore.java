package org.krewoCore;

import org.bukkit.plugin.java.JavaPlugin;
import org.krewoCore.balance.Economy;
import org.krewoCore.balance.commands.Bal;
import org.krewoCore.balance.commands.Pay;
import org.krewoCore.commands.Fly;
import org.krewoCore.listeners.JoinLeave;

public final class KrewoCore extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {
        // Befehle registrieren
        getCommand("fly").setExecutor(new Fly());
        getCommand("pay").setExecutor(new Pay());
        getCommand("bal").setExecutor(new Bal());
        // Listener registrieren
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
    }



   // private boolean setupEconomy() {
    //        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
    //        if (rsp == null) {
    //            return false;
    //        }
    //        econ = rsp.getProvider();
    //        return econ != null;
    //    }
}
