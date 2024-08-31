package net.TAskMAster339.firsttime.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomArmorItem extends ArmorItem {

    private final String TIP;
    public CustomArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, String tip, Properties properties) {
        super(armorMaterial, equipmentSlot, properties);
        this.TIP = tip;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        components.add(Component.literal("Press Shift for more info").withStyle(ChatFormatting.GOLD));
        if (Screen.hasShiftDown()) {
            components.add(Component.literal(TIP).withStyle(ChatFormatting.YELLOW));
        }
    }
}
