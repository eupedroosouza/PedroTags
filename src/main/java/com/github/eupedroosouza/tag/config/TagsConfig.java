package com.github.eupedroosouza.tag.config;

import com.github.eupedroosouza.tag.Main;
import com.github.eupedroosouza.tag.config.api.Config;
import lombok.Getter;

public class TagsConfig extends Config {

    @Getter
    private static TagsConfig instance;

    public TagsConfig(){
        super(Main.getInstance(), "tags");
        instance = this;
    }
}
