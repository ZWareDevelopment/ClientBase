package dev.zihasz.zware.feature.command;

import dev.zihasz.zware.feature.Feature;

public abstract class Command extends Feature {

	private String usage;
	private String[] aliases;

	public Command(String name, String description, String usage, String... aliases) {
		super(name, description);
		this.usage = usage;
		this.aliases = aliases;
	}

	public abstract boolean execute(String[] arguments) throws Exception;

	public String getUsage() { return usage; }
	public String[] getAliases() { return aliases; }

}
