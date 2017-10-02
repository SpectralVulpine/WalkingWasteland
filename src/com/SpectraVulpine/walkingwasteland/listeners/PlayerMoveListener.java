package com.SpectraVulpine.walkingwasteland.listeners;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;
import com.SpectralVulpine.walkingwasteland.managers.WastelandManager;

public class PlayerMoveListener implements Listener {

	WalkingWasteland plugin;

	public PlayerMoveListener(WalkingWasteland ww) {
		plugin = ww;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onPlayerMove(PlayerMoveEvent e) {
		// TODO: Make nearby mobs take damage
		if (WastelandManager.isWastelander(e.getPlayer())) {
			Random r = new Random();
			Location center = e.getPlayer().getLocation();
			Location bottomCorner = center.subtract(1, 1, 1);
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 4; y++) { // y is higher because the player is 2 blocks tall
					for (int z = 0; z < 3; z++) {
						// Iterates through all blocks in a 3x4x3 area, one row at a time
						if (r.nextInt(100) < 20) { // TODO: Make this configurable
							Block b = bottomCorner.clone().add(x, y, z).getBlock();
							if (b.getType() == Material.GRASS) {
								b.setType(Material.DIRT);
							} else if (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER) {
								b.setType(Material.FROSTED_ICE); // frosted ice is like normal ice, but it melts a lot faster
							} else if (b.getType() == Material.LONG_GRASS || 
									b.getType() == Material.RED_ROSE || 
									b.getType() == Material.YELLOW_FLOWER || 
									b.getType() == Material.DOUBLE_PLANT) {
								if (r.nextInt(2) < 1) {
									b.breakNaturally();
								} else {
									b.setType(Material.DEAD_BUSH);
								}
							} else if (b.getType() == Material.LEAVES || b.getType() == Material.LEAVES_2) {
								b.breakNaturally();
							} else if (b.getType() == Material.IRON_ORE || 
									b.getType() == Material.LAPIS_ORE || 
									b.getType() == Material.GOLD_ORE || 
									b.getType() == Material.REDSTONE_ORE || 
									b.getType() == Material.GLOWING_REDSTONE_ORE || 
									b.getType() == Material.EMERALD_ORE) {
								b.setType(Material.COAL_ORE);
							} else if (b.getType() == Material.QUARTZ_ORE) {
								b.setType(Material.NETHERRACK);
							} else if (b.getType() == Material.SOUL_SAND) {
								b.setType(Material.GRAVEL);
							} else if (b.getType() == Material.SOIL) {
								b.setType(Material.DIRT);
								b.setData((byte) 1);
							} else if (b.getType() == Material.VINE) {
								b.breakNaturally();
							} else if (b.getType() == Material.SUGAR_CANE_BLOCK) {
								b.breakNaturally();
							} else if (b.getType() == Material.MOSSY_COBBLESTONE) {
								b.setType(Material.COBBLESTONE);
							} else if (b.getType() == Material.BROWN_MUSHROOM || 
									b.getType() == Material.RED_MUSHROOM || 
									b.getType() == Material.HUGE_MUSHROOM_1 || 
									b.getType() == Material.HUGE_MUSHROOM_2) {
								b.breakNaturally();
							} else if (b.getType() == Material.SMOOTH_BRICK) {
								b.setData((byte) 2);
							}
						}
					}
				}
			}
		}
	}
}
