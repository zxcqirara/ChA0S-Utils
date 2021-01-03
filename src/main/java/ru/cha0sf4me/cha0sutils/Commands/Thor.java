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

    private static int thor(CommandSource source, Collection<? extends Entity> entities) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, source.getWorld());

        for (Entity i: entities) {
            if (i == null) {source.sendErrorMessage(new TranslationTextComponent("commands.thor.error.null")); return 1;}
            bolt.setPosition(i.getPosX(), i.getPosY(), i.getPosZ());
            source.getWorld().addEntity(bolt);
        }

        source.sendFeedback(new TranslationTextComponent("commands.thor.multi_done", TextFormatting.LIGHT_PURPLE + String.valueOf(entities.size()) + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }

    private static int thor(CommandSource source, Entity entity) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, source.getWorld());

        if (entity == null) {source.sendErrorMessage(new TranslationTextComponent("commands.thor.error.null")); return 1;}
        bolt.setPosition(entity.getPosX(), entity.getPosY(), entity.getPosZ());
        source.getWorld().addEntity(bolt);

        source.sendFeedback(new TranslationTextComponent("commands.thor.done", TextFormatting.LIGHT_PURPLE + entity.getDisplayName().getString() + TextFormatting.BLUE).mergeStyle(TextFormatting.BLUE), true);

        return 1;
    }
}
