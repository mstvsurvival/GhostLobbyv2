package de.mstv.ghostlobbyv2.Commands;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Command_Build implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (!(sender instanceof Player)) {
            p.sendMessage(Main.console);
        } else {
            if (p.hasPermission("ghostlobby.build")) {
                if (args.length == 0) {
                    Location loc = p.getLocation();
                    if (!Main.buildmode.contains(p)) {
                        Main.buildmode.add(p);

                        p.sendMessage(Main.prefix + "§7Baumodus §eAktiviert");
                    } else if (Main.buildmode.contains(p)) {
                        Main.buildmode.remove(p);
                        p.sendMessage(Main.prefix + "§7Baumodus §eDeaktiviert");
                        p.getInventory().clear();
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
                    } else if (args.length == 1) {
                        if (Bukkit.getPlayer(args[0]) != null) {
                            Player target = Bukkit.getPlayer(args[0]);

                            if (Main.buildmode.contains(target)) {
                                Main.buildmode.add(target);
                                p.sendMessage(Main.prefix + "§7Der Spieler §e" + args[0] + " §7ist nun im Baumodus");
                                target.sendMessage(Main.prefix + "§7Der Spieler §e" + p.getName() + " §7hat dich in den Baumodus versetzt");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            } else if (Main.buildmode.contains(target)) {
                                Main.buildmode.remove(target);
                                p.sendMessage(Main.prefix + "§7Der Spieler §e" + args[0] + " §7ist nun nicht mehr im Baumodus");
                                target.sendMessage(Main.prefix + "§7Der Spieler §e" + p.getName() + " §7hat dir den Baumodus weggenommen");
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                            }
                        }
                    } else {
                        p.sendMessage(Main.use + "§e/build");
                    }
                } else {
                    p.sendMessage(Main.noperm);
                }
            }


            return false;
        }
        return false;
    }
}

