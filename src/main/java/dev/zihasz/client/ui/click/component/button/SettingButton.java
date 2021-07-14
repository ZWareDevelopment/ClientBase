package dev.zihasz.client.ui.click.component.button;

import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public abstract class SettingButton<T> extends Button {

	protected final Setting<T> setting;

	public SettingButton(Setting<T> setting, Rectangle button, Colors colors) {
		super(button, colors);
		this.setting = setting;
	}

	public int height() { return button.height; }

}
