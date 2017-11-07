/*
 * Death listener for Walking Wasteland plugin
 * Responsible for zombifying those who die via wasteland effect
 */

package com.SpectralVulpine.walkingwasteland.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.SpectralVulpine.walkingwasteland.WalkingWasteland;
import com.SpectralVulpine.walkingwasteland.managers.ConfigManager;
import com.SpectralVulpine.walkingwasteland.managers.WastelandManager;

public class DeathListener implements Listener {
	
	public WalkingWasteland plugin;
	
	public DeathListener(WalkingWasteland ww) {
		plugin = ww;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		// Players who die via Wastelander are resurrected as zombies, with the armor they were wearing.
		if (!e.getEntity().hasPermission("walkingwasteland.immune") && ConfigManager.isZombifyPlayers() && WastelandManager.isWastelander(e.getEntity().getKiller())) {
			String deathMessage;
			if (e.getDeathMessage().contains("shot by")) {
				deathMessage = e.getEntity().getDisplayName() + " was shot down by " + e.getEntity().getKiller().getDisplayName() + ", whose deadly aura resurrected them as a zombie!";
			} else {
				deathMessage = e.getEntity().getDisplayName() + " was killed by " + e.getEntity().getKiller().getDisplayName() + ", whose deadly aura resurrected them as a zombie!";
			}
			e.setDeathMessage(deathMessage);
			ItemStack[] armor = e.getEntity().getEquipment().getArmorContents();
			LivingEntity playerZombie = (LivingEntity)e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE);
			playerZombie.getEquipment().setArmorContents(armor);
			playerZombie.setCustomName(e.getEntity().getDisplayName());
			playerZombie.setCustomNameVisible(true);
		}
	}
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		// Villagers who die via Wastelander are resurrected as zombies
		if (ConfigManager.isZombifyVillagers() && e.getEntityType() == EntityType.VILLAGER && WastelandManager.isWastelander(e.getEntity().getKiller())) {
			Villager deceased = (Villager) e.getEntity();
			Profession job = deceased.getProfession();
			deceased.remove();
			ZombieVillager zombieVillager = (ZombieVillager) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE_VILLAGER);
			zombieVillager.setVillagerProfession(job);
		}
	}
}
