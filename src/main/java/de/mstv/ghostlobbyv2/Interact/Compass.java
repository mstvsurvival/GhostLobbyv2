package de.mstv.ghostlobbyv2.Interact;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
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

public class Compass implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigator")) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§aNavigator");

                    ItemStack i1 = new ItemStack(Material.MAGMA_CREAM);
                    ItemMeta i1meta = i1.getItemMeta();
                    i1meta.setDisplayName("§aSpawn");
                    i1.setItemMeta(i1meta);

                    ItemStack i2 = new ItemStack(Material.GRASS_BLOCK);
                    ItemMeta i2meta = i2.getItemMeta();
                    i2meta.setDisplayName("§aSurvival");
                    i2.setItemMeta(i2meta);

                    ItemStack i3 = new ItemStack(Material.BEACON);
                    ItemMeta i3meta = i3.getItemMeta();
                    i3meta.setDisplayName("§aCityBuild");
                    i3.setItemMeta(i3meta);

                    ItemStack i4 = new ItemStack(Material.RED_BED);
                    ItemMeta i4meta = i4.getItemMeta();
                    i4meta.setDisplayName("§cBedwars");
                    i4.setItemMeta(i4meta);

                    inv.setItem(16+6, i1);
                    inv.setItem(8+3, i2);
                    inv.setItem(8+5, i3);
                    inv.setItem(8+7, i4);

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
            if (e.getView().getTitle().equalsIgnoreCase("§aNavigator")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpawn")) {

                            p.sendMessage(Main.prefix + "§aDu bist nun am §eSpawn§a!");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            Location loc = new Location(Bukkit.getWorld(Main.world), 0, 51, 0);
                            loc.setYaw((float) -90);
                            loc.setPitch((float) 0);
                            p.teleport(loc);
                            p.closeInventory();
                        }
                    }
                }catch (Exception ex2) {

                }
            }
        }catch (Exception ex1) {

        }
    }

    @EventHandler
    public void onClick1(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§aNavigator")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.GRASS_BLOCK) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSurvival")) {

                            p.sendMessage(Main.prefix + "§aDu bist nun beim Spielmodus §eSurvival§a!");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            Location loc = new Location(Bukkit.getWorld(Main.world), -34, 50, 0);
                            loc.setYaw((float) -90);
                            loc.setPitch((float) 0);
                            p.teleport(loc);
                            p.closeInventory();
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
            if (e.getView().getTitle().equalsIgnoreCase("§aNavigator")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.BEACON) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCityBuild")) {

                            p.sendMessage(Main.prefix + "§aDu bist nun beim Spielmodus §eCityBuild§a!");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            Location loc = new Location(Bukkit.getWorld(Main.world), 0, 50, 34);
                            loc.setYaw((float) -90);
                            loc.setPitch((float) 0);
                            p.teleport(loc);
                            p.closeInventory();
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
            if (e.getView().getTitle().equalsIgnoreCase("§aNavigator")) {
                e.setCancelled(true);
                try {

                    if (e.getCurrentItem().getType() == Material.RED_BED) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedwars")) {

                            p.sendMessage(Main.prefix + "§aDu bist nun beim Spielmodus §eBedwars§a!");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            Location loc = new Location(Bukkit.getWorld(Main.world), 0, 50, -34);
                            loc.setYaw((float) -90);
                            loc.setPitch((float) 0);
                            p.teleport(loc);
                            p.closeInventory();
                        }
                    }
                }catch (Exception ex2) {

                }
            }
        }catch (Exception ex1) {

        }
    }

}
