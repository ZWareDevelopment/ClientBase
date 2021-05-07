package dev.zihasz.clientbase.manager;

import dev.zihasz.clientbase.features.command.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommandManager {

	public static String prefix = ";";
	private static List<Command> commands = new ArrayList<>();

	public CommandManager() {
		MinecraftForge.EVENT_BUS.register(this);

		commands.add(new ModulesCommand());
		commands.add(new ToggleCommand());
	}

	public static void parseCommand(String... lines) {
		for (String line : lines) {
			String[] split = line.split(" ");

			String nameIn = split[0];
			String[] args = Arrays.copyOfRange(split, 1, split.length);

			Command command = CommandManager.getCommand(nameIn);
			if (command != null) command.execute(args);
		}
	}

	@SubscribeEvent
	public void onChat(ClientChatEvent event) {
		if (event.getMessage().startsWith(prefix)) {
			CommandManager.parseCommand(event.getMessage().replaceFirst(prefix, ""));
			event.setCanceled(true);

			Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
		}
	}

	public static Command getCommand(Class<? extends Command> commandClass) {
		return commands.stream().filter(command -> command.getClass() == commandClass).findFirst().orElse(null);
	}

	public static Command getCommand(String name) {
		for (Command command : commands) {
			if (command.getName().equalsIgnoreCase(name)) {
				return command;
			}
			for (String alias : command.getAliases()) {
				if (alias.equalsIgnoreCase(name)) {
					return command;
				}
			}
		}
		return null;
	}

	public static List<Command> getCommands() {
		return commands;
	}
}
