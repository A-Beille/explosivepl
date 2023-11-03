package org.explosivepl.explosive;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class Explosive extends JavaPlugin {

    @Override
    public synchronized void onEnable() {
        // Plugin startup logic
        Plugin pl = this;
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() { public void run() {
            for (Player player:Bukkit.getServer().getOnlinePlayers()) {
                Bukkit.broadcastMessage("ALERTE À LA BOMBE ! ÉVACUATION !");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() { public void run() {
                    player.kickPlayer("Alerte à la bombe: évacuation du serveur.");
                }},200);
            }
        }}, 6000);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
