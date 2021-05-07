package dev.zihasz.clientbase.features.command;

import dev.zihasz.clientbase.manager.ModuleManager;
import net.minecraft.util.text.TextComponentString;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("toggle", "Toggles a module", new String[] { "t", "togglemodule" });
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			mc.player.sendMessage(new TextComponentString("Please supply a module name."));
			return;
		}

		ModuleManager.getModule(args[0]).toggle();
		mc.player.sendMessage(new TextComponentString(args[0] + ".enabled = " + ModuleManager.getModule(args[0]).isEnabled()));
	}

}
