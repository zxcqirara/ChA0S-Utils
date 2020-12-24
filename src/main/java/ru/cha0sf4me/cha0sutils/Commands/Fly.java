package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Fly {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("fly").executes(source -> {
            return fly(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return fly(source.getSource(), EntityArgument.getPlayer(source, "target"));
        })));
    }

    private static int fly(CommandSource source, ServerPlayerEntity player) {
        player.abilities.allowFlying = !player.abilities.allowFlying;

        source.sendFeedback(new TranslationTextComponent("commands.fly.switched").mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
