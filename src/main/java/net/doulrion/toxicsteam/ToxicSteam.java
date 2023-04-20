package net.doulrion.toxicsteam;

import net.doulrion.toxicsteam.init.ConfigInit;
import net.doulrion.toxicsteam.item.ToxicSteamItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToxicSteam implements ModInitializer {
	public static final String MOD_ID = "toxicsteam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ToxicSteamItems.registerModItems();
		ConfigInit.init();
	}

	/**
	 * Only uses the LOGGER when executed in a development environment
	 * @param text input text for the LOGGER
	 */
	public static void devLogger(String text) {
		if (!FabricLoader.getInstance().isDevelopmentEnvironment()) return;
		ToxicSteam.LOGGER.info(" - [" + text + "]");
	}
}
