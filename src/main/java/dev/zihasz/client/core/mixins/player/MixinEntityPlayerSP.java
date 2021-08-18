package dev.zihasz.client.core.mixins.player;

import com.mojang.authlib.GameProfile;
import dev.zihasz.client.event.events.PlayerEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.MoverType;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP extends AbstractClientPlayer {

	public MixinEntityPlayerSP(World worldIn, GameProfile playerProfile) {
		super(worldIn, playerProfile);
	}

	@Redirect(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/AbstractClientPlayer;move(Lnet/minecraft/entity/MoverType;DDD)V"))
	public void move(AbstractClientPlayer abstractClientPlayer, MoverType type, double x, double y, double z) {
		PlayerEvent.Move event = new PlayerEvent.Move(type, x, y, z);
		MinecraftForge.EVENT_BUS.post(event);

		super.move(event.type, event.x, event.y, event.z);
	}

}
