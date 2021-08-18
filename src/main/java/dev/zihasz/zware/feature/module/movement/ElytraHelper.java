package dev.zihasz.zware.feature.module.movement;

import dev.zihasz.zware.feature.module.Category;
import dev.zihasz.zware.feature.module.Module;
import dev.zihasz.zware.feature.settings.Setting;
import dev.zihasz.zware.feature.settings.SettingBuilder;
import dev.zihasz.zware.utils.misc.Timer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ElytraHelper extends Module {

	public ElytraHelper() {
		super("ElytraHelper", "Helps with elytras", Category.MOVEMENT);
	}

	private final Setting<Integer> delay = new SettingBuilder<>(100).name("Delay").description("Delay between pitch changes").range(0, 5000).build(this);

	private Timer timer = new Timer();
	private int stage = 0;

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (timer.passedMS(delay.value)) {
			if (stage == 0) {
				stage = 1;
				mc.player.rotationPitch = -2.6f;
			}
			else if (stage == 1) {
				stage = 0;
				mc.player.rotationPitch = -2.7f;
			}
			timer.reset();
		}
	}

}
