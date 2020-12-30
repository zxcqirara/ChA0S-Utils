package ru.cha0sf4me.cha0sutils.Items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.cha0sf4me.cha0sutils.Main;

public class DropPickaxe extends Item {
    public DropPickaxe() {
        super(new Properties()
            .group(Main.TAB)
        );
    }
}
