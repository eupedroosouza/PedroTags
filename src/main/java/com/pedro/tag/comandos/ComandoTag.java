package com.pedro.tag.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.pedro.tag.app.Tag;
import com.pedro.tag.utils.Messages;

public class ComandoTag implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}else {
			Player jogador = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("tag")) {
				if(args.length == 1) {
					if(Tag.get(args[0].toLowerCase()) == null) {
						jogador.sendMessage(Messages.TAG_NAO_EXISTE.replace("%tag%", args[0].toLowerCase()));
						return false;
					}
					Tag tag = Tag.get(args[0].toLowerCase());
					
					if(!jogador.hasPermission(tag.getPermission())) {
						jogador.sendMessage(Messages.NAO_TEM_TAG.replace("%tag%", tag.getDisplay()));
						return false;
					}
					
					if(Tag.getJogadores().containsKey(jogador)) {
						Tag.getJogadores().remove(jogador);
					}
					Tag.getJogadores().put(jogador, tag);
					jogador.sendMessage(Messages.TAG_TROCADA_SUCESSO.replace("%tag%", tag.getDisplay()));
					return true;
				}else {
					jogador.sendMessage(Messages.ERRO_SINTAXE_CMD_TAG);
					return false;
				}
			}
		}
		return false;
	}

}
