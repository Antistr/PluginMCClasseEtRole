package fr.instart.classesetroles;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
	//Tout ce qui est executé dés que le plugin est lancé
	@Override
	public void onEnable() {
		System.out.println("Pulgin Classes démarré !");
		
		//Mise en place des commandes
		getCommand("guide").setExecutor(new Guide());
		getCommand("classe").setExecutor(new ChoisClasse());
		getCommand("initialisation").setExecutor(new Setup());
		
		//Mise en place des évènements
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		//On creer un tache qui permet d'affecter les effets des classes qui se repete toute les 1 seconde (20 tics)
		BukkitRunnable task = new EffetsClasses();
		task.runTaskTimer(this, 0, 20);	
	}
	
	//Tout ce qui est executé dés que le plugin est éteint
	@Override
	public void onDisable() {
		System.out.println("Pulgin Classes éteint !");
	}
}
