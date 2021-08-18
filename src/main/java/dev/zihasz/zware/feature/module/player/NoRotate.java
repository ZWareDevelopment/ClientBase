package dev.zihasz.zware.feature.module.player;

import dev.zihasz.zware.event.events.PacketEvent;
import dev.zihasz.zware.feature.module.Category;
import dev.zihasz.zware.feature.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRotate extends Module {

	public NoRotate() {
		super("NoRotate", "Doesnt rotate", Category.PLAYER);
	}

	@SubscribeEvent
	public void onPacketRead(PacketEvent.Read event) {
		Packet<?> rawPacket = event.getPacket();
		if (rawPacket instanceof SPacketPlayerPosLook) {
			SPacketPlayerPosLook packet = (SPacketPlayerPosLook) rawPacket;
			event.cancel();

			double x = packet.getX();
			double y = packet.getY();
			double z = packet.getZ();

			if (packet.getFlags().contains(SPacketPlayerPosLook.EnumFlags.X))
				x += mc.player.posX;
			else
				mc.player.motionX = 0.0D;

			if (packet.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Y))
				y += mc.player.posY;
			else
				mc.player.motionY = 0.0D;

			if (packet.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Z))
				z += mc.player.posZ;
			else
				mc.player.motionZ = 0.0D;

			mc.player.setPosition(x, y, z);
			mc.player.connection.sendPacket(new CPacketConfirmTeleport(packet.getTeleportId()));
			mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(mc.player.posX, mc.player.posY, mc.player.posZ, packet.yaw, packet.pitch, false));
		}
	}

}
