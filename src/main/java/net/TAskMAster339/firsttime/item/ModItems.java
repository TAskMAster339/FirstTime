package net.TAskMAster339.firsttime.item;

import net.TAskMAster339.firsttime.FirstTime;
import net.TAskMAster339.firsttime.item.material.CustomTier;
import net.TAskMAster339.firsttime.item.multitool.MultiToolItem;
import net.TAskMAster339.firsttime.item.nightglasses.NightVisionMask;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstTime.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(tab()));

    //SAPPHIRE_TOOLS
    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(CustomTier.SAPPHIRE, 0, 1.2f, tab()));
    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(CustomTier.SAPPHIRE, 4, 1.2f,tab()));
    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(CustomTier.SAPPHIRE, 0, 1.2f, tab()));
    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(CustomTier.SAPPHIRE, 2, 1f, tab()));
    public static final RegistryObject<MultiToolItem> SAPPHIRE_MULTI_TOOL = ITEMS.register("sapphire_multi_tool",
            () -> new MultiToolItem(0, 1f, CustomTier.SAPPHIRE, tab()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //SAPPHIRE_ARMOR
    public static final RegistryObject<ArmorItem> SAPPHIRE_HEAD = ITEMS.register("sapphire_head",
            () -> new ArmorItem(CustomTier.SAPPHIRE_ARMOR, EquipmentSlot.HEAD, tab()));
    public static final RegistryObject<ArmorItem> SAPPHIRE_CHEST = ITEMS.register("sapphire_chest",
            () -> new ArmorItem(CustomTier.SAPPHIRE_ARMOR, EquipmentSlot.CHEST, tab()));
    public static final RegistryObject<ArmorItem> SAPPHIRE_LEGS = ITEMS.register("sapphire_legs",
            () -> new ArmorItem(CustomTier.SAPPHIRE_ARMOR, EquipmentSlot.LEGS, tab()));
    public static final RegistryObject<ArmorItem> SAPPHIRE_FEET = ITEMS.register("sapphire_feet",
            () -> new ArmorItem(CustomTier.SAPPHIRE_ARMOR, EquipmentSlot.FEET, tab()));

    //NIGHT_VISION_MASK
    public static final RegistryObject<NightVisionMask> NIGHT_VISION_MASK = ITEMS.register("night_vision_mask",
            () -> new NightVisionMask(CustomTier.NIGHT_VISION_MASK, tab()));

    /**
     * shortcut to add item to creative mode tab
     * @return new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB);
     */
    private static Item.Properties tab() {
        return new Item.Properties().tab(ModCreativeModeTab.FIRST_TIME_TAB);
    }
}
