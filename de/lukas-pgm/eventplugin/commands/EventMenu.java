package de.lukas-pgm.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lukas-pgm.eventplugin.main.GlobalVariables;
import de.lukas-pgm.eventplugin.main.Main;

public class EventMenu implements CommandExecutor {
	
	public static int TaskID;
	public static boolean event_activ;
	public static Location eventLocation;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("eventplugin.admin.eventmenu")) {
				if(args.length == 1) {
					if(event_activ == false) {
	                		eventLocation = player.getLocation();
	                
					Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2" + player.getName() + " hat ein " + args[0] + "-Event gestartet!");
					Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in 60 Sekunden...");
					Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Benutze /event um zum Event zugelangen!");
					event_activ = true;
					TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
						
						int countdown = 60;
						
						@Override
						public void run() {
							if(countdown <= 0) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§cDas " + args[0] + "-Event kann nun nicht mehr beigetreten werden!");
								Bukkit.getScheduler().cancelTask(TaskID);
								event_activ = false;
								return;
							} else
								countdown --;
							if(countdown == 50) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
							if(countdown == 40) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
							if(countdown == 30) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
							if(countdown == 20) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
							if(countdown == 10) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
							if(countdown <= 5) {
								Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§2Das " + args[0] + "-Event startet in " + countdown + " Sekunden...");
							}
						}
						
					}, 0, 20);
					} else
						player.sendMessage(GlobalVariables.chatPrefix + "§cEin Event ist bereits aktiv!");
				} else
					player.sendMessage(GlobalVariables.chatPrefix + "§cBenutze /eventmenu <EVENTNAME>");
			} else
				player.sendMessage(GlobalVariables.chatPrefix + "§cDu darfst diesen Befehl nicht ausführen!");
		} else
			sender.sendMessage(GlobalVariables.chatPrefix + "Dieser Befehl kann nur als Spieler verwendet werden!");
		
		return false;
	}

}
