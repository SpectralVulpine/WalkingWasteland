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
	String help = "�8�l[Walking Wasteland] �rType /wwl to toggle Wasteland mode on and off.\n"
			+ "�lNOTE: �rWhile in Wasteland mode, �nyou will cause uncontrollable damage "
			+ "to your surroundings. �rBe careful!";

	public CommandManager(WalkingWasteland ww) {
		plugin = ww;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wwl") && sender instanceof Player) {
			if (args.length == 0) {
				WastelandManager.toggleWastelander((Player) sender);
				if (WastelandManager.isWastelander((Player) sender)) {
					sender.sendMessage("�8�l[Walking Wasteland] �r�2You are now a Wastelander!");
				} else {
					sender.sendMessage("�8�l[Walking Wasteland] �r�6You are no longer a Wastelander.");
				}
			} else if (args.length > 0 && args[0].equalsIgnoreCase("help")) {
				sender.sendMessage(help);
			}
			return true;
		} else { return false; }
	}	
}
