/*
 * ParticleManager - handles the creation of particles for various effects
 */

package com.SpectralVulpine.walkingwasteland.managers;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;

public class ParticleManager {
	
	private static Random random = new Random();
	
	public static WalkingWasteland plugin = (WalkingWasteland) Bukkit.getPluginManager().getPlugin("WalkingWasteland");
	
	public static void wastelandAura(Location l) {
		World w = l.getWorld();
		l = l.add(random.nextDouble(), random.nextDouble(), random.nextDouble());
		w.spawnParticle(Particle.SUSPENDED_DEPTH, l, 4, random.nextDouble(), random.nextDouble(), random.nextDouble());
	}
}
