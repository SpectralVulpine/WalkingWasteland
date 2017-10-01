package com.SpectraVulpine.walkingwasteland.listeners;

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
			Block standingBlock = e.getPlayer().getLocation().subtract(0, 1, 0).getBlock();
			if (standingBlock.getType() == Material.GRASS) {
				standingBlock.setType(Material.DIRT);
			} else if (standingBlock.getType() == Material.WATER || standingBlock.getType() == Material.STATIONARY_WATER) {
				standingBlock.setType(Material.FROSTED_ICE); // frosted ice is like normal ice, but it melts a lot faster
			}
		}
	}
}
