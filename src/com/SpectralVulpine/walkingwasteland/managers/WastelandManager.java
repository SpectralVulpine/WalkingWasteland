/*
 * WastelandManager - keeps track of which players are and aren't wastelanders currently.
 * Repurposed to use metadata instead of an ArrayList
 */

package com.SpectralVulpine.walkingwasteland.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class WastelandManager {
	public static WalkingWasteland plugin = (WalkingWasteland) Bukkit.getPluginManager().getPlugin("WalkingWasteland");
	
	public static void toggleWastelander(Player p) {
		if (p.hasMetadata("Wastelander")) {
			p.removeMetadata("Wastelander", plugin);
		} else {
			p.setMetadata("Wastelander", new FixedMetadataValue(plugin, "waste"));
		}
	}
	
	public static boolean isWastelander(Player p) {
		if (p != null) {
			return p.hasMetadata("Wastelander");
		} else {
			return false;
		}
	}
}
