package dev.zihasz.client.feature.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Setting<T> {

	private final String name, description;
	private final T min, max;
	private final Predicate<T> visibility;
	private final BiFunction<T, T, Boolean> callback;
	private final List<Setting> subs;

	public T value;

	public Setting(String name, String description, T value, T min, T max, Predicate<T> visibility, BiFunction<T, T, Boolean> callback, Setting<?> parent) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.min = min;
		this.max = max;
		this.visibility = visibility;
		this.callback = callback;
		this.subs = new ArrayList<>();

		if (parent != null)
			parent.addSub(this);
	}

	public boolean test() {
		return visibility.test(value);
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T newValue) {
		if (callback.apply(value, newValue)) value = newValue;
	}

	public T getMin() {
		return min;
	}
	public T getMax() {
		return max;
	}

	public void addSub(Setting<?> setting) {
		this.subs.add(setting);
	}
	public Setting<?> getSub(String name) {
		for (Setting<?> setting : subs) {
			if (setting.name.equalsIgnoreCase(name))
				return setting;
		}
		return null;
	}
	public List<Setting> getSubs() {
		return this.subs;
	}

}
