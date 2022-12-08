package com.pedro.tag.utils;

import com.pedro.tag.Main;
import com.pedro.tag.api.ConfigAPI;

public class Messages {
	
	public static String ERRO_SINTAXE_CMD_TAG = "";
	public static String TAG_NAO_EXISTE = "";
	public static String NAO_TEM_TAG = "";
	public static String TAG_TROCADA_SUCESSO = "";
	
	public static void setup() {
		ConfigAPI config = Main.getConfigMessagesApi();
		ERRO_SINTAXE_CMD_TAG = config.getStringReplaced("erro-sintaxe-cmd-tag");
		TAG_NAO_EXISTE = config.getStringReplaced("tag-nao-existe");
		NAO_TEM_TAG = config.getStringReplaced("nao-tem-tag");
		TAG_TROCADA_SUCESSO = config.getStringReplaced("tag-trocado-sucesso");
	}

}
