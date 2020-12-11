package lcore;

import lcore.Managers.ConfigValues;
import lcore.PrivateMessageCommands.MessageCommand;
import lcore.PrivateMessageCommands.ReplyCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import lcore.time.DayCommand;
import lcore.time.NightCommand;
import lcore.weather.RainCommand;
import lcore.weather.SunCommand;

public final class LCore extends JavaPlugin implements Listener {
    private static FileConfiguration config;
    public static LCore plugin;
    @Override
    public void onEnable() {
        this.plugin = this;
        new ConfigValues();
        System.out.println("[lCore] Plugin was enabled!");
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(new WelcomeEvent(),this);
        getServer().getPluginManager().registerEvents(new DeathEvent(),this);
        getServer().getPluginManager().registerEvents(new MotdPingEvent(),this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("sun").setExecutor(new SunCommand());
        getCommand("rain").setExecutor(new RainCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("suicide").setExecutor(new SuicideCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("world").setExecutor(new WorldCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("[lCore] Plugin was disabled!");
    }
    public static FileConfiguration config() {
        return config;
    }
}
