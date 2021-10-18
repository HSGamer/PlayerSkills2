package com.leonardobishop.playerskills2.skill;

import com.leonardobishop.playerskills2.PlayerSkills;
import com.leonardobishop.playerskills2.config.CreatorConfigValue;
import com.leonardobishop.playerskills2.player.SPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Skill implements Listener {

    private final PlayerSkills plugin;
    private final String name;
    private final String configName;
    private final HashMap<String, Object> config = new HashMap<>();
    private final HashMap<Integer, Integer> pointPriceOverrides = new HashMap<>();
    private final ArrayList<CreatorConfigValue> creatorConfigValues = new ArrayList<>();
    private String itemLocation;

    public Skill(PlayerSkills plugin, String name, String configName) {
        this.plugin = plugin;
        this.name = name;
        this.configName = configName;
    }

    public final String getName() {
        return name;
    }

    public final String getConfigName() {
        return configName;
    }

    public final PlayerSkills getPlugin() {
        return plugin;
    }

    public HashMap<String, Object> getConfig() {
        return config;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public abstract String getPreviousString(SPlayer player);

    public abstract String getNextString(SPlayer player);

    public ArrayList<CreatorConfigValue> getCreatorConfigValues() {
        return creatorConfigValues;
    }

    public void enable(PlayerSkills plugin) {

    }

    public int getPriceOverride(int level) {
        return pointPriceOverrides.getOrDefault(level, 1);
    }

    public HashMap<Integer, Integer> getPointPriceOverrides() {
        return pointPriceOverrides;
    }

    public double getDecimalNumber(String location) {
        Object obj = getConfig().get(location);
        if (obj == null) {
            return 0;
        }

        if (obj instanceof Integer) {
            return ((int) obj);
        } else {
            return (double) obj;
        }
    }

    public boolean isWorldNotAllowed(Player player) {
        if (this.getConfig().containsKey("only-in-worlds")) {
            List<String> listOfWorlds = (List<String>) this.getConfig().get("only-in-worlds");
            return !listOfWorlds.contains(player.getLocation().getWorld().getName());
        }
        return false;
    }
}
