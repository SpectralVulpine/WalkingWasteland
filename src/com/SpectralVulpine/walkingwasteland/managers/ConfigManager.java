/*
 * Configuration manager for Walking Wasteland plugin
 * Written by SpectralVulpine
 */

package com.SpectralVulpine.walkingwasteland.managers;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class ConfigManager {
	
	private static int effectPower, effectRadius, potionMultiplier;
	private static double effectDamage;
	private static boolean crackBrick, exorciseSand, freezeWater, freezeLava, extinguishFire, killFarmland, killGrass, 
	killLeavesVines, killMoss, killMushrooms, killSmallPlants, killTallPlants, slowMobs, weakenMobs, killMobs, 
	zombifyVillagers, killPlayers, zombifyPlayers, depleteOre, iron, gold, lapis, redstone, emerald, quartz, diamond;
	public static WalkingWasteland plugin = (WalkingWasteland) Bukkit.getPluginManager().getPlugin("WalkingWasteland");
	
	public static void load() {
		// Validate inputs for the ints - they should be default if they're invalid
		// On a side note, UGH.
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		FileConfiguration config = plugin.getConfig();
		try {
			if (config.getInt("effectPower") < 1 || config.getInt("effectPower") > 100) {
				throw new Exception();
			} else {
				effectPower = config.getInt("effectPower");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectPower in the configuration file is set to an illegal value! Using default.");
			effectPower = 20;
		}
		
		try {
			if (config.getInt("effectRadius") < 1) {
				throw new Exception();
			} else {
				effectRadius = config.getInt("effectRadius");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectRadius in the configuration file is set to an illegal value! Using default.");
			effectRadius = 1;
		}
		
		try {
			if (config.getDouble("effectDamage") < 0) {
				throw new Exception();
			} else {
				effectDamage = config.getDouble("effectDamage");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectDamage in the configuration file is set to an illegal value! Using default.");
			effectDamage = 0.5;
		}
		
		try {
			if (config.getInt("potionMultiplier") < 1 || config.getInt("potionMultiplier") > 128) {
				throw new Exception();
			} else {
				potionMultiplier = config.getInt("potionMultiplier");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] potionMultiplier in the configuration file is set to an illegal value! Using default.");
			potionMultiplier = 1;
		}
		
		try {
			crackBrick = config.getBoolean("crackBrick");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] crackBrick in the configuration file is set to an illegal value! Using default.");
			crackBrick = true;
		}
		
		try {
			exorciseSand = config.getBoolean("exorciseSand");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] exorciseSand in the configuration file is set to an illegal value! Using default.");
			exorciseSand = true;
		}
		
		try {
			freezeWater = config.getBoolean("freezeWater");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] freezeWater in the configuration file is set to an illegal value! Using default.");
			freezeWater = true;
		}
		
		try {
			freezeLava = config.getBoolean("freezeLava");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] freezeLava in the configuration file is set to an illegal value! Using default.");
			freezeLava = true;
		}
		
		try {
			extinguishFire = config.getBoolean("extinguishFire");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] extinguishFire in the configuration file is set to an illegal value! Using default.");
			extinguishFire = true;
		}
		
		try {
			killFarmland = config.getBoolean("killFarmland");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killFarmland in the configuration file is set to an illegal value! Using default.");
			killFarmland = true;
		}
		
		try {
			killGrass = config.getBoolean("killGrass");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killGrass in the configuration file is set to an illegal value! Using default.");
			killGrass = true;
		}
		
		try {
			killLeavesVines = config.getBoolean("killLeavesVines");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killLeavesVines in the configuration file is set to an illegal value! Using default.");
			killLeavesVines = true;
		}
		
		try {
			killMoss = config.getBoolean("killMoss");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMoss in the configuration file is set to an illegal value! Using default.");
			killMoss = true;
		}
		
		try {
			killMushrooms = config.getBoolean("killMushrooms");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMushrooms in the configuration file is set to an illegal value! Using default.");
			killMushrooms = true;
		}
		
		try {
			killSmallPlants = config.getBoolean("killSmallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killSmallPlants in the configuration file is set to an illegal value! Using default.");
			killSmallPlants = true;
		}
		
		try {
			killTallPlants = config.getBoolean("killTallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killTallPlants in the configuration file is set to an illegal value! Using default.");
			killTallPlants = true;
		}
		
		try {
			slowMobs = config.getBoolean("slowMobs");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] slowMobs in the configuration file is set to an illegal value! Using default.");
			slowMobs = true;
		}
		
		try {
			weakenMobs = config.getBoolean("weakenMobs");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] weakenMobs in the configuration file is set to an illegal value! Using default.");
			weakenMobs = true;
		}
		
		try {
			killMobs = config.getBoolean("killMobs");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMobs in the configuration file is set to an illegal value! Using default.");
			killMobs = true;
		}
		
		try {
			zombifyVillagers = config.getBoolean("zombifyVillagers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyVillagers in the configuration file is set to an illegal value! Using default.");
			zombifyVillagers = true;
		}
		
		try {
			killPlayers = config.getBoolean("killPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killPlayers in the configuration file is set to an illegal value! Using default.");
			killPlayers = true;
		}
		
		try {
			zombifyPlayers = config.getBoolean("zombifyPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyPlayers in the configuration file is set to an illegal value! Using default.");
			zombifyPlayers = true;
		}
		
		try {
			depleteOre = config.getBoolean("depleteOre");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] depleteOre in the configuration file is set to an illegal value! Using default.");
			depleteOre = true;
		}
		
		try {
			iron = config.getBoolean("iron");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] iron in the configuration file is set to an illegal value! Using default.");
			iron = true;
		}
		
		try {
			gold = config.getBoolean("gold");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] gold in the configuration file is set to an illegal value! Using default.");
			gold = true;
		}
		
		try {
			lapis = config.getBoolean("lapis");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] lapis in the configuration file is set to an illegal value! Using default.");
			lapis = true;
		}
		
		try {
			redstone = config.getBoolean("redstone");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] redstone in the configuration file is set to an illegal value! Using default.");
			redstone = true;
		}
		
		try {
			emerald = config.getBoolean("emerald");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] emerald in the configuration file is set to an illegal value! Using default.");
			emerald = true;
		}

		try {
			quartz = config.getBoolean("quartz");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] quartz in the configuration file is set to an illegal value! Using default.");
			quartz = true;
		}
		
		try {
			diamond = config.getBoolean("diamond");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] diamond in the configuration file is set to an illegal value! Using default.");
			diamond = false;
		}
	}
	
	public static void reload() {
		// Reload config file from disk
		try {
			load();
			Bukkit.getLogger().log(Level.INFO, "[Walking Wasteland] Configuration reloaded.");
		} catch(Exception e) { // may be irrelevant because of the way that load() deals with configuration files - check first few lines of load()
			plugin.saveDefaultConfig();
			plugin.reloadConfig();
			load();
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] Configuration file invalid! Using defaults instead.");
		}
	}
	
	public static void reset() {
		// Reset config file to default
		File config = new File(plugin.getDataFolder(), "config.yml");
		config.delete();
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		load();
		Bukkit.getLogger().log(Level.INFO, "[Walking Wasteland] Configuration reset to defaults.");
	}

	public static int getEffectPower() {
		return effectPower;
	}

	public static int getEffectRadius() {
		return effectRadius;
	}
	
	public static double getEffectDamage() {
		return effectDamage;
	}
	
	public static int getPotionMultiplier() {
		// Returns the value - 1 so that the player can put 2 in and get Effect 2 out.
		return potionMultiplier - 1;
	}

	public static boolean isCrackBrick() {
		return crackBrick;
	}

	public static boolean isExorciseSand() {
		return exorciseSand;
	}

	public static boolean isFreezeWater() {
		return freezeWater;
	}
	
	public static boolean isFreezeLava() {
		return freezeLava;
	}
	
	public static boolean isExtinguishFire() {
		return extinguishFire;
	}

	public static boolean isKillFarmland() {
		return killFarmland;
	}

	public static boolean isKillGrass() {
		return killGrass;
	}

	public static boolean isKillLeavesVines() {
		return killLeavesVines;
	}

	public static boolean isKillMoss() {
		return killMoss;
	}

	public static boolean isKillMushrooms() {
		return killMushrooms;
	}

	public static boolean isKillSmallPlants() {
		return killSmallPlants;
	}

	public static boolean isKillTallPlants() {
		return killTallPlants;
	}

	public static boolean isSlowMobs() {
		return slowMobs;
	}

	public static boolean isWeakenMobs() {
		return weakenMobs;
	}

	public static boolean isKillMobs() {
		return killMobs;
	}

	public static boolean isZombifyVillagers() {
		return zombifyVillagers;
	}

	public static boolean isKillPlayers() {
		return killPlayers;
	}

	public static boolean isZombifyPlayers() {
		return zombifyPlayers;
	}

	public static boolean isDepleteOre() {
		return depleteOre;
	}

	public static boolean isIron() {
		return iron;
	}

	public static boolean isGold() {
		return gold;
	}

	public static boolean isLapis() {
		return lapis;
	}

	public static boolean isRedstone() {
		return redstone;
	}

	public static boolean isEmerald() {
		return emerald;
	}

	public static boolean isQuartz() {
		return quartz;
	}

	public static boolean isDiamond() {
		return diamond;
	}
}
