package dev.zihasz.client.feature.hud;

import dev.zihasz.client.feature.Feature;
import dev.zihasz.client.feature.traits.IToggleable;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Mouse;

import java.awt.*;

public abstract class HudComponent extends Feature implements IToggleable {

	public Point location;
	public boolean enabled;

	public HudComponent(String name, String description, Point location) {
		super(name, description);
		this.location = location;
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

	public abstract void render(float ticks);
	public abstract int width();
	public abstract int height();

	protected Point mouse() {
		return new Point(Mouse.getX(), Mouse.getY());
	}

}
