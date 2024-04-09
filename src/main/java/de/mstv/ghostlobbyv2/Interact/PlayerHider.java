package de.mstv.ghostlobbyv2.Interact;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerHider implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType() == Material.BLAZE_ROD) {
                if (Main.Playerhider.contains(p)) {
                    Main.Playerhider.remove(p);
                  for (Player all : Bukkit.getOnlinePlayers()) {
                      p.showPlayer(all);
                      p.sendMessage(Main.prefix + "Du siehst nun alle Spieler.");
                      p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                      p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 ,5);
                  }
                }else {
                    Main.Playerhider.add(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer(all);
                        p.sendMessage(Main.prefix + "Du siehst nun keine Spieler mehr.");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 ,5);
                    }
                }
            }
        }
    }

}
