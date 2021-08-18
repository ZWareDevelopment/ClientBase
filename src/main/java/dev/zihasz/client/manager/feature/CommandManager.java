package dev.zihasz.client.manager.feature;

import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.manager.Manager;
import dev.zihasz.client.utils.client.MessageBus;
import dev.zihasz.client.utils.client.ReflectionUtil;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CommandManager extends Manager {

	private final List<Command> commands = new ArrayList<>();

	public String commandPrefix = "-";

	public CommandManager() {
		MinecraftForge.EVENT_BUS.register(this);

		try {
			Set<Class<?>> classes = ReflectionUtil.findClasses(Command.class.getPackage().getName(), Command.class);
			for (Class<?> clazz : classes) {
				Command command = (Command) clazz.newInstance();
				this.addCommand(command);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onChat(ClientChatEvent event) {
		String message = event.getOriginalMessage();
		if (message.startsWith(commandPrefix)) {
			event.setCanceled(true);

			String[] split = message.split(" ");

			String name = split[0].replace(commandPrefix, "");
			String[] args = Arrays.copyOfRange(split, 1, split.length);

			Command cmd = null;

			for (Command command : commands) {
				if (command.getName().equalsIgnoreCase(name)) {
					cmd = command;
				} else {
					for (String alias : command.getAliases()) {
						if (alias.equalsIgnoreCase(name)) {
							cmd = command;
						}
					}
				}
			}

			if (cmd != null) {
				try {
					if (cmd.execute(args))
						MessageBus.sendInfoMessage(String.format("Ran %s successfully!", cmd.getName()));
					else
						MessageBus.sendErrorMessage(String.format("Failed to run %s!", cmd.getName()));
				} catch (Exception exception) {
					MessageBus.sendErrorMessage(String.format("Failed to run %s!", cmd.getName()));
				}
			}
			else
				MessageBus.sendErrorMessage(String.format("Couldn't find command named: %s", name));
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
