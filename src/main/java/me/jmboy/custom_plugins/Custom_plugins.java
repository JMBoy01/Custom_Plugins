package me.jmboy.custom_plugins;

import me.jmboy.custom_plugins.commands.Home;
import me.jmboy.custom_plugins.commands.SetHome;
import me.jmboy.custom_plugins.handlers.OnePlayerSleepListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Custom_plugins extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Plugin starting...");

        Bukkit.getPluginManager().registerEvents(new OnePlayerSleepListener(), this);

        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Plugin shutting down...");
    }
}
