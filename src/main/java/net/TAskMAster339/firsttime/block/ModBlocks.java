package net.TAskMAster339.firsttime.block;

import net.TAskMAster339.firsttime.FirstTime;
import net.TAskMAster339.firsttime.item.ModCreativeModeTab;
import net.TAskMAster339.firsttime.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstTime.MOD_ID);

    //Blocks

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.AMETHYST)
                    .strength(0.1f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FIRST_TIME_TAB);
    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = registerBlock("sapphire_ore_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FIRST_TIME_TAB);
    public static final RegistryObject<Block> SAPPHIRE_DEEP_ORE_BLOCK = registerBlock("sapphire_deep_ore_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(0.7f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FIRST_TIME_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
