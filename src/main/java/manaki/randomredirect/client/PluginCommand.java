package manaki.randomredirect.client;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class PluginCommand implements CommandExecutor {

    private final RandomRedirect plugin;

    public PluginCommand(RandomRedirect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String j, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are allowed to use this command");
            return false;
        }

        // Perm = randomredirect.command
        if (!sender.hasPermission("randomredirect.command")) return false;

        if (args.length == 0) {
            var player = (Player) sender;
            var request = new Request(UUID.randomUUID(), player.getName());
            var rs = request.toString();
            var stream = new ByteArrayOutputStream();
            var out = new DataOutputStream(stream);
            try {
                out.writeUTF("redirect");
                out.writeUTF(rs);
            } catch (IOException e) {
                plugin.getLogger().severe("An I/O error occurred!");
            }
            ((Player) sender).sendPluginMessage(plugin, plugin.CHANNEL, stream.toByteArray());
        }

        return false;
    }

}
