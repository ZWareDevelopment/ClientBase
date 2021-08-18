package dev.zihasz.client.feature;

import dev.zihasz.client.feature.settings.Setting;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Feature {

	protected Minecraft mc = Minecraft.getMinecraft();
	protected Random random = new Random();

	public final String name, description;
	private List<Setting> settings = new ArrayList<>();

	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void addSetting(Setting setting) { this.settings.add(setting); }
	public Setting<?> getSetting(String name) { return settings.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null); }
	public List<Setting> getSettings() { return settings; }

	public String getName() { return name; }
	public String getDescription() { return description; }

	public boolean nullCheck() { return mc.player == null || mc.world == null; }

}
