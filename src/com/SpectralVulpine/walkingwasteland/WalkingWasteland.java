/*
 * Walking Wasteland: Spread death and decay just by walking around!
 * Written by SpectralVulpine (www.spectralvulpine.com)
 */

package com.SpectralVulpine.walkingwasteland;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.walkingwasteland.listeners.DeathListener;
import com.SpectralVulpine.walkingwasteland.managers.CommandManager;
import com.SpectralVulpine.walkingwasteland.managers.ConfigManager;
import com.SpectralVulpine.walkingwasteland.runnables.WastelandTick;

public class WalkingWasteland extends JavaPlugin {
	
	CommandManager exe;
	WastelandTick wTick;

	public void onEnable() {
		wTick = new WastelandTick();
		exe = new CommandManager(this);
		this.getCommand("wwl").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
		this.saveDefaultConfig();
		this.reloadConfig();
		ConfigManager.loadConfig(this.getConfig());
		wTick.runTaskTimer(this, 0, 5);
	}	
}
