package com.SpectralVulpine.walkingwasteland.managers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class WastelandManager {
	// TODO: Use player metadata instead of this class
	private static ArrayList<Player> wastelanders = new ArrayList<Player>();
	
	public static void addWastelander(Player p) {
		if (!wastelanders.contains(p)) {
			wastelanders.add(p);
		}
	}
	
	public static void removeWastelander(Player p) {
		if (wastelanders.contains(p)) {
			wastelanders.remove(p);
		}
	}
	
	public static void toggleWastelander(Player p) {
		if (wastelanders.contains(p)) {
			wastelanders.remove(p);
		} else {
			wastelanders.add(p);
		}
	}
	
	public static ArrayList<Player> getWastelanders() {
		return wastelanders;
	}
	
	public static boolean isWastelander(Player p) {
		return wastelanders.contains(p);
	}
}
