package dev.zihasz.clientbase.features.command;

import dev.zihasz.clientbase.features.Feature;

public abstract class Command extends Feature {

	private String[] aliases;

	public Command(String name, String description, String[] aliases) {
		super(name, description);
		this.aliases = aliases;
	}
	public Command(String name, String[] aliases) {
		super(name, "");
		this.aliases = aliases;
	}

	public abstract void execute(String[] args);

	public String[] getAliases() {
		return aliases;
	}

}
