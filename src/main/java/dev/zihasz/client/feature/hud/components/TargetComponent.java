package dev.zihasz.client.feature.hud.components;

import dev.zihasz.client.feature.hud.HudComponent;
import dev.zihasz.client.utils.render.Renderer2D;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Comparator;

public class TargetComponent extends HudComponent {

	public TargetComponent() {
		super("TargetComponent", "Shows the nearest player and some info about them.", new Point(2, 10));
	}

	private final DecimalFormat FORMAT = new DecimalFormat("##.#");

	@Override
	public void render(float ticks) {
		if (nullCheck()) return;

		EntityPlayer player = mc.world.playerEntities.stream()
				.filter(e -> e != mc.player)
				.filter(e -> e.isDead)
				.min(Comparator.comparing(e -> mc.player.getDistance(e)))
				.orElse(null);

		if (player == null) return;

		Renderer2D.drawRectangle(new Rectangle(location, new Dimension(200, 150)), new Color(127, 127, 127, 127));
		Renderer2D.drawEntity(player, new Point(location.x + 2, location.y + 2 + mc.fontRenderer.FONT_HEIGHT), mouse(), 1f);
		mc.fontRenderer.drawString(player.getName(), location.x + 2, location.y + 2, 0xffffffff);
		mc.fontRenderer.drawString(FORMAT.format(player.getHealth()), location.x + 2 + mc.fontRenderer.getStringWidth(mc.player.getName()) + 2, location.y + 2, 0xffffffff);
	}

	public int width() {
		return 200;
	}
	public int height() {
		return 150;
	}

}
