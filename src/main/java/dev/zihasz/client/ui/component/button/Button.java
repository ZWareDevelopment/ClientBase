package dev.zihasz.client.ui.component.button;

import dev.zihasz.client.ui.component.Component;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public abstract class Button implements Component {

	protected Rectangle button;
	protected Colors colors;

	public Button(Rectangle button, Colors colors) {
		this.button = button;
		this.colors = colors;
	}

	public boolean hovered(Point mouse) {
		return button.contains(mouse);
	}

}
