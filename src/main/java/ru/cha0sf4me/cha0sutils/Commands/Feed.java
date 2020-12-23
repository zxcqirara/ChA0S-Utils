package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TranslationTextComponent;

public class Feed {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("feed").executes(source -> {
            return feed(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return feed(source.getSource(), EntityArgument.getPlayer(source, "target"));
        })));
    }

    private static int feed(CommandSource source, ServerPlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SATURATION, 1, 999, true, false));
        source.sendFeedback(new TranslationTextComponent("commands.feed.done", player.getDisplayName()), true);
        return 1;
    }
}
