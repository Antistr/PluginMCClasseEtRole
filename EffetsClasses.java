package fr.instart.classesetroles;

import org.bukkit.scheduler.BukkitRunnable;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class EffetsClasses extends BukkitRunnable{
	
	//on programme les actions qui seront executé en boucle
	@Override
	public void run() {
		//On creer la liste qui contiendra tous les biomes foret
		ArrayList<Biome> biomesListID = new ArrayList<Biome>();
			//On ajoute tous les biomes avec une foret à la liste
			biomesListID.add(Biome.FOREST);
			biomesListID.add(Biome.FLOWER_FOREST);
			biomesListID.add(Biome.WOODED_HILLS);
			biomesListID.add(Biome.BIRCH_FOREST);
			biomesListID.add(Biome.TALL_BIRCH_FOREST);
			biomesListID.add(Biome.BIRCH_FOREST_HILLS);
			biomesListID.add(Biome.DARK_FOREST);
			biomesListID.add(Biome.DARK_FOREST_HILLS);
			biomesListID.add(Biome.TAIGA);
			biomesListID.add(Biome.TAIGA_HILLS);
			biomesListID.add(Biome.TAIGA_MOUNTAINS);
			biomesListID.add(Biome.GIANT_SPRUCE_TAIGA);
			biomesListID.add(Biome.GIANT_SPRUCE_TAIGA_HILLS);
			biomesListID.add(Biome.GIANT_TREE_TAIGA);
			biomesListID.add(Biome.GIANT_TREE_TAIGA_HILLS);
			biomesListID.add(Biome.JUNGLE);
			biomesListID.add(Biome.JUNGLE_EDGE);
			biomesListID.add(Biome.MODIFIED_JUNGLE);
			biomesListID.add(Biome.JUNGLE_HILLS);
			biomesListID.add(Biome.MODIFIED_JUNGLE_EDGE);
			biomesListID.add(Biome.BAMBOO_JUNGLE);
			biomesListID.add(Biome.BAMBOO_JUNGLE_HILLS);
			biomesListID.add(Biome.WOODED_MOUNTAINS);
			biomesListID.add(Biome.WOODED_BADLANDS_PLATEAU);
			biomesListID.add(Biome.SNOWY_TAIGA);
			biomesListID.add(Biome.SNOWY_TAIGA_HILLS);
			biomesListID.add(Biome.SNOWY_TAIGA_MOUNTAINS);
			biomesListID.add(Biome.CRIMSON_FOREST);
			biomesListID.add(Biome.WARPED_FOREST);
			biomesListID.add(Biome.FOREST);
			biomesListID.add(Biome.FOREST);
			biomesListID.add(Biome.FOREST);
		
		//On effectue le test pour tous les joueurs en ligne
		for (Player pl : Bukkit.getOnlinePlayers()) {
			Player player = pl.getPlayer();
			
			//On défini et on récupere la scoreboarde où on enregistre la classe de tous les joueurs
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getMainScoreboard();	
			Objective objective = board.getObjective("Classe");
			@SuppressWarnings("deprecation")
			Score score = objective.getScore(player);
			
			//On test s'il est 1 -> Elfe
			if (score.getScore() == 1) {
				//On donne les effets constant
				player.addPotionEffect((new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 0, true)));				
				
				//On recupere le nom du biome où est le joueur
				Biome biome = player.getLocation().getBlock().getBiome();
				//On test s'il est dans le bon biome (liste au début)
				if (biomesListID.contains(biome)) {
					//on lui donne les effet s'il est dans le bon biome
					player.addPotionEffect((new PotionEffect(PotionEffectType.INVISIBILITY, 40, 1, true)));
					player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 40, 0, true)));

				}				
			}

			//On test s'il est 2 -> Humain
			if (score.getScore() == 2) {
				//On donne les effets constant
				player.addPotionEffect((new PotionEffect(PotionEffectType.LUCK, 99999, 0, true)));
				

			}
			
			//On test s'il est 3 -> Nain
			if (score.getScore() == 3) {
				//On donne les effets constant
				player.addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, true)));
				player.addPotionEffect((new PotionEffect(PotionEffectType.FAST_DIGGING, 99999, 0, true)));

			}
			
			//Hobbit à lieu lors d'un évenement donc dans Event.java
			return;
		}
	}
}