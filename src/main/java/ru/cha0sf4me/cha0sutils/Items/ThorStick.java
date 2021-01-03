package ru.cha0sf4me.cha0sutils.Items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.cha0sf4me.cha0sutils.Main;

public class ThorStick extends Item {
    public ThorStick() {
        super(new Properties()
                .group(Main.TAB)
        );
    }

    /*
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, context.getWorld());
        bolt.setPosition(context.getHitVec().getX(), context.getHitVec().getY(), context.getHitVec().getZ());
        context.getWorld().addEntity(bolt);
        return ActionResultType.PASS;
    }
     */

    @Override
    public ActionResult onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
        bolt.setPosition(playerIn.getLookVec().x, playerIn.getLookVec().y, playerIn.getLookVec().z);
        worldIn.addEntity(bolt);
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }
}
