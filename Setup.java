package fr.instart.classesetroles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Setup implements CommandExecutor {
	
	//On setup la scoreborde qu'utilise le plugin pour sauvegarder les donnée via le serveur
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("initialisation")) {
				if (sender.isOp()) {
					
					//Creation d'une scoreboard gere par le serveur avec un objectif "classe"
					ScoreboardManager manager = Bukkit.getScoreboardManager();
					Scoreboard board = manager.getMainScoreboard();	
					board.registerNewObjective("Classe", "dummy", "Classe");	
					player.setScoreboard(board);
					player.sendMessage(ChatColor.RED + "Scoreboard setup !");
					
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
