package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Collection;

public class Heal {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("heal").executes(source -> {
            return heal(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.players()).executes(source -> {
            return heal(source.getSource(), EntityArgument.getPlayers(source, "target"));
        })));
    }

    private static int heal(CommandSource source, Collection<? extends PlayerEntity> players) {
        for (PlayerEntity i: players) {
            i.setHealth(i.getMaxHealth());
        }

        source.sendFeedback(new TranslationTextComponent("commands.heal.multi_done", TextFormatting.LIGHT_PURPLE + String.valueOf(players.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }

    private static int heal(CommandSource source, PlayerEntity player) {
        player.setHealth(player.getMaxHealth());

        source.sendFeedback(new TranslationTextComponent("commands.heal.done", TextFormatting.LIGHT_PURPLE + player.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }
}
