package dev.zihasz.client.ui;

import java.io.IOException;

public interface GuiBase {

	void initGui();
	void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException;
	void mouseReleased(int mouseX, int mouseY, int state);
	void keyTyped(char typedChar, int keyCode) throws IOException;
	void onGuiClosed();

}
