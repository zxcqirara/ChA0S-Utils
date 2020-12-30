package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Heal {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("heal").executes(source -> {
            return heal(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return heal(source.getSource(), EntityArgument.getPlayer(source, "target"));
        })));
    }

    private static int heal(CommandSource source, ServerPlayerEntity player) {
        if (player.getHealth() == player.getMaxHealth()) {
            source.sendErrorMessage(new TranslationTextComponent("commands.heal.error.alreadyHealed", player.getDisplayName()));
            return 1;
        }
        player.setHealth(player.getMaxHealth());
        source.sendFeedback(new TranslationTextComponent("commands.heal.done", TextFormatting.LIGHT_PURPLE + source.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
