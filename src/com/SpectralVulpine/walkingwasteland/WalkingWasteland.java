/*
 * Walking Wasteland: Kill things by walking around!
 * Written by SpectralVulpine (www.spectralvulpine.com)
 */

package com.SpectralVulpine.walkingwasteland;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectraVulpine.walkingwasteland.listeners.PlayerMoveListener;
import com.SpectralVulpine.walkingwasteland.managers.CommandManager;

public class WalkingWasteland extends JavaPlugin {
	
	CommandManager exe;

	public void onEnable() {
		exe = new CommandManager(this);
		this.getCommand("wwl").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this), this);
	}	
}
