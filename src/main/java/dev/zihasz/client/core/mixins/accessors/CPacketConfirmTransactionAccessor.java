package dev.zihasz.client.core.mixins.accessors;

import net.minecraft.network.play.client.CPacketConfirmTransaction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketConfirmTransaction.class)
public interface CPacketConfirmTransactionAccessor {

	@Accessor("windowId")
	void setWindowId(int windowIdIn);

	@Accessor("uid")
	void setUid(short uidIn);

	@Accessor("accepted")
	boolean isAccepted();

	@Accessor("accepted")
	void setAccepted(boolean acceptedIn);

}
