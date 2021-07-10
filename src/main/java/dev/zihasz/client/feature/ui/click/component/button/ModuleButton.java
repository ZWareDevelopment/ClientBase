package dev.zihasz.client.feature.ui.click.component.button;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.traits.IClosable;
import dev.zihasz.client.feature.ui.click.component.Component;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public class ModuleButton implements Component, IClosable {

	public final static int MODULE_BUTTON_WIDTH = 100;
	public final static int MODULE_BUTTON_HEIGHT = 20;

	private final Category category;
	private final Colors colors;

	private boolean open = true;

	public ModuleButton(Category category, Colors colors) {
		this.category = category;
		this.colors = colors;
	}

	public void render(Point mouse) {

	}

	public void update(Point mouse) {

	}

	public void onMouseDown(Point mouse, int mb) {

	}

	public void onMouseUp(Point mouse, int mb) {

	}

	public void onKeyTyped(int key, char character) {

	}

	public void onClosed() {

	}

	public int height() {
		return 0;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean openIn) {
		open = openIn;
	}

	public Category getCategory() {
		return category;
	}

	public Colors getColors() {
		return colors;
	}
}
