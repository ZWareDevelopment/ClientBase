package dev.zihasz.zware.feature.hud.components;

import dev.zihasz.zware.ZWare;
import dev.zihasz.zware.feature.hud.HudComponent;

import java.awt.*;

public class Watermark extends HudComponent {

	public Watermark() {
		super("Watermark", "Shows a watermark with the name of the client", new Point(2, 2));
		this.setEnabled(true);
	}

	private final String watermark = String.format("%s v%s", ZWare.CNAME, ZWare.VERSION);

	@Override
	public void render(float ticks) {
		mc.fontRenderer.drawString(watermark, location.x, location.y, 0xffffffff);
	}

	public int width() { return mc.fontRenderer.getStringWidth(watermark); }
	public int height() { return mc.fontRenderer.FONT_HEIGHT; }

}
