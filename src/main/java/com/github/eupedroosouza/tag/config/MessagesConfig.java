package com.github.eupedroosouza.tag.config;

import com.github.eupedroosouza.tag.Main;
import com.github.eupedroosouza.tag.config.api.Config;
import lombok.Getter;

public class MessagesConfig extends Config {

    @Getter
    private static MessagesConfig instance;

    public String syntaxErrorTagCmd;
    public String tagDoesntExists;
    public String dontHaveTheTag;
    public String tagChanged;

    public MessagesConfig(){
        super(Main.getInstance(), "messages");
        instance = this;

        syntaxErrorTagCmd = getStringReplaced("syntax_error_tag_cmd");
        tagDoesntExists = getStringReplaced("tag_doesnt_exists");
        dontHaveTheTag = getStringReplaced("dont_have_the_tag");
        tagChanged = getStringReplaced("tag_changed");
    }

}
