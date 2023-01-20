package com.github.eupedroosouza.tag;

import com.github.eupedroosouza.tag.config.DefaultConfig;
import com.github.eupedroosouza.tag.config.MessagesConfig;
import com.github.eupedroosouza.tag.config.TagsConfig;
import com.github.eupedroosouza.tag.listeners.PlayerJoinListener;
import com.github.eupedroosouza.tag.manager.TagManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.eupedroosouza.tag.app.Update;
import com.github.eupedroosouza.tag.comandos.ComandoTag;
import com.github.eupedroosouza.tag.eventos.Eventos;

public class Main extends JavaPlugin{

	@Getter
	private static Main instance;
	
	public void onEnable() {
		instance = this;

		new DefaultConfig();
		new MessagesConfig();
		new TagsConfig();

		TagManager.getManager().setup();

		new Update().runTaskTimerAsynchronously(Main.getInstance(), 0L, 20L);

		registerCommands();
		registerEvents();
		
		getLogger().info("Plugin enabled.");

	}
	
	public void onDisable() {
		instance = null;

		getLogger().info("Plugin disabled.");
	}
	
	private void registerCommands() {
		getCommand("tag").setExecutor(new ComandoTag());
	}
	
	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
	}

	

}
