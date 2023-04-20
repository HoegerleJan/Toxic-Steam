package net.doulrion.toxicsteam.init;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.doulrion.toxicsteam.config.ToxicSteamConfig;

public class ConfigInit {

    public static ToxicSteamConfig CONFIG = new ToxicSteamConfig();

    public static void init() {

        AutoConfig.register(ToxicSteamConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ToxicSteamConfig.class).getConfig();
    }
}
