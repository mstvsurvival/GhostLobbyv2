package de.mstv.ghostlobbyv2.Commands;

import de.mstv.ghostlobbyv2.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage(Main.console);
        } else {
            if (p.hasPermission("ghostlobby.fly")) {

                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(Main.prefix + "§7Du kannst nun §enicht mehr §7Fliegen.");
                    return true;
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(Main.prefix + "§7Du §ekannst §7nun Fliegen.");
                }
            }
        }

            return false;

    }
}
