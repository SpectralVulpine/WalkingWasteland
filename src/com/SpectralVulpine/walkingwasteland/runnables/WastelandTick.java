package com.SpectralVulpine.walkingwasteland.runnables;

import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.walkingwasteland.managers.ConfigManager;
import com.SpectralVulpine.walkingwasteland.managers.WastelandManager;

public class WastelandTick extends BukkitRunnable {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO: Make nearby mobs take damage
		Collection<? extends Player> players = Bukkit.getOnlinePlayers();
		for (Player p : players) {
			if (WastelandManager.isWastelander(p)) {
				Random rng = new Random();
				Location center = p.getLocation();
				int radius = ConfigManager.getEffectRadius();
				Location bottomCorner = center.subtract(radius, radius, radius);
				for (int x = 0; x < radius * 2 + 1; x++) {
					for (int y = 0; y < radius * 2 + 2; y++) { // y is one higher because the player is 2 blocks tall
						for (int z = 0; z < radius * 2 + 1; z++) {
							// Iterates through all blocks in a player-defined area, one row at a time
							if (rng.nextInt(100) < ConfigManager.getEffectPower()) {
								Block b = bottomCorner.clone().add(x, y, z).getBlock();
								if (ConfigManager.isKillGrass() && b.getType() == Material.GRASS) {
									b.setType(Material.DIRT);
								} else if (ConfigManager.isFreezeWater() && 
										(b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
									b.setType(Material.FROSTED_ICE); // frosted ice is like normal ice, but it melts a lot faster
								} else if (ConfigManager.isKillSmallPlants() && 
										(b.getType() == Material.LONG_GRASS || 
										b.getType() == Material.RED_ROSE || 
										b.getType() == Material.YELLOW_FLOWER || 
										b.getType() == Material.DOUBLE_PLANT)) {
									if (rng.nextInt(2) < 1) {
										b.breakNaturally();
									} else {
										b.setType(Material.DEAD_BUSH);
									}
								} else if (ConfigManager.isDepleteOre() && 
										((ConfigManager.isIron() && b.getType() == Material.IRON_ORE) || 
												(ConfigManager.isLapis() && b.getType() == Material.LAPIS_ORE) || 
												(ConfigManager.isGold() && b.getType() == Material.GOLD_ORE) || 
												(ConfigManager.isRedstone() && (b.getType() == Material.REDSTONE_ORE || 
												b.getType() == Material.GLOWING_REDSTONE_ORE)) || 
												(ConfigManager.isEmerald() && b.getType() == Material.EMERALD_ORE) || 
												(ConfigManager.isDiamond() && b.getType() == Material.DIAMOND_ORE))) {
									if (rng.nextInt(2) < 1) {
										b.setType(Material.COAL_ORE);
									} else {
										b.setType(Material.STONE);
									}
								} else if (ConfigManager.isQuartz() && b.getType() == Material.QUARTZ_ORE) {
									b.setType(Material.NETHERRACK);
								} else if (ConfigManager.isExorciseSand() && b.getType() == Material.SOUL_SAND) {
									b.setType(Material.SAND);
								} else if (ConfigManager.isKillFarmland() && b.getType() == Material.SOIL) {
									b.setType(Material.DIRT);
									b.setData((byte) 1);
								} else if (ConfigManager.isKillMoss() && b.getType() == Material.MOSSY_COBBLESTONE) {
									b.setType(Material.COBBLESTONE);
								} else if ((ConfigManager.isKillMushrooms() && (b.getType() == Material.BROWN_MUSHROOM || 
										b.getType() == Material.HUGE_MUSHROOM_1 || 
										b.getType() == Material.HUGE_MUSHROOM_2 || 
										b.getType() == Material.RED_MUSHROOM)) || 
										(ConfigManager.isKillTallPlants() && (b.getType() == Material.CACTUS || 
										b.getType() == Material.SUGAR_CANE_BLOCK)) || 
										(ConfigManager.isKillLeavesVines() && (b.getType() == Material.LEAVES || 
										b.getType() == Material.LEAVES_2 || 
										b.getType() == Material.VINE))) {
									b.breakNaturally();
								} else if (ConfigManager.isCrackBrick() && b.getType() == Material.SMOOTH_BRICK) {
									b.setData((byte) 2);
								}
							}
						}
					}
				}
			}
		}
	}
}
