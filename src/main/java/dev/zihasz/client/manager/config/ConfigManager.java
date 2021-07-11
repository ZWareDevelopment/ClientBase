package dev.zihasz.client.manager.config;

import dev.zihasz.client.Client;
import dev.zihasz.client.manager.Manager;

public class ConfigManager extends Manager {

	public static final String MAIN_FOLDER = Client.ID + "/";
	public static final String CONFIG_FOLDER = MAIN_FOLDER + "config/";
	public static final String RELATIONS_FOLDER = MAIN_FOLDER + "relations/";
	public static final String DOWNLOADS_FOLDER = MAIN_FOLDER + "downloads/";

	public ConfigManager() {

	}

}
