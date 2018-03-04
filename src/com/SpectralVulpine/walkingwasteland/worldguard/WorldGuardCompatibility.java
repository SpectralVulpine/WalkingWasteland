package com.SpectralVulpine.walkingwasteland.worldguard;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class WorldGuardCompatibility {	
	
	private static WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
	
	public static boolean blockIsInProtectedZone(Player p, Location l) {
		WorldGuardPlugin plugin = getWorldGuard();
		if (plugin == null) {
			return false;
		}
		else {
			return !plugin.canBuild(p, l);
		}
	}
}
