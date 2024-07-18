package fi.natroutter.hidefeedback.mixins;

import fi.natroutter.hidefeedback.HideFeedBack;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ServerCommandSource.class)
public abstract class ServerCommandSourceMixin {

    @Shadow @Final private String name;
    @Shadow @Final private @Nullable Entity entity;
    @Shadow @Final private ServerWorld world;

    @Inject(
            method = "sendFeedback",
            at= @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/CommandOutput;sendMessage(Lnet/minecraft/text/Text;)V"
            ),
            cancellable = true
    )
    public void feedBackSendMessage(Supplier<Text> feedbackSupplier, boolean broadcastToOps, CallbackInfo ci) {
        String ent = null;
        if (entity != null) {
            ent = entity.getType().getName().getString();
        }

        //Block feedback to ops if its from player
        if (ent != null && ent.equalsIgnoreCase("Player")) {
            if(!world.getGameRules().getBoolean(HideFeedBack.feedBackPlayer)) {
                ci.cancel();
            }
            return;
        }

        //Block feedback to ops if its from Console
        if (name.equalsIgnoreCase("server")) {
            if(!world.getGameRules().getBoolean(HideFeedBack.feedBackServer)) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = "sendFeedback",
            at= @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/ServerCommandSource;sendToOps(Lnet/minecraft/text/Text;)V"
            ),
            cancellable = true
    )
    public void feedBackSendToOps(Supplier<Text> feedbackSupplier, boolean broadcastToOps, CallbackInfo ci) {
        String ent = null;
        if (entity != null) {
            ent = entity.getType().getName().getString();
        }

        //Block feedback to ops if its from player
        if (ent != null && ent.equalsIgnoreCase("Player")) {
            if(!world.getGameRules().getBoolean(HideFeedBack.feedBackFromPlayer)) {
                ci.cancel();
            }
            return;
        }

        //Block feedback to ops if its from commandBlock
        if (name.equalsIgnoreCase("@")) {
            if(!world.getGameRules().getBoolean(HideFeedBack.feedBackFromCommandBlock)) {
                ci.cancel();
            }
            return;
        }

        //Block feedback to ops if its from Console
        if (name.equalsIgnoreCase("server")) {
            if(!world.getGameRules().getBoolean(HideFeedBack.feedBackFromServer)) {
                ci.cancel();
            }
        }
    }

}
