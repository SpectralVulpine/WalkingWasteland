/*
 * PlayerMoveListener - keeps track of when players walk around and makes the magic happen
 */

package com.SpectralVulpine.walkingwasteland.listeners;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;
import com.SpectralVulpine.walkingwasteland.managers.ConfigManager;
import com.SpectralVulpine.walkingwasteland.managers.WastelandManager;

public class PlayerMoveListener implements Listener {

	WalkingWasteland plugin;

	public PlayerMoveListener(WalkingWasteland ww) {
		plugin = ww;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerMove(PlayerMoveEvent e) {
		// TODO: Maybe make this runnable? 5 tick intervals?
		// TODO: Make nearby mobs take damage
		// TODO: Optimize by checking distance before running code - IRRELEVANT if we make this runnable instead
		if (WastelandManager.isWastelander(e.getPlayer())) {
			Random r = new Random();
			Location center = e.getPlayer().getLocation();
			Location bottomCorner = center.subtract(1, 1, 1);
			for (int x = 0; x < ConfigManager.getEffectRadius() * 2 + 1; x++) {
				for (int y = 0; y < ConfigManager.getEffectRadius() * 2 + 2; y++) { // y is one higher because the player is 2 blocks tall
					for (int z = 0; z < ConfigManager.getEffectRadius() * 2 + 1; z++) {
						// Iterates through all blocks in a player-defined area, one row at a time
						if (r.nextInt(100) < ConfigManager.getEffectPower()) {
							Block b = bottomCorner.clone().add(x, y, z).getBlock();
							if (ConfigManager.isKillGrass() && b.getType() == Material.GRASS) {
								b.setType(Material.DIRT);
							} else if (ConfigManager.isFreezeWater() && 
									b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER) {
								b.setType(Material.FROSTED_ICE); // frosted ice is like normal ice, but it melts a lot faster
							} else if (ConfigManager.isKillSmallPlants() && 
									b.getType() == Material.LONG_GRASS || 
									b.getType() == Material.RED_ROSE || 
									b.getType() == Material.YELLOW_FLOWER || 
									b.getType() == Material.DOUBLE_PLANT) {
								if (r.nextInt(2) < 1) {
									b.breakNaturally();
								} else {
									b.setType(Material.DEAD_BUSH);
								}
							} else if (ConfigManager.isDepleteOre() && 
									(ConfigManager.isIron() && b.getType() == Material.IRON_ORE) || 
									(ConfigManager.isLapis() && b.getType() == Material.LAPIS_ORE) || 
									(ConfigManager.isGold() && b.getType() == Material.GOLD_ORE) || 
									(ConfigManager.isRedstone() && (b.getType() == Material.REDSTONE_ORE || 
									b.getType() == Material.GLOWING_REDSTONE_ORE)) || 
									(ConfigManager.isEmerald() && b.getType() == Material.EMERALD_ORE) || 
									(ConfigManager.isDiamond() && b.getType() == Material.DIAMOND_ORE)) {
								if (r.nextInt(2) < 1) {
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
