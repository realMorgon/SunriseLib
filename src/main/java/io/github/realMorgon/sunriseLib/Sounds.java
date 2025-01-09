package io.github.realMorgon.sunriseLib;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Sounds {


    /**
     * Play a sound for a specified player at the players location with a specified volume and pitch
     *
     * @param sound Choose a sound from the Sound enum
     * @param volume Volume of the sound
     *               1.0 is normal volume
     * @param pitch Pitch of the sound
     * @param duration Duration of the loop in seconds
     * @param interval Interval between each sound wave in seconds
     */
    public static void playForAll(final Sound sound, final float volume, final float pitch, double duration, double interval) {

        final int durationTicks = (int) (duration * 20);
        final int intervalTicks = (int) (interval * 20);

        new BukkitRunnable() {

            int time = 0;

            @Override
            public void run() {

                // Loop through all online players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // Show particles for each player
                    player.playSound(player.getLocation(), sound, volume, pitch);
                }

                // Cancel the task after the duration
                time += intervalTicks;

                if (time >= durationTicks) {
                    Bukkit.getScheduler().cancelTask(this.getTaskId());
                }
            }

        }.runTaskTimer(SunriseLib.getPlugin(), 0, intervalTicks);

    }

    /**
     * Play a sound for a specified player at the players location with a specified volume and pitch
     *
     * @param sound Choose a sound from the Sound enum
     * @param volume Volume of the sound
     *               1.0 is normal volume
     * @param pitch Pitch of the sound
     * @param duration Duration of the loop in seconds
     * @param interval Interval between each sound wave in seconds
     * @param players Players to play the sound for
     */
    public static void playForPlayers(final Sound sound, final float volume, final float pitch, double duration, double interval, final Player... players) {

        final int durationTicks = (int) (duration * 20);
        final int intervalTicks = (int) (interval * 20);

        new BukkitRunnable() {

            int time = 0;

            @Override
            public void run() {

                // Loop through all relevant players
                for (Player player : players) {
                    // Show particles for each player
                    player.playSound(player.getLocation(), sound, volume, pitch);
                }

                // Cancel the task after the duration
                time += intervalTicks;

                if (time >= durationTicks) {
                    Bukkit.getScheduler().cancelTask(this.getTaskId());
                }
            }

        }.runTaskTimer(SunriseLib.getPlugin(), 0, intervalTicks);

    }

    /**
     * Play a sound for a specified player at the players location with a specified volume and pitch
     *
     * @param sound Choose a sound from the Sound enum
     * @param volume Volume of the sound
     *               1.0 is normal volume
     * @param pitch Pitch of the sound
     * @param duration Duration of the loop in seconds
     * @param interval Interval between each sound wave in seconds
     * @param location Location to play the sound at
     * @param dx X-axis range
     * @param dy Y-axis range
     * @param dz Z-axis range
     */
    public static void playInArea(final Sound sound, final float volume, final float pitch, double duration, double interval, final Location location, final double dx, final double dy, final double dz) {

        final int durationTicks = (int) (duration * 20);
        final int intervalTicks = (int) (interval * 20);

        new BukkitRunnable() {

            int time = 0;

            @Override
            public void run() {

                // Get relevant players
                ArrayList<Player> players = new ArrayList<>();
                for(Entity entity : location.getWorld().getNearbyEntities(location, dx, dy, dz)){
                    players.add((Player) entity);
                }

                // Loop through all relevant players
                for (Player player : players) {
                    // Show particles for each player
                    player.playSound(player.getLocation(), sound, volume, pitch);
                }

                // Cancel the task after the duration
                time += intervalTicks;

                if (time >= durationTicks) {
                    Bukkit.getScheduler().cancelTask(this.getTaskId());
                }
            }

        }.runTaskTimer(SunriseLib.getPlugin(), 0, intervalTicks);

    }
}
