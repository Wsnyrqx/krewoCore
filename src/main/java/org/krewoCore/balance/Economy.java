package org.krewoCore.balance;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Economy implements Listener {
    private FileConfiguration balanceConfig;
    private File balanceFile;

    public Economy() {
        loadBalances();
    }

    // Load balances from the file
    private void loadBalances() {
        balanceFile = new File("plugins/KrewoCore", "balances.yml");
        if (!balanceFile.exists()) {
            balanceFile.getParentFile().mkdirs();
            try {
                balanceFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        balanceConfig = YamlConfiguration.loadConfiguration(balanceFile);
    }

    // Save balances to the file
    private void saveBalances() {
        try {
            balanceConfig.save(balanceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        // Check if the player is joining for the first time
        if (!balanceConfig.contains(playerId.toString())) {
            // Set initial balance to 1000
            balanceConfig.set(playerId.toString(), 1000.0);
            player.sendMessage("§aWelcome to the server! You have been given §61000 currency§a.");
            saveBalances();
        } else {
            player.sendMessage("§aWelcome back! Your balance is §6" + getBalance(player) + " currency§a.");
        }
    }

    // Get the balance of a player
    public double getBalance(Player player) {
        return balanceConfig.getDouble(player.getUniqueId().toString());
    }

    // Check if a player has enough balance
    public boolean has(Player player, double amount) {
        return getBalance(player) >= amount;
    }

    // Withdraw money from a player
    public void withdrawPlayer(Player player, double amount) {
        double newBalance = getBalance(player) - amount;
        balanceConfig.set(player.getUniqueId().toString(), newBalance);
        saveBalances();
    }

    // Deposit money to a player
    public void depositPlayer(Player player, double amount) {
        double newBalance = getBalance(player) + amount;
        balanceConfig.set(player.getUniqueId().toString(), newBalance);
        saveBalances();
    }
}
