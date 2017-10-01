/*
 * Command manager for PatLock plugin
 * Written by SpectralVulpine, like the rest of this mess.
 */

package com.SpectralVulpine.walkingwasteland.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class CommandManager implements CommandExecutor{
	WalkingWasteland plugin;
	// TODO: Add help string

	public CommandManager(WalkingWasteland ww) {
		plugin = ww;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("wwl") && sender instanceof Player) {
			WastelandManager.toggleWastelander((Player) sender);
			if (WastelandManager.isWastelander((Player) sender)) {
				sender.sendMessage("§8§l[Walking Wasteland] §r§2You are now a Wastelander!");
			} else {
				sender.sendMessage("§8§l[Walking Wasteland] §r§6You are no longer a Wastelander.");
			}
			return true;
		} else { return false; }
	}	
}
