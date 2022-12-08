package com.pedro.tag.app;

import org.bukkit.entity.Player;

public class TagAPI {
	
	public static Tag getPlayerTag(Player jogador) {
		if(Tag.getJogadores().containsKey(jogador)) {
			return Tag.getJogadores().get(jogador);
 		}
		return null;
	}
	
	public static void setPlayerTag(Player jogador, Tag tag) {
		if(Tag.getJogadores().containsKey(jogador)) {
			Tag.getJogadores().remove(jogador);
		}
		Tag.getJogadores().put(jogador, tag);
		return;
	}
	
	public static boolean containsTag(Player jogador, Tag tag) {
		return jogador.hasPermission(tag.getPermission());
	}
	
	public static Tag getTag(String name) {
		return Tag.get(name);
	}

}
