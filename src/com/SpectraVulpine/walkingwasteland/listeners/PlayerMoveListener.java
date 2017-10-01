package com.SpectraVulpine.walkingwasteland.listeners;

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

	@EventHandler
	public static void onPlayerMove(PlayerMoveEvent e) {
		if (WastelandManager.isWastelander(e.getPlayer())) {
			Location center = e.getPlayer().getLocation();
			Location bottomCorner = center.subtract(3, 3, 3);
			for (int x = 0; x < 7; x++) {
				for (int y = 0; y < 7; y++) {
					for (int z = 0; z < 7; z++) {
						// Iterates through all blocks in a 7x7x7 area, one row at a time
						Block b = bottomCorner.clone().add(x, y, z).getBlock();
						if (b.getType() != Material.AIR) {
							System.out.println("[WASTELAND DEBUG] Got block of type " + b.getType().toString());
						}
						if (b.getType() == Material.GRASS) {
							b.setType(Material.DIRT);
						} else if (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER) {
							b.setType(Material.FROSTED_ICE); // frosted ice is like normal ice, but it melts a lot faster
						}
					}
				}
			}
		}
	}
}
