package dev.zihasz.client.event;

/**
 * A simple, simple wrapper of {@link net.minecraftforge.fml.common.eventhandler.Event}.
 * @author Zihasz
 */
public abstract class Event extends net.minecraftforge.fml.common.eventhandler.Event {

	public Event() {}

	/**
	 * Cancels the event.
	 */
	public void cancel() { this.setCanceled(true); }

	@Override
	public boolean isCancelable() { return true; }

}
