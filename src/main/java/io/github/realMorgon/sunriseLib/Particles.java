package io.github.realMorgon.sunriseLib;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Particles {

    /**
     * Show particles for all online players at a location with a specified duration and interval
     * @param particle Choose a particle from the Particle enum
     * @param location Location of the particles
     * @param count Number of particles
     * @param offsetX Offset on the x-axis
     * @param offsetY Offset on the y-axis
     * @param offsetZ Offset on the z-axis
     * @param duration Duration of the loop in seconds
     * @param interval Interval between each particle wave in seconds
     */
    public static void showForAll(final Particle particle, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, double duration, double interval) {

        final int durationTicks = (int) (duration * 20);
        final int intervalTicks = (int) (interval * 20);

        new BukkitRunnable() {

            int time = 0;

            @Override
            public void run() {

                // Loop through all online players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // Show particles for each player
                    player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
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
     * Show particles for specified players at a location with a specified duration and interval
     * @param particle Choose a particle from the Particle enum
     * @param location Location of the particles
     * @param count Number of particles
     * @param offsetX Offset on the x-axis
     * @param offsetY Offset on the y-axis
     * @param offsetZ Offset on the z-axis
     * @param duration Duration of the loop in seconds
     * @param interval Interval between each particle wave in seconds
     * @param players List of players to show particles to
     */
    public static void showForPlayers(final Particle particle, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, double duration, int interval, final Player... players) {

        final int durationTicks = (int) (duration * 20);
        final int intervalTicks = (interval * 20);

        new BukkitRunnable() {

            int time = 0;

            @Override
            public void run() {

                // Loop through all relevant players
                for (Player player : players) {
                    // Show particles for each player
                    player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
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
