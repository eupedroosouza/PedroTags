package com.github.eupedroosouza.tag.repository;

import com.github.eupedroosouza.tag.config.TagsConfig;
import com.github.eupedroosouza.tag.model.Tag;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pedro
 * @project pedrotags
 * @created 08/12/2022 - 15:57
 */
public class TagRepository {

    @Getter
    private static final TagRepository repository = new TagRepository();

    public Tag load(String id){
        TagsConfig config = TagsConfig.getInstance();

        String name = config.getStringReplaced("tags." + id + ".name");
        String prefix = config.getStringReplaced("tags." + id + ".prefix");
        String suffix = config.getStringReplaced("tags." + id + ".suffix");
        int priority = config.getInt("tags." + id + ".priority");
        String permission = config.getString("tags." + id + ".permission");

        return new Tag(id, name, prefix, suffix, priority, permission);
    }


    public List<Tag> loadAll(){
        return TagsConfig.getInstance().getSection("tags").getKeys(false).stream()
                .map(this::load).collect(Collectors.toList());
    }

}
