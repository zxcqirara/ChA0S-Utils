package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.*;
import net.minecraft.world.GameType;

public class Gm {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("gm")
        .then(Commands.argument("mode", IntegerArgumentType.integer(0, 3)).executes(source -> {
            return gm(source.getSource(), source.getSource().asPlayer(), IntegerArgumentType.getInteger(source, "mode"));
        })));
    }

    private static int gm(CommandSource source, ServerPlayerEntity player, Integer mode) {
        if (mode == 0) {
            player.setGameType(GameType.SURVIVAL);
        } else if (mode == 1) {
            player.setGameType(GameType.CREATIVE);
        } else if (mode == 2) {
            player.setGameType(GameType.ADVENTURE);
        } else if (mode == 3) {
            player.setGameType(GameType.SPECTATOR);
        }
        source.sendFeedback(new TranslationTextComponent("commands.gm.switched").mergeStyle(TextFormatting.BLUE).append(new StringTextComponent(mode.toString()).mergeStyle(TextFormatting.LIGHT_PURPLE)), true);
        return 1;
    }
}
