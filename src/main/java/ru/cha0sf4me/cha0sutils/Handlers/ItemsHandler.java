package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.cha0sf4me.cha0sutils.Items.DeathStick;
import ru.cha0sf4me.cha0sutils.Items.DropPickaxe;
import ru.cha0sf4me.cha0sutils.Items.ThorStick;
import ru.cha0sf4me.cha0sutils.Main;

public class ItemsHandler {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    // ITEMS
    public static final RegistryObject<Item> DEATH_STICK = ITEMS.register("death_stick",  DeathStick::new);
    // public static final RegistryObject<Item> THOR_STICK = ITEMS.register("thor_stick",  ThorStick::new);

    public static void reg() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}