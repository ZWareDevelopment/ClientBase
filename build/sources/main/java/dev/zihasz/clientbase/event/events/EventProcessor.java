package dev.zihasz.clientbase.event.events;

import dev.zihasz.clientbase.features.module.Module;
import dev.zihasz.clientbase.manager.ModuleManager;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventProcessor {

	public EventProcessor() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		ModuleManager.getModules().stream().filter(Module::isEnabled).filter(module -> !module.nullCheck()).forEach(Module::onUpdate);
	}

	@SubscribeEvent
	public void onRender(TickEvent.RenderTickEvent event) {
		ModuleManager.getModules().stream().filter(Module::isEnabled).filter(module -> !module.nullCheck()).forEach(Module::onRender);
	}

	@SubscribeEvent
	public void onWorldRender(RenderWorldLastEvent event) {
		ModuleManager.getModules().stream().filter(Module::isEnabled).filter(module -> !module.nullCheck()).forEach(module -> module.onWorldRender(event));
	}
}
