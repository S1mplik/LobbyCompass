package danix25.lobbycompas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyCompass extends JavaPlugin {

    public static String prefix = "§7[§eServer§7] ";

    public static String use_Permission = "lobbycompass.use";
    public static String get_Permission = "lobbycompass.get";
    public static String admin_Permission = "lobbycompass.admin";

    @Override
    public void onEnable() {

        getCommand("lobbycompass").setExecutor(new LobbyCompassCommand(this));
        Bukkit.getPluginManager().registerEvents(new LobbyCompassCommand(this), this);

        getConfig().addDefault("compass-name", "&f&lServer Selector");
        getConfig().addDefault("compass-inventory-name", "&a&lServer Selector");
        getConfig().addDefault("get-compass-on-join", true);
        getConfig().addDefault("get-compass-on-join-slot", 4);
        getConfig().addDefault("get-compass-worlds", new String[] { "world", "world_nether", "world_the_end" });
        getConfig().addDefault("only-allow-command-lc_get-in-worlds", true);
        getConfig().addDefault("can-drop-compass", false);
        getConfig().addDefault("inventory-lines-amount", 4);
        getConfig().addDefault("sound-effect", true);

        getConfig().addDefault("options", new String[] { "spawn", "pvp" });

        getConfig().addDefault("data.spawn.name", "&e&lSkywars");
        getConfig().addDefault("data.spawn.lore", new String[] { "&aNove Mapy", "&c&lSuper Veci", "&7Nove mody" });
        getConfig().addDefault("data.spawn.item", 368);
        getConfig().addDefault("data.spawn.cmd", "skywars join skywars");
        getConfig().addDefault("data.spawn.executedByPlayer", true);
        getConfig().addDefault("data.spawn.position-in-inventory", 10);

        getConfig().addDefault("data.pvp.name", "&c&lPractise");
        getConfig().addDefault("data.pvp.lore", new String[] { "&cSkvele Mapy", "&c&lNove kity" });
        getConfig().addDefault("data.pvp.item", 267);
        getConfig().addDefault("data.pvp.cmd", "practise %n% join");
        getConfig().addDefault("data.pvp.executedByPlayer", false);
        getConfig().addDefault("data.pvp.position-in-inventory", 19);

        getConfig().options().copyHeader(true);
        getConfig().options().copyDefaults(true);

        saveConfig();
        reloadConfig();

    }

    @Override
    public void onDisable() {



    }

}
