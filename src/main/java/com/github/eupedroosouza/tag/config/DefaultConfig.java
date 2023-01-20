package com.github.eupedroosouza.tag.config;

import com.github.eupedroosouza.tag.Main;
import com.github.eupedroosouza.tag.config.api.Config;

public class DefaultConfig extends Config {

    public DefaultConfig() {
        super(Main.getInstance(), "config");
    }
}
