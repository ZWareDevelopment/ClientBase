package dev.zihasz.client.event.events;

import dev.zihasz.client.event.Event;
import dev.zihasz.client.feature.module.Module;

public abstract class ModuleEvent extends Event {

	private final Module module;

	public ModuleEvent(Module module) {
		this.module = module;
	}

	public Module getModule() { return module; }

	public static class Enable extends ModuleEvent {
		public Enable(Module module) {
			super(module);
		}
	}
	public static class Disable extends ModuleEvent {
		public Disable(Module module) {
			super(module);
		}
	}

}
