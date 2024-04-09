package de.mstv.ghostlobbyv2;

import de.mstv.ghostlobbyv2.Commands.*;
import de.mstv.ghostlobbyv2.Interact.AdminTools;
import de.mstv.ghostlobbyv2.Interact.Compass;
import de.mstv.ghostlobbyv2.Interact.PlayerHider;
import de.mstv.ghostlobbyv2.Listener.HungerListener;
import de.mstv.ghostlobbyv2.Listener.JoinItems;
import de.mstv.ghostlobbyv2.Listener.PlayerJoinListener;
import de.mstv.ghostlobbyv2.Listener.WeatherListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.print.DocFlavor;
import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static String prefix = "§7[§bLOBBY§7] ";
    public static String noperm = "§7[§bLOBBY§7] Dazu hast du keine Rechte ";
    public static String console = "§7[§bLOBBY§7] §cDu musst ein Spieler sein umd dies Auszuführen! ";
    public static String use = "§7[§bLOBBY§7] $cBitte benutze ";
    public static String world = "Lobby [by EnrazeGames]";

    public static ArrayList<Player> Playerhider = new ArrayList<>();

    @Override
    public void onEnable() {

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinItems(), this);
        pm.registerEvents(new Compass(), this);
        pm.registerEvents(new PlayerHider(), this);
        pm.registerEvents(new AdminTools(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new WeatherListener(), this);
        pm.registerEvents(new HungerListener(), this);

        getCommand("fly").setExecutor(new Command_Fly());
        getCommand("cc").setExecutor(new Command_CC());
        getCommand("gm0").setExecutor(new Command_Survival());
        getCommand("gm1").setExecutor(new Command_Creative());
        getCommand("gm3").setExecutor(new Command_Spectator());





    }

    @Override
    public void onDisable() {
    }
}

