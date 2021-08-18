package dev.zihasz.client.feature.module.combat;

import dev.zihasz.client.feature.module.Category;
import dev.zihasz.client.feature.module.Module;
import dev.zihasz.client.feature.settings.Setting;
import dev.zihasz.client.feature.settings.SettingBuilder;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Offhand extends Module {


	private final Setting<Item> item = new SettingBuilder<>(Item.Crystal).name("Item").description("The item to put in your offhand normally.").build(this);
	private final Setting<Boolean> rightClickGap = new SettingBuilder<>(true).name("Right Click Gap").description("").visibility(v -> item.getValue() != Item.Gap).build(this);
	private final Setting<Boolean> swordOnly = new SettingBuilder<>(true).name("Sword Only").description("Only gap when swording.").parent(rightClickGap).build(this);
	private final Setting<Integer> totemHealth = new SettingBuilder<>(10).name("Totem Health").description("The health to put totems in your hand.").range(0, 36).build(this);

	public Offhand() {
		super("Offhand", "Puts items in your offhand, useful in the ends against the opps.", Category.COMBAT);
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {

	}

	private enum Item {
		Totem,
		Crystal,
		Gap,
		Bow,
		Potion,
		Exp,
	}

}
