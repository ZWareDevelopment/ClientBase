package dev.zihasz.client.feature.module.render;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Brightness extends Module {

	private final Setting<Mode> mode = new SettingBuilder<>(Mode.Potion)
			.name("Mode")
			.description("Change the gamma setting or give night vision potion effect.")
			.build(this);
	private final Setting<Float> gamma = new SettingBuilder<>(100f)
			.name("Gamma")
			.description("The gamma value to use if mode is set to Gamma.")
			.range(0f, 100f)
			.visibility(v -> mode.getValue().equals(Mode.Gamma))
			.build(this);
	private float oldGamma = 0f;

	public Brightness() {
		super("Brightness", "Brightens your day.", Category.RENDER);
	}

	@Override
	public void onEnable() {
		oldGamma = mc.gameSettings.gammaSetting;
		if (mode.getValue().equals(Mode.Gamma))
			mc.gameSettings.gammaSetting = gamma.getValue();
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (mode.getValue().equals(Mode.Potion))
			mc.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION));
	}

	@Override
	public void onDisable() {
		mc.gameSettings.gammaSetting = oldGamma;
	}

	public enum Mode {
		Gamma,
		Potion
	}

}
