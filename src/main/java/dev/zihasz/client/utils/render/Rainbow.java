package dev.zihasz.client.utils.render;

import java.awt.*;

/**
 * @author LeonLeonPotato - Trinity
 */
public class Rainbow {
	private float hue;

	public Rainbow() {
		this.hue = 0.0f;
	}

	public Rainbow(Color color) {
		this.hue = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), new float[3])[0];
	}

	public Rainbow(float hue) {
		this.hue = hue;
	}

	public void update(float val) {
		hue += (val % 360f) / 360f;
	}

	public Color getColor() {
		return new Color(Color.HSBtoRGB(hue, 1.0f, 1.0f));
	}

	public Color getColor(float off) {
		return new Color(Color.HSBtoRGB(((hue + off) % 360), 1.0f, 1.0f));
	}

	public Color getColor(float off, float sat, float bright) {
		return new Color(Color.HSBtoRGB(((hue + off) % 360), sat, bright));
	}

	public float getHue() {
		return hue;
	}

	public float getHueMultiplied() {
		return hue * 360f;
	}

	public void setHue(float hue) {
		this.hue = hue;
	}

	// static methods below
	// very spaghetti

	private static float transform(float max, float val) {
		final float f0 = val / max;
		return f0 * 1.0f;
	}

	public static Color getColorStatic(int alpha) {
		final Color color = new Color(Color.HSBtoRGB(transform(6500L, (System.currentTimeMillis() % 6500L)), 1.0f, 1.0f));
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}

	public static Color getColorStatic(float off, float speed, int alpha) {
		return new Color(Color.HSBtoRGB(transform(((long) (6500L / speed)), (System.currentTimeMillis() + ((long) off)) % ((long) (6500L / speed))), 1.0f, 1.0f));
	}

	public static Color getColorStatic(float off, float speed, float sat, float bright, int alpha) {
		final Color color = new Color(Color.HSBtoRGB(transform(((long) (6500L / speed)), (System.currentTimeMillis() + ((long) off)) % ((long) (6500L / speed))), sat, bright));
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}
}
