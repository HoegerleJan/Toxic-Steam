package net.doulrion.toxicsteam.mixin;

import net.doulrion.toxicsteam.ToxicSteam;
import net.doulrion.toxicsteam.init.ConfigInit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;


@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {
    @Final
    @Shadow
    private MinecraftClient client;

    @ModifyExpressionValue(
        method = "render",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 0)
    )
    private boolean toxicSteam$restrictPlayerListKeyPressed(boolean original) {
        ToxicSteam.devLogger("started mixin evaluation");
        if (!ConfigInit.CONFIG.restrictPlayerList) return original;
        if (!client.options.playerListKey.isPressed()) return false;
        if (client.player == null) return false;
        ToxicSteam.devLogger("custom evaluation is used | client in singleplayer: " + client.isInSingleplayer());
        return !client.isInSingleplayer();
    }

}
