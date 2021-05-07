package dev.zihasz.clientbase.features.module.movement;

import dev.zihasz.clientbase.features.module.Category;
import dev.zihasz.clientbase.features.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "Automatically sprints.", Category.MOVEMENT);
	}

	@Override
	public void onDisable() {
		mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown());
	}

	@Override
	public void onUpdate() {
		if (mc.player.foodStats.getFoodLevel() > 6) {
			mc.player.setSprinting(true);
		}
	}
}
