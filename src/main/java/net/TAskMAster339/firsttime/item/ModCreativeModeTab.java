package net.TAskMAster339.firsttime.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FIRST_TIME_TAB = new CreativeModeTab("firsttimetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SAPPHIRE.get());
        }
    };
}
