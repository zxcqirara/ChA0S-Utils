package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.cha0sf4me.cha0sutils.Commands.*;
import ru.cha0sf4me.cha0sutils.Commands.Times.Day;
import ru.cha0sf4me.cha0sutils.Commands.Times.Night;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod.EventBusSubscriber
public class EventsHandler
{
    @SubscribeEvent
    public static void onServerStarting(final RegisterCommandsEvent e)
    {
        // COMMANDS
        // HelloCommand.register(event.getDispatcher());
        Repair.register(e.getDispatcher());

        Heal.register(e.getDispatcher());
        Feed.register(e.getDispatcher());

        Fly.register(e.getDispatcher());
        Gm.register(e.getDispatcher());

        Day.register(e.getDispatcher());
        Night.register(e.getDispatcher());

        ToSpawn.register(e.getDispatcher());
    }

    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent event)
    {
        if (event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            // player.sendMessage(new StringTextComponent("Hello, %p!".replace("%p", player.getName().getString())));
            System.out.printf("PLAYER %s JOINED!!!", player.getName().getString());
        }
    }
}
