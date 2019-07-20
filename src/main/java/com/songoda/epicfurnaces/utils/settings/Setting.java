package com.songoda.epicfurnaces.utils.settings;

import com.songoda.epicfurnaces.EpicFurnaces;
import com.songoda.epicfurnaces.utils.ServerVersion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Setting {

    UPGRADE_BY_SMELTING("Main.Upgrade By Smelting Materials", true),

    UPGRADE_WITH_ECONOMY("Main.Upgrade With Economy", true,
            "Should you be able to upgrade furnaces with economy?"),

    UPGRADE_WITH_XP("Main.Upgrade With XP", true,
            "Should you be able to upgrade furnaces with experience?"),

    AUTOSAVE("Main.Auto Save Interval In Seconds", 15,
            "The amount of time in between saving to file.",
            "This is purely a safety function to prevent against unplanned crashes or",
            "restarts. With that said it is advised to keep this enabled.",
            "If however you enjoy living on the edge, feel free to turn it off."),

    LEVEL_MULTIPLIER("Main.Level Cost Multiplier", 50),

    FURNACE_ITEM("Main.Remember Furnace Item Levels", true,
            "Should furnace levels be remembered when broken?"),

    HOLOGRAMS("Main.Furnaces Have Holograms", true),

    REDSTONE_DEACTIVATES("Main.Redstone Deactivates Furnaces", true),

    UPGRADE_COST("Main.Furnace Upgrade Cost", "IRON_INGOT"),
    CUSTOM_RECIPES("Main.Use Custom Recipes", true),
    NO_REWARDS_FROM_RECIPES("Main.No Rewards From Custom Recipes", true),

    PARTICLE_TYPE("Main.Upgrade Particle Type", "SPELL_WITCH",
            "The type of particle shown when a furnace is upgraded."),

    REMOTE("Main.Access Furnaces Remotely", true),

    TICK_SPEED("Main.Furnace Tick Speed", 10),
    OVERHEAT_PARTICLES("Main.Overheat Particles", true),

    REWARD_ICON("Interfaces.Reward Icon", "GOLDEN_APPLE"),
    PERFORMANCE_ICON("Interfaces.Performance Icon", "REDSTONE"),
    FUEL_SHARE_ICON("Interfaces.FuelShare Icon", "COAL_BLOCK"),
    FUEL_DURATION_ICON("Interfaces.FuelDuration Icon", "COAL"),
    OVERHEAT_ICON("Interfaces.Overheat Icon", EpicFurnaces.getInstance().isServerVersionAtLeast(ServerVersion.V1_13) ? "FIRE_CHARGE" : "FIREWORK_CHARGE"),

    VAULT_ECONOMY("Economy.Use Vault Economy", true,
            "Should Vault be used?"),

    RESERVE_ECONOMY("Economy.Use Reserve Economy", true,
            "Should Reserve be used?"),

    PLAYER_POINTS_ECONOMY("Economy.Use Player Points Economy", false,
            "Should PlayerPoints be used?"),

    RAINBOW("Interfaces.Replace Glass Type 1 With Rainbow Glass", false),
    ECO_ICON("Interfaces.Economy Icon", EpicFurnaces.getInstance().isServerVersionAtLeast(ServerVersion.V1_13) ? "SUNFLOWER" : "DOUBLE_PLANT"),
    XP_ICON("Interfaces.XP Icon", EpicFurnaces.getInstance().isServerVersionAtLeast(ServerVersion.V1_13) ? "EXPERIENCE_BOTTLE" : "EXP_BOTTLE"),
    GLASS_TYPE_1("Interfaces.Glass Type 1", 7),
    GLASS_TYPE_2("Interfaces.Glass Type 2", 11),
    GLASS_TYPE_3("Interfaces.Glass Type 3", 3),

    DATABASE_SUPPORT("Database.Activate Mysql Support", false,
            "Should MySQL be used for data storage?"),

    DATABASE_IP("Database.IP", "127.0.0.1",
            "MySQL IP"),

    DATABASE_PORT("Database.Port", 3306,
            "MySQL Port"),

    DATABASE_NAME("Database.Database Name", "EpicFurnaces",
            "The database you are inserting data into."),

    DATABASE_PREFIX("Database.Prefix", "EH-",
            "The prefix for tables inserted into the database."),

    DATABASE_USERNAME("Database.Username", "PUT_USERNAME_HERE",
            "MySQL Username"),

    DATABASE_PASSWORD("Database.Password", "PUT_PASSWORD_HERE",
            "MySQL Password"),

    LANGUGE_MODE("System.Language Mode", "en_US",
            "The enabled language file.",
            "More language files (if available) can be found in the plugins data folder.");

    private String setting;
    private Object option;
    private String[] comments;

    Setting(String setting, Object option, String... comments) {
        this.setting = setting;
        this.option = option;
        this.comments = comments;
    }

    Setting(String setting, Object option) {
        this.setting = setting;
        this.option = option;
        this.comments = null;
    }

    public static Setting getSetting(String setting) {
        List<Setting> settings = Arrays.stream(values()).filter(setting1 -> setting1.setting.equals(setting)).collect(Collectors.toList());
        if (settings.isEmpty()) return null;
        return settings.get(0);
    }

    public String getSetting() {
        return setting;
    }

    public Object getOption() {
        return option;
    }

    public String[] getComments() {
        return comments;
    }

    public List<String> getStringList() {
        return EpicFurnaces.getInstance().getConfig().getStringList(setting);
    }

    public boolean getBoolean() {
        return EpicFurnaces.getInstance().getConfig().getBoolean(setting);
    }

    public int getInt() {
        return EpicFurnaces.getInstance().getConfig().getInt(setting);
    }

    public long getLong() {
        return EpicFurnaces.getInstance().getConfig().getLong(setting);
    }

    public String getString() {
        return EpicFurnaces.getInstance().getConfig().getString(setting);
    }

    public char getChar() {
        return EpicFurnaces.getInstance().getConfig().getString(setting).charAt(0);
    }

    public double getDouble() {
        return EpicFurnaces.getInstance().getConfig().getDouble(setting);
    }
}