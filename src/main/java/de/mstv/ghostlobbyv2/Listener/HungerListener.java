package de.mstv.ghostlobbyv2.Listener;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerListener implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {

        if (e.getEntity() instanceof Player && e.getEntity().getWorld().getName().equals(Main.world)) {
            e.setCancelled(true);
            ((Player)e.getEntity()).setFoodLevel(20);
        }
    }
}
