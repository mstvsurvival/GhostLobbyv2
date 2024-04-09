package de.mstv.ghostlobbyv2.Interact;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminTools implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAdmin tools")) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                    Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§cAdmin tools");

                    ItemStack i1 = new ItemStack(Material.PAPER);
                    ItemMeta i1meta = i1.getItemMeta();
                    i1meta.setDisplayName("§aClear Chat");
                    i1.setItemMeta(i1meta);

                    ItemStack i2 = new ItemStack(Material.BARRIER);
                    ItemMeta i2meta = i2.getItemMeta();
                    i2meta.setDisplayName("§aRestart");
                    i2.setItemMeta(i2meta);

                    ItemStack i3 = new ItemStack(Material.FEATHER);
                    ItemMeta i3meta = i3.getItemMeta();
                    i3meta.setDisplayName("§aFly");
                    i3.setItemMeta(i3meta);

                    inv.setItem(0, i1);
                    inv.setItem(1, i2);
                    inv.setItem(2, i3);

                    p.openInventory(inv);

                }
            }

        }catch (Exception ex) {

        }

    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cAdmin tools")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.PAPER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClear Chat")) {

                            p.performCommand("cc");

                        }
                    }
                }catch (Exception ex2) {

                }
            }
        }catch (Exception ex1) {

        }
    }

    @EventHandler
    public void onClick2(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cAdmin tools")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.BARRIER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRestart")) {

                            p.performCommand("restart");

                        }
                    }
                }catch (Exception ex2) {

                }
            }
        }catch (Exception ex1) {

        }
    }

    @EventHandler
    public void onClick3(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cAdmin tools")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.FEATHER) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFly")) {

                            p.performCommand("fly");

                        }
                    }
                }catch (Exception ex2) {

                }
            }
        }catch (Exception ex1) {

        }
    }
}
