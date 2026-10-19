package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled");
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("ah").setExecutor(new AuctionHouseCommand());
        getCommand("order").setExecutor(new OrderCommand());
        getCommand("bal").setExecutor(new BalanceCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        setupScoreboard();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    private void setupScoreboard() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("terrorsmp", "dummy", "Terrorsmp.com");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(scoreboard);
        }
    }
}