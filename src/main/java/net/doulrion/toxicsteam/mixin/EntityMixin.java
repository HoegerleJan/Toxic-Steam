package net.doulrion.toxicsteam.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.biome.BiomeKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class EntityMixin {

    @Inject(at = @At(value = "TAIL"), method = "tick()V")
    private void tick(CallbackInfo cb) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof ServerPlayerEntity playerEntity) {

            if (entity.hasStatusEffect(StatusEffects.POISON)) return;
            if (!locationAppliesNetherPoison(playerEntity) && !locationAppliesMushroomPoison(playerEntity)) return;

            playerEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), playerEntity);

            playerEntity.sendMessage(new TranslatableText("chat.toxicsteam.toxic_location"), true);
        }
    }

    private boolean fullArmorSetEquiped(LivingEntity entity) {
        return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.LEATHER_HELMET)
                && entity.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.LEATHER_CHESTPLATE)
                && entity.getEquippedStack(EquipmentSlot.LEGS).isOf(Items.LEATHER_LEGGINGS)
                && entity.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS);
    }

    private boolean headArmorEquiped(LivingEntity entity) {
        return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.LEATHER_HELMET);
    }

    private boolean locationAppliesNetherPoison(ServerPlayerEntity playerEntity) {
        return playerEntity.getEntityWorld().getDimension().isUltrawarm() && !fullArmorSetEquiped(playerEntity);
    }

    private boolean locationAppliesMushroomPoison(ServerPlayerEntity playerEntity) {
        var playerBiomeKey = playerEntity.getEntityWorld().getBiome(playerEntity.getBlockPos()).getKey();

        return playerBiomeKey.isPresent() && playerBiomeKey.get().equals(BiomeKeys.MUSHROOM_FIELDS)
                && !headArmorEquiped(playerEntity);
    }
}
