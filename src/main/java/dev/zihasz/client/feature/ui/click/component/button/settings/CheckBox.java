package dev.zihasz.client.feature.ui.click.component.button.settings;

import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.ui.click.component.button.SettingButton;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public class CheckBox extends SettingButton<Boolean> {

	public CheckBox(Setting<Boolean> setting, Rectangle button, Colors colors) {
		super(setting, button, colors);
	}

	@Override
	public void render(Point mouse) {

	}

	@Override
	public void onMouseDown(Point mouse, int mb) {
		if (mb == 0 && hovered(mouse)) {
			setting.setValue(!setting.getValue());
		}
	}

	@Override
	public void onMouseUp(Point mouse, int mb) {

	}

	@Override
	public void onKeyTyped(int key, char character) {

	}

	@Override
	public void onClosed() {

	}

}
