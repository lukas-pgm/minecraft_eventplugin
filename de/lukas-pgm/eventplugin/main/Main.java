package de.lukas-pgm.eventplugin.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {	
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;

		
		//Admin Commands
		getCommand("eventmenu").setExecutor(new de.lukas-pgm.eventplugin.commands.EventMenu());
		getCommand("em").setExecutor(new de.lukas-pgm.eventplugin.commands.EventMenu());
		getCommand("resetevent").setExecutor(new de.lukas-pgm.eventplugin.commands.ResetEvent());
		getCommand("re").setExecutor(new de.lukas-pgm.eventplugin.commands.ResetEvent());
		getCommand("eventmegaphone").setExecutor(new de.lukas-pgm.eventplugin.commands.MegaPhone());
		getCommand("em").setExecutor(new de.lukas-pgm.eventplugin.commands.MegaPhone());

		//Player Command
		getCommand("event").setExecutor(new de.lukas-pgm.eventplugin.commands.Event());
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
