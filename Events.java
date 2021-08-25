package fr.instart.classesetroles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Events implements Listener {

	//On envoi un message au joueur qui se connecte
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent arrivé) {
		Player player = arrivé.getPlayer();
		
		player.sendMessage(ChatColor.GREEN + "Utilise la commande " + ChatColor.BLUE + "/guide" + ChatColor.GREEN + " pour obtenir de l'aide à propos de plugin.");
		
	}
	
	//On programme l'évenement pour quand un joueur choisie une classe
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerClick (PlayerInteractEvent e) {
		Player player = e.getPlayer();	
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {			
			if (e.getItem() !=null) {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				Scoreboard board = manager.getMainScoreboard();	
				Objective objective = board.getObjective("Classe");
				Score score = objective.getScore(player);
				
				ItemStack i = e.getItem();
				ItemMeta item = i.getItemMeta();
				
				if (item.getDisplayName().equals("Elfe")) {
					player.sendMessage(ChatColor.GREEN + "Tu as choisis la classe " + ChatColor.LIGHT_PURPLE + "elfe" + ChatColor.GREEN + ".");
					score.setScore(1);
					player.getInventory().setItemInMainHand(new ItemStack(Material.BOW));;
					
				}
				if (item.getDisplayName().equals("Humain")) {
					player.sendMessage(ChatColor.GREEN + "Tu as choisis la classe " + ChatColor.LIGHT_PURPLE + "humain" + ChatColor.GREEN + ".");
					score.setScore(2);
					player.getInventory().setItemInMainHand(new ItemStack(Material.FISHING_ROD));;

				}
				if (item.getDisplayName().equals("Nain")) {
					player.sendMessage(ChatColor.GREEN + "Tu as choisis la classe " + ChatColor.LIGHT_PURPLE + "nain" + ChatColor.GREEN + ".");
					score.setScore(3);
					player.getInventory().setItemInMainHand(new ItemStack(Material.WOODEN_PICKAXE));;

				}
				if (item.getDisplayName().equals("Hobbit")) {
					player.sendMessage(ChatColor.GREEN + "Tu as choisis la classe " + ChatColor.LIGHT_PURPLE + "hobbit" + ChatColor.GREEN + ".");
					score.setScore(4);
					player.getInventory().setItemInMainHand(new ItemStack(Material.COOKED_CHICKEN));;

				}
			return;	
			}
		return;
		}
	return;
	}
	

	//On programe les effets pour les classe qui nécessite de manger : hobbit
	@EventHandler
	public void onPlayerEat (PlayerItemConsumeEvent p) {
		Player player = p.getPlayer();
			
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getMainScoreboard();	
		Objective objective = board.getObjective("Classe");
		@SuppressWarnings("deprecation")
		Score score = objective.getScore(player);
			
		if (score.getScore() == 4) {
			player.addPotionEffect((new PotionEffect(PotionEffectType.ABSORPTION, 99999, 0, true)));
				
		
		}
		return;
	}
}