/*
 * Configuration manager for Walking Wasteland plugin
 * Written by SpectralVulpine
 */

package com.SpectralVulpine.walkingwasteland.managers;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	
	private static int effectPower, effectRadius;
	private static boolean crackBrick, exorciseSand, freezeWater, killFarmland, killGrass, killLeavesVines, 
	killMoss, killMushrooms, killSmallPlants, killTallPlants, killMobs, zombifyVillagers, killPlayers, 
	zombifyPlayers, depleteOre, iron, gold, lapis, redstone, emerald, quartz, diamond;
	
	public static void loadConfig(FileConfiguration config) {
		// Validate inputs for the ints - they should be default if they're invalid
		// On a side note, UGH.
		try {
			if (config.getInt("effectPower") < 1 || config.getInt("effectPower") > 100) {
				throw new Exception();
			} else {
				effectPower = config.getInt("effectPower");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectPower in the configuration file is set to an illegal value! Using default", e);
			effectPower = 20;
		}
		
		try {
			if (config.getInt("effectRadius") < 1) {
				throw new Exception();
			} else {
				effectRadius = config.getInt("effectRadius");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectRadius in the configuration file is set to an illegal value! Using default", e);
			effectRadius = 1;
		}
		
		try {
			crackBrick = config.getBoolean("crackBrick");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] crackBrick in the configuration file is set to an illegal value! Using default", e);
			crackBrick = true;
		}
		
		try {
			exorciseSand = config.getBoolean("exorciseSand");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] exorciseSand in the configuration file is set to an illegal value! Using default", e);
			exorciseSand = true;
		}
		
		try {
			freezeWater = config.getBoolean("freezeWater");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] freezeWater in the configuration file is set to an illegal value! Using default", e);
			freezeWater = true;
		}
		
		try {
			killFarmland = config.getBoolean("killFarmland");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killFarmland in the configuration file is set to an illegal value! Using default", e);
			killFarmland = true;
		}
		
		try {
			killGrass = config.getBoolean("killGrass");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killGrass in the configuration file is set to an illegal value! Using default", e);
			killGrass = true;
		}
		
		try {
			killLeavesVines = config.getBoolean("killLeavesVines");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killLeavesVines in the configuration file is set to an illegal value! Using default", e);
			killLeavesVines = true;
		}
		
		try {
			killMoss = config.getBoolean("killMoss");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMoss in the configuration file is set to an illegal value! Using default", e);
			killMoss = true;
		}
		
		try {
			killMushrooms = config.getBoolean("killMushrooms");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMushrooms in the configuration file is set to an illegal value! Using default", e);
			killMushrooms = true;
		}
		
		try {
			killSmallPlants = config.getBoolean("killSmallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killSmallPlants in the configuration file is set to an illegal value! Using default", e);
			killSmallPlants = true;
		}
		
		try {
			killTallPlants = config.getBoolean("killTallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killTallPlants in the configuration file is set to an illegal value! Using default", e);
			killTallPlants = true;
		}
		
		try {
			killMobs = config.getBoolean("killMobs");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMobs in the configuration file is set to an illegal value! Using default", e);
			killMobs = true;
		}
		
		try {
			zombifyVillagers = config.getBoolean("zombifyVillagers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyVillagers in the configuration file is set to an illegal value! Using default", e);
			zombifyVillagers = true;
		}
		
		try {
			killPlayers = config.getBoolean("killPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killPlayers in the configuration file is set to an illegal value! Using default", e);
			killPlayers = false;
		}
		
		try {
			zombifyPlayers = config.getBoolean("zombifyPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyPlayers in the configuration file is set to an illegal value! Using default", e);
			zombifyPlayers = true;
		}
		
		try {
			depleteOre = config.getBoolean("depleteOre");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] depleteOre in the configuration file is set to an illegal value! Using default", e);
			depleteOre = true;
		}
		
		try {
			iron = config.getBoolean("iron");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] iron in the configuration file is set to an illegal value! Using default", e);
			iron = true;
		}
		
		try {
			gold = config.getBoolean("gold");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] gold in the configuration file is set to an illegal value! Using default", e);
			gold = true;
		}
		
		try {
			lapis = config.getBoolean("lapis");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] lapis in the configuration file is set to an illegal value! Using default", e);
			lapis = true;
		}
		
		try {
			redstone = config.getBoolean("redstone");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] redstone in the configuration file is set to an illegal value! Using default", e);
			redstone = true;
		}
		
		try {
			emerald = config.getBoolean("emerald");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] emerald in the configuration file is set to an illegal value! Using default", e);
			emerald = true;
		}

		try {
			quartz = config.getBoolean("quartz");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] quartz in the configuration file is set to an illegal value! Using default", e);
			quartz = true;
		}
		
		try {
			diamond = config.getBoolean("diamond");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] diamond in the configuration file is set to an illegal value! Using default", e);
			diamond = false;
		}
	}
}
