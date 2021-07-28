package dev.zihasz.client.manager;

import net.minecraft.client.Minecraft;

import java.util.Random;

public abstract class Manager {

	protected Minecraft mc = Minecraft.getMinecraft();
	protected Random random = new Random();

}
