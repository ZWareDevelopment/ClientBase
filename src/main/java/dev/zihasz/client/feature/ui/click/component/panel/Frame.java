package dev.zihasz.client.feature.ui.click.component.panel;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.traits.IClosable;
import dev.zihasz.client.feature.ui.click.component.Component;
import dev.zihasz.client.feature.ui.click.component.button.ModuleButton;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame implements Component, IClosable {

	public final static int FRAME_HEADER_WIDTH = 120;
	public final static int FRAME_HEADER_HEIGHT = 30;

	private final Category category;
	private final Colors colors;

	private final List<ModuleButton> buttons = new ArrayList<>();

	private boolean open = true;

	public Frame(Category category, Colors colors) {
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

}
