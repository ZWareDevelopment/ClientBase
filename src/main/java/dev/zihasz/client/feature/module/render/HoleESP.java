package dev.zihasz.client.feature.module.render;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;

public class HoleESP extends Module {

	public HoleESP() {
		super("HoleESP", "ESP for holes", Category.RENDER);
	}

	private Setting<Integer> holes = new SettingBuilder<>(16).name("Holes").description("Number of holes to render.").min(0).max(1024).build(this);
	private Setting<Integer> range = new SettingBuilder<>(16).name("Range").description("Range to render holes in.").min(0).max(32).build(this);
	private Setting<Boolean> doubleHoles = new SettingBuilder<>(true).name("Double").description("Render double holes.").build(this);
	private Setting<Boolean> quadHoles = new SettingBuilder<>(false).name("Quad").description("Render quad holes.").build(this);
	private Setting<Boolean> enterable = new SettingBuilder<>(true).name("Enterable").description("Only render parts of double/quad holes that you can enter.").visibility(v -> doubleHoles.getValue() || quadHoles.getValue()).build(this);

	private Setting<Shape> shape = new SettingBuilder<>(Shape.FULL).name("Shape").description("Shape of the render.").build(this);
	private Setting<Float> height = new SettingBuilder<>(.25f).name("Height").description("Height of the slab").min(0f).max(1f).visibility(v -> shape.getValue().equals(Shape.SLAB)).build(this);

	private Setting<Mode> mode = new SettingBuilder<>(Mode.OUTLINE).name("Mode").description("Way to render holes.").build(this);
	private Setting<Float> width = new SettingBuilder<>(1f).name("Outline Width").description("Width of the outline").min(0f).max(5f).visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private Setting<Integer> outlineAlpha = new SettingBuilder<>(0).name("Outline Alpha").description("Alpha of the outline").min(0).max(255).visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private Setting<Outline> outline = new SettingBuilder<>(Outline.SIMPLE).name("Outline Mode").description("The way to render the outline").visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private Setting<Float> length = new SettingBuilder<>(.1f).name("Claw Length").description("Length of the \"claws\".").min(0f).max(.5f).visibility(v -> (mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)) && outline.getValue().equals(Outline.CLAW)).build(this);

	private Setting<Boolean> glow = new SettingBuilder<>(true).name("Glow").description("Give the holes a glow effect.").build(this);
	private Setting<Boolean> invert = new SettingBuilder<>(true).name("Invert Glow").description("Invert the glow effect").visibility(v -> glow.getValue()).build(this);
	private Setting<Integer> glowAlpha = new SettingBuilder<>(0).name("Glow Alpha").description("Changes the \"hidden\" parts alpha.").min(0).max(255).build(this);

	private Setting<Boolean> bedrock = new SettingBuilder<>(true).name("Bedrock").description("Render bedrock holes.").build(this);
	private Setting<Color> bedrockColor = new SettingBuilder<>(new Color(40, 255, 40)).name("Bedrock Color").description("Color of bedrock holes").visibility(v -> bedrock.getValue()).build(this);

	private Setting<Boolean> obsidian = new SettingBuilder<>(true).name("Obsidian").description("Render obsidian holes.").build(this);
	private Setting<Color> obsidianColor = new SettingBuilder<>(new Color(255, 40, 40)).name("Obsidian Color").description("Color of obsidian holes").visibility(v -> obsidian.getValue()).build(this);

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {

	}

	@SubscribeEvent
	public void onRender3D(RenderWorldLastEvent event) {

	}

	private enum Shape {
		FULL,
		SLAB,
		FLAT,
	}
	private enum Mode {
		OUTLINE,
		FILL,
		BOTH,
	}
	private enum Outline {
		SIMPLE,
		CLAW,
	}

}
