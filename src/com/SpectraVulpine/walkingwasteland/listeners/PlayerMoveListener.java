package com.SpectraVulpine.walkingwasteland.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class PlayerMoveListener implements Listener {
	
	WalkingWasteland plugin;

	public PlayerMoveListener(WalkingWasteland ww) {
		plugin = ww;
	}
	
	@EventHandler
	public static void onPlayerMove(PlayerMoveEvent e) {
		Block standingBlock;
		if (true) { // TODO: Make this only work if they have the permission
			standingBlock = e.getPlayer().getLocation().subtract(0, 1, 0).getBlock();
			if (standingBlock.getType() == Material.GRASS) {
				standingBlock.setType(Material.DIRT);
			} else if (standingBlock.getType() == Material.WATER || standingBlock.getType() == Material.STATIONARY_WATER) {
				standingBlock.setType(Material.ICE);
			}
		}
	}
}
