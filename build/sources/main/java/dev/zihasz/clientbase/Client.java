package dev.zihasz.clientbase;

import dev.zihasz.clientbase.event.events.EventProcessor;
import dev.zihasz.clientbase.manager.*;
import dev.zihasz.clientbase.mixin.MixinLoader;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.MOD_VERSION)
public class Client {

	public static final String MOD_ID = "client";
	public static final String MOD_NAME = "Client";
	public static final String MOD_VERSION = "1.0.0";
	public static final String MOD_VERSION_PREFIX = "v";

	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	public static final EventBus EVENT_BUS = new EventManager();

	public static MixinLoader mixinLoader;
	public static EventProcessor eventProcessor;

	public static CommandManager commandManager;
	public static CosmeticsManager cosmeticsManager;
	public static ModuleManager moduleManager;

	/**
	 * Load mixins, security here.
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		mixinLoader = new MixinLoader();
		eventProcessor = new EventProcessor();
	}

	/**
	 * Load features here. Also if you are not sure just load things here.
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ConfigManager.initialize();
		commandManager = new CommandManager();
		moduleManager = new ModuleManager();
		Runtime.getRuntime().addShutdownHook(new Thread(ConfigManager::save));
		ConfigManager.load();

	}

	/**
	 * Load cosmetics and things like that here.
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Display.setTitle(MOD_NAME + " " + MOD_VERSION_PREFIX + MOD_VERSION);
		cosmeticsManager = new CosmeticsManager();
	}

}
