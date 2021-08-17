package dev.zihasz.client.ui.editor;

import dev.zihasz.client.Client;
import dev.zihasz.client.feature.hud.HudComponent;
import dev.zihasz.client.feature.module.client.HUDEditor;
import dev.zihasz.client.utils.client.MessageBus;
import dev.zihasz.client.utils.render.Colors;
import dev.zihasz.client.utils.render.Renderer2D;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class GuiEditor extends GuiScreen {

	public static Colors colors = new Colors(new Color(0xff3f3fff), new Color(0xff3f3f3f), new Color(0xfff3f3f3));

	private HudComponent drag = null;
	private Point dragLocation = null;

	public GuiEditor() {
		MessageBus.sendDebugMessage("GuiEditor created");
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);

		for (HudComponent component : Client.hudManager.getComponents()) {
			component.render(partialTicks);
			Renderer2D.drawRectangle(
					getRectFromComp(component),
					getBackgroundColor(
							getRectFromComp(component).contains(mouseX, mouseY),
							component.enabled
					)
			);
		}

		if (drag != null)
			drag.location.setLocation(dragLocation);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);

		Point mouse = new Point(mouseX, mouseY);
		HudComponent component = getHovered(mouse);
		if (component != null) {
			switch (mouseButton) {
				case 0:
					drag = component;
					dragLocation = mouse;
				case 1:
					component.enabled = !component.enabled;
			}
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);

		drag = null;
		dragLocation = null;
	}



	@Override
	public void onGuiClosed() {
		Client.moduleManager.getModule(HUDEditor.class).setEnabled(false);
		super.onGuiClosed();
	}

	private Rectangle getRectFromComp(HudComponent component) {
		return new Rectangle(component.location.x, component.location.y, component.width(), component.height());
	}
	private HudComponent getHovered(Point mouse) {
		for (HudComponent component : Client.hudManager.getComponents())
			if (getRectFromComp(component).contains(mouse))
				return component;

		return null;
	}
	private Color getBackgroundColor(boolean hovered, boolean enabled) {
		Color color = colors.back;

		if (enabled)
			color = color.brighter();
		else
			color = color.darker();

		if (hovered)
			color = color.brighter();

		return color;
	}

}
