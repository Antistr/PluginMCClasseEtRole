package fr.instart.classesetroles;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChoisClasse implements CommandExecutor {
	
	//On creer l'API (interface) où un joueur peux choisir les objets définissant les classes
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("classe")) {
				
				//On créer un inventaire de 9x1 : le minimum
				Inventory inv = Bukkit.createInventory(player, 9, "classe");
				
				//On creer un item avec un nom particulier à l'emplacement 1
				ItemStack elfe = new ItemStack(Material.BOW);
				ItemMeta elfeMeta = elfe.getItemMeta();
				elfeMeta.setDisplayName("Elfe");
				elfe.setItemMeta(elfeMeta);
				inv.setItem(1, elfe);
				
				//On creer un item avec un nom particulier à l'emplacement 3
				ItemStack humain = new ItemStack(Material.FISHING_ROD);
				ItemMeta humainMeta = humain.getItemMeta();
				humainMeta.setDisplayName("Humain");
				humain.setItemMeta(humainMeta);
				inv.setItem(3, humain);
				
				//On creer un item avec un nom particulier à l'emplacement 5
				ItemStack nain = new ItemStack(Material.WOODEN_PICKAXE);
				ItemMeta nainMeta = nain.getItemMeta();
				nainMeta.setDisplayName("Nain");
				nain.setItemMeta(nainMeta);
				inv.setItem(5, nain);
	
				//On creer un item avec un nom particulier à l'emplacement 7
				ItemStack hobbit = new ItemStack(Material.COOKED_CHICKEN);
				ItemMeta hobbitMeta = hobbit.getItemMeta();
				hobbitMeta.setDisplayName("Hobbit");
				hobbit.setItemMeta(hobbitMeta);
				inv.setItem(7, hobbit);
				
				//On ouvre l'inventaire pour le joueur qui a executé la commande
				player.openInventory(inv);
					
				return true;
			}
			return false;
		}
		return false;
	}
}
