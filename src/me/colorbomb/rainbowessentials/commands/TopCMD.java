package me.colorbomb.rainbowessentials.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TopCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			int playerX = (int) player.getLocation().getX();
			int playerZ = (int) player.getLocation().getZ();
			Location topBlock = null;
			for (int y = 0; y <= 255; y++) {
				if (player.getWorld().getBlockAt(playerX, y, playerZ).getType() != Material.AIR) {
					topBlock = player.getWorld().getBlockAt(playerX, y, playerZ).getLocation();
				}
			}
			player.teleport(topBlock.add(0, 1, 0));
			player.sendMessage(ChatColor.GRAY + "You have been teleported to the top block at your location.");
		} else {
			System.out.println("You can only use this command in-game.");
		}
		return false;
	}
}
