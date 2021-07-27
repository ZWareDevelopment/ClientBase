package dev.zihasz.client.feature.hud;

import dev.zihasz.client.feature.Feature;
import dev.zihasz.client.feature.traits.IToggleable;
import net.minecraftforge.common.MinecraftForge;

public abstract class HudComponent extends Feature implements IToggleable {

	public boolean enabled;

	public HudComponent(String name, String description) {
		super(name, description);
	}

	public void enable() { this.setEnabled(true); }
	public void disable() { this.setEnabled(false); }
	public void toggle() { this.setEnabled(!enabled); }

	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			MinecraftForge.EVENT_BUS.register(this);
			onEnable();
		}
		else {
			onDisable();
			MinecraftForge.EVENT_BUS.unregister(this);
		}
	}

	public void onEnable() {}
	public void onDisable() {}
	public void render(float ticks) {}

}
