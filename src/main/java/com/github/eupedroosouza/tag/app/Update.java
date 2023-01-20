package com.github.eupedroosouza.tag.app;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

@SuppressWarnings("deprecation")
public class Update extends BukkitRunnable{

	public void run() {
		/*for(Player jogadores : Bukkit.getOnlinePlayers()) {
			if(jogadores.getScoreboard() == null) {
				jogadores.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
			}else {
				update(jogadores.getScoreboard());
			}
		}
		update(Bukkit.getScoreboardManager().getMainScoreboard());	*/
	}
	
	/*public static void update(Scoreboard scoreboard) {
		for(Entry<Player, Tag> entry : Tag.getJogadores().entrySet()) {
			Player jogador = entry.getKey();
			Tag tag = entry.getValue();
			
			Team team = null;
			if(jogador.getName().length() >= 15) {
				if((team = scoreboard.getTeam(tag.getHierarchy() + jogador.getName().substring(15))) == null){
					team = scoreboard.registerNewTeam(tag.getHierarchy() + jogador.getName().substring(15));
				}else {
					team = scoreboard.getTeam(tag.getHierarchy() + jogador.getName().substring(15));
				}
			}else {
				if((team = scoreboard.getTeam(tag.getHierarchy() + jogador.getName())) == null){
					team = scoreboard.registerNewTeam(tag.getHierarchy() + jogador.getName());
				}else {
					team = scoreboard.getTeam(tag.getHierarchy() + jogador.getName());
				}
			}
			
			if(!team.hasPlayer(jogador)) {
				team.addPlayer(jogador);
			}
			
			team.setPrefix(tag.getPrefix());
			team.setSuffix(tag.getSuffix());
			continue;
		}
	}*/

}
