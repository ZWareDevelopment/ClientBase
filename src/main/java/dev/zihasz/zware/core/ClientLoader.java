package dev.zihasz.zware.core;

import dev.zihasz.zware.ZWare;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.Name;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@Name(ZWare.ID)
@MCVersion(ForgeVersion.mcVersion)
public class ClientLoader implements IFMLLoadingPlugin {

	public ClientLoader() {

	}

	public void initialize() {
		ZWare.LOGGER.info("Initializing mixins...");

		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.zware.json");

		ZWare.LOGGER.info("Successfully initialized mixins!");
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Nullable
	@Override
	public String getSetupClass() {
		return "dev.zihasz.client.core.ClientHook";
	}

	@Override
	public void injectData(Map<String, Object> dataMap) {}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
