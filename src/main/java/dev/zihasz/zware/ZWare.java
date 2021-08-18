package dev.zihasz.zware;

import dev.zihasz.zware.core.ClientLoader;
import dev.zihasz.zware.manager.config.ConfigManager;
import dev.zihasz.zware.manager.feature.CommandManager;
import dev.zihasz.zware.manager.feature.HudManager;
import dev.zihasz.zware.manager.feature.ModuleManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ZWare.ID, name = ZWare.NAME, version = ZWare.VERSION, clientSideOnly = true)
public class ZWare {

	public static final String ID = "zware";
	public static final String NAME = "ZWare.cc";
	public static final String CNAME = String.format("§d%s§r%s", NAME.charAt(0), NAME.substring(1));
	public static final String VERSION = "1.0";

	public static final Logger LOGGER = LogManager.getLogger(ZWare.NAME + " " + ZWare.VERSION);

	@Instance
	public static ZWare INSTANCE;

	public static ClientLoader loader;
	public static CommandManager commandManager;
	public static ConfigManager configManager;
	public static HudManager hudManager;
	public static ModuleManager moduleManager;

	public ZWare() {
		INSTANCE = this;
	}

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		loader = new ClientLoader();
		loader.initialize();
	}

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		commandManager = new CommandManager();
		configManager = new ConfigManager();
		moduleManager = new ModuleManager();

		configManager.load();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> configManager.save()));
	}

	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void onLoadComplete(FMLLoadCompleteEvent event) {

	}


}
