package ru.cha0sf4me.cha0sutils.Commands.Weather;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Rain {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("rain").executes(source -> {
            return rain(source.getSource());
        }));
    }

    private static int rain(CommandSource source) {
        source.getWorld().func_241113_a_(0, 6000, true, false);
        source.sendFeedback(new TranslationTextComponent("commands.weather.set", TextFormatting.LIGHT_PURPLE + "RAIN" + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
