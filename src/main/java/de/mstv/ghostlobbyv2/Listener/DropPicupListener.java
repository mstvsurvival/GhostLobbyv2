package de.mstv.ghostlobbyv2.Listener;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DropPicupListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
      if (Main.buildmode.contains(e.getPlayer())) {
          e.setCancelled(false);
      } else {
          e.setCancelled(true);
      }
    }
    @EventHandler
    public void onPicup(PlayerPickupItemEvent e) {
        if (Main.buildmode.contains(e.getPlayer())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

}
