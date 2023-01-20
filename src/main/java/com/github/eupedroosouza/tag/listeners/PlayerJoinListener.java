package com.github.eupedroosouza.tag.listeners;

import com.github.eupedroosouza.tag.manager.TagManager;
import com.github.eupedroosouza.tag.model.Tag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Pedro
 * @project pedrotags
 * @created 08/12/2022 - 16:22
 */

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        TagManager.getManager().set(player, TagManager.getManager().getTags().values().stream().findAny().get());
    }

}
