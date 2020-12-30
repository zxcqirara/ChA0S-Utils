package ru.cha0sf4me.cha0sutils.Commands.Weather;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Sun {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("sun").executes(source -> {
            return sun(source.getSource());
        }));
    }

    private static int sun(CommandSource source) {
        source.getWorld().func_241113_a_(6000, 0, false, false);
        source.sendFeedback(new TranslationTextComponent("commands.weather.set", TextFormatting.LIGHT_PURPLE + "SUN" + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
