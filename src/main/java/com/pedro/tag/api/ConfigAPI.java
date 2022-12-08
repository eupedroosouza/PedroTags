package com.pedro.tag.api;

import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigAPI {
	
	private String name;
	private FileConfiguration config;
	
	public ConfigAPI(String name, FileConfiguration config) {
		this.name = name;
		this.config = config;
	}
	
	public String getString(String path) {
		return config.getString(path);
	}
	
	public String getStringReplaced(String path) {
		return getString(path).replace("&", "§");
	}
	
	public ConfigurationSection getSection(String path) {
		return config.getConfigurationSection(path);
	}
	
	public List<String> getStringList(String path){
		return config.getStringList(path);
	}
	
	public int getInt(String path) {
		return config.getInt(path);
	}
	
	public boolean getBoolean(String path) {
		return config.getBoolean(path);
	}
	
	public void set(String path, Object value) {
		config.set(path, value);
	}
	
	public boolean contains(String path) {
		return config.contains(path);
	}
	
	
	public void save() {
		try {
			config.save(DataManager.getFile(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
