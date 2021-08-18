package dev.zihasz.client.utils.player;

import dev.zihasz.client.utils.Util;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerUtil implements Util {

	public static float getFullHealth() {
		return mc.player.getHealth() + mc.player.getAbsorptionAmount();
	}

	public static float getFullHealth(EntityPlayer player) {
		return player.getHealth() + player.getAbsorptionAmount();
	}

}
