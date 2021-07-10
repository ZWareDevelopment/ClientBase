package dev.zihasz.client.feature.module;

import dev.zihasz.client.feature.Feature;
import dev.zihasz.client.feature.traits.IBindable;
import dev.zihasz.client.feature.traits.IToggleable;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public abstract class Module extends Feature implements IToggleable, IBindable {

	public Category category;
	public boolean enabled;
	public int bind;

	public Module(String name, String description, Category category, int bind) {
		super(name, description);
		this.category = category;
		this.bind = bind;
	}
	public Module(String name, String description, Category category) {
		this(name, description, category, Keyboard.KEY_NONE);
	}

	public void onEnable() {}
	public void onDisable() {}

	public void enable() { this.setEnabled(true); }
	public void disable() { this.setEnabled(false); }
	public void toggle() { this.setEnabled(!enabled); }

	public int getBind() { return bind; }
	public boolean isEnabled() { return enabled; }

	public void setBind(int bind) { this.bind = bind; }
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

}
