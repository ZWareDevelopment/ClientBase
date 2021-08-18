package dev.zihasz.client.event.events;

import dev.zihasz.client.event.Event;
import net.minecraft.network.Packet;

public abstract class PacketEvent extends Event {

	private final Packet packet;

	public PacketEvent(Packet packet) {
		this.packet = packet;
	}

	public Packet getPacket() { return packet; }

	public static class Send extends PacketEvent {
		public Send(Packet packet) {
			super(packet);
		}
	}

	public static class Read extends PacketEvent {
		public Read(Packet packet) {
			super(packet);
		}
	}

}
