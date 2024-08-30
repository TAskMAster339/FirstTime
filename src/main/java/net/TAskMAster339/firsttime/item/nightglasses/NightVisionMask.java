package net.TAskMAster339.firsttime.item.nightglasses;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NightVisionMask extends ArmorItem {
    public NightVisionMask(ArmorMaterial armorMaterial, Properties p_40388_) {
        super(armorMaterial, EquipmentSlot.HEAD, p_40388_);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (20 * 11)));
    }
}
