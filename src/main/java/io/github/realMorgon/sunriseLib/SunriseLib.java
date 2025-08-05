package io.github.realMorgon.sunriseLib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class SunriseLib extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Beep boop beep beep boop!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // For other classes in our library
    public static JavaPlugin getPlugin() {
        return plugin;
    }

    // This method must not be used anywhere in the library!
    public static void setPlugin(final JavaPlugin plugin) {
        SunriseLib.plugin = plugin;
    }

}
