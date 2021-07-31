package dev.zihasz.client.utils.text;

import dev.zihasz.client.utils.Util;

public class StringUtil implements Util {

	public static String removeLastChar(String string) {
		return string.substring(0, string.length() - 1);
	}

}
