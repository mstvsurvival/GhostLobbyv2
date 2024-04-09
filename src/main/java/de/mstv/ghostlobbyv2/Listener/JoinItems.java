package de.mstv.ghostlobbyv2.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        ItemStack i1 = new ItemStack(Material.COMPASS);
        ItemMeta i1meta = i1.getItemMeta();
        i1meta.setDisplayName("§aNavigator");
        i1.setItemMeta(i1meta);

        ItemStack i2 = new ItemStack(Material.BLAZE_ROD);
        ItemMeta i2meta = i2.getItemMeta();
        i2meta.setDisplayName("§aSpieler verstecken");
        i2.setItemMeta(i2meta);

        ItemStack i3 = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta i3meta = i3.getItemMeta();
        i3meta.setDisplayName("§cAdmin tools");
        i3.setItemMeta(i3meta);

        ItemStack i4 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta i4meta = i4.getItemMeta();
        i4meta.setDisplayName("§aKleiderschrank");
        i4.setItemMeta(i4meta);

        ItemStack i5 = new ItemStack(Material.CHEST);
        ItemMeta i5meta = i5.getItemMeta();
        i5meta.setDisplayName("§aExtras");
        i5.setItemMeta(i5meta);

        p.getInventory().clear();

        p.getInventory().setItem(4, i1);
        p.getInventory().setItem(2, i2);
        p.getInventory().setItem(6, i4);
        p.getInventory().setItem(8, i5);

        if (p.hasPermission("ghostlobby.admin")) {
            p.getInventory().clear();

            p.getInventory().setItem(4, i1);
            p.getInventory().setItem(2, i2);
            p.getInventory().setItem(6, i4);
            p.getInventory().setItem(8, i5);
            p.getInventory().setItem(0, i3);

        }


    }
}

