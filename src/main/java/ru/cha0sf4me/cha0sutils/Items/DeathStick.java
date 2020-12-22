package ru.cha0sf4me.cha0sutils.Items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import ru.cha0sf4me.cha0sutils.Main;

public class DeathStick extends Item {
    public DeathStick() {
        super(new Properties()
            .group(Main.TAB)
        );
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.attackEntityFrom(DamageSource.causePlayerDamage((PlayerEntity) attacker), 999999999);
        return true;
    }
}
