package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Collection;

public class Repair {

    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("repair").executes(source -> {
            return repair(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.players()).executes(source -> {
            return repair(source.getSource(), EntityArgument.getPlayers(source, "target"));
        })));
    }

    private static int repair(CommandSource source, Collection<? extends PlayerEntity> players) {
        for (PlayerEntity i: players) {
            if (i.getHeldItemMainhand().equals(ItemStack.EMPTY)) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.noItem")); return 1;}
            if (!i.getHeldItemMainhand().isDamageable()) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.notDamageable")); return 1;}
            if (i.getHeldItemMainhand().getDamage() == 0) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.alreadyRepaired")); return 1;}

            i.getHeldItemMainhand().setDamage(0);
        }

        source.sendFeedback(new TranslationTextComponent("commands.repair.multi_done", TextFormatting.LIGHT_PURPLE + String.valueOf(players.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }

    private static int repair(CommandSource source, PlayerEntity player) {
        if (player.getHeldItemMainhand().equals(ItemStack.EMPTY)) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.noItem", player.getDisplayName())); return 1;}
        if (!player.getHeldItemMainhand().isDamageable()) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.notDamageable", player.getDisplayName())); return 1;}
        if (player.getHeldItemMainhand().getDamage() == 0) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.alreadyRepaired", player.getDisplayName())); return 1;}

        player.getHeldItemMainhand().setDamage(0);

        source.sendFeedback(new TranslationTextComponent("commands.repair.done", TextFormatting.LIGHT_PURPLE + player.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }
}
