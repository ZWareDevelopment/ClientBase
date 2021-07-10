package dev.zihasz.client.core.mixins.network;

import dev.zihasz.client.event.events.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

	@Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
	public void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet<?> p_channelRead0_2_, CallbackInfo ci) {
		PacketEvent.Read event = new PacketEvent.Read(p_channelRead0_2_);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			ci.cancel();
	}

	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
	public void channelRead0(Packet<?> packetIn, CallbackInfo ci) {
		PacketEvent.Send event = new PacketEvent.Send(packetIn);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			ci.cancel();
	}

}
