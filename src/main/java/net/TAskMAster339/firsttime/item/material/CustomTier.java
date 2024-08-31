package net.TAskMAster339.firsttime.item.material;

import net.TAskMAster339.firsttime.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class CustomTier {
    public static final ForgeTier SAPPHIRE =
            new ForgeTier(5,
                    65536,
                    9.0F,
                    5.0F,
                    10,
                    null,
                    () -> { return Ingredient.of(ModItems.SAPPHIRE.get());
                    });
    public static final MaterialArmor SAPPHIRE_ARMOR =
            new MaterialArmor("sapphire",
                    40,
                    new int[]{3, 6, 8, 3},
                    30,
                    SoundEvents.ARMOR_EQUIP_TURTLE,
                    4.0F,
                    0.2F,
                    () -> { return Ingredient.of(ModItems.SAPPHIRE.get());});
    public static final MaterialArmor NIGHT_VISION_MASK =
            new MaterialArmor("night",
                    5,
                    new int[]{1, 1, 1, 1},
                    4,
                    SoundEvents.ARMOR_EQUIP_TURTLE,
                    0.0F,
                    0.0F,
                    () -> { return Ingredient.of(ModItems.SAPPHIRE.get());});
    public static final MaterialArmor INVISIBLE_COAT =
            new MaterialArmor("invisible",
                    5,
                    new int[]{1, 1, 1, 1},
                    4,
                    SoundEvents.ARMOR_EQUIP_TURTLE,
                    0.0F,
                    0.0F,
                    () -> { return Ingredient.of(ModItems.SAPPHIRE.get());});
}
