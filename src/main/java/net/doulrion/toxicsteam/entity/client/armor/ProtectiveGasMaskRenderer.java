package net.doulrion.toxicsteam.entity.client.armor;

import net.doulrion.toxicsteam.item.custom.ProtectiveSuitItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ProtectiveGasMaskRenderer extends GeoArmorRenderer<ProtectiveSuitItem> {
    public ProtectiveGasMaskRenderer() {
        super(new ProtectiveGasMaskModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }

}
