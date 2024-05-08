package cn.dancingsnow.disable_tools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DisableToolsMod.MODID)
public class DisableToolsEventListener {

    @SubscribeEvent
    public static void onPlayerLeftBlock(PlayerInteractEvent event) {
        if (event.isCancelable()) {
            event.setCanceled(DisableToolsMod.isItemDisabled(event.getItemStack().getItem()));
        }
    }

    @SubscribeEvent
    public static void onPlayerAttackEntity(AttackEntityEvent event) {
        if (event.isCancelable()) {
            event.setCanceled(DisableToolsMod.isItemDisabled(event.getEntity().getMainHandItem().getItem()));
        }
    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if (DisableToolsMod.isItemDisabled(event.getItemStack().getItem())) {
            event.getToolTip().add(1, Component.translatable(DisableToolsMod.config.tooltip).withStyle(ChatFormatting.RED));
        }
    }
}
