package net.doulrion.toxicsteam.item;

import net.doulrion.toxicsteam.ToxicSteam;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ToxicSteamItemGroup {

    public static final ItemGroup TOXIC_STEAM = FabricItemGroupBuilder.build(new Identifier(ToxicSteam.MOD_ID, "toxicsteam"),
            ()  -> new ItemStack(ToxicSteamItems.REINFORCED_CHARGED_FABRIC));

}
