package net.TAskMAster339.firsttime.item;

import com.mojang.datafixers.kinds.IdF;
import net.TAskMAster339.firsttime.FirstTime;
import net.TAskMAster339.firsttime.item.multitool.MultiToolItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstTime.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB)));

    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(CustomTier.SAPPHIRE, 0, 1.2f, new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB)));
    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(CustomTier.SAPPHIRE, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB)));
    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(CustomTier.SAPPHIRE, 0, 1.2f, new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB)));

    public static final RegistryObject<MultiToolItem> SAPPHIRE_MULTI_TOOL = ITEMS.register("sapphire_multi_tool",
            () -> new MultiToolItem(0, 1f, CustomTier.SAPPHIRE, new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static class CustomTier {
        public static final ForgeTier SAPPHIRE =
                new ForgeTier(5,
                        65536,
                        9.0F,
                        5.0F,
                        10,
                        null,
                        () -> { return Ingredient.of(ModItems.SAPPHIRE.get());
        });
    }

}
