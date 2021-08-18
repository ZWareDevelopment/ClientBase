package dev.zihasz.zware.ui.editor;

import dev.zihasz.zware.ZWare;
import dev.zihasz.zware.feature.module.client.HudEditor;
import dev.zihasz.zware.utils.client.MessageBus;
import dev.zihasz.zware.utils.render.Colors;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class GuiEditor extends GuiScreen {

	public static Colors colors = new Colors(new Color(0xff3f3fff), new Color(0xff3f3f3f), new Color(0xfff3f3f3));

	public GuiEditor() {

	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	public void onGuiClosed() {
		ZWare.moduleManager.getModule(HudEditor.class).setEnabled(false);
		super.onGuiClosed();
	}

}
