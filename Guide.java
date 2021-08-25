package fr.instart.classesetroles;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Guide implements CommandExecutor {
	
	//on creer et on donne un livre qui est un guide quand un joueur execute la commande
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
				if (cmd.getName().equalsIgnoreCase("Guide")) {
					
					//On creer un livre avec un nom et un auteur
					ItemStack Guide = new ItemStack(Material.WRITTEN_BOOK);
					BookMeta GuideMeta = (BookMeta) Guide.getItemMeta();
					GuideMeta.setTitle("Guide");
					GuideMeta.setAuthor("Instart");
					
					//On creer les pages à la suite, avec le texte qu'elle contiennent
					List<String> pages = new ArrayList<String>();
					pages.add("Il y a 4 choix possible : §dElfe§r, §dHumain§r, §dNain§r, §dHobbit§r.");
					pages.add("§dElfe§r : §6vision nocturne§r ainsi que §6invisibilité 1§r et §6vitesse 1§r dans des biomes forêt");
					pages.add("§dHumain§r : §6chance 1");
					pages.add("§dNain§r : §6célérité 1§r et §6résistance 1");
					pages.add("§dHobbit§r : 2 coeur d'§6absorption§r quand il mange.");
					pages.add("Pour choisir, il faut executer la commande §9/classe§r et prendre l'item avec la nom de la classe choisi dans la main puis faire un clic droit dans le vide.");
					//On ajoute les pages au livre
					GuideMeta.setPages(pages);
					
					//On place le livre en tant qu'item dans le jeu
					Guide.setItemMeta(GuideMeta);
					
					//On donne le livre au joueur
					player.getInventory().addItem(Guide);					
					return true;
				}
				return false;
		}
		return false;
	}

}