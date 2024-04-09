package de.mstv.ghostlobbyv2.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.TimeSkipEvent;

public class WeatherListener implements Listener {

    @EventHandler
    public void onWeatherchange(WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDay(TimeSkipEvent e) {
        if (e.getSkipReason() == TimeSkipEvent.SkipReason.NIGHT_SKIP) {
            e.setCancelled(true);
            Bukkit.getWorlds().forEach(world -> world.setTime(0));
        }
    }
}
