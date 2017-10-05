/*
 * Command manager for Walking Wasteland plugin
 */

package com.SpectralVulpine.walkingwasteland.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class CommandManager implements CommandExecutor{
	WalkingWasteland plugin;
	String help = "§r------------- §8§lWalking Wasteland Help §r-------------\n"
			+ "§e/wwl §r- toggle Wasteland mode\n"
			+ "§e/wwl reload §r- reload the configuration file from disk\n"
			+ "§e/wwl reset §r- reset the configuration file to defaults\n";

	public CommandManager(WalkingWasteland ww) {
		plugin = ww;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wwl") && sender instanceof Player && sender.hasPermission("walkingwasteland.commands")) {
			if (args.length == 0) {
				WastelandManager.toggleWastelander((Player) sender);
				if (WastelandManager.isWastelander((Player) sender)) {
					sender.sendMessage("§8§l[Walking Wasteland] §2You are now a Wastelander!");
				} else {
					sender.sendMessage("§8§l[Walking Wasteland] §6You are no longer a Wastelander.");
				}
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
				ConfigManager.reload();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reloaded.");
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
				ConfigManager.reset();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reset to defaults.");
			} else {
				sender.sendMessage(help);
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("wwl") && !(sender instanceof Player)) {
			if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
				ConfigManager.reload();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reloaded.");
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
				ConfigManager.reset();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reset to defaults.");
			} else {
				sender.sendMessage(help);
			}
			return true;
		}
		else { return false; }
	}	
}
