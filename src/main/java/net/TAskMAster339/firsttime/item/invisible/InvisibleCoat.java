package net.TAskMAster339.firsttime.item.invisible;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InvisibleCoat extends ArmorItem {
    public InvisibleCoat(ArmorMaterial armorMaterial, Properties properties) {
        super(armorMaterial, EquipmentSlot.CHEST, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5));
    }
}
