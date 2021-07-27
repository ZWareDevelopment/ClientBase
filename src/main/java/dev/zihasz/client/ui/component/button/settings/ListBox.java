package dev.zihasz.client.ui.component.button.settings;

import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.ui.component.button.SettingButton;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public class ListBox extends SettingButton<Enum> {

	public ListBox(Setting<Enum> setting, Rectangle button, Colors colors) {
		super(setting, button, colors);
	}

	@Override
	public void render(Point mouse) {

	}

	@Override
	public void onMouseDown(Point mouse, int mb) {

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
