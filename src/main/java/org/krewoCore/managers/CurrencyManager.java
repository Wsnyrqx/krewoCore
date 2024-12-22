package org.krewoCore.managers;

import com.sun.tools.javac.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CurrencyManager {
    public Main plugin;
    private HashMap<UUID, Integer> currency = new HashMap<>();

    public CurrencyManager(Main instance) {
        plugin = instance;
    }

    public void saveCurrencyFile() throws IOException {
        // Add currency
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            File file = new File("CurrencyData/currency.dat");
            ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));

            UUID uuid = player.getUniqueId();
            if(currency.get(uuid) != null){
                currency.put(uuid, currency.get(uuid));
            }
            try{
                oos.writeObject(currency);
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadCurrencyFile() throws IOException, ClassNotFoundException {
        // Add currency
        File file = new File("CurrencyData/currency.dat");
        ObjectInputStream ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
        Object readObject = ois.readObject();
        ois.close();

        if (!(readObject instanceof HashMap)) {
            throw new IOException("Data is not a HashMap");
        }

        currency = (HashMap<UUID, Integer>) readObject;
        for (UUID key : currency.keySet()) {
            currency.put(key, currency.get(key));
        }
    }

    public void addCurrency(OfflinePlayer p, int amount) {
        UUID uuid = p.getUniqueId();
        if(currency.get(uuid) != null){
            currency.put(uuid, currency.get(uuid) + amount);
        } else {
            currency.put(uuid, amount);
        }
    }
    public void removeCurrency(OfflinePlayer p, int amount) {
        UUID uuid = p.getUniqueId();
        if(currency.get(uuid) != null){
            currency.put(uuid, currency.get(uuid) - amount);
        }
    }
    public void setCurrency(OfflinePlayer p, int amount) {
        UUID uuid = p.getUniqueId();
        currency.put(uuid, amount);
    }

    public int getCurrency(OfflinePlayer p) {
        UUID uuid = p.getUniqueId();
        if(currency.get(uuid) != null){
            return currency.get(uuid);
        } else {
            return 0;
        }
    }
}
