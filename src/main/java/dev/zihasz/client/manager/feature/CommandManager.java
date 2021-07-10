package dev.zihasz.client.manager.feature;

import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.manager.Manager;
import dev.zihasz.client.utils.client.ReflectionUtils;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommandManager extends Manager {

	private final List<Command> commands = new ArrayList<>();

	public CommandManager() {
		MinecraftForge.EVENT_BUS.register(this);
		try {
			Set<Class<?>> classes = ReflectionUtils.findClasses(Command.class.getPackage().getName(), Command.class);
			for (Class<?> clazz : classes) {
				Command command = (Command) clazz.newInstance();
				this.addCommand(command);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

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
