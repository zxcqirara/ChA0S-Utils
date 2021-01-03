package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.Collection;

public class Feed {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("feed").executes(source -> {
            return feed(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.players()).executes(source -> {
            return feed(source.getSource(), EntityArgument.getPlayers(source, "target"));
        })));
    }

    private static int feed(CommandSource source, Collection<? extends PlayerEntity> players) {
        for (PlayerEntity i: players) {
            i.addPotionEffect(new EffectInstance(Effects.SATURATION, 1, 999, true, false));
        }

        source.sendFeedback(new TranslationTextComponent("commands.feed.multi_done", TextFormatting.LIGHT_PURPLE + String.valueOf(players.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }

    private static int feed(CommandSource source, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SATURATION, 1, 999, true, false));

        source.sendFeedback(new TranslationTextComponent("commands.feed.done", TextFormatting.LIGHT_PURPLE + player.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }
}
