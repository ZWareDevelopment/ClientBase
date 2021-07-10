package dev.zihasz.client.manager;

import net.minecraft.client.Minecraft;
import org.reflections.Reflections;

import java.util.Random;
import java.util.Set;

public abstract class Manager {

	protected Minecraft mc = Minecraft.getMinecraft();
	protected Random random = new Random();

}
