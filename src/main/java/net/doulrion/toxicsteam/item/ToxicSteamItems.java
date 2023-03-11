package net.doulrion.toxicsteam.item;

import net.doulrion.toxicsteam.ToxicSteam;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToxicSteamItems {

    public static final Item REDSTONE_INGOT = registerItem("redstone_ingot",
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item CHARGED_STRING = registerItem("charged_string",
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item CHARGED_FABRIC = registerItem("charged_fabric",
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item REINFORCED_CHARGED_STRING = registerItem("reinforced_charged_string", //TODO: Rezept fehlt!
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item REINFORCED_CHARGED_FABRIC = registerItem("reinforced_charged_fabric", //TODO: Rezept fehlt!
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item FILTER = registerItem("filter",
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item GAS_MASK = registerItem("gas_mask", //TODO: Scheiß Texture
            new ArmorItem(ToxicSteamArmorMaterials.GAS_MASK, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(ToxicSteam.MOD_ID, name), item);
    }


    public static void registerModItems() {
        ToxicSteam.LOGGER.info("Registering " + ToxicSteam.MOD_ID + " Mod items");
    }
}
