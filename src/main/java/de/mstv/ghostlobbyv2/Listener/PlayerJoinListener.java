package de.mstv.ghostlobbyv2.Listener;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.setFoodLevel(20);
        p.setHealth(20);
        p.setLevel(2024);

        e.setJoinMessage(null);
        p.teleport(new Location(Bukkit.getWorld(Main.world), 0, 51, 0, 0, 0));
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        e.setDeathMessage(null);
    }
}
