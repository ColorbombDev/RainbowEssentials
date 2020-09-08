package me.colorbomb.rainbowessentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.colorbomb.rainbowessentials.commands.FeedCMD;
import me.colorbomb.rainbowessentials.commands.FlyCMD;
import me.colorbomb.rainbowessentials.commands.GamemodeCMD;
import me.colorbomb.rainbowessentials.commands.GodCMD;
import me.colorbomb.rainbowessentials.commands.HealCMD;
import me.colorbomb.rainbowessentials.commands.RepairCMD;
import me.colorbomb.rainbowessentials.commands.TopCMD;
import me.colorbomb.rainbowessentials.listeners.EventListener;

public class Main extends JavaPlugin {
	
	public void onEnable() {

		getLogger().info("Loading config..");
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();

		getLogger().info("Registering events..");
		Bukkit.getPluginManager().registerEvents(new EventListener(), this);
		
		getLogger().info("Registering commands..");
		getCommand("gamemode").setExecutor(new GamemodeCMD());
		getCommand("heal").setExecutor(new HealCMD());
		getCommand("feed").setExecutor(new FeedCMD());
		getCommand("god").setExecutor(new GodCMD());
		getCommand("repair").setExecutor(new RepairCMD());
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("top").setExecutor(new TopCMD());

		getLogger().info("Successfully enabled.");
	}

	public void onDisable() {
		getLogger().info("Successfully disabled.");
	}
}
