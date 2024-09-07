package net.TAskMAster339.firsttime.event;

import net.TAskMAster339.firsttime.FirstTime;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Mod.EventBusSubscriber(modid= FirstTime.MOD_ID)
public class ModEvents {

    private static int blocksBroken = 0;
    private static final Random random = new Random();
    private static int target = 1;
    private static int range = 1;
    //thunderEvent
    private static boolean lastIsThundering = false;


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
    @SubscribeEvent
    public static void spawnCreeperWhenBlokeBrakes(BlockEvent.BreakEvent event) {
        if (!event.getPlayer().level.isClientSide()) {
            event.getPlayer().sendSystemMessage(Component.literal(blocksBroken + " -- " + target));
            blocksBroken++;
            if (blocksBroken >= target) {
                blocksBroken = 0;
                target = random.nextInt(1, 10 * range++);

                BlockPos playerPos = event.getPlayer().blockPosition();
                ServerLevel world = (ServerLevel) event.getPlayer().level;

                Creeper creeper = new Creeper(EntityType.CREEPER, world);

                creeper.setPos(playerPos.getX() + random.nextDouble(-3, 3), playerPos.getY() + random.nextDouble(5, 15), playerPos.getZ() + random.nextDouble(-3, 3));

                world.addFreshEntity(creeper);
                event.getPlayer().sendSystemMessage(Component.literal("Беригись, Они на деревьях!!!"));
            }
        }
    }
    public static void addBrokenBlocksNumber(int num){
        blocksBroken+=num;
    }
    @SubscribeEvent
    public static void spawnThunderLighting(TickEvent.LevelTickEvent event) {
        if (!event.level.isClientSide() && event.level instanceof ServerLevel) {
            ServerLevel world = (ServerLevel) event.level;

            boolean isThundering = world.isThundering();
            if (isThundering && !lastIsThundering) {
                lastIsThundering = true;
                int extraLightningBolts = 200;

                for (int i = 0; i < extraLightningBolts; i++) {
                    double x = world.random.nextDouble() * 1000 - 500;
                    double z = world.random.nextDouble() * 1000 - 500;
                    double y = world.getHeight(Heightmap.Types.MOTION_BLOCKING, (int) x, (int) z);

                    LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                    lightning.setPos(x, y, z);

                    world.addFreshEntity(lightning);
                }
            }

            if (!isThundering && lastIsThundering) {
                lastIsThundering = false;
            }
        }
    }
    @SubscribeEvent
    public static void onSomethingBrake(PlayerDestroyItemEvent event) {
        //give random negative effect.
    }
    @SubscribeEvent
    public static void onHarvest(PlayerEvent.HarvestCheck event) {
        //
    }
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {

    }
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

    }
    @SubscribeEvent
    public static void onRightClickEmptySpace(PlayerInteractEvent.RightClickEmpty event) {

    }
    @SubscribeEvent
    public static void whenPlayerSetSpawnPoint(PlayerSetSpawnEvent event) {

    }
    @SubscribeEvent
    public static void whenPlayerSleepInBed(PlayerSleepInBedEvent event) {

    }
    @SubscribeEvent
    public static void whenPlayerWakeUp(PlayerWakeUpEvent event) {

    }
    @SubscribeEvent
    public static void WhenBlockPlaced(BlockEvent.EntityPlaceEvent event) {

    }
    @SubscribeEvent
    public static void onNoteBlockClick(NoteBlockEvent.Change event) {

    }
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

    }
    @SubscribeEvent
    public static void onItemPickedUp(PlayerEvent.ItemPickupEvent event) {

    }
    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {

    }
    @SubscribeEvent
    public static void whenPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

    }

}
