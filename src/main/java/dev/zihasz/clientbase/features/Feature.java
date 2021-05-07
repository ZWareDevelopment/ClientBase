package dev.zihasz.clientbase.features;

import dev.zihasz.clientbase.features.setting.Setting;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public abstract class Feature {

	protected Minecraft mc = Minecraft.getMinecraft();

	private final String name, description;
	private List<Setting> settings = new ArrayList<>();

	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() { return name; }
	public String getDescription() { return description; }

	public void addSetting(Setting<?> setting) { this.settings.add(setting); }
	public List<Setting> getSettings() { return settings; }
	public Setting getSetting(String name) { return settings.stream().filter(setting -> setting.getName().equals(name)).findFirst().orElse(null); }

	public boolean nullCheck() { return mc.player == null || mc.world == null; }
	public boolean fullNullCheck() { return nullCheck() || mc.player.connection == null || mc.playerController == null || mc.session == null; }

}
