package dev.zihasz.client.feature.settings;

import dev.zihasz.client.feature.Feature;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SettingBuilder<T> {

	private String name, description;
	private final T value;
	private T min, max = null;
	private Predicate<T> visibility = v -> true;
	private BiFunction<T, T, Boolean> callback = (oldValue, newValue) -> true;
	private Setting<?> parent = null;

	public SettingBuilder(T value) {
		this.value = value;
	}

	public SettingBuilder<T> name(String name) {
		this.name = name;
		return this;
	}
	public SettingBuilder<T> description(String description) {
		this.description = description;
		return this;
	}
	public SettingBuilder<T> min(T min) {
		this.min = min;
		return this;
	}
	public SettingBuilder<T> max(T max) {
		this.max = max;
		return this;
	}
	public SettingBuilder<T> range(T min, T max) {
		this.min = min;
		this.max = max;
		return this;
	}
	public SettingBuilder<T> visibility(Predicate<T> v) {
		this.visibility = v;
		return this;
	}
	public SettingBuilder<T> callback(BiFunction<T, T, Boolean> callback) {
		this.callback = callback;
		return this;
	}

	public SettingBuilder<T> parent(Setting<?> parent) {
		this.parent = parent;
		return this;
	}

	public SettingBuilder<T> parent(String category, String description) {
		this.parent = new Setting<Void>(category, description, null, null, null, null, null, null);
		return this;
	}

	public Setting<T> build(Feature feature) {
		Setting<T> setting = new Setting<>(name, description, value, min, max, visibility, callback, parent);
		feature.addSetting(setting);

		return setting;
	}

}
