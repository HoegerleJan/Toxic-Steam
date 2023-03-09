package net.doulrion.toxicsteam.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.BiomeKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class EntityMixin {
    @Shadow protected abstract void playBlockFallSound();

    @Inject(at = @At(value = "TAIL"), method = "tick()V")
    private void tick(CallbackInfo cb)
    {
        LivingEntity entity = (LivingEntity)(Object)this;

        if (entity instanceof ServerPlayerEntity playerEntity) {

            //var a = entity.getEntityWorld().getBiome(playerEntity.getBlockPos()).getKey().toString();

            if(entity.getEntityWorld().getDimension().isUltrawarm() && !entity.hasStatusEffect(StatusEffects.POISON)
                    && !armorSet(entity)) {

                playerEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), playerEntity);
            }

            if(entity.getEntityWorld().getBiome(playerEntity.getBlockPos()).getKey().isPresent()) {
                if(entity.getEntityWorld().getBiome(playerEntity.getBlockPos()).getKey().get().equals(BiomeKeys.MUSHROOM_FIELDS)
                        && !entity.hasStatusEffect(StatusEffects.POISON) && !entity.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.LEATHER_HELMET)) {

                    playerEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), playerEntity);
                }
            }
        }
    }

    private boolean armorSet(LivingEntity entity) {

        boolean a = true;

        if(!entity.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.LEATHER_HELMET)
                ||!entity.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.LEATHER_CHESTPLATE)
                ||!entity.getEquippedStack(EquipmentSlot.LEGS).isOf(Items.LEATHER_LEGGINGS)
                ||!entity.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS)) {

            a = false;

        }

        return a;
    }
}
