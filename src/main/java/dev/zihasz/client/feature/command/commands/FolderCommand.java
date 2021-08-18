package dev.zihasz.client.feature.command.commands;

import dev.zihasz.client.feature.command.Command;
import dev.zihasz.client.manager.config.ConfigManager;

import java.awt.*;
import java.net.URI;

public class FolderCommand extends Command {

	public FolderCommand() {
		super("Folder", "Opens the current main folder", ".folder ", "openfolder", "configfolder", "openconfigs");
	}

	@Override
	public boolean execute(String[] arguments) {
		try {
			Desktop.getDesktop().browse(URI.create(ConfigManager.MAIN_FOLDER));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
}
