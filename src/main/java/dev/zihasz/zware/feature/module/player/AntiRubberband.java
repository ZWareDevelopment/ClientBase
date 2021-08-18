package dev.zihasz.zware.feature.module.player;

import dev.zihasz.zware.event.events.PacketEvent;
import dev.zihasz.zware.feature.module.Category;
import dev.zihasz.zware.feature.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiRubberband extends Module {

	public AntiRubberband() {
		super("AntiRubberband", "Prevents rubberbanding.", Category.PLAYER);
	}

	@SubscribeEvent
	public void onPacketRead(PacketEvent.Read event) {
		if (nullCheck()) return;

		Packet<?> rawPacket = event.getPacket();
		if (rawPacket instanceof SPacketPlayerPosLook) {
			SPacketPlayerPosLook packet = (SPacketPlayerPosLook) rawPacket;
			event.cancel();

			mc.player.connection.sendPacket(new CPacketConfirmTeleport(packet.teleportId));
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.lastTickPosX, mc.player.posY, mc.player.lastTickPosZ, mc.player.onGround));
		}
	}

}
