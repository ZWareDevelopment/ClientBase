package dev.zihasz.clientbase.event;

import me.zero.alpine.type.Cancellable;
import me.zero.alpine.type.EventState;

public class Event extends Cancellable {

	private final EventState state;
	private int stage;

	public Event(EventState state, int stage) {
		this.state = state;
		this.stage = stage;
	}

	public Event(EventState state) {
		this(state, 0);
	}

	public Event(int stage) {
		this(EventState.PRE, stage);
	}

	public Event() {
		this(EventState.PRE, 0);
	}

	public EventState getState() { return state; }

	public int getStage() { return stage; }
	public void setStage(int stage) { this.stage = stage; }
}
