package de.lukas-pgm.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lukas-pgm.eventplugin.main.GlobalVariables;

public class ResetEvent implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("eventplugin.admin.resetevent")) {
			if(args.length == 0) {
				if(EventMenu.event_activ == true) {
					EventMenu.event_activ = false;
					Bukkit.getScheduler().cancelTask(EventMenu.TaskID);
				 for(Player admins : Bukkit.getOnlinePlayers()) {
					    if(admins.hasPermission("adminsystem")) {
					    	admins.sendMessage(GlobalVariables.chatPrefixAdmin + "§c" + player.getName() + " hat den Event Status resettet!");
					    }
						 Bukkit.broadcastMessage(GlobalVariables.chatPrefixEvent + "§cAdmin " + player.getName() + " hat das Event abgebrochen!");
					}
				} else
					player.sendMessage(GlobalVariables.chatPrefix + "§cDer Event-Status kann zurzeit nicht resettet werden, weil kein Event aktiv ist!");
				} else
					player.sendMessage(GlobalVariables.chatPrefix + "§cBenutze /resetevent !");
			} else
				player.sendMessage(GlobalVariables.chatPrefix + "§cDu darfst diesen Befehl nicht ausführen!");
		} else
			sender.sendMessage(GlobalVariables.chatPrefix + "Dieser Befehl kann nur als Spieler verwendet werden!");
		
		return false;
	}

}
