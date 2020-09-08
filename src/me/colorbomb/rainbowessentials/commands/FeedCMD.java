package me.colorbomb.rainbowessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FeedCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.setFoodLevel(20);
			player.setSaturation(20);
			player.sendMessage(ChatColor.GRAY + "You have been fed.");
		} else {
			System.out.println("You can only use this command in-game.");
		}
		return false;
	}
}
