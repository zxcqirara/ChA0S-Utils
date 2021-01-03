package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.MixinEnvironment;
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

    @SubscribeEvent
    public void onUpdates(RenderPlayerEvent.Pre e)
    {
        if( e.getPlayer().getHeldItemMainhand().getItem() == Items.APPLE)
        {
            ItemStack stack = e.getPlayer().getHeldItemMainhand();
            System.out.println("BARRIER 1");
            if(e.getPlayer().isInvisible())
            {
                System.out.println("BARRIER 2");
                e.setCanceled(true);
            }
        }
    }
}
