package net.doulrion.toxicsteam.item;

import net.doulrion.toxicsteam.ToxicSteam;
import net.doulrion.toxicsteam.item.custom.ProtectiveSuitItem;
import net.doulrion.toxicsteam.item.custom.ToxicSteamHealingItem;
import net.doulrion.toxicsteam.util.HealingItemValue;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
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

    public static final Item REINFORCED_CHARGED_STRING = registerItem("reinforced_charged_string", //TODO: no recipe
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item REINFORCED_CHARGED_FABRIC = registerItem("reinforced_charged_fabric", //TODO: no recipe
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item FILTER = registerItem("filter",                                    //FIXME: change item (in hand) texture
            new Item(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));


    public static final Item PROTECTIVE_GAS_MASK = registerItem("protective_gas_mask",        //FIXME: change item (in hand) texture
            new ProtectiveSuitItem(ToxicSteamArmorMaterials.PROTECTIVE_FIBER, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item PROTECTIVE_CHESTPLATE = registerItem("protective_chestplate",
            new ProtectiveSuitItem(ToxicSteamArmorMaterials.PROTECTIVE_FIBER, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item PROTECTIVE_LEGGINGS = registerItem("protective_leggings",
            new ProtectiveSuitItem(ToxicSteamArmorMaterials.PROTECTIVE_FIBER, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));

    public static final Item PROTECTIVE_BOOTS = registerItem("protective_boots",
            new ProtectiveSuitItem(ToxicSteamArmorMaterials.PROTECTIVE_FIBER, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM)));
    public static final Item PLASTER = registerItem("plaster",
            new ToxicSteamHealingItem(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM).maxCount(3),
                    HealingItemValue.WEAK));
    public static final Item BANDAGE = registerItem("bandage",
            new ToxicSteamHealingItem(new FabricItemSettings().group(ToxicSteamItemGroup.TOXIC_STEAM).maxCount(1),
                    HealingItemValue.MEDIUM));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(ToxicSteam.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ToxicSteam.LOGGER.info("Registering " + ToxicSteam.MOD_ID + " Mod items");
    }
}
