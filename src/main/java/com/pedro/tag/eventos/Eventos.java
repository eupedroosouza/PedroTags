package com.pedro.tag.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.pedro.tag.app.Tag;

public class Eventos implements Listener{
	
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player jogador = e.getPlayer();
		
		for(Tag tag : Tag.getTags().values()) {
			if(jogador.hasPermission(tag.getPermission())) {
				Tag.getJogadores().put(jogador, tag);
				break;
			}
		}
	}

}
