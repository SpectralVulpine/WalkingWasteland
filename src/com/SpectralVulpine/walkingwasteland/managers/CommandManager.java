/*
 * Command manager for Walking Wasteland plugin
 */

package com.SpectralVulpine.walkingwasteland.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class CommandManager implements CommandExecutor{
	WalkingWasteland plugin;
	String help = "§r------------- §8§lWalking Wasteland Help §r-------------\n"
			+ "§e/wwl §r- toggle Wasteland mode\n"
			+ "§e/wwl list §r- list currently active Wastelanders\n"
			+ "§e/wwl reload §r- reload the configuration file from disk\n"
			+ "§e/wwl reset §r- reset the configuration file to defaults\n"
			+ "§e/wwl toggle <player> §r- toggle the given player's Wastelander status\n";

	public CommandManager(WalkingWasteland ww) {
		plugin = ww;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO: Make more efficient to cut down on code reuse
		if (cmd.getName().equalsIgnoreCase("wwl") && sender.hasPermission("walkingwasteland.commands")) {
			if (args.length == 0 && sender instanceof Player) {
				// By default, toggle the user's Wasteland status
				WastelandManager.toggleWastelander((Player) sender);
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
				// Reload configuration file from disk
				ConfigManager.reload();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reloaded.");
			} else if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
				// Reset configuration file to default
				ConfigManager.reset();
				sender.sendMessage("§8§l[Walking Wasteland] §aConfiguration reset to defaults.");
			} else if (args.length > 0 && args[0].equalsIgnoreCase("list")) {
				// List all currently active Wastelanders
				String msg = "§8§l[Walking Wasteland] §eCurrently active Wastelanders:";
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (WastelandManager.isWastelander(p)) {
						msg += "\n§7" + p.getDisplayName();
					}
				}
				if (msg == "§8§l[Walking Wasteland] §eCurrently active Wastelanders:") {
					sender.sendMessage("§8§l[Walking Wasteland] §eNo Wastelanders are currently active.");
				} else {
					sender.sendMessage(msg);
				}
			} else if (args.length == 1 && args[0].equalsIgnoreCase("toggle")) {
				if (sender instanceof Player) {
					WastelandManager.toggleWastelander((Player) sender);
				} else {
					sender.sendMessage("§8§l[Walking Wasteland] §cPlease specify a player name.");
				}
			} else if (args.length > 1 && args[0].equalsIgnoreCase("toggle")) {
				Player p = Bukkit.getPlayer(args[1]);
				boolean completed = WastelandManager.toggleWastelander(p);
				if (completed) {
					if (WastelandManager.isWastelander(p)) {
						sender.sendMessage("§8§l[Walking Wasteland] §2" + p.getDisplayName() + " is now a Wastelander!");
					} else {
						sender.sendMessage("§8§l[Walking Wasteland] §6" + p.getDisplayName() + " is no longer a Wastelander.");
					}
				} else {
					sender.sendMessage("§8§l[Walking Wasteland] §cCould not find player with name " + args[1] + "!");
				}
			} else {
				sender.sendMessage(help);
			}
			return true;
		} else { return false;}
	}	
}
