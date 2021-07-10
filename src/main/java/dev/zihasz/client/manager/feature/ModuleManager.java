package dev.zihasz.client.manager.feature;

import dev.zihasz.client.feature.module.*;
import dev.zihasz.client.manager.Manager;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager extends Manager {

	private final List<Module> modules = new ArrayList<>();

	public ModuleManager() { MinecraftForge.EVENT_BUS.register(this); }

	public void addModule(Module module) { this.modules.add(module); }

	public Module getModule(String name) {
		return this.modules.stream()
				.filter(module -> module.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	public Module getModule(Class<? extends Module> clazz) {
		return this.modules.stream()
				.filter(module -> module.getClass() == clazz)
				.findFirst()
				.orElse(null);
	}

	public List<Module> getModules() {
		return this.modules;
	}
	public List<Module> getModules(Category category) {
		return this.modules.stream()
				.filter(m -> m.category == category)
				.collect(Collectors.toList());
	}

}
