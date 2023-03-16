package net.doulrion.toxicsteam;

import net.doulrion.toxicsteam.entity.client.armor.ProtectiveGasMaskRenderer;
import net.doulrion.toxicsteam.item.ToxicSteamItems;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ToxicSteamClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        GeoArmorRenderer.registerArmorRenderer(new ProtectiveGasMaskRenderer(), ToxicSteamItems.PROTECTIVE_GAS_MASK);
    }
}
