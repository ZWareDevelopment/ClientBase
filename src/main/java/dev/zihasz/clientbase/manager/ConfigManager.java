package dev.zihasz.clientbase.manager;

import dev.zihasz.clientbase.Client;
import dev.zihasz.clientbase.features.module.Module;
import dev.zihasz.clientbase.features.setting.Setting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ConfigManager {

	public static String mainFolder = Client.MOD_NAME.toLowerCase() + "/";
	public static String configFolder = mainFolder + "config/";

	public static String modulesFile = configFolder + "modules.json";
	public static String GUIFile = configFolder + "gui.json";
	public static String HUDFile = configFolder + "hud.json";

	public ConfigManager() {
		initialize();
	}

	public static void initialize() {
		try {
			createFolders();
			createFiles();
		} catch (IOException exception) { exception.printStackTrace(); }
	}
	public static void createFolders() throws IOException {
		if (!Files.exists(Paths.get(mainFolder))) Files.createDirectory(Paths.get(mainFolder));
		if (!Files.exists(Paths.get(configFolder))) Files.createDirectory(Paths.get(configFolder));
	}
	public static void createFiles() throws IOException {
		if (!Files.exists(Paths.get(modulesFile))) Files.createFile(Paths.get(modulesFile));
		if (!Files.exists(Paths.get(GUIFile))) Files.createFile(Paths.get(GUIFile));
		if (!Files.exists(Paths.get(HUDFile))) Files.createFile(Paths.get(HUDFile));
	}

	public static void save() {
		saveModules();
		saveGUI();
		saveHUD();
	}
	public static void load() {
		try {
			loadModules();
			loadGUI();
			loadHUD();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public static void saveModules() {

		JSONArray modulesArray = new JSONArray();

		for (Module module : ModuleManager.getModules()) {

			JSONObject moduleObj = new JSONObject(new HashMap<String, Object>());
			JSONArray settingsArr = new JSONArray();

			moduleObj.put("name", module.getName());
			moduleObj.put("bind", module.getBind());
			moduleObj.put("enabled", module.isEnabled());
			moduleObj.put("visible", module.isVisible());

			for (Setting<?> setting : module.getSettings()) {
				JSONObject settingObj = new JSONObject();
				Object value = (setting.getValue() instanceof Number || setting.getValue() instanceof Boolean) ? setting.getValue() : setting.getValue().toString();
				settingObj.put("name", setting.getName());
				settingObj.put("value", value);
				settingsArr.add(settingObj);
			}

			moduleObj.put("settings", settingsArr);
			modulesArray.add(moduleObj);
		}

		try (FileWriter writer = new FileWriter(modulesFile)) { writer.write(modulesArray.toJSONString()); }
		catch (IOException exception) { exception.printStackTrace(); }

	}
	public static void saveGUI() {

	}
	public static void saveHUD() {

	}

	public static void loadModules() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(modulesFile);
		JSONArray modulesArray = (JSONArray) parser.parse(reader);
		for (Object object : modulesArray) {
			JSONObject moduleObject = (JSONObject) object;
			Module module = ModuleManager.getModule((String) moduleObject.get("name"));
			module.setBind((int) moduleObject.get("bind"));
			module.setEnabled((boolean) moduleObject.get("enabled"));
			module.setVisible((boolean) moduleObject.get("visible"));
			JSONArray settingsArray = (JSONArray) parser.parse("settings");
			for (Object object1 : settingsArray) {
				JSONObject settingObject = (JSONObject) object1;
				module.getSetting((String)settingObject.get("name")).setValue(settingObject.get("value"));
			}
		}
		reader.close();
	}
	public static void loadGUI() throws IOException {

	}
	public static void loadHUD() throws IOException {

	}

}