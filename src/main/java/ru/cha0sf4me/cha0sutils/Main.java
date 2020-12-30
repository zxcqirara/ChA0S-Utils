package ru.cha0sf4me.cha0sutils;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import ru.cha0sf4me.cha0sutils.Handlers.ConfigHandler;
import ru.cha0sf4me.cha0sutils.Handlers.ItemsHandler;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "cha0sutils";

    public Main() {
        ItemsHandler.reg();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC, "cha0sutils-config.toml");
    }

    public static final ItemGroup TAB = new ItemGroup("modTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.REPEATING_COMMAND_BLOCK);
        }
    };
}