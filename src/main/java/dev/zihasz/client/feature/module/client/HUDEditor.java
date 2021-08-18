package dev.zihasz.client.feature.module.client;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.ui.editor.GuiEditor;
import dev.zihasz.client.utils.client.MessageBus;
import org.lwjgl.input.Keyboard;

public class HUDEditor extends Module {

	public HUDEditor() {
		super("HUDEditor", "Enables the heads-up display editor.", Category.CLIENT, Keyboard.KEY_P);
	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(new GuiEditor());
		MessageBus.sendDebugMessage("GuiEditor enabled");
	}

	@Override
	public void onDisable() {

	}

}
