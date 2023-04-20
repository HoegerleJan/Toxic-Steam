package net.doulrion.toxicsteam.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "toxicsteam")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class ToxicSteamConfig implements ConfigData {
    @Comment("restricts the PlayerList when joining a server")
    public boolean restrictPlayerList = true;
}
