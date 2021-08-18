package dev.zihasz.client.utils.render;

import dev.zihasz.client.utils.Util;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Renderer2D implements Util {

	private static final Tessellator tessellator = Tessellator.getInstance();
	private static final BufferBuilder bufferBuilder = tessellator.getBuffer();

	// Draw shapes

	public static void drawRectangle(Rectangle rectangle, Color color) {
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.glLineWidth(1);

		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
		bufferBuilder.pos(rectangle.x, rectangle.y + rectangle.height, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x, rectangle.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
	public static void drawRectangleOutline(Rectangle rectangle, float width, Color color) {
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.glLineWidth(width);

		bufferBuilder.begin(GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR);
		bufferBuilder.pos(rectangle.x, rectangle.y + rectangle.height, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x, rectangle.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawCircle(Point o, float radius, Color color) {
		glEnable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
		glEnable(GL_LINE_SMOOTH);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glColor4f(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		glBegin(GL_TRIANGLE_FAN);

		for (int i = 0; i <= 360; i++)
			glVertex2d(o.x + Math.sin(((i * Math.PI) / 180)) * radius, o.y + Math.cos(((i * Math.PI) / 180)) * radius);

		glEnd();
		glDisable(GL_LINE_SMOOTH);
		glEnable(GL_TEXTURE_2D);
		glDisable(GL_BLEND);
	}
	public static void drawCircleOutline(Point o, float radius, float width, Color color) {
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.glLineWidth(width);
		glEnable(GL_LINE_SMOOTH);
		glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
		bufferBuilder.begin(GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR);

		for (int a = 0; a < 360; a++) {
			final double x1 = o.x + (radius * Math.sin(Math.toRadians(a)));
			final double z1 = o.y + (radius * Math.cos(Math.toRadians(a)));

			bufferBuilder.pos(x1, z1, 0.0f).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		}

		tessellator.draw();
		GlStateManager.shadeModel(GL_FLAT);
		glDisable(GL_LINE_SMOOTH);

		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawTriangle(Point position, float rotation, float scale, Color color) {
		glPushMatrix();
		glScaled(0.5, 0.5, 0.5);
		glTranslated(position.x, position.y, 0);
		glColor4f(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		glEnable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
		glEnable(GL_LINE_SMOOTH);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_TRIANGLES);

		glVertex2d(0, 6);
		glVertex2d(3, -2);
		glVertex2d(-3, -2);

		glEnd();
		glDisable(GL_LINE_SMOOTH);
		glEnable(GL_LINE_SMOOTH);
		glDisable(GL_TEXTURE_2D);
		glRotatef(rotation, 0F, 0F, 1.0F);
		glScalef(-scale, scale, scale);

		glPopMatrix();
	}

	public static void drawLine(Point start, Point end, float width, Color color) {
		GlStateManager.pushMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, GL_ZERO, GL_ONE);

		GlStateManager.shadeModel(GL_SMOOTH);
		glLineWidth(width);
		glEnable(GL_LINE_SMOOTH);
		glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);

		bufferBuilder.begin(GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferBuilder.pos(start.x, start.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferBuilder.pos(end.x, end.y, 0.0D).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();

		GlStateManager.shadeModel(GL_FLAT);
		glDisable(GL_LINE_SMOOTH);

		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
		GlStateManager.popMatrix();
	}

	public static void drawGradientRectangle(Rectangle rectangle, Color start, Color end) {
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.shadeModel(GL_SMOOTH);

		bufferBuilder.begin(GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y, 0).color(end.getRed(), end.getGreen(), end.getBlue(), end.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x, rectangle.y, 0).color(start.getRed(), start.getGreen(), start.getBlue(), start.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x, rectangle.y + rectangle.height, 0).color(start.getRed(), start.getGreen(), start.getBlue(), start.getAlpha()).endVertex();
		bufferBuilder.pos(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0).color(end.getRed(), end.getGreen(), end.getBlue(), end.getAlpha()).endVertex();
		tessellator.draw();

		GlStateManager.shadeModel(GL_FLAT);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
	}
	public static void drawRainbowRectangleHorizontal(Rectangle rectangle, float speed, int alpha, Color starting) {
		Rainbow rainbow = new Rainbow(starting);

		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.glLineWidth(1);
		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
		for (float i = rectangle.x; i < rectangle.x + rectangle.width; i += 0.5) {
			rainbow.update(speed);

			final float red = (float) rainbow.getColor().getRed() / 255;
			final float green = (float) rainbow.getColor().getGreen() / 255;
			final float blue = (float) rainbow.getColor().getBlue() / 255;

			bufferBuilder.pos(i + 0.5f, rectangle.y + rectangle.height, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(i, rectangle.y + rectangle.height, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(i, rectangle.y, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(i + 0.5f, rectangle.y, 0.0D).color(red, green, blue, alpha).endVertex();
		}
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
	public static void drawRainbowRectangleVertical(Rectangle rectangle, int speed, int alpha, Color starting) {
		Rainbow rainbow = new Rainbow(starting);

		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.glLineWidth(1);
		bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
		for (float i = rectangle.y; i < rectangle.y + rectangle.height; i += 0.5) {
			rainbow.update(speed);

			final float red = (float) rainbow.getColor().getRed() / 255;
			final float green = (float) rainbow.getColor().getGreen() / 255;
			final float blue = (float) rainbow.getColor().getBlue() / 255;

			bufferBuilder.pos(rectangle.x + rectangle.width, i + 0.5f, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(rectangle.x, i + 0.5f, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(rectangle.x, i, 0.0D).color(red, green, blue, alpha).endVertex();
			bufferBuilder.pos(rectangle.x, i, 0.0D).color(red, green, blue, alpha).endVertex();
		}
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	// Draw non-shapes

	public static void drawEntity(Entity entity, Point position, Point mouse, float scale) {
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate(position.x, position.y, 50.0F);
		GlStateManager.scale(-scale, scale, scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate((float) (-Math.atan(mouse.y / 40.0F) * 20.0F), 1.0F, 0.0F, 0.0F);
		GlStateManager.translate(0.0F, 0.0F, 0.0F);

		mc.getRenderManager().setPlayerViewY(180.0F);
		mc.getRenderManager().setRenderShadow(false);
		mc.getRenderManager().renderEntity(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
		mc.getRenderManager().setRenderShadow(true);

		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	// Utility functions

	private static void startScissor(Rectangle rectangle) {
		ScaledResolution sr = new ScaledResolution(mc);

		glPushAttrib(GL_SCISSOR_BIT);
		glEnable(GL_SCISSOR_TEST);
		glScissor(rectangle.x * sr.getScaleFactor(),
				rectangle.y * sr.getScaleFactor(),
				rectangle.width * sr.getScaleFactor(),
				rectangle.height * sr.getScaleFactor());
	}

	private static void stopScissor() {
		glPopAttrib();
		glDisable(GL_SCISSOR_TEST);
	}

	private static void color(Color color) {
		GlStateManager.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}

}
