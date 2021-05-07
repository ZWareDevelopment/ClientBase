package dev.zihasz.clientbase.utils.misc;

import dev.zihasz.clientbase.utils.Util;

public class TextUtils implements Util {

	public static String textToCircleText(String text) {
		text = text.replace("a", "\u0024d0");
		text = text.replace("b", "\u0024d1");
		text = text.replace("c", "\u0024d2");
		text = text.replace("d", "\u0024d3");
		text = text.replace("e", "\u0024d4");
		text = text.replace("f", "\u0024d5");
		text = text.replace("g", "\u0024d6");
		text = text.replace("h", "\u0024d7");
		text = text.replace("i", "\u0024d8");
		text = text.replace("j", "\u0024d9");
		text = text.replace("k", "\u0024da");
		text = text.replace("l", "\u0024db");
		text = text.replace("m", "\u0024dc");
		text = text.replace("n", "\u0024dd");
		text = text.replace("o", "\u0024de");
		text = text.replace("p", "\u0024df");
		text = text.replace("q", "\u0024e0");
		text = text.replace("r", "\u0024e1");
		text = text.replace("s", "\u0024e2");
		text = text.replace("t", "\u0024e3");
		text = text.replace("u", "\u0024e4");
		text = text.replace("v", "\u0024e5");
		text = text.replace("w", "\u0024e6");
		text = text.replace("x", "\u0024e7");
		text = text.replace("y", "\u0024e8");
		text = text.replace("z", "\u0024e9");
		text = text.replace("1", "\u002460");
		text = text.replace("2", "\u002461");
		text = text.replace("3", "\u002462");
		text = text.replace("4", "\u002463");
		text = text.replace("5", "\u002464");
		text = text.replace("6", "\u002465");
		text = text.replace("7", "\u002466");
		text = text.replace("8", "\u002467");
		text = text.replace("9", "\u002468");
		text = text.replace("0", "\u0024ea");
		return text;
	}

}
