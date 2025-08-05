package io.github.realMorgon.sunriseLib;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Message {

    /**
     * Send a message to all online players
     *
     * @param message The message to send
     */
    public static void sendToAllPlayers(String message) {
        for (Player player : SunriseLib.getPlugin().getServer().getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    /**
     * Send a message to all online players
     *
     * @param message The message to send
     * @param players The players to send the message to
     */
    public static void sendToSpecificPlayers(String message, Player... players) {
        for (Player player : players) {
            player.sendMessage(message);
        }
    }

    /**
     * Send a message to all online players
     *
     * @param message The message to send
     * @param location The location to center the message around
     * @param dx The x-axis range
     * @param dy The y-axis range
     * @param dz The z-axis range
     */
    public static void sendInArea(String message, Location location, double dx, double dy, double dz) {
        for (Entity entity : location.getWorld().getNearbyEntities(location, dx, dy, dz)) {
            if (entity instanceof Player) {
                entity.sendMessage(message);
            }
        }
    }

}
