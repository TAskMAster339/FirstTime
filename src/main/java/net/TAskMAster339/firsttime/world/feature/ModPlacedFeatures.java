package net.TAskMAster339.firsttime.world.feature;

import net.TAskMAster339.firsttime.FirstTime;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, FirstTime.MOD_ID);

    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE_PLACED = PLACED_FEATURES.register("sapphire_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAPPHIRE_ORE.getHolder().get(), commonOrePlacement(10,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-100), VerticalAnchor.aboveBottom(100)))));
    public static final RegistryObject<PlacedFeature> SAPPHIRE_DEEP_ORE_PLACED = PLACED_FEATURES.register("sapphire_deep_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAPPHIRE_DEEP_ORE.getHolder().get(), commonOrePlacement(10,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-100), VerticalAnchor.aboveBottom(100)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier placeMod1, PlacementModifier placeMod2){
        return List.of(placeMod1, InSquarePlacement.spread(), placeMod2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int num, PlacementModifier placeMod) {
        return orePlacement(CountPlacement.of(num), placeMod);
    }

    public static List<PlacementModifier> rareOrePlacement(int num, PlacementModifier placeMod) {
        return orePlacement(RarityFilter.onAverageOnceEvery(num), placeMod);
    }

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
