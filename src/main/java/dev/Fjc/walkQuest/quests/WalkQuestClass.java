package dev.Fjc.walkQuest.quests;

import com.ordwen.odailyquests.quests.types.AbstractQuest;
import com.ordwen.odailyquests.quests.types.shared.BasicQuest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;

public class WalkQuestClass extends AbstractQuest {


    public WalkQuestClass(BasicQuest basicQuest) {
        super(basicQuest);
    }

    @Override
    public String getType() {
        return "WALK";
    }


    @Override
    public boolean canProgress(Event provided) {
        return provided instanceof PlayerMoveEvent;
    }

    @Override
    public boolean loadParameters(ConfigurationSection configurationSection, String s, String s1) {
        return true;
    }
}
