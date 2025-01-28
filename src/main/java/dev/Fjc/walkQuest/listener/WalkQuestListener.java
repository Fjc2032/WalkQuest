package dev.Fjc.walkQuest.listener;

import com.ordwen.odailyquests.quests.player.progression.PlayerProgressor;
import dev.Fjc.walkQuest.WalkQuest;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class WalkQuestListener extends PlayerProgressor implements Listener {

    private final Map<Player, Double> playerDistance = new HashMap<>();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            return;
        }
        if (player.isGliding() || player.isSwimming() || player.isClimbing() || player.isRiptiding() || player.isInsideVehicle() || player.isFlying() || player.isInWater() || player.isDead()) {
            return;
        }
        if (!player.isOnGround()) return;

        Location from = event.getFrom();
        Location to = event.getTo();

        double distance = Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY()) + Math.abs(from.getZ() - to.getZ());

        double threshold = (double) JavaPlugin.getPlugin(WalkQuest.class).getConfig().get("threshold");
        if (distance > threshold) return;

        double fullDistance = playerDistance.getOrDefault(player, 0.0);

        fullDistance += distance;

        playerDistance.put(player, fullDistance);


        setPlayerQuestProgression(event, player, 1, "WALK");
    }

}
