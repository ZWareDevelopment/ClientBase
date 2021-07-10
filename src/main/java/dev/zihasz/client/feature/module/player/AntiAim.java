package dev.zihasz.client.feature.module.player;

import dev.zihasz.client.event.events.PacketEvent;
import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiAim extends Module {

	private Setting<Float> pitch = new SettingBuilder<>(0f).name("Pitch").description("The pitch to look at").min(-360f).max(360f).build(this);
	private Setting<Float> yaw = new SettingBuilder<>(0f).name("Yaw").description("The yaw to look at").min(-360f).max(360f).build(this);

	public AntiAim() {
		super("AntiAim", "Its like csgo all over again!", Category.PLAYER);
	}

	@SubscribeEvent
	public void onPacketSend(PacketEvent.Send event) {
		Packet<?> raw = event.getPacket();
		if (raw instanceof CPacketPlayer) {
			CPacketPlayer packet = (CPacketPlayer) raw;
			packet.pitch = pitch.getValue();
			packet.yaw = yaw.getValue();
		}
	}

}
