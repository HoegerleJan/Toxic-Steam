package net.doulrion.toxicsteam;

import net.doulrion.toxicsteam.item.ToxicSteamItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToxicSteam implements ModInitializer {
	public static final String MOD_ID = "toxicsteam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ToxicSteamItems.registerModItems();

	}
}
