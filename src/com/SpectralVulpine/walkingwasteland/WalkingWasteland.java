/*
 * Walking Wasteland: Kill things by walking around!
 * Written by SpectralVulpine (www.spectralvulpine.com)
 */

package com.SpectralVulpine.walkingwasteland;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectraVulpine.walkingwasteland.listeners.PlayerMoveListener;

public class WalkingWasteland extends JavaPlugin {

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this), this);
	}
	
}
