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
import ru.cha0sf4me.cha0sutils.Commands.Weather.Rain;
import ru.cha0sf4me.cha0sutils.Commands.Weather.Sun;

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
        Thor.register(e.getDispatcher());

        Sun.register(e.getDispatcher());
        Rain.register(e.getDispatcher());
    }
}
