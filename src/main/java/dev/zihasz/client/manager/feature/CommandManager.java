package dev.zihasz.client.manager.feature;

import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.manager.Manager;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends Manager {

	private final List<Command> commands = new ArrayList<>();

	public CommandManager() { MinecraftForge.EVENT_BUS.register(this); }

	public void addCommand(Command command) { this.commands.add(command); }

	public Command getCommand(String name) {
		return this.commands.stream()
				.filter(command -> command.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	public Command getCommand(Class<? extends Command> clazz) {
		return this.commands.stream()
				.filter(command -> command.getClass() == clazz)
				.findFirst()
				.orElse(null);
	}

	public List<Command> getCommands() {
		return this.commands;
	}

}
