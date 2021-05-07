package dev.zihasz.clientbase.features.module.player;

import dev.zihasz.clientbase.features.module.Category;
import dev.zihasz.clientbase.features.module.Module;
import dev.zihasz.clientbase.features.setting.Setting;

public class SpeedMine extends Module {

	public SpeedMine() {
		super("SpeedMine", "Mines blocks faster", Category.PLAYER);
	}

	private final Setting<Float> damage = new Setting<>("", "", .7f, 0f, 1f);

	@Override
	public void onUpdate() {
		if (nullCheck()) return;

		if (mc.playerController.curBlockDamageMP >= damage.getValue())
			mc.playerController.curBlockDamageMP = 1f;
	}
}
