package dev.zihasz.client.utils.client;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.zihasz.client.Client;
import dev.zihasz.client.utils.Util;
import net.minecraft.util.text.TextComponentString;

public class MessageBus implements Util {

	private static final String watermark = String.format("[%s] ", Client.NAME);

	public static void sendMessage(String message) {
		mc.player.sendMessage(new TextComponentString(watermark + message));
	}
	public static void sendInfoMessage(String message) {
		sendMessage(ChatFormatting.BLUE + message);
	}
	public static void sendWarningMessage(String message) {
		sendMessage(ChatFormatting.YELLOW + message);
	}
	public static void sendErrorMessage(String message) {
		sendMessage(ChatFormatting.RED + message);
	}
	public static void sendDebugMessage(String message) {
		sendMessage(ChatFormatting.LIGHT_PURPLE + message);
	}
	
}
