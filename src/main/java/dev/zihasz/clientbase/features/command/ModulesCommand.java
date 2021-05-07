package dev.zihasz.clientbase.features.command;

import dev.zihasz.clientbase.features.module.Module;
import dev.zihasz.clientbase.manager.ModuleManager;
import net.minecraft.util.text.TextComponentString;

public class ModulesCommand extends Command {

	public ModulesCommand() {
		super("modules", "List all modules", new String[] { "allmodules", "list" });
	}

	@Override
	public void execute(String[] args) {
		for (Module module : ModuleManager.getModules()) {
			mc.player.sendMessage(new TextComponentString(module.getName() + " - " + module.getDescription()));
		}
	}
}
