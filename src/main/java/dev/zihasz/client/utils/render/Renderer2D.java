package dev.zihasz.client.utils.render;

import dev.zihasz.client.utils.Util;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.Entity;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;


public class Renderer2D implements Util {

	private static final ScaledResolution sr = new ScaledResolution(mc);

	// Draw outline shapes

	public static void drawRectangle(Rectangle rectangle, float width, Color color) {}
	public static void drawSphere(Point o, float radius, float width, Color color) {}
	public static void drawTriangle(Point p1, Point p2, Point p3, float width, Color color) {}

	// Draw filled shapes

	public static void fillRectangle(Rectangle rectangle, Color color) {}
	public static void fillSphere(Point o, float radius, Color color) {}
	public static void fillTriangle(Point p1,  Point p2, Point p3, Color color) {}

	// Draw filled rainbow shapes

	public static void fillRainbowRectangle(Rectangle rectangle) {}
	public static void fillRainbowRectangleH(Rectangle rectangle) {}
	public static void fillRainbowRectangleV(Rectangle rectangle) {}
	public static void fillRainbowSphere(Point o, float radius) {}
	public static void fillRainbowTriangle(Point p1,  Point p2, Point p3) {}

	// Draw non-shapes

	public static void drawEntity(Entity entity, Point position, Point mouse, int scale) {
		GlStateManager.enableColorMaterial();

		// Push
		GlStateManager.pushMatrix();

		// Translate Scale and rotate
		GlStateManager.translate((float) position.x, (float) position.y, 50.0F);
		GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);

		// Rotate 135
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);

		// Enable lighting
		RenderHelper.enableStandardItemLighting();

		// Rotate -135
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);

		// Mouse rotation
		GlStateManager.rotate(-((float) Math.atan(mouse.y / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);

		// Translate nothing
		GlStateManager.translate(0.0F, 0.0F, 0.0F);

		// Render entity
		mc.getRenderManager().setPlayerViewY(180.0F);
		mc.getRenderManager().setRenderShadow(false);
		mc.getRenderManager().renderEntity(entity, 0.0D, 0.0D, 0.0D, 0.0F, mc.getRenderPartialTicks(), false);
		mc.getRenderManager().setRenderShadow(true);

		// Disable lighting
		RenderHelper.disableStandardItemLighting();

		// Pop
		GlStateManager.popMatrix();

		// Lightmap
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	// Utility functions

	private static void scissor(Rectangle rectangle) {
		glPushAttrib(GL_SCISSOR_BIT);
		glEnable(GL_SCISSOR_TEST);
		glScissor(rectangle.x * sr.getScaleFactor(),
				rectangle.y * sr.getScaleFactor(),
				rectangle.width * sr.getScaleFactor(),
				rectangle.height * sr.getScaleFactor());
	}
	private static void unScissor() {
		glPopAttrib();
		glDisable(GL_SCISSOR_TEST);
	}
	private static void color(Color color) {
		GlStateManager.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}

}
