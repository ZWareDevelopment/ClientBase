package dev.zihasz.client.core.mixins.render;

import dev.zihasz.client.event.events.TransformEvent;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

	@Inject(method = "transformFirstPerson(Lnet/minecraft/util/EnumHandSide;F)V", at = @At("HEAD"), cancellable = true)
	public void transformFirstPerson(EnumHandSide hand, float p_187453_2_, CallbackInfo ci) {
		TransformEvent.FirstPerson event = new TransformEvent.FirstPerson(hand);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			ci.cancel();
	}

	@Inject(method = "transformSideFirstPerson(Lnet/minecraft/util/EnumHandSide;F)V", at = @At("HEAD"), cancellable = true)
	public void transformSideFirstPerson(EnumHandSide hand, float p_185749_2_, CallbackInfo ci) {
		TransformEvent.FirstPerson.Side event = new TransformEvent.FirstPerson.Side(hand);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			ci.cancel();
	}

	@Inject(method = "transformEatFirstPerson(FLnet/minecraft/util/EnumHandSide;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
	public void transformEatFirstPerson(float p_187454_1_, EnumHandSide hand, ItemStack stack, CallbackInfo ci) {
		TransformEvent.FirstPerson.Eat event = new TransformEvent.FirstPerson.Eat(hand, stack);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
			ci.cancel();
	}

}
