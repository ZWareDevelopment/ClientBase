package dev.zihasz.zware.feature.module.client;

import dev.zihasz.zware.feature.module.Category;
import dev.zihasz.zware.feature.module.Module;
import dev.zihasz.zware.ui.click.GuiClick;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "Enables the clickable graphical user interface.", Category.CLIENT, Keyboard.KEY_RSHIFT);
	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(new GuiClick());
	}

	@Override
	public void onDisable() {

	}
}
