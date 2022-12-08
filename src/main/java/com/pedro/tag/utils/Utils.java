package com.pedro.tag.utils;

import com.pedro.tag.Main;

public class Utils {
	
	public static boolean PEX = false;
	
	public static void setup() {
		PEX = Main.getConfigApi().getBoolean("pex");
	}
	
}
