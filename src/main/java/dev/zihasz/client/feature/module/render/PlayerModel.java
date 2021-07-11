package dev.zihasz.client.feature.module.render;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.utils.render.Renderer2D;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

import java.awt.*;

public class PlayerModel extends Module {

	public PlayerModel() {
		super("PlayerModel", "Renders the local player model on screen.", Category.RENDER);
	}

	@SubscribeEvent
	public void onRender2D(TickEvent.RenderTickEvent event) {
		Renderer2D.drawEntity(mc.player, new Point(20, 20), new Point(Mouse.getDX(), Mouse.getDY()), 1);
	}

}
