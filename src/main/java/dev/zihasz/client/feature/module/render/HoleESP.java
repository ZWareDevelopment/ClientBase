package dev.zihasz.client.feature.module.render;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.network.status.client.CPacketServerQuery;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;

public class HoleESP extends Module {

	public HoleESP() {
		super("HoleESP", "ESP for holes", Category.RENDER);
	}

	// Holes
	private final Setting<Integer> holes = new SettingBuilder<>(16).name("Holes").description("Number of holes to render.").min(0).max(1024).build(this);
	private final Setting<Integer> range = new SettingBuilder<>(16).name("Range").description("Range to render holes in.").min(0).max(32).build(this);
	private final Setting<Boolean> doubleHoles = new SettingBuilder<>(true).name("Double").description("Render double holes.").build(this);
	private final Setting<Boolean> quadHoles = new SettingBuilder<>(false).name("Quad").description("Render quad holes.").build(this);
	private final Setting<Boolean> enterable = new SettingBuilder<>(true).name("Enterable").description("Only render parts of double/quad holes that you can enter.").visibility(v -> doubleHoles.getValue() || quadHoles.getValue()).build(this);

	// Render
	private final Setting<Shape> shape = new SettingBuilder<>(Shape.FULL).name("Shape").description("Shape of the render.").build(this);
	private final Setting<Float> height = new SettingBuilder<>(.25f).name("Height").description("Height of the slab").min(0f).max(1f).visibility(v -> shape.getValue().equals(Shape.SLAB)).build(this);
	private final Setting<Mode> mode = new SettingBuilder<>(Mode.BOTH).name("Mode").description("Way to render holes.").build(this);
	private final Setting<Float> width = new SettingBuilder<>(1f).name("Outline Width").description("Width of the outline").min(0f).max(5f).visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private final Setting<Outline> outline = new SettingBuilder<>(Outline.SIMPLE).name("Outline Mode").description("The way to render the outline").visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private final Setting<Integer> outlineAlpha = new SettingBuilder<>(0).name("Outline Alpha").description("Alpha of the outline").min(0).max(255).visibility(v -> mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)).build(this);
	private final Setting<Float> length = new SettingBuilder<>(.1f).name("Claw Length").description("Length of the \"claws\".").min(0f).max(.5f).visibility(v -> (mode.getValue().equals(Mode.OUTLINE) || mode.getValue().equals(Mode.BOTH)) && outline.getValue().equals(Outline.CLAW)).build(this);

	private final Setting<Boolean> glow = new SettingBuilder<>(true).name("Glow").description("Give the holes a glow effect.").build(this);
	private final Setting<Boolean> invert = new SettingBuilder<>(true).name("Invert Glow").description("Invert the glow effect").parent(glow).build(this);
	private final Setting<Integer> glowAlpha = new SettingBuilder<>(0).name("Glow Alpha").description("Changes the \"hidden\" parts alpha.").min(0).max(255).parent(glow).build(this);

	// Bedrock
	private final Setting<Boolean> bedrock = new SettingBuilder<>(true).name("Bedrock").description("Render bedrock holes.").build(this);
	private final Setting<Color> bedrockColor = new SettingBuilder<>(new Color(30, 255, 30)).name("Bedrock Color").description("Color of bedrock holes").parent(bedrock).build(this);
	private final Setting<Color> bedrockDColor = new SettingBuilder<>(new Color(35, 255, 35)).name("Double Bedrock Color").description("Color of double bedrock holes").parent(bedrock).build(this);
	private final Setting<Color> bedrockQColor = new SettingBuilder<>(new Color(40, 255, 40)).name("Quad Bedrock Color").description("Color of quad bedrock holes").parent(bedrock).build(this);

	// Obsidian
	private final Setting<Boolean> obsidian = new SettingBuilder<>(true).name("Obsidian").description("Render obsidian holes.").build(this);
	private final Setting<Color> obsidianColor = new SettingBuilder<>(new Color(255, 30, 30)).name("Obsidian Color").description("Color of obsidian holes").parent(obsidian).build(this);
	private final Setting<Color> obsidianDColor = new SettingBuilder<>(new Color(255, 35, 35)).name("Double Obsidian Color").description("Color of double obsidian holes").parent(obsidian).build(this);
	private final Setting<Color> obsidianQColor = new SettingBuilder<>(new Color(255, 40, 40)).name("Quad Obsidian Color").description("Color of quad obsidian holes").parent(obsidian).build(this);


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
