package dev.zihasz.client.manager.config;

import com.google.gson.*;
import dev.zihasz.client.Client;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.manager.Manager;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager extends Manager {

	public static final String MAIN_FOLDER = Client.ID + "/";
	public static final String CONFIG_FOLDER = MAIN_FOLDER + "config/";

	public static final String MODULES_FILE = CONFIG_FOLDER + "modules.json";
	public static final String FRIENDS_FILE = CONFIG_FOLDER + "friends.json";
	public static final String ENEMIES_FILE = CONFIG_FOLDER + "enemies.json";

	public ConfigManager() {

		try {
			createFolders();
			createFiles();
		} catch (IOException e) {
			Client.LOGGER.error(e);
		}

	}

	private void createFolders() throws IOException {
		if (!Files.exists(Paths.get(MAIN_FOLDER))) Files.createDirectory(Paths.get(MAIN_FOLDER));
		if (!Files.exists(Paths.get(CONFIG_FOLDER))) Files.createDirectory(Paths.get(CONFIG_FOLDER));
	}
	private void createFiles() throws IOException {
		if (!Files.exists(Paths.get(MODULES_FILE))) Files.createFile(Paths.get(MODULES_FILE));
		if (!Files.exists(Paths.get(FRIENDS_FILE))) Files.createFile(Paths.get(FRIENDS_FILE));
		if (!Files.exists(Paths.get(ENEMIES_FILE))) Files.createFile(Paths.get(ENEMIES_FILE));
	}

	public void load() {

		try {

			loadModules();

		} catch (IOException e) {
			Client.LOGGER.error(e);
		}

	}
	public void save() {

		try {

			saveModules();

		} catch (IOException e) {
			Client.LOGGER.error(e);
		}

	}

	private void loadModules() throws IOException {

		try (FileReader reader = new FileReader(MODULES_FILE)) {

			JsonParser parser = new JsonParser();
			JsonElement parsed = parser.parse(reader);
			if (parsed instanceof    JsonNull) return;
			JsonArray modulesArray = (JsonArray) parsed;

			for (Object moduleObject : modulesArray) {
				JsonObject moduleJson = (JsonObject) moduleObject;

				Module module = Client.moduleManager.getModule(moduleJson.get("name").getAsString());

				if (module == null) throw new IllegalStateException("Cannot find parsed module!");

				module.setBind(moduleJson.get("bind").getAsInt());
				module.setEnabled(moduleJson.get("name").getAsBoolean());

				JsonArray settingsArray = moduleJson.getAsJsonArray("settings");

				for (Object settingObject : settingsArray) {
					JsonObject settingJson = (JsonObject) settingObject;

					Setting setting = module.getSetting(settingJson.get("name").getAsString());

					if (setting == null) throw new IllegalStateException("Cannot find parsed setting!");

					if (setting.getValue() instanceof Boolean)
						setting.setValue(settingJson.get("value").getAsBoolean());
					else if (setting.getValue() instanceof Number) {
						Double raw = settingJson.get("value").getAsDouble();
						if (setting.getValue() instanceof Integer)
							setting.setValue(raw.intValue());
						else if (setting.getValue() instanceof Long)
							setting.setValue(raw.longValue());
						else if (setting.getValue() instanceof Float)
							setting.setValue(raw.floatValue());
						else if (setting.getValue() instanceof Double)
							setting.setValue(raw.doubleValue());
						else
							throw new IllegalStateException("Illegal setting type!");
					} else if (setting.getValue() instanceof String)
						setting.setValue(settingJson.get("value").getAsString());
					else if (setting.getValue() instanceof Color) {
						setting.setValue(new Color(settingJson.get("value").getAsInt()));
					} else if (setting.getValue() instanceof Enum) {
						setting.setValue(Enum.valueOf(((Enum<?>) setting.getValue()).getClass(), settingJson.get("value").getAsString()));
					} else
						throw new IllegalStateException("Illegal setting type!");
				}

			}

		} catch (IOException e) {
			Client.LOGGER.error(e);
		}

	}
	private void saveModules() throws IOException {
		JsonArray modulesArray = new JsonArray();

		for (Module module : Client.moduleManager.getModules()) {

			JsonObject moduleJson = new JsonObject();
			moduleJson.addProperty("name", module.getName());
			moduleJson.addProperty("bind", module.getBind());
			moduleJson.addProperty("enabled", module.isEnabled());

			JsonArray settingsArray = new JsonArray();

			for (Setting<?> setting : module.getSettings()) {
				JsonObject settingJson = new JsonObject();
				settingJson.addProperty("name", setting.getName());

				if (setting.getValue() instanceof Boolean)
					settingJson.addProperty("value", (Boolean) setting.getValue());
				else if (setting.getValue() instanceof Number)
					settingJson.addProperty("value", ((Number) setting.getValue()).doubleValue());
				else if (setting.getValue() instanceof String)
					settingJson.addProperty("value", (String) setting.getValue());
				else if (setting.getValue() instanceof Color) {
					settingJson.addProperty("value", ((Color) setting.getValue()).getRGB());
				} else if (setting.getValue() instanceof Enum)
					settingJson.addProperty("value", ((Enum) setting.getValue()).name());
				else
					throw new IllegalStateException("Illegal setting type! " + setting.getName());

				settingsArray.add((settingJson));
			}

			moduleJson.add("settings", settingsArray);

			modulesArray.add(moduleJson);
		}

		try (FileWriter writer = new FileWriter(MODULES_FILE)) {
			writer.write(modulesArray.toString());
		} catch (IOException e) {
			Client.LOGGER.error(e);
		}
	}

}
