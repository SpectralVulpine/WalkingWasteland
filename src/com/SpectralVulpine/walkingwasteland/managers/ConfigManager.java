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
	private static double effectDamage;
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
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectPower in the configuration file is set to an illegal value! Using default");
			effectPower = 20;
		}
		
		try {
			if (config.getInt("effectRadius") < 1) {
				throw new Exception();
			} else {
				effectRadius = config.getInt("effectRadius");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectRadius in the configuration file is set to an illegal value! Using default");
			effectRadius = 1;
		}
		
		try {
			if (config.getDouble("effectDamage") < 0) {
				throw new Exception();
			} else {
				effectDamage = config.getDouble("effectDamage");
			}
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] effectDamage in the configuration file is set to an illegal value! Using default");
			effectDamage = 0.5;
		}
		
		try {
			crackBrick = config.getBoolean("crackBrick");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] crackBrick in the configuration file is set to an illegal value! Using default");
			crackBrick = true;
		}
		
		try {
			exorciseSand = config.getBoolean("exorciseSand");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] exorciseSand in the configuration file is set to an illegal value! Using default");
			exorciseSand = true;
		}
		
		try {
			freezeWater = config.getBoolean("freezeWater");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] freezeWater in the configuration file is set to an illegal value! Using default");
			freezeWater = true;
		}
		
		try {
			killFarmland = config.getBoolean("killFarmland");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killFarmland in the configuration file is set to an illegal value! Using default");
			killFarmland = true;
		}
		
		try {
			killGrass = config.getBoolean("killGrass");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killGrass in the configuration file is set to an illegal value! Using default");
			killGrass = true;
		}
		
		try {
			killLeavesVines = config.getBoolean("killLeavesVines");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killLeavesVines in the configuration file is set to an illegal value! Using default");
			killLeavesVines = true;
		}
		
		try {
			killMoss = config.getBoolean("killMoss");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMoss in the configuration file is set to an illegal value! Using default");
			killMoss = true;
		}
		
		try {
			killMushrooms = config.getBoolean("killMushrooms");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMushrooms in the configuration file is set to an illegal value! Using default");
			killMushrooms = true;
		}
		
		try {
			killSmallPlants = config.getBoolean("killSmallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killSmallPlants in the configuration file is set to an illegal value! Using default");
			killSmallPlants = true;
		}
		
		try {
			killTallPlants = config.getBoolean("killTallPlants");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killTallPlants in the configuration file is set to an illegal value! Using default");
			killTallPlants = true;
		}
		
		try {
			killMobs = config.getBoolean("killMobs");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killMobs in the configuration file is set to an illegal value! Using default");
			killMobs = true;
		}
		
		try {
			zombifyVillagers = config.getBoolean("zombifyVillagers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyVillagers in the configuration file is set to an illegal value! Using default");
			zombifyVillagers = true;
		}
		
		try {
			killPlayers = config.getBoolean("killPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] killPlayers in the configuration file is set to an illegal value! Using default");
			killPlayers = true;
		}
		
		try {
			zombifyPlayers = config.getBoolean("zombifyPlayers");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] zombifyPlayers in the configuration file is set to an illegal value! Using default");
			zombifyPlayers = true;
		}
		
		try {
			depleteOre = config.getBoolean("depleteOre");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] depleteOre in the configuration file is set to an illegal value! Using default");
			depleteOre = true;
		}
		
		try {
			iron = config.getBoolean("iron");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] iron in the configuration file is set to an illegal value! Using default");
			iron = true;
		}
		
		try {
			gold = config.getBoolean("gold");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] gold in the configuration file is set to an illegal value! Using default");
			gold = true;
		}
		
		try {
			lapis = config.getBoolean("lapis");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] lapis in the configuration file is set to an illegal value! Using default");
			lapis = true;
		}
		
		try {
			redstone = config.getBoolean("redstone");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] redstone in the configuration file is set to an illegal value! Using default");
			redstone = true;
		}
		
		try {
			emerald = config.getBoolean("emerald");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] emerald in the configuration file is set to an illegal value! Using default");
			emerald = true;
		}

		try {
			quartz = config.getBoolean("quartz");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] quartz in the configuration file is set to an illegal value! Using default");
			quartz = true;
		}
		
		try {
			diamond = config.getBoolean("diamond");
		} catch(Exception e) {
			Bukkit.getLogger().log(Level.WARNING, "[Walking Wasteland] diamond in the configuration file is set to an illegal value! Using default");
			diamond = false;
		}
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

	public static boolean isCrackBrick() {
		return crackBrick;
	}

	public static boolean isExorciseSand() {
		return exorciseSand;
	}

	public static boolean isFreezeWater() {
		return freezeWater;
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
