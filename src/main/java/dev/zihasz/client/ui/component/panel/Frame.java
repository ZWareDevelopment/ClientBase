package dev.zihasz.client.ui.component.panel;

import dev.zihasz.client.Client;
import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.traits.IClosable;
import dev.zihasz.client.ui.component.Component;
import dev.zihasz.client.ui.component.button.Button;
import dev.zihasz.client.ui.component.button.ModuleButton;
import dev.zihasz.client.utils.render.Colors;
import dev.zihasz.client.utils.render.Renderer2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame implements Component, IClosable {

	private final Category category;
	private final Rectangle size;
	private final Colors colors;

	private boolean open = true;

	private final List<Button> buttons = new ArrayList<>();

	public Frame(Category category, Rectangle size, Colors colors) {
		this.category = category;
		this.size = size;
		this.colors = colors;

		int y = 20;
		for (Module module : Client.moduleManager.getModules(category)) {
			buttons.add(new ModuleButton(module, new Rectangle(size.x, size.y + y, size.width, size.height), colors));
			y += size.height;
		}
	}

	public void render(Point mouse) {
		Renderer2D.fillRectangle(size, colors.fore);
	}

	public void onMouseDown(Point mouse, int mb) {

	}

	public void onMouseUp(Point mouse, int mb) {

	}

	public void onKeyTyped(int key, char character) {

	}

	public void onClosed() {

	}

	@Override
	public int height() {
		return 0;
	}

	public boolean isOpen() { return open; }
	public void setOpen(boolean open) { this.open = open; }

	public Category getCategory() { return category; }
	public Rectangle getButton() { return size; }
	public Colors getColors() { return colors; }

}
