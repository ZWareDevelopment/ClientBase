package dev.zihasz.client.event.events;

import dev.zihasz.client.event.Event;
import net.minecraft.entity.MoverType;

public abstract class PlayerEvent extends Event {

	public PlayerEvent() {
	}

	public static class Move extends PlayerEvent {
		public MoverType type;
		public double x;
		public double y;
		public double z;

		public Move(MoverType type, double x, double y, double z) {
			this.type = type;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
