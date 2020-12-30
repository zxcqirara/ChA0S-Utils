package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ToSpawn {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("tospawn").executes(source -> {
            return tospawn(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return tospawn(source.getSource(), EntityArgument.getPlayer(source, "target"));
        })));
    }

    private static int tospawn(CommandSource source, ServerPlayerEntity player) {
        player.teleport((ServerWorld)player.world, (double) player.func_241140_K_().getX(), (double) player.func_241140_K_().getY(), (double) player.func_241140_K_().getZ(), player.rotationYaw, player.rotationPitch);
        source.sendFeedback(new TranslationTextComponent("commands.tospawn.done", TextFormatting.LIGHT_PURPLE + player.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
