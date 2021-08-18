package dev.zihasz.client;

import net.minecraftforge.common.config.Config;

@Config(modid = Client.ID, name = Client.NAME, category = "client")
public class ClientConfig {

	@Config.Name("Blacklist Bypass")
	@Config.Comment("Bypass Mojang's server blacklist.")
	public static boolean blacklistBypass = true;

	@Config.Name("Proxy")
	@Config.Comment("Proxy all your network traffic.")
	public static boolean proxy = false;

}
