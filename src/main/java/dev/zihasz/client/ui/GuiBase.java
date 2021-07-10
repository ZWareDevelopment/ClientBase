package dev.zihasz.client.ui;

import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public abstract class GuiBase extends GuiScreen {

	public abstract void initGui();
	public abstract void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException;
	public abstract void mouseReleased(int mouseX, int mouseY, int state);
	public abstract void keyTyped(char typedChar, int keyCode) throws IOException;
	public abstract void onGuiClosed();

}
