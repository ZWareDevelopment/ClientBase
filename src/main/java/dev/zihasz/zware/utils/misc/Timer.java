package dev.zihasz.zware.utils.misc;


import dev.zihasz.zware.utils.Util;

import java.sql.Time;

public class Timer implements Util {

	private long time = -1L;

	public boolean passedNS(long ns) { return System.nanoTime() - this.time >= ns; }
	public boolean passedMS(long ms) { return this.passedNS(TimeUtil.convertMSToNS(ms)); }
	public boolean passedS(double s) { return this.passedMS((long) s * 1000L); }



	public void reset() {
		this.time = System.nanoTime();
	}

	public long getTime() { return time; }

	/**
	 * Set the timers current time.
	 * @param time The time in <i>nano</i> seconds.
	 */
	public void setTime(long time) { this.time = time; }

}