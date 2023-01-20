package com.github.eupedroosouza.tag.config.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.commons.lang.Validate;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

/**
 * @version 1.0.0
 * @author PedroCodes
 * @since 02/2022
 */
@Getter
public abstract class Config {

    private final String name;
    protected final Plugin plugin;

    private final File configFile;
    private FileConfiguration config;

    public Config(@NonNull Plugin plugin, @NonNull String name){
        this.plugin = plugin;
        this.name = name;

        this.configFile = new File(plugin.getDataFolder(), name + ".yml");
        load();
    }

    @SneakyThrows
    private void load(){
        Validate.notNull(configFile, "File cannot be null");

        if(!configFile.exists()){
            plugin.saveResource(name + ".yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    @SneakyThrows
    public void save(){
        config.save(configFile);
    }

    public void reload(){
        load();
    }

    public String getString(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return config.getString(path, path + ": not found.");
    }

    public List<String> getStringList(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return config.getStringList(path);
    }

    public boolean getBoolean(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return config.getBoolean(path);
    }

    public int getInt(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return config.getInt(path);
    }

    public double getDouble(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return config.getDouble(path);
    }

    public double getDouble(@NonNull String path, double def){
        Validate.notNull(config, "Config cannot be null");
        return config.getDouble(path, def);
    }

    public String getStringReplaced(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }

    public List<String> getListReplaced(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        List<String> list = config.getStringList(path);
        list.replaceAll(string -> string = ChatColor.translateAlternateColorCodes('&', string));
        return list;
    }

    public void set(String key, Object value){
        config.set(key, value);
    }

    public String getListReplacedWithJoin(@NonNull String path){
        return String.join("\n", getListReplaced(path));
    }

    public ChatColor getChatColor(@NonNull String path){
        Validate.notNull(config, "Config cannot be null");
        return ChatColor.valueOf(getString(path));
    }

    public ConfigurationSection getSection(@NonNull String path){
        return config.getConfigurationSection(path);
    }

}
