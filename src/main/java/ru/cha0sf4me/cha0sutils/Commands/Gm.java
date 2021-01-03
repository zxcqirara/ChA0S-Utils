package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.*;
import net.minecraft.world.GameType;

import java.util.Collection;
import java.util.Collections;

public class Gm {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("gm")
        .then(Commands.argument("mode", IntegerArgumentType.integer(0, 3)).executes(source -> {
            return gm(source.getSource(), source.getSource().asPlayer(), IntegerArgumentType.getInteger(source, "mode"));
        }).then(Commands.argument("target", EntityArgument.players()).executes(source -> {
            return gm(source.getSource(), EntityArgument.getPlayers(source, "target"), IntegerArgumentType.getInteger(source, "mode"));
        }))));
    }

    private static GameType GMer(Integer mode) {
        if (mode == 0) {
            return GameType.SURVIVAL;
        } else if (mode == 1) {
            return GameType.CREATIVE;
        } else if (mode == 2) {
            return GameType.ADVENTURE;
        } else if (mode == 3) {
            return GameType.SPECTATOR;
        }

        return null;
    }

    private static int gm(CommandSource source, Collection<? extends PlayerEntity> players, Integer mode) {
        for (PlayerEntity i: players) {
            i.setGameType(GMer(mode));
        }

        source.sendFeedback(new TranslationTextComponent("commands.gm.multi_switched", TextFormatting.LIGHT_PURPLE + String.valueOf(players.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }

    private static int gm(CommandSource source, PlayerEntity player, Integer mode) {
        player.setGameType(GMer(mode));

        source.sendFeedback(new TranslationTextComponent("commands.gm.switched", TextFormatting.LIGHT_PURPLE + player.getDisplayName().toString() + TextFormatting.BLUE, TextFormatting.LIGHT_PURPLE + mode.toString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }
}
