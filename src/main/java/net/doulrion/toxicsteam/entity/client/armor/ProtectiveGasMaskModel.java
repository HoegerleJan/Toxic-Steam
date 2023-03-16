package net.doulrion.toxicsteam.entity.client.armor;

import net.doulrion.toxicsteam.ToxicSteam;
import net.doulrion.toxicsteam.item.custom.ProtectiveSuitItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ProtectiveGasMaskModel extends AnimatedGeoModel<ProtectiveSuitItem> {
    @Override
    public Identifier getModelLocation(ProtectiveSuitItem object) {
        return new Identifier(ToxicSteam.MOD_ID, "geo/protective_gas_mask.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ProtectiveSuitItem object) {
        return new Identifier(ToxicSteam.MOD_ID, "textures/models/armor/protective_gas_mask_gray.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ProtectiveSuitItem animatable) {
        return new Identifier(ToxicSteam.MOD_ID, "animations/model.animation.json");
    }
}
