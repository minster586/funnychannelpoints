package projectshiko.projectshiko;

import org.bukkit.plugin.java.JavaPlugin;
import projectshiko.projectshiko.handlers.TwitchHandler;

public final class ProjectShiko extends JavaPlugin {

    private static ProjectShiko plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        new TwitchHandler();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ProjectShiko getPlugin() {
        return plugin;
    }
}
