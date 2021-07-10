package dev.zihasz.client.feature.command.commands;

import dev.zihasz.client.feature.command.Command;

public class FolderCommand extends Command {

	public FolderCommand() {
		super("Folder", "Opens the current main folder", ".folder ", "openfolder", "configfolder", "openconfigs");
	}

	@Override
	public void execute(String[] arguments) {

	}
}
