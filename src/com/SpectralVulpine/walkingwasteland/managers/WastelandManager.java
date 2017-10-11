/*
 * WastelandManager - keeps track of which players are and aren't wastelanders currently.
 */

package com.SpectralVulpine.walkingwasteland.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class WastelandManager {
	public static WalkingWasteland plugin = (WalkingWasteland) Bukkit.getPluginManager().getPlugin("WalkingWasteland");
	
	public static boolean toggleWastelander(Player p) {
		// Toggle the Wastelander status of this player. Returns whether or not a change was made.
		if (p instanceof Player) {
			if (p.hasMetadata("Wastelander")) {
				p.removeMetadata("Wastelander", plugin);
				p.sendMessage("§8§l[Walking Wasteland] §6You are no longer a Wastelander.");
			} else {
				p.setMetadata("Wastelander", new FixedMetadataValue(plugin, "waste"));
				p.sendMessage("§8§l[Walking Wasteland] §2You are now a Wastelander!");
			}
			return true;
		} else { return false; }
	}
	
	public static boolean isWastelander(Player p) {
		if (p != null) {
			return p.hasMetadata("Wastelander");
		} else {
			return false;
		}
	}
}
