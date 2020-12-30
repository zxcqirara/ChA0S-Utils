package ru.cha0sf4me.cha0sutils.Commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Collection;

public class Thor {
    public static void register(CommandDispatcher dispatcher) {
        dispatcher.register(Commands.literal("thor")
        .then(Commands.argument("target", EntityArgument.entities()).executes(source -> {
            return thor(source.getSource(), EntityArgument.getEntities(source, "target"));
        })));
    }

    private static int thor(CommandSource source, Collection<? extends Entity> player) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, source.getWorld());
        for (Entity i: player) {
            if (i == null) {source.sendErrorMessage(new TranslationTextComponent("commands.thor.error.null")); return 1;}
            bolt.setPosition(i.getPosX(), i.getPosY(), i.getPosZ());
            source.getWorld().addEntity(bolt);
            if (player.size() == 1) {
                source.sendFeedback(new TranslationTextComponent("commands.thor.done", TextFormatting.LIGHT_PURPLE + i.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
            }
        }
        if (player.size() > 1) {
            source.sendFeedback(new TranslationTextComponent("commands.thor.multi_done", TextFormatting.LIGHT_PURPLE + String.valueOf(player.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);
        }
        return 1;
    }
}
