package dev.zihasz.client.utils.client;

import dev.zihasz.client.utils.Util;
import org.reflections.Reflections;

import java.util.Set;

public class ReflectionUtils implements Util {

	protected Set<?> findClasses(String pack, Class<?> subType) {
		Reflections reflections = new Reflections(pack);
		return reflections.getSubTypesOf(subType);
	}

}
