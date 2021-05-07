package dev.zihasz.clientbase.features.module.client;

import dev.zihasz.clientbase.features.module.Category;
import dev.zihasz.clientbase.features.module.Module;

public class ClickGUIModule extends Module {

	public ClickGUIModule() {
		super("ClickGUI", "Enables the ClickGUI.", Category.CLIENT);
	}

	@Override
	public void onEnable() {
		// mc.displayGuiScreen(new ClickGUIScreen());
		disable();
	}

}
