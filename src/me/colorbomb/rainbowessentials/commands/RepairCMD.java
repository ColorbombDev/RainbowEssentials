package me.colorbomb.rainbowessentials.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class RepairCMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
					player.getInventory().getItemInMainHand().setDurability((short) 0);
					player.sendMessage(ChatColor.GRAY + "You have repaired your " + ChatColor.RED + player.getInventory().getItemInMainHand().getType().name().replace("_", " ").toLowerCase());
				} else {
					player.sendMessage(ChatColor.GRAY + "You can't repair air.");
				}
			} else if (args[0].contains("-a")) {
				ItemStack[] contents;
				for (int length = (contents = player.getInventory().getContents()).length, j = 0; j < length; ++j) {
					ItemStack i = contents[j];
					if (i != null) {
						i.setDurability((short) 0);
					}
				}
				player.sendMessage(ChatColor.GRAY + "You have repaired all of the items in your inventory.");
			} else {
				player.sendMessage(ChatColor.GRAY + "Invalid arguments. Valid arguments: " + ChatColor.RED + "-a");
			}
		} else {
			System.out.println("You can only use this command in-game.");
		}
		return false;
	}
}