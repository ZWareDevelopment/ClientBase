package dev.zihasz.client.feature.command.commands;

import dev.zihasz.client.Client;
import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.utils.client.MessageBus;

public class ModulesCommand extends Command {

	public ModulesCommand() {
		super("Modules", "List available modules.", "[category name]", "modulelist", "listmodule");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (arguments.length > 1) {
			MessageBus.sendErrorMessage("You need to supply no or zero arguments!");
			return false;
		}
		if (arguments.length == 1) {
			try {
				Category category = Category.valueOf(arguments[0].toUpperCase());
				MessageBus.sendMessage("Modules in " + category.name() + "category:");
				for (Module module : Client.moduleManager.getModules(category)) {
					MessageBus.sendMessage(module.name);
				}
				return true;
			} catch (IllegalArgumentException exception) {
				MessageBus.sendErrorMessage("You need to supply a valid category name!");
				return false;
			}
		} else {
			MessageBus.sendMessage("Modules in all categories:");
			for (Module module : Client.moduleManager.getModules()) {
				MessageBus.sendMessage(module.name);
			}
			return true;
		}
	}
}
