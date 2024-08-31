package net.TAskMAster339.firsttime.event;

import net.TAskMAster339.firsttime.FirstTime;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= FirstTime.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addEffectsWhenCustomArmorOn(TickEvent.PlayerTickEvent event) {
        String feetName = event.player.getInventory().getArmor(0).getItem().toString();
        String legsName = event.player.getInventory().getArmor(1).getItem().toString();
        String chestName = event.player.getInventory().getArmor(2).getItem().toString();
        String headName = event.player.getInventory().getArmor(3).getItem().toString();

        if (headName.equals("night_vision_mask")) {
            event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20 * 11, 0, false, false, false));
        } else {
            event.player.removeEffect(MobEffects.NIGHT_VISION);
        }

        if (chestName.equals("invisible_coat")) {
            event.player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 1, false, false, false));
        } else {
            event.player.removeEffect(MobEffects.INVISIBILITY);
        }

        if (feetName.equals("fast_boots")) {
            event.player.maxUpStep = event.player.isShiftKeyDown() ? 0.65F : 1.25F;
            event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, true, false, false));
            event.player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 0, false, false, false));
        } else {
            event.player.maxUpStep = 0.65F;
            event.player.removeEffect(MobEffects.MOVEMENT_SPEED);
            event.player.removeEffect(MobEffects.JUMP);
        }


    }
}
