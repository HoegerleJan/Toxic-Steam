package net.doulrion.toxicsteam.item.custom;

import net.doulrion.toxicsteam.util.HealingItemValue;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ToxicSteamHealingItem extends Item{
    private final HealingItemValue level;

    public ToxicSteamHealingItem(Settings settings, HealingItemValue level) {
        super(settings);
        this.level = level;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.isSneaking() || !(entity instanceof ServerPlayerEntity)) {
            return ActionResult.PASS;
        }

        switch (level) {
            case WEAK:
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), user);
                break;
            case MEDIUM:
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), user);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), user);
                break;
            case STRONG:
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 2), user);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), user);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0), user);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 1), user);
                break;
        }

        stack.decrement(1);
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack =  user.getStackInHand(hand);
        if (user.isSneaking() || !(user instanceof ServerPlayerEntity)) {
            return TypedActionResult.pass(stack);
        }

        switch (level) {
            case WEAK:
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), user);
                break;
            case MEDIUM:
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 120, 0), user);
                break;
            case STRONG:
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 2), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 1), user);
                break;
        }

        stack.decrement(1);
        return TypedActionResult.success(stack);
    }
}



