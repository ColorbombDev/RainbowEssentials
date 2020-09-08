package me.colorbomb.rainbowessentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GamemodeCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String gArg = null;
			if (args.length == 0) {
				player.sendMessage(ChatColor.GRAY + "Missing arguments. " + ChatColor.RED + "/gamemode <creative/survival/adventure/spectator>");
			} else {
				gArg = args[0];
				if (matchGamemode(gArg) != null) {
					player.setGameMode(matchGamemode(gArg));
					player.sendMessage(ChatColor.GRAY + "Your gamemode has been updated to " + ChatColor.RED + matchGamemodeString(gArg));
				} else {
					player.sendMessage(ChatColor.RED + gArg + ChatColor.GRAY + " is not a valid gamemode.");
				}
			}
		} else {
			System.out.println("You can only use this command in-game.");
		}
		return false;
	}
	
	private GameMode matchGamemode(String arg) {
		GameMode mode = null;
		if (arg.equalsIgnoreCase("c") || arg.equalsIgnoreCase("creative")) {
			mode = GameMode.CREATIVE;
		} else if (arg.equalsIgnoreCase("s") || arg.equalsIgnoreCase("survival")) {
			mode = GameMode.SURVIVAL;
		} else if (arg.equalsIgnoreCase("a") || arg.equalsIgnoreCase("adventure")) {
			mode = GameMode.ADVENTURE;
		} else if (arg.equalsIgnoreCase("sp") || arg.equalsIgnoreCase("spectator")) {
			mode = GameMode.SPECTATOR;
		}
		return mode;
	}
	
	private String matchGamemodeString(String arg) {
		String mode = null;
		if (arg.equalsIgnoreCase("c") || arg.equalsIgnoreCase("creative")) {
			mode = "Creative";
		} else if (arg.equalsIgnoreCase("s") || arg.equalsIgnoreCase("survival")) {
			mode = "Survival";
		} else if (arg.equalsIgnoreCase("a") || arg.equalsIgnoreCase("adventure")) {
			mode = "Adventure";
		} else if (arg.equalsIgnoreCase("sp") || arg.equalsIgnoreCase("spectator")) {
			mode = "Spectator";
		}
		return mode;
	}
}
