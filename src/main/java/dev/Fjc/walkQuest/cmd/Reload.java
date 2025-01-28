package dev.Fjc.walkQuest.cmd;

import dev.Fjc.walkQuest.WalkQuest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equals("walkquestapi-reload") && commandSender.hasPermission("odailyquests.admin")) {
            JavaPlugin.getPlugin(WalkQuest.class).reloadConfig();
        }
        return false;
    }
}
