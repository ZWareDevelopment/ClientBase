package dev.zihasz.client.core;

import dev.zihasz.client.Client;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.Name;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@Name("client")
@MCVersion(ForgeVersion.mcVersion)
public class ClientLoader implements IFMLLoadingPlugin {

	public ClientLoader() {
		this.initialize();
	}

	public void initialize() {
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.client.json");
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
