package fr.ozyris.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("mp").setExecutor(new CommandeMp());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
