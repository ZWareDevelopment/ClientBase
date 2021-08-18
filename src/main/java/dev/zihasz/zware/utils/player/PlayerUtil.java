package dev.zihasz.zware.utils.player;

import dev.zihasz.zware.utils.Util;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerUtil implements Util {

	public static float getFullHealth() {
		return mc.player.getHealth() + mc.player.getAbsorptionAmount();
	}

	public static float getFullHealth(EntityPlayer player) {
		return player.getHealth() + player.getAbsorptionAmount();
	}

}
