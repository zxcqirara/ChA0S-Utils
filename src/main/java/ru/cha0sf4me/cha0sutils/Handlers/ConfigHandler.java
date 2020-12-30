package ru.cha0sf4me.cha0sutils.Handlers;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import ru.cha0sf4me.cha0sutils.Main;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHandler {
    public static class Common {
        public final BooleanValue kickForBadNick;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.comment("ChA0S Utils - Configuration")
                    .push("cha0sutils");

            kickForBadNick = builder
                    .comment("Kick player for bad(not convenient) nick-names")
                    .translation("config.kickForBadNick.translation")
                    .worldRestart()
                    .define("kickForBadNick", true);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading event) {}

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading event) {}
}
