package dev.zihasz.client.feature.command.commands;

import dev.zihasz.client.Client;
import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.utils.client.MessageBus;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("Toggle", "Toggles a module", "<module name>", "t");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (arguments.length != 1) {
			MessageBus.sendErrorMessage("You need to supply exactly one argument!");
			return false;
		}
		Module module = Client.moduleManager.getModule(arguments[0]);
		if (module == null) {
			MessageBus.sendErrorMessage("You need to supply a valid module name!");
			return false;
		}
		module.toggle();
		return true;
	}
}
