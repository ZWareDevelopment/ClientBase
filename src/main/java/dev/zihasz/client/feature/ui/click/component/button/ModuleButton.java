package dev.zihasz.client.feature.ui.click.component.button;

import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;

public class ModuleButton extends Button {

	public final static int MODULE_BUTTON_WIDTH = 100;
	public final static int MODULE_BUTTON_HEIGHT = 20;

	public ModuleButton(Module module, Rectangle size, Colors colors) {
		super(size, colors);
	}

	@Override
	public void render(Point mouse) {

	}

	@Override
	public void update(Point mouse) {

	}

	@Override
	public void onMouseDown(Point mouse, int mb) {

	}

	@Override
	public void onMouseUp(Point mouse, int mb) {

	}

	@Override
	public void render(int mx, int my) {

	}

	@Override
	public void update(int mx, int my) {

	}

	@Override
	public void onMouseDown(int mx, int my, int mb) {

	}

	@Override
	public void onKeyTyped(int key, char character) {

	}

	@Override
	public void onMouseUp(int mx, int my, int mb) {

	}

	@Override
	public void onClosed() {

	}

	@Override
	public int height() {
		return 0;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public void setOpen(boolean openIn) {

	}

}
