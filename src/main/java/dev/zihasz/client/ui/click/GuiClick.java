package dev.zihasz.client.ui.click;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.ui.GuiBase;
import dev.zihasz.client.ui.click.component.panel.Frame;
import dev.zihasz.client.utils.render.Colors;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiClick implements GuiBase {

	private Colors colors = new Colors(
			new Color(0xff6767ff),
			new Color(0xff3f3f3f),
			new Color(0xfff3f3f3)
	);
	private List<Frame> frames = new ArrayList<>();


	public GuiClick() {
		int x = 20;

		for (Category category : Category.values()) {
			frames.add(new Frame(category, new Rectangle(x, 20, 100, 20), colors));
			x += 100;
		}
	}

	@Override
	public void initGui() {

	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {

	}

	@Override
	public void keyTyped(char typedChar, int keyCode) throws IOException {

	}

	@Override
	public void onGuiClosed() {

	}

}
