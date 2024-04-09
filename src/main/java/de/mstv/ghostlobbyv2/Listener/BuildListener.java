package de.mstv.ghostlobbyv2.Listener;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.imageio.stream.ImageInputStream;

public class BuildListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (Main.buildmode.contains(p)) {
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }

}
