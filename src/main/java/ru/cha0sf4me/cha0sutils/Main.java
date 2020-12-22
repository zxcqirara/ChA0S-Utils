package ru.cha0sf4me.cha0sutils;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import ru.cha0sf4me.cha0sutils.Handlers.ItemsHandler;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "cha0sutils";

    public Main() {
        ItemsHandler.reg();
    }

    public static final ItemGroup TAB = new ItemGroup("modTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.REPEATING_COMMAND_BLOCK);
        }
    };
}