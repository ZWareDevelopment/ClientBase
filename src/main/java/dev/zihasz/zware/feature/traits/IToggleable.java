package dev.zihasz.zware.feature.traits;

public interface IToggleable {

	void enable();
	void disable();
	void toggle();

	boolean isEnabled();
	void setEnabled(boolean enabled);

	public void onEnable();
	public void onDisable();

}
