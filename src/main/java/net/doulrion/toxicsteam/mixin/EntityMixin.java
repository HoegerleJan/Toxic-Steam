package net.doulrion.toxicsteam.mixin;

import net.doulrion.toxicsteam.ToxicSteam;
import net.doulrion.toxicsteam.item.ToxicSteamItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class EntityMixin {
    private static Item divingHelmet;
    private static Item copperBackTank;
    private static Item divingBoots;


    @Inject(method = "tick()V", at = @At(value = "TAIL"))
    private void tick(CallbackInfo cb) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (ToxicSteam.loadedMods(false)) {
            divingHelmet = Registry.ITEM.get(new Identifier("create", "diving_helmet"));
            copperBackTank = Registry.ITEM.get(new Identifier("create", "copper_backtank"));
            divingBoots = Registry.ITEM.get(new Identifier("create", "diving_boots"));
        }

        if (entity instanceof ServerPlayerEntity playerEntity) {
            if (playerEntity.isCreative() || playerEntity.isSpectator()) return;
            if (entity.hasStatusEffect(StatusEffects.POISON)) return;
            if (!locationAppliesNetherPoison(playerEntity) && !locationAppliesMushroomPoison(playerEntity)) return;

            playerEntity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), playerEntity);

            playerEntity.sendMessage(new TranslatableText("chat.toxicsteam.toxic_location"), true);
        }
    }

    private boolean fullArmorSetEquiped(LivingEntity entity) {
        if (ToxicSteam.loadedMods(false)) {
            return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(divingHelmet)
                    && entity.getEquippedStack(EquipmentSlot.CHEST).isOf(copperBackTank)
                    && entity.getEquippedStack(EquipmentSlot.FEET).isOf(divingBoots);
        } else {
            //TODO: maybe delete this part?
            return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(ToxicSteamItems.PROTECTIVE_GAS_MASK)
                    && entity.getEquippedStack(EquipmentSlot.CHEST).isOf(ToxicSteamItems.PROTECTIVE_CHESTPLATE)
                    && entity.getEquippedStack(EquipmentSlot.LEGS).isOf(ToxicSteamItems.PROTECTIVE_LEGGINGS)
                    && entity.getEquippedStack(EquipmentSlot.FEET).isOf(ToxicSteamItems.PROTECTIVE_BOOTS);
        }
    }

    private boolean headArmorEquiped(LivingEntity entity) {
        if (ToxicSteam.loadedMods(false)) {

            return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(ToxicSteamItems.PROTECTIVE_GAS_MASK)
                    || entity.getEquippedStack(EquipmentSlot.HEAD).isOf(divingHelmet);
        }

        //TODO: maybe delete this part?
        return entity.getEquippedStack(EquipmentSlot.HEAD).isOf(ToxicSteamItems.PROTECTIVE_GAS_MASK);
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
