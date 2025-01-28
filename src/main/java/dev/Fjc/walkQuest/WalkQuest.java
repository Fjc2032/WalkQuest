package dev.Fjc.walkQuest;

import com.ordwen.odailyquests.api.ODailyQuestsAPI;
import dev.Fjc.walkQuest.cmd.Reload;
import dev.Fjc.walkQuest.listener.WalkQuestListener;
import dev.Fjc.walkQuest.quests.WalkQuestClass;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class WalkQuest extends JavaPlugin {

    @Override
    public void onLoad() {
        ODailyQuestsAPI.registerQuestType("WALK", WalkQuestClass.class);
        getLogger().info("Quest registration successful.");
    }
    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("ODailyQuests")) {
            getLogger().warning("ODailyQuests was not detected! That is an issue but loading will attempt to continue.");
        } else {
            getLogger().info("Found ODailyQuests.");
        }
        Bukkit.getPluginManager().registerEvents(new WalkQuestListener(), this);
        getLogger().info("Listener loaded.");

        getServer().getPluginCommand("walkquestapi-reload").setExecutor(new Reload());
        this.getConfig().addDefault("threshold", 1.5);
        saveDefaultConfig();
        getLogger().info("Configuration file loaded.");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
