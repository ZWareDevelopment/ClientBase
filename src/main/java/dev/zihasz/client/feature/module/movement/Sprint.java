package dev.zihasz.client.feature.module.movement;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {

	private Setting<Boolean> rage = new SettingBuilder<>(true).name("Rage").description("Always sprints.").build(this);

	public Sprint() {
		super("Sprint", "Automatically sprints for you.", Category.MOVEMENT);
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (nullCheck()) return;

		if (mc.player.getFoodStats().getFoodLevel() < 6) {
			mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown());
			return;
		}
		mc.player.setSprinting(!rage.getValue() || (mc.gameSettings.keyBindForward.isKeyDown() &&
						!mc.player.collidedHorizontally &&
						!mc.player.isSneaking()));
	}

	@Override
	public void onDisable() {
		if (nullCheck()) return;

		mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown());
	}
}
