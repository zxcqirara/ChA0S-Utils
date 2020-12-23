package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.cha0sf4me.cha0sutils.Commands.HelloCommand;
import ru.cha0sf4me.cha0sutils.Commands.Repair;

@Mod.EventBusSubscriber
public class EventsHandler
{
    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event)
    {
        if (event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntity();

            player.dropItem(new ItemStack(Items.GOLDEN_APPLE, 1), false);
            System.out.println("PLAYER "+player.getDisplayName()+" DIED!!!");
        }
    }

    @SubscribeEvent
    public static void onServerStarting(final RegisterCommandsEvent event)
    {
        // HelloCommand.register(event.getDispatcher());
        Repair.register(event.getDispatcher());
    }
}
