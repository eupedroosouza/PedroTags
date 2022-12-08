package com.pedro.tag;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.pedro.tag.api.ConfigAPI;
import com.pedro.tag.api.ConfigManager;
import com.pedro.tag.app.Tag;
import com.pedro.tag.app.Update;
import com.pedro.tag.comandos.ComandoTag;
import com.pedro.tag.eventos.Eventos;
import com.pedro.tag.utils.Messages;
import com.pedro.tag.utils.Utils;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private static FileConfiguration configPrincipal;
	private static FileConfiguration configTags;
	private static FileConfiguration configMessages;
	private static ConfigAPI configApi;
	private static ConfigAPI configTagsApi;
	private static ConfigAPI configMessagesApi;
	
	public void onEnable() {
		instance = this;

		registrarArquivos();
		Tag.setup();
		Utils.setup();
		Messages.setup();
		new Update().runTaskTimerAsynchronously(Main.getInstance(), 0L, 20L);
		registrarComandos();
		registrarEventos();
		
		getLogger().info("Plugin ativado com sucesso.");

	}
	
	public void onDisable() {
		instance = null;

		getLogger().info("Plugin ativado com sucesso.");
	}
	
	private void registrarArquivos() {
		ConfigManager.createConfig("config");
		ConfigManager.createConfig("tags");
		ConfigManager.createConfig("messages");
		configPrincipal = ConfigManager.getConfig("config");
		configTags = ConfigManager.getConfig("tags");
		configMessages = ConfigManager.getConfig("messages");
		configApi = new ConfigAPI("config", configPrincipal);
		configTagsApi = new ConfigAPI("tags", configTags);
		configMessagesApi = new ConfigAPI("messages", configMessages);
	}
	
	private void registrarComandos() {
		getCommand("tag").setExecutor(new ComandoTag());
	}
	
	private void registrarEventos() {
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static FileConfiguration getConfigPrinicipal() {
		return configPrincipal;
	}
	
	public static FileConfiguration getConfigTags() {
		return configTags;
	}
	
	public static FileConfiguration getConfigMessages() {
		return configMessages;
	}
	
	public static ConfigAPI getConfigApi() {
		return configApi;
	}
	
	public static ConfigAPI getConfigTagsApi() {
		return configTagsApi;
	}
	
	public static ConfigAPI getConfigMessagesApi() {
		return configMessagesApi;
	}
	

}
