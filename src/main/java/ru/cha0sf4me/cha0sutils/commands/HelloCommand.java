package ru.cha0sf4me.cha0sutils.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.IEventBus;

public class HelloCommand {
    private static final DynamicCommandExceptionType UNKNOWN_COLOR = new DynamicCommandExceptionType(color -> {
        return new TranslationTextComponent("commands.test.unknown_color", color);
    });

    private static final SuggestionProvider<CommandSource> SUGGEST_COLOR = (source, builder) -> {
        return ISuggestionProvider.suggest(TextFormatting.getValidValues(true, false).stream(), builder);
    };

    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("hello").executes(source -> {
            return hello(source.getSource(), source.getSource().asPlayer());
        }).then(Commands.argument("target", EntityArgument.player()).executes(source -> {
            return hello(source.getSource(), EntityArgument.getPlayer(source, "target"));
        }).then(Commands.argument("color", StringArgumentType.string()).suggests(SUGGEST_COLOR).executes(source -> {
            return hello(source.getSource(), EntityArgument.getPlayer(source, "target"), StringArgumentType.getString(source, "color"));
        }))));
    }

    private static int hello(CommandSource source, ServerPlayerEntity player) {
        source.sendFeedback(new TranslationTextComponent("commands.hello", player.getDisplayName()), true);
        return 1;
    }

    private static int hello(CommandSource source, ServerPlayerEntity player, String color) throws CommandSyntaxException {
        if(TextFormatting.getValueByName(color) == null) {
            throw UNKNOWN_COLOR.create(color);
        }
        source.sendFeedback(new TranslationTextComponent("commands.hello.color", TextFormatting.getValueByName(color).toString(), player.getDisplayName()), true);
        return 1;
    }
}
