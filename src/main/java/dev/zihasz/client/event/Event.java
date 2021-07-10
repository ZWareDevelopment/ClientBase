package dev.zihasz.client.event;

public abstract class Event extends net.minecraftforge.fml.common.eventhandler.Event {

	public Event() {}

	public void cancel() { this.setCanceled(true); }

	@Override
	public boolean isCancelable() { return true; }

}
