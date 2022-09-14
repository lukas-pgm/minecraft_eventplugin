package de.lukas-pgm.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.lukas-pgm.eventplugin.main.GlobalVariables;

public class MegaPhone implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("eventplugin.admin.megaphone")) {
				if(args.length >= 1) {					
						String message = "";					 
						for(int i = 0; i < args.length; i++)
						message += " " + args[i];
						Bukkit.broadcastMessage("§6§l---------------------------------------------");
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(GlobalVariables.chatAlertWarning + "§7Broadcast von " + player.getName());
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage(GlobalVariables.chatAlertMsgOut + "§c" + message);
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage("");
						Bukkit.broadcastMessage("§6§l---------------------------------------------");
					} else
						player.sendMessage(GlobalVariables.chatPrefix + "§cBitte benutze /m <Nachricht> oder /megaphone <Nachricht>!");
				} else
			player.sendMessage(GlobalVariables.chatPrefix + "§cDu darfst diesen Befehl nicht ausführen!");
		} else
			sender.sendMessage(GlobalVariables.chatPrefix + "Dieser Befehl kann nur als Spieler verwendet werden!");
		
		return false;
	}

}
