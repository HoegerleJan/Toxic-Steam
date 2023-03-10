package net.doulrion.toxicsteam.item;

import net.doulrion.toxicsteam.ToxicSteam;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToxicSteamItems {

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(ToxicSteam.MOD_ID, name), item);
    }


    public static void registerModItems() {
        ToxicSteam.LOGGER.info("Registering " + ToxicSteam.MOD_ID + " Mod items");
    }
}
