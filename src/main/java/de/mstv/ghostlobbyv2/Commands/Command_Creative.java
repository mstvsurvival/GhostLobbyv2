package de.mstv.ghostlobbyv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Creative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.gm1")) {
                if (args.length == 0) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                    p.sendMessage("§a[§cGhostSystem§a] Dein Gamemode wurde auf Creative gesetzt");
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.gm1.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage("§a[§cGhostSystem§a] Dein Gamemode wurde auf Creative gesetzt");
                            p.sendMessage("§a[§cGhostSystem§a] Du hast den Spieler in Creative gesetzt");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                        }
                    } else {
                        p.sendMessage("§a[§cGhostSystem§a] Usage: /gm <0,1,3>  <player>");
                    }
                }
            } else {
                p.sendMessage("§a[§cGhostSystem§a] Dazu hast du keine Rechte");
            }
        }
        return false;
    }
}
