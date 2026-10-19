package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("terrorsmp", "dummy", "Terrorsmp.com");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Add scores for money, playtime, and kills
        objective.getScore("Money").setScore(1000);
        objective.getScore("Playtime").setScore(100);
        objective.getScore("Kills").setScore(50);

        player.setScoreboard(scoreboard);
    }
}