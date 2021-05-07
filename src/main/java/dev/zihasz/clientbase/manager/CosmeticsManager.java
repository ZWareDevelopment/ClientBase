package dev.zihasz.clientbase.manager;

import dev.zihasz.clientbase.utils.Util;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CosmeticsManager implements Util {

	private static Map<UUID, ResourceLocation> cosmetics = new HashMap<>();

	public CosmeticsManager() {

	}

}
