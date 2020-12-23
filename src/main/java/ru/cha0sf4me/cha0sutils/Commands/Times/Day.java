package ru.cha0sf4me.cha0sutils.Commands.Times;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.message.FormattedMessage;

import java.util.Formatter;

public class Day {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("day").executes(source -> {
            return day(source.getSource());
        }));
    }

    private static int day(CommandSource source) {
        source.getWorld().func_241114_a_(1000);
        source.sendFeedback(new TranslationTextComponent("commands.time.day", source.getDisplayName()), true);
        return 1;
    }
}
