package dev.zihasz.clientbase.event.events;

import dev.zihasz.clientbase.event.Event;
import me.zero.alpine.type.EventState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public abstract class BlockEvent extends Event {

	BlockPos blockPos;

	public BlockEvent(BlockPos blockPos, EventState state) {
		super(state);
		this.blockPos = blockPos;
	}

	public BlockPos getBlockPos() {
		return blockPos;
	}

	public static class Click extends BlockEvent {
		EnumFacing face;

		public Click(BlockPos blockPos, EnumFacing face, EventState state) {
			super(blockPos, state);
			this.face = face;
		}

		public EnumFacing getFace() {
			return face;
		}
	}
	public static class Damage extends BlockEvent {
		EnumFacing face;

		public Damage(BlockPos blockPos, EnumFacing face, EventState state) {
			super(blockPos, state);
			this.face = face;
		}

		public EnumFacing getFace() {
			return face;
		}
	}
	public static class Break extends BlockEvent {
		public Break(BlockPos blockPos, EventState state) {
			super(blockPos, state);
		}
	}

}
