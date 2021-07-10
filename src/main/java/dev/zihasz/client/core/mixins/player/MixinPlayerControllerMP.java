package dev.zihasz.client.core.mixins.player;

import dev.zihasz.client.event.events.BlockEvent;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerControllerMP.class)
public abstract class MixinPlayerControllerMP {

	@Inject(method = "clickBlock", at = @At("HEAD"), cancellable = true)
	public void clickBlock(BlockPos loc, EnumFacing face, CallbackInfoReturnable<Boolean> cir) {
		BlockEvent.Click event = new BlockEvent.Click(loc, face);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			cir.cancel();
	}

	@Inject(method = "onPlayerDamageBlock", at = @At("HEAD"), cancellable = true)
	public void onPlayerDamageBlock(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
		BlockEvent.Damage event = new BlockEvent.Damage(posBlock, directionFacing);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			cir.cancel();
	}

	@Inject(method = "onPlayerDestroyBlock", at = @At("HEAD"), cancellable = true)
	public void onPlayerDestroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockEvent.Destroy event = new BlockEvent.Destroy(pos);
		MinecraftForge.EVENT_BUS.post(event);


		if (event.isCanceled())
			cir.cancel();
	}

}
