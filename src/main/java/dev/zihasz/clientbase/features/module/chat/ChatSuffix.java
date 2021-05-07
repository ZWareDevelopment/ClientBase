package dev.zihasz.clientbase.features.module.chat;

import dev.zihasz.clientbase.Client;
import dev.zihasz.clientbase.features.module.Category;
import dev.zihasz.clientbase.features.module.Module;
 import dev.zihasz.clientbase.manager.CommandManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {

	public ChatSuffix() {
		super("ChatSuffix", "Appends a suffix after every chat message.", Category.CHAT);
	}

	@Override
	public void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void onDisable() {
		MinecraftForge.EVENT_BUS.unregister(this);
	}

	@SubscribeEvent
	public void onChat(ClientChatEvent event) {
		if (event.getMessage().startsWith("/") || event.getMessage().startsWith(CommandManager.prefix)) return;
		event.setMessage(event.getOriginalMessage() + " | " + Client.MOD_NAME);
	}

}
