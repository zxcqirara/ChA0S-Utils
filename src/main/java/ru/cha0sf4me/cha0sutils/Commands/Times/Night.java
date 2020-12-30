package ru.cha0sf4me.cha0sutils.Commands.Times;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class Night {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("night").executes(source -> {
            return night(source.getSource());
        }));
    }

    private static int night(CommandSource source) {
        source.getWorld().setDayTime(18000);
        source.sendFeedback(new TranslationTextComponent("commands.times.set", TextFormatting.LIGHT_PURPLE + "NIGHT" + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        return 1;
    }
}
