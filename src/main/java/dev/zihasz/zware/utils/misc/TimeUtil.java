package dev.zihasz.zware.utils.misc;

import dev.zihasz.zware.utils.Util;

public class TimeUtil implements Util {

	public static int ticksToMs(int ticks) {
		return ticks * 500;
	}
	public static int msToTicks(int millis) {
		return millis / 500;
	}

	public static long convertMSToNS(long time) { return time * 1000000L; }
	public static long convertNSToMS(long time) { return time / 1000000L; }

}
