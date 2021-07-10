package dev.zihasz.client.feature.settings;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Setting<T> {

	public final String name, description;
	public final T min, max;
	public final Predicate<T> visibility;
	public final BiFunction<T, T, Boolean> callback;

	public T value;

	public Setting(String name, String description, T value, T min, T max, Predicate<T> visibility, BiFunction<T, T, Boolean> callback) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.min = min;
		this.max = max;
		this.visibility = visibility;
		this.callback = callback;
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	public T getValue() { return value; }
	public T getMin() { return min; }
	public T getMax() { return max; }

	public void setValue(T newValue) {
		if (callback.apply(value, newValue))
			value = newValue;
	}

}
