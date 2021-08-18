package dev.zihasz.client.core.mixins.accessors;

import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketCustomPayload.class)
public interface CPacketCustomPayloadAccessor {

	@Accessor("channel")
	void setChannel(String channelIn);

	@Accessor("data")
	void setData(PacketBuffer dataIn);

}
