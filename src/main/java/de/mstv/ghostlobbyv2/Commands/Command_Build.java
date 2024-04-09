package de.mstv.ghostlobbyv2.Commands;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                        p.openInventory(p.getEnderChest());
                        p.closeInventory();
                    }
                } else if (args.length == 1) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);

                        if (Main.buildmode.contains(target)) {
                            Main.buildmode.add(target);
                            p.sendMessage(Main.prefix + "§7Der Spieler §e" + args[0] + " §7ist nun im Baumodus");
                            target.sendMessage(Main.prefix + "§7Der Spieler §e" + p.getName() + " §7hat dich in den Baumodus versetzt");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 , 5);
                            target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 , 5);
                        } else if (Main.buildmode.contains(target)) {
                            Main.buildmode.remove(target);
                            p.sendMessage(Main.prefix + "§7Der Spieler §e" + args[0] + " §7ist nun nicht mehr im Baumodus");
                            target.sendMessage(Main.prefix + "§7Der Spieler §e" + p.getName() + " §7hat dir den Baumodus weggenommen");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 , 5);
                            target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5 , 5);
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
}
