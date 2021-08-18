package dev.zihasz.zware.utils.text;

import dev.zihasz.zware.utils.Util;

public class StringUtil implements Util {

	public static String removeLastChar(String string) {
		return string.substring(0, string.length() - 1);
	}

}
