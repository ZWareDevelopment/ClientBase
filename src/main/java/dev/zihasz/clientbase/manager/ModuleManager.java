package dev.zihasz.clientbase.manager;

import dev.zihasz.clientbase.features.module.Category;
import dev.zihasz.clientbase.features.module.Module;
import dev.zihasz.clientbase.features.setting.Setting;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleManager {

	private static List<Module> modules = new ArrayList<>();

	public ModuleManager() {
		Set<Class> moduleClasses = findClasses(Module.class.getPackage().getName(), Module.class);
		moduleClasses.forEach(moduleClass -> {
			try {
				addModule((Module) moduleClass.newInstance());
			} catch (Exception ignored) {}
		});
	}

	private static void addModule(Module module) {
		try {
			for (Field field : module.getClass().getDeclaredFields()) {
				if (Setting.class.isAssignableFrom(field.getType())) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					final Setting<?> val = (Setting<?>) field.get(module);
					module.addSetting(val);
				}
			}
		} catch (Exception ignored) {
		}
		modules.add(module);
	}

	public static Set findClasses(String pack, Class subType) {
		Reflections reflections = new Reflections(pack);
		return reflections.getSubTypesOf(subType);
	}

	public static Module getModule(Class<? extends Module> module) {
		return modules.stream().filter(module1 -> module1.getClass() == module).findFirst().orElse(null);
	}

	public static Module getModule(String module) {
		return modules.stream().filter(module1 -> module1.getName().equalsIgnoreCase(module)).findFirst().orElse(null);
	}

	public static List<Module> getModules() {
		return modules;
	}

	public static List<Module> getModules(Category category) {
		return modules.stream().filter(module -> module.getCategory() == category).collect(Collectors.toList());
	}
}
