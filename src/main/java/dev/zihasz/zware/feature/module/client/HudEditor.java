package dev.zihasz.zware.feature.module.client;

import dev.zihasz.zware.feature.module.Category;
import dev.zihasz.zware.feature.module.Module;
import dev.zihasz.zware.ui.editor.GuiEditor;
import dev.zihasz.zware.utils.client.MessageBus;
import org.lwjgl.input.Keyboard;

public class HudEditor extends Module {

	public HudEditor() {
		super("HudEditor", "Enables the heads-up display editor.", Category.CLIENT, Keyboard.KEY_P);
	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(new GuiEditor());
	}

	@Override
	public void onDisable() {

	}

}
