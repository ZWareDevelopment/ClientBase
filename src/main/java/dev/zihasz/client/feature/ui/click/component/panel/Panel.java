package dev.zihasz.client.feature.ui.click.component.panel;

import dev.zihasz.client.feature.traits.IClosable;
import dev.zihasz.client.feature.ui.click.component.Component;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public abstract class Panel implements Component, IClosable {

	private final Rectangle size;
	private final Colors colors;

	public Panel(Rectangle size, Colors colors) {
		this.size = size;
		this.colors = colors;
	}

	public abstract void render(int mx, int my);

	public abstract void update(int mx, int my);

	public abstract void onMouseDown(int mx, int my, int mb);

	public abstract void onKeyTyped(int key, char character);

	public abstract void onMouseUp(int mx, int my, int mb);

	public abstract void onClosed();

	public abstract int height();

	public abstract boolean isOpen();

	public abstract void setOpen(boolean openIn);

	public Rectangle getSize() {
		return size;
	}

	public Colors getColors() {
		return colors;
	}
}
