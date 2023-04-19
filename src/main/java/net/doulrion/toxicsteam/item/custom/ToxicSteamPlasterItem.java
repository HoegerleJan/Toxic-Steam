package net.doulrion.toxicsteam.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ToxicSteamPlasterItem extends Item{

    public ToxicSteamPlasterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if(Screen.hasShiftDown() && entity instanceof ServerPlayerEntity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), user);

            stack.setCount(stack.getCount() - 1);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack =  user.getStackInHand(hand);

        if(!Screen.hasShiftDown()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), user);

            stack.setCount(stack.getCount() - 1);
        }
        return super.use(world, user, hand);
    }
}
