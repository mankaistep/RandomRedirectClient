package manaki.randomredirect.client;

import manaki.randomredirect.client.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomRedirect extends JavaPlugin {

    public final String CHANNEL = "manaki:randomredirect";

    @EventHandler
    public void onEnable() {
        this.getCommand("rtp").setExecutor(new PluginCommand(this));
        this.getLogger().info("RandomRedirect by MankaiStep enabled!");

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, CHANNEL);
    }

}
