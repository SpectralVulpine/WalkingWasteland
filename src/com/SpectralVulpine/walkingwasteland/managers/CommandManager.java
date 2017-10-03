/*
 * Command manager for Walking Wasteland plugin
 */

package com.SpectralVulpine.walkingwasteland.managers;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class CommandManager implements CommandExecutor{
	WalkingWasteland plugin;
	String help = "§r------------- §8§lWalking Wasteland Help §r-------------\n"
			+ "§e/wwl §r- toggle Wasteland mode\n"
			+ "§e/wwl regen §r- regenerate the configuration file\n"
			+ "§e/wwl reload §r- reload the configuration file from disk\n";

	public CommandManager(WalkingWasteland ww) {
		plugin = ww;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wwl") && sender instanceof Player && sender.hasPermission("walkingwasteland.commands")) {
			if (args.length == 0) {
				WastelandManager.toggleWastelander((Player) sender);
				if (WastelandManager.isWastelander((Player) sender)) {
					sender.sendMessage("§8§l[Walking Wasteland] §r§2You are now a Wastelander!");
				} else {
					sender.sendMessage("§8§l[Walking Wasteland] §r§6You are no longer a Wastelander.");
				}
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
				try {
					plugin.reloadConfig();
					ConfigManager.loadConfig(plugin.getConfig());
					sender.sendMessage("§8§l[Walking Wasteland] §r§aConfiguration reloaded.");
				} catch(Exception e) {
					plugin.saveDefaultConfig();
					plugin.reloadConfig();
					ConfigManager.loadConfig(plugin.getConfig());
					sender.sendMessage("§8§l[Walking Wasteland] §r§cConfiguration file invalid! Default configuration loaded instead.");
				}
			} else if (args.length > 0 && args[0].equalsIgnoreCase("regen")) {
				File config = new File(plugin.getDataFolder(), "config.yml");
				config.delete();
				plugin.saveDefaultConfig();
				plugin.reloadConfig();
				ConfigManager.loadConfig(plugin.getConfig());
				sender.sendMessage("§8§l[Walking Wasteland] §r§aConfiguration regenerated.");
			} else {
				sender.sendMessage(help);
			}
			return true;
		} else { return false; }
	}	
}
