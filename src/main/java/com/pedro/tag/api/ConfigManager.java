package com.pedro.tag.api;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.google.common.io.Resources;
import com.pedro.tag.Main;

public class ConfigManager {
	
	
	public static void createConfig(String file) {
		if (!new File(Main.getInstance().getDataFolder(), file + ".yml").exists()) {
			Main.getInstance().saveResource(file + ".yml", false); 
		}
	}
	
	public static FileConfiguration getConfig(String file) {
      	File arquivo = new File(Main.getInstance().getDataFolder() + File.separator + file + ".yml");
      	FileConfiguration config = (FileConfiguration)YamlConfiguration.loadConfiguration(arquivo);
      	try {
			String allText = Resources.toString(arquivo.toURI().toURL(), Charset.forName("UTF-8"));
			config.loadFromString(allText);
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
      	return config;
	}

}
