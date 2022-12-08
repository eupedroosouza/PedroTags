package com.pedro.tag.app;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.pedro.tag.Main;
import com.pedro.tag.api.ConfigAPI;

public class Tag {
	
	private static HashMap<Player, Tag> jogadores = new HashMap<>();
	private static HashMap<String, Tag> tags = new HashMap<>();
	
	private String name;
	private String display;
	private String prefix;
	private String suffix;
	private String hierarchy;
	private String permission;
	
	public Tag(String name, String display, String prefix, String suffix, String hierarchy, String permission) {
		this.name = name.toLowerCase();
		this.display = display;
		this.prefix = prefix;
		this.suffix = suffix;
		this.hierarchy = hierarchy;
		this.permission = permission;
		
		tags.put(this.name, this);
	}

	public String getName() {
		return name;
	}
	
	public String getDisplay() {
		return display;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getPermission() {
		return permission;
	}
	
	public static void setup() {
		ConfigAPI config = Main.getConfigTagsApi();
		if(config.contains("tags")) {
			for(String key : config.getSection("tags").getKeys(false)) {
				String name = key;
				String display = config.getString("tags." + key + ".display").replace("&", "§");
				String prefix = config.getString("tags." + key + ".prefix").replace("&", "§");
				String suffix = config.getString("tags." + key + ".suffix").replace("&", "§");
				String hierarchy = config.getString("tags." + key + ".hierarchy");
				String permission = config.getString("tags." + key + ".permission");
				new Tag(name, display, prefix, suffix, hierarchy, permission);
			}
			Main.getInstance().getLogger().info("Foram carregadas " + tags.size() + " tag(s).");
		}
	}
	
	public static Tag get(String name) {
		return tags.get(name);
	}
	
	public static HashMap<String, Tag> getTags(){
		return tags;
	}
	
	public static HashMap<Player, Tag> getJogadores(){
		return jogadores;
	}

}
