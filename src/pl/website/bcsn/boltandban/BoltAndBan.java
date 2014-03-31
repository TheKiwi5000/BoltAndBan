package pl.website.bcsn.boltandban;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BoltAndBan extends JavaPlugin {
	public static Server server;
	public static String victimName; // very bad technique
	
	/*
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 * PERMISSION NODES:
	 * bnb.sban - access /sban
	 */
	
	
	
	public void onEnable() {
		server = getServer();
		getServer().getLogger().fine("This is BoltAndBan by TheKiwi5000");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("sban")) {
			if (sender.hasPermission("bnb.sban"));
			if (args.length < 1) { // when no args are given
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&6&lBolt&e&lAnd&6&lBan &cversion "
								+ this.getDescription().getVersion()));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&9&lBy &a&lTheKiwi&2&l5000 &9&l[&b&l "
								+ this.getDescription().getWebsite() + " &9&l]"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7&lUsage: &8&l&o" + cmd.getUsage()));
				return true;
			}
			Thread banningThread = new Thread(new BanningThread());
			victimName = args[0];

			banningThread.start();
			return true;
		}

		return false;
	}
}
