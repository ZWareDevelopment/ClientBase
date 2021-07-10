package dev.zihasz.client.event.events;

import dev.zihasz.client.event.Event;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;

public abstract class TransformEvent extends Event {

	private final EnumHandSide handSide;

	public TransformEvent(final EnumHandSide handSide) {
		this.handSide = handSide;
	}

	public EnumHandSide getHandSide() { return handSide; }

	public static class FirstPerson extends TransformEvent {

		public FirstPerson(final EnumHandSide handSide) {
			super(handSide);
		}

		public static class Side extends FirstPerson {
			public Side(final EnumHandSide handSide) {
				super(handSide);
			}
		}
		public static class Eat extends FirstPerson {

			private final ItemStack itemStack;

			public Eat(final EnumHandSide handSide, final ItemStack itemStack) {
				super(handSide);
				this.itemStack = itemStack;
			}

			public ItemStack getItemStack() { return itemStack; }

		}

	}

}