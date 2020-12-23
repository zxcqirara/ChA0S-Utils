package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.cha0sf4me.cha0sutils.Commands.*;
import ru.cha0sf4me.cha0sutils.Commands.Times.Day;
import ru.cha0sf4me.cha0sutils.Commands.Times.Night;

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
    }

    /*
    @SubscribeEvent
    public void RenderPlayerEvent(RenderPlayerEvent e)
    {
        e.setCanceled(true);
    }
     */
}
