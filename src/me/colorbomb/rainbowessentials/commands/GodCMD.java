package me.colorbomb.rainbowessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GodCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.isInvulnerable()) {
				player.setInvulnerable(false);
				player.sendMessage(ChatColor.GRAY + "You are no longer in god mode.");
			} else {
				player.setInvulnerable(true);
				player.sendMessage(ChatColor.GRAY + "You are now in god mode.");
			}
		} else {
			System.out.println("You can only use this command in-game.");
		}
		return false;
	}
}
