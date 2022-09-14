package de.lukas-pgm.eventplugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.lukas-pgm.eventplugin.main.GlobalVariables;

public class Event implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 0) {
				if(EventMenu.event_activ == true) {
				player.setGameMode(GameMode.SURVIVAL);
                		player.teleport(EventMenu.eventLocation);
				player.sendMessage(GlobalVariables.chatPrefixEvent + "§2Du hast dich erfolgreich zum Event teleportiert!");
				player.setHealth(20);
				player.setFoodLevel(20);
				} else
					player.sendMessage(GlobalVariables.chatPrefix + "§cEs ist kein Event aktiv!");
				} else
					player.sendMessage(GlobalVariables.chatPrefix + "§cBenutze /event !");
		} else
			sender.sendMessage(GlobalVariables.chatPrefix + "Dieser Befehl kann nur als Spieler verwendet werden!");
		
		return false;
	}

}
