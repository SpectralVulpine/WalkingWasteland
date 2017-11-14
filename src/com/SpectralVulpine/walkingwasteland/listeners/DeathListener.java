/*
 * Death listener for Walking Wasteland plugin
 * Responsible for zombifying those who die via wasteland effect
 */

package com.SpectralVulpine.walkingwasteland.listeners;

import java.util.List;

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
			ItemStack mainHand = e.getEntity().getEquipment().getItemInMainHand();
			ItemStack offHand = e.getEntity().getEquipment().getItemInOffHand();
			LivingEntity playerZombie = (LivingEntity)e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE);
			// Equip our new playerZombie with the stuff the player was holding.
			playerZombie.getEquipment().setArmorContents(armor);
			playerZombie.getEquipment().setItemInMainHand(mainHand);
			playerZombie.getEquipment().setItemInOffHand(offHand);
			playerZombie.getEquipment().setBootsDropChance(1);
			playerZombie.getEquipment().setChestplateDropChance(1);
			playerZombie.getEquipment().setHelmetDropChance(1);
			playerZombie.getEquipment().setLeggingsDropChance(1);
			playerZombie.getEquipment().setItemInMainHandDropChance(1);
			playerZombie.getEquipment().setItemInOffHandDropChance(1);
			// To prevent items being duplicated (dropped by player and wielded by zombie), clear the player's equipped stuff.
			List<ItemStack> droppedItems = e.getDrops();
			for (ItemStack piece : armor) {
				droppedItems.remove(piece);
			}
			droppedItems.remove(mainHand);
			droppedItems.remove(offHand);
			playerZombie.setCustomName(e.getEntity().getDisplayName());
			playerZombie.setCustomNameVisible(true);
		}
	}
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		// Villagers who die via Wastelander are resurrected as zombies.
		if (ConfigManager.isZombifyVillagers() && e.getEntityType() == EntityType.VILLAGER && WastelandManager.isWastelander(e.getEntity().getKiller())) {
			Villager deceased = (Villager) e.getEntity();
			Profession job = deceased.getProfession();
			Boolean isBaby = !deceased.isAdult();
			deceased.remove();
			ZombieVillager zombieVillager = (ZombieVillager) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE_VILLAGER);
			zombieVillager.setVillagerProfession(job);
			zombieVillager.setBaby(isBaby);
		}
	}
}
