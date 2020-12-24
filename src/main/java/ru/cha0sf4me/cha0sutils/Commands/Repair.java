package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Repair {

    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("repair").executes(source -> {
            return repair(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return repair(source.getSource(), EntityArgument.getPlayer(source, "target"));
        })));
    }

    private static int repair(CommandSource source, ServerPlayerEntity player) {
        if (player.getHeldItemMainhand().equals(ItemStack.EMPTY)) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.noItem", player.getDisplayName())); return 1;}
        else if (!player.getHeldItemMainhand().isDamageable()) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.notDamageable", player.getDisplayName())); return 1;}
        else if (player.getHeldItemMainhand().getDamage() == 0) {source.sendErrorMessage(new TranslationTextComponent("commands.repair.error.alreadyRepaired", player.getDisplayName())); return 1;}
        player.getHeldItemMainhand().setDamage(0);
        source.sendFeedback(new TranslationTextComponent("commands.times.set").mergeStyle(TextFormatting.BLUE).append(new TranslationTextComponent("commands.times.night").mergeStyle(TextFormatting.LIGHT_PURPLE)), true);
        return 1;
    }
}
